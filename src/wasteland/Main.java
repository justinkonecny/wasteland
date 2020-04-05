package wasteland;

import wasteland.data.World;
import wasteland.decision.Choice;
import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.decision.Node;
import wasteland.util.Constants;
import wasteland.util.PhysicalObject;

import java.io.IOException;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    boolean isInfected = new Random().nextBoolean();

    // Some welcome message when the game starts
    System.out.println(Constants.GAME_WELCOME);

    String infectionStatus = isInfected ? Constants.INTRO_INFECTED : Constants.INTRO_SAFE;
    System.out.println(infectionStatus);

    System.out.print("Press 'ENTER' to start... ");
    waitOnKeyPressEnter();


    // ================================================================================================================================================== \\

    INode wakeHospital = new Node(World.PROMPT_WAKE_HOSPITAL);

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

    IChoice attackBikersWithDog = new Choice(World.ACTION_ATTACK_BIKERS_DOG, World.VALUE_ATTACK_BIKERS_DOG, World.RESULT_ATTACK_BIKERS_DOG);
    attackBikersWithDog.setDependOnDog(World.ACTION_REQUIRES_DOG);
    linkPromptToChoice(encounterBikers, attackBikersWithDog);

    IChoice attackBikersWithoutDog = new Choice(World.ACTION_ATTACK_BIKERS_NO_DOG, World.VALUE_ATTACK_BIKERS_NO_DOG, World.RESULT_ATTACK_BIKERS_NO_DOG);
    attackBikersWithoutDog.setDependOnDog(World.ACTION_REQUIRES_NO_DOG);
    linkPromptToChoice(encounterBikers, attackBikersWithoutDog);

    IChoice askBikers = new Choice(World.ACTION_ASK_BIKERS, World.VALUE_ASK_BIKERS, World.RESULT_ASK_BIKERS);
    linkPromptToChoice(encounterBikers, askBikers);

    // ================================================================================================================================================== \\

    INode confrontBikersCannibals = new Node(World.PROMPT_BIKERS_NEXT);
    linkChoiceToNext(attackBikersWithDog, confrontBikersCannibals);
    linkChoiceToNext(attackBikersWithoutDog, confrontBikersCannibals);
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



    // Start the game
    Controller controller = new Controller(wakeHospital);
    controller.run();
  }

  private static void linkPromptToChoice(INode current, IChoice choice) {
    current.addChoice(choice);
  }

  private static void linkChoiceToNext(IChoice choice, INode next) {
    choice.setNextNode(next);
  }

  private static int waitOnKeyPressEnter() {
    try {
      int val = System.in.read();
      System.out.println();
      return val;
    } catch (IOException e) {
      return -1;
    }
  }
}
