package wasteland;

import org.apache.commons.text.WordUtils;
import wasteland.data.ChoiceAttackBikers;
import wasteland.data.ChoiceBillOfRightsHide;
import wasteland.data.NodeHospital;
import wasteland.data.World;
import wasteland.decision.Choice;
import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.decision.Node;
import wasteland.util.Constants;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Controller {
  private INode startNode;
  private Scanner scanner;
  private int playerScore;
  private Set<String> playerInventory;
  private boolean doesPlayerHaveDog;
  private boolean isPlayerInfected;

  public Controller(boolean isPlayerInfected) {
    this.isPlayerInfected = isPlayerInfected;
    this.scanner = new Scanner(System.in);
    this.playerScore = 0;
    this.playerInventory = new HashSet<String>();
    this.doesPlayerHaveDog = false;
    this.startNode = init();
  }

  public void run() {
    INode next = this.startNode;

    while (next != null) {
      System.out.println();
      next = this.displayPrompt(next);
    }

    this.endGame();
  }

  private INode displayPrompt(INode node) {
    String startPrompt = node.getPrompt(this.isPlayerInfected);
    printWrap(startPrompt);
    printWrap();
    printWrap(Constants.USER_PROMPT_BEFORE);

    List<IChoice> filteredChoices = node.getAllChoices();
    for (int i = 0; i < filteredChoices.size(); i++) {
      IChoice choice = filteredChoices.get(i);
      printWrap(String.format(Constants.FMT_OPTION, i, choice.getChoiceText(this.playerInventory, this.isPlayerInfected, this.doesPlayerHaveDog)));
    }
    printWrap();

    int selection = this.readChoice(node.getNumberOfChoices());

    IChoice action = filteredChoices.get(selection);  // The option that the user selected
    boolean updatedInventory = action.updatePlayerInventory(this.playerInventory);
    this.playerScore = this.playerScore + action.getPointValue(this.playerInventory, this.isPlayerInfected, this.doesPlayerHaveDog);

    if (action.hasResultText()) {
      printWrap(action.getResultText(this.playerInventory, this.isPlayerInfected, this.doesPlayerHaveDog));
    }

    if (action.hasNewDogStatus()) {
      this.doesPlayerHaveDog = action.getNewDogStatus();
    }

    if (updatedInventory) {
      printWrap();
      printWrap(Constants.INVENTORY_UPDATE);
      printWrap(String.format("[%s]", String.join(", ", this.playerInventory)));
      printWrap();
    }

    if (action.hasNextNode()) {
      INode next = action.getNextNode();
      if (next.hasChoices()) {
        // CASE: there is another prompt and more choices, so keep going
        return next;
      }
    }

    return null;
  }

  private void endGame() {
    printWrap();
    printWrap(String.format(Constants.GAME_END, this.playerScore));
    printWrap();
    printWrap(Constants.GAME_END_INVENTORY);
    printWrap(String.format("[%s]", String.join(", ", this.playerInventory)));
  }

  private int readChoice(int numberOfChoices) {
    while (true) {
      try {
        System.out.print(Constants.USER_PROMPT_AFTER);
        int selection = this.scanner.nextInt();
        if (selection < numberOfChoices && selection >= 0) {
          System.out.println();
          clearConsole();
          return selection;
        }
      } catch (InputMismatchException e) {
        this.scanner.next();
      }
    }
  }

  private static void linkPromptToChoice(INode current, IChoice choice) {
    current.addChoice(choice);
  }

  private static void linkChoiceToNext(IChoice choice, INode next) {
    choice.setNextNode(next);
  }

  private static void printWrap() {
    System.out.println();
  }

  private static void printWrap(String text) {
    System.out.println(WordUtils.wrap(text, Constants.WRAP_LEN));
  }

  private static void clearConsole() {
    System.out.println("\033[H\033[2J");
  }

  private INode init() {
    // ================================================================================================================================================== \\

    INode wakeHospital = new NodeHospital();

    IChoice stayInHospital = new Choice(World.ACTION_STAY_HOSPITAL, World.VALUE_STAY_HOSPITAL, World.RESULT_STAY_HOSPITAL + World.RESULT_LEAVE_HOSPITAL);
    stayInHospital.addToPlayerOnSelection(World.ADD_LEAVE_HOSPITAL);
    linkPromptToChoice(wakeHospital, stayInHospital);

    IChoice leaveHospital = new Choice(World.ACTION_LEAVE_HOSPITAL, World.VALUE_LEAVE_HOSPITAL, World.RESULT_LEAVE_HOSPITAL);
    leaveHospital.addToPlayerOnSelection(World.ADD_LEAVE_HOSPITAL);
    linkPromptToChoice(wakeHospital, leaveHospital);

    // ================================================================================================================================================== \\

    INode encounterDog = new Node(World.PROMPT_DOG);
    linkChoiceToNext(stayInHospital, encounterDog);
    linkChoiceToNext(leaveHospital, encounterDog);

    IChoice feedDog = new Choice(World.ACTION_FEED_DOG, World.VALUE_FEED_DOG, World.RESULT_FEED_DOG);
    feedDog.removeFromPlayerOnSelection(World.REMOVE_FEED_DOG);
    feedDog.updateDogStatus(World.RESULT_NEW_DOG_STATUS);
    linkPromptToChoice(encounterDog, feedDog);

    IChoice leaveDog = new Choice(World.ACTION_LEAVE_DOG, World.VALUE_LEAVE_DOG, World.RESULT_LEAVE_DOG);
    linkPromptToChoice(encounterDog, leaveDog);

    // ================================================================================================================================================== \\

    INode encounterBikers = new Node(World.PROMPT_BIKERS);
    linkChoiceToNext(feedDog, encounterBikers);
    linkChoiceToNext(leaveDog, encounterBikers);

    IChoice attackBikers = new ChoiceAttackBikers();
    linkPromptToChoice(encounterBikers, attackBikers);

    IChoice askBikers = new Choice(World.ACTION_ASK_BIKERS, World.VALUE_ASK_BIKERS, World.RESULT_ASK_BIKERS);
    linkPromptToChoice(encounterBikers, askBikers);

    // ================================================================================================================================================== \\

    INode confrontBikersCannibals = new Node(World.PROMPT_BIKERS_NEXT);
    linkChoiceToNext(attackBikers, confrontBikersCannibals);
    linkChoiceToNext(askBikers, confrontBikersCannibals);

    IChoice killBikers = new Choice(World.ACTION_KILL_BIKERS, World.VALUE_KILL_BIKERS, World.RESULT_KILL_BIKERS);
    killBikers.addToPlayerOnSelection(World.ADD_KILL_BIKERS_REWARD);
    linkPromptToChoice(confrontBikersCannibals, killBikers);

    IChoice killCannibals = new Choice(World.ACTION_KILL_CANNIBALS, World.VALUE_KILL_CANNIBALS, World.RESULT_KILL_CANNIBALS);
    killCannibals.addToPlayerOnSelection(World.ADD_KILL_CANNIBALS_REWARD);
    linkPromptToChoice(confrontBikersCannibals, killCannibals);

    IChoice killBoth = new Choice(World.ACTION_KILL_ALL, World.VALUE_KILL_ALL, World.RESULT_KILL_ALL);
    killBoth.addToPlayerOnSelection(World.ADD_KILL_ALL_REWARD);
    linkPromptToChoice(confrontBikersCannibals, killBoth);

    IChoice leaveBoth = new Choice(World.ACTION_LEAVE_ALL, World.VALUE_LEAVE_ALL, World.RESULT_LEAVE_ALL);
    linkPromptToChoice(confrontBikersCannibals, leaveBoth);

    // ================================================================================================================================================== \\

    INode findShovel = new Node(World.PROMPT_SHOVEL);
    linkChoiceToNext(killBikers, findShovel);
    linkChoiceToNext(killCannibals, findShovel);
    linkChoiceToNext(killBoth, findShovel);
    linkChoiceToNext(leaveBoth, findShovel);

    IChoice takeShovel = new Choice(World.ACTION_TAKE_SHOVEL, World.VALUE_TAKE_SHOVEL, World.RESULT_TAKE_SHOVEL);
    takeShovel.addToPlayerOnSelection(World.ADD_SHOVEL);
    linkPromptToChoice(findShovel, takeShovel);

    IChoice leaveShovel = new Choice(World.ACTION_LEAVE_SHOVEL, World.VALUE_LEAVE_SHOVEL, World.RESULT_LEAVE_SHOVEL);
    linkPromptToChoice(findShovel, leaveShovel);

    // ================================================================================================================================================== \\

    INode findHouse = new Node(World.PROMPT_HOUSE);
    linkChoiceToNext(takeShovel, findHouse);
    linkChoiceToNext(leaveShovel, findHouse);

    IChoice enterHouse = new Choice(World.ACTION_HOUSE_ENTER, World.VALUE_HOUSE_ENTER, World.RESULT_HOUSE_ENTER);
    linkPromptToChoice(findHouse, enterHouse);

    IChoice passHouse = new Choice(World.ACTION_HOUSE_LEAVE, World.VALUE_HOUSE_LEAVE, World.RESULT_HOUSE_LEAVE);
    linkPromptToChoice(findHouse, passHouse);

    // ================================================================================================================================================== \\

    INode houseLady = new Node(World.PROMPT_HOUSE_LADY);
    linkChoiceToNext(enterHouse, houseLady);

    IChoice helpLady = new Choice(World.ACTION_HOUSE_LADY_HELP, World.VALUE_HOUSE_LADY_HELP, World.RESULT_HOUSE_LADY_HELP);
    linkPromptToChoice(houseLady, helpLady);

    IChoice stealLady = new Choice(World.ACTION_HOUSE_LADY_STEAL, World.VALUE_HOUSE_LADY_STEAL, World.RESULT_HOUSE_LADY_STEAL);
    stealLady.addToPlayerOnSelection(World.ADD_HOUSE_LADY_STEAL);
    linkPromptToChoice(houseLady, stealLady);

    // ================================================================================================================================================== \\

    INode houseDinner = new Node(World.PROMPT_HOUSE_DINNER);
    linkChoiceToNext(helpLady, houseDinner);

    IChoice acceptDinner = new Choice(World.ACTION_HOUSE_DINNER_STAY, World.VALUE_HOUSE_DINNER_STAY, World.RESULT_HOUSE_DINNER_STAY);
    linkPromptToChoice(houseDinner, acceptDinner);

    IChoice denyDinner = new Choice(World.ACTION_HOUSE_DINNER_LEAVE, World.VALUE_HOUSE_DINNER_LEAVE, World.RESULT_HOUSE_DINNER_LEAVE);
    linkPromptToChoice(houseDinner, denyDinner);

    // ================================================================================================================================================== \\

//    linkChoiceToNext(passHouse, encounterScientist);
//    linkChoiceToNext(acceptDinner, encounterScientist);
//    linkChoiceToNext(denyDinner, encounterScientist);
    // SCIENTIST HUMAN EXPERIMENTS

    // ================================================================================================================================================== \\

    INode findBOR = new Node(World.PROMPT_BOR);
//    linkChoiceToNext(takeShovel, findBOR);  // TODO: CHANGE
//    linkChoiceToNext(leaveShovel, findBOR);  // TODO: CHANGE

    IChoice protectBOR = new Choice(World.ACTION_BOR_PROTECT, World.VALUE_BOR_PROTECT, World.RESULT_BOR_PROTECT);
    takeShovel.addToPlayerOnSelection(World.ADD_BOR);
    linkPromptToChoice(findBOR, protectBOR);

    IChoice alterBOR = new Choice(World.ACTION_BOR_ALTER, World.VALUE_BOR_ALTER, World.RESULT_BOR_ALTER);
    takeShovel.addToPlayerOnSelection(World.ADD_BOR);
    linkPromptToChoice(findBOR, alterBOR);

    IChoice hideBOR = new ChoiceBillOfRightsHide();
    linkPromptToChoice(findBOR, hideBOR);

    // ================================================================================================================================================== \\

    return wakeHospital;
  }
}