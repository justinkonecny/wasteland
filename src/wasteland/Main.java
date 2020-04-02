package wasteland;

import wasteland.data.World;
import wasteland.decision.Choice;
import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.decision.Node;
import wasteland.util.Constants;

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
    linkPromptToChoice(encounterDog, feedDog);

    IChoice leaveDog = new Choice(World.ACTION_LEAVE_DOG, World.VALUE_LEAVE_DOG, World.RESULT_LEAVE_DOG);
    linkPromptToChoice(encounterDog, leaveDog);

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
