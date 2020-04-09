package wasteland;

import org.apache.commons.text.WordUtils;
import wasteland.data.ChoiceAttackBikers;
import wasteland.data.ChoiceBillOfRightsHide;
import wasteland.data.ChoiceCapturedEqual;
import wasteland.data.ChoiceWanderEqual;
import wasteland.data.NodeHospital;
import wasteland.data.NodeInfectionFork;
import wasteland.data.NodePromptGirl;
import wasteland.data.World;
import wasteland.decision.Choice;
import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.decision.Node;
import wasteland.util.Constants;

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
    if (!node.showUserThisPrompt(this.playerInventory)) {
      return node.getNextNode(this.isPlayerInfected);
    }

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
    }

    if (action.hasNextNode()) {
      // CASE: there is another prompt and more choices, so keep going
      return action.getNextNode();
    }

    return null;
  }

  private void endGame() {
    printWrap();
    printWrap(Constants.GAME_END_INVENTORY);
    printWrap(String.format("[%s]", String.join(", ", this.playerInventory)));
    printWrap();
    printWrap(String.format(Constants.GAME_END, this.playerScore));
    printWrap();

    if (this.playerScore < 0) {
      printWrap(Constants.KARMA_NEGATIVE);
    } else if (this.playerScore == 0) {
      printWrap(Constants.KARMA_ZERO);
    } else {
      printWrap(Constants.KARMA_POSITIVE);
    }
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

    INode encounterScientist = new Node(World.PROMPT_SCIENTIST);
    linkChoiceToNext(passHouse, encounterScientist);
    linkChoiceToNext(stealLady, encounterScientist);
    linkChoiceToNext(acceptDinner, encounterScientist);
    linkChoiceToNext(denyDinner, encounterScientist);

    IChoice helpScientist = new Choice(World.ACTION_SCIENTIST_ACCEPT, World.VALUE_SCIENTIST_ACCEPT, World.RESULT_SCIENTIST_ACCEPT);
    linkPromptToChoice(encounterScientist, helpScientist);

    IChoice leaveScientist = new Choice(World.ACTION_SCIENTIST_LEAVE, World.VALUE_SCIENTIST_LEAVE, World.RESULT_SCIENTIST_LEAVE);
    linkPromptToChoice(encounterScientist, leaveScientist);

    IChoice killScientist = new Choice(World.ACTION_SCIENTIST_KILL, World.VALUE_SCIENTIST_KILL, World.RESULT_SCIENTIST_KILL);
    killScientist.addToPlayerOnSelection(World.ADD_SCIENTIST_KILL);
    linkPromptToChoice(encounterScientist, killScientist);

    // ================================================================================================================================================== \\

    INode findBOR = new Node(World.PROMPT_BOR);
    linkChoiceToNext(helpScientist, findBOR);
    linkChoiceToNext(leaveScientist, findBOR);
    linkChoiceToNext(killScientist, findBOR);

    IChoice protectBOR = new Choice(World.ACTION_BOR_PROTECT, World.VALUE_BOR_PROTECT, World.RESULT_BOR_PROTECT);
    protectBOR.addToPlayerOnSelection(World.ADD_BOR);
    linkPromptToChoice(findBOR, protectBOR);

    IChoice alterBOR = new Choice(World.ACTION_BOR_ALTER, World.VALUE_BOR_ALTER, World.RESULT_BOR_ALTER);
    alterBOR.addToPlayerOnSelection(World.ADD_BOR_ALTERED);
    linkPromptToChoice(findBOR, alterBOR);

    IChoice hideBOR = new ChoiceBillOfRightsHide();
    linkPromptToChoice(findBOR, hideBOR);

    // ================================================================================================================================================== \\

    INode findStuffedAnimal = new Node(World.PROMPT_STUFFED_ANIMAL);
    linkChoiceToNext(protectBOR, findStuffedAnimal);
    linkChoiceToNext(alterBOR, findStuffedAnimal);
    linkChoiceToNext(hideBOR, findStuffedAnimal);

    IChoice takeStuffedAnimal = new Choice(World.ACTION_STUFFED_ANIMAL_TAKE, World.VALUE_STUFFED_ANIMAL_TAKE, World.RESULT_STUFFED_ANIMAL_TAKE);
    takeStuffedAnimal.addToPlayerOnSelection(World.ADD_STUFFED_ANIMAL_TAKE);
    linkPromptToChoice(findStuffedAnimal, takeStuffedAnimal);

    IChoice leaveStuffedAnimal = new Choice(World.ACTION_STUFFED_ANIMAL_LEAVE, World.VALUE_STUFFED_ANIMAL_LEAVE, World.RESULT_STUFFED_ANIMAL_LEAVE);
    linkPromptToChoice(findStuffedAnimal, leaveStuffedAnimal);

    // ================================================================================================================================================== \\

    INode findGrave = new Node(World.PROMPT_GRAVE);
    linkChoiceToNext(takeStuffedAnimal, findGrave);
    linkChoiceToNext(leaveStuffedAnimal, findGrave);

    IChoice takeRing = new Choice(World.ACTION_GRAVE_TAKE, World.VALUE_GRAVE_TAKE, World.RESULT_GRAVE_TAKE);
    takeRing.addToPlayerOnSelection(World.ADD_GRAVE_TAKE);
    linkPromptToChoice(findGrave, takeRing);

    IChoice leaveRing = new Choice(World.ACTION_GRAVE_LEAVE, World.VALUE_GRAVE_LEAVE, World.RESULT_GRAVE_LEAVE);
    linkPromptToChoice(findGrave, leaveRing);

    // ================================================================================================================================================== \\

    INode infectedMother = new Node(World.PROMPT_INF_MOTHER);
    INode immuneMother = new Node(World.PROMPT_IMN_MOTHER);

    INode fork = new NodeInfectionFork(infectedMother, immuneMother);
    linkChoiceToNext(takeRing, fork);
    linkChoiceToNext(leaveRing, fork);

    // ================================================================================================================================================== \\
    // ================================================================================================================================================== \\

    IChoice infectedMotherShareFood = new Choice(World.ACTION_INF_MOTHER_GIVE, World.VALUE_INF_MOTHER_GIVE, World.RESULT_INF_MOTHER_GIVE);
    infectedMotherShareFood.removeFromPlayerOnSelection(World.REMOVE_INF_MOTHER_GIVE);
    linkPromptToChoice(infectedMother, infectedMotherShareFood);

    IChoice infectedMotherIgnore = new Choice(World.ACTION_INF_MOTHER_REFUSE, World.VALUE_INF_MOTHER_REFUSE, World.RESULT_INF_MOTHER_REFUSE);
    linkPromptToChoice(infectedMother, infectedMotherIgnore);

    // ================================================================================================================================================== \\

    INode infectedCaptured = new Node(World.PROMPT_CAPTURED);

    INode infectedGirl = new NodePromptGirl(World.PROMPT_INF_GIRL, infectedCaptured);
    linkChoiceToNext(infectedMotherShareFood, infectedGirl);
    linkChoiceToNext(infectedMotherIgnore, infectedGirl);

    IChoice infectedGirlGive = new Choice(World.ACTION_INF_GIRL_GIVE, World.VALUE_INF_GIRL_GIVE, World.RESULT_INF_GIRL_GIVE);
    infectedGirlGive.removeFromPlayerOnSelection(World.REMOVE_INF_GIRL_GIVE);
    linkPromptToChoice(infectedGirl, infectedGirlGive);

    IChoice infectedGirlRefuse = new Choice(World.ACTION_INF_GIRL_REFUSE, World.VALUE_INF_GIRL_REFUSE, World.RESULT_INF_GIRL_REFUSE);
    linkPromptToChoice(infectedGirl, infectedGirlRefuse);

    // ================================================================================================================================================== \\

    linkChoiceToNext(infectedGirlGive, infectedCaptured);
    linkChoiceToNext(infectedGirlRefuse, infectedCaptured);

    IChoice capturedAgree = new Choice(World.ACTION_CAPTURED_AGREE, World.VALUE_CAPTURED_AGREE, World.RESULT_CAPTURED_AGREE);
    linkPromptToChoice(infectedCaptured, capturedAgree);

    IChoice capturedRevolt = new Choice(World.ACTION_CAPTURED_REVOLT, World.VALUE_CAPTURED_REVOLT, World.RESULT_CAPTURED_REVOLT);
    linkPromptToChoice(infectedCaptured, capturedRevolt);

    IChoice capturedEqual = new ChoiceCapturedEqual();
    linkPromptToChoice(infectedCaptured, capturedEqual);

    // ================================================================================================================================================== \\
    // ================================================================================================================================================== \\

    IChoice immuneMotherShareFood = new Choice(World.ACTION_IMN_MOTHER_GIVE, World.VALUE_IMN_MOTHER_GIVE, World.RESULT_IMN_MOTHER_GIVE);
    immuneMotherShareFood.removeFromPlayerOnSelection(World.REMOVE_IMN_MOTHER_GIVE);
    linkPromptToChoice(immuneMother, immuneMotherShareFood);

    IChoice immuneMotherIgnore = new Choice(World.ACTION_IMN_MOTHER_REFUSE, World.VALUE_IMN_MOTHER_REFUSE, World.RESULT_IMN_MOTHER_REFUSE);
    linkPromptToChoice(immuneMother, immuneMotherIgnore);

    // ================================================================================================================================================== \\

    INode immuneWander = new Node(World.PROMPT_WANDER);

    INode immuneGirl = new NodePromptGirl(World.PROMPT_IMN_GIRL, immuneWander);
    linkChoiceToNext(immuneMotherShareFood, immuneGirl);
    linkChoiceToNext(immuneMotherIgnore, immuneGirl);

    IChoice immuneGirlGive = new Choice(World.ACTION_IMN_GIRL_GIVE, World.VALUE_GIRL_IMN_GIVE, World.RESULT_IMN_GIRL_GIVE);
    immuneGirlGive.removeFromPlayerOnSelection(World.REMOVE_IMN_GIRL_GIVE);
    linkPromptToChoice(immuneGirl, immuneGirlGive);

    IChoice immuneGirlRefuse = new Choice(World.ACTION_IMN_GIRL_REFUSE, World.VALUE_IMN_GIRL_REFUSE, World.RESULT_IMN_GIRL_REFUSE);
    linkPromptToChoice(immuneGirl, immuneGirlRefuse);

    // ================================================================================================================================================== \\

    linkChoiceToNext(immuneGirlGive, immuneWander);
    linkChoiceToNext(immuneGirlRefuse, immuneWander);

    IChoice wanderStay = new Choice(World.ACTION_WANDER_STAY, World.VALUE_WANDER_STAY, World.RESULT_WANDER_STAY);
    linkPromptToChoice(immuneWander, wanderStay);

    IChoice wanderRevolt = new Choice(World.ACTION_WANDER_REVOLT, World.VALUE_WANDER_REVOLT, World.RESULT_WANDER_REVOLT);
    linkPromptToChoice(immuneWander, wanderRevolt);

    IChoice wanderEqual = new ChoiceWanderEqual();
    linkPromptToChoice(immuneWander, wanderEqual);

    // ================================================================================================================================================== \\

    return wakeHospital;
  }
}