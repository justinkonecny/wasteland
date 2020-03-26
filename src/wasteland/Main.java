package wasteland;

import wasteland.data.WorldA;
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

    // First decision the user must make
    INode startNode = new Node(WorldA.PROMPT);

    // Action 0 the user can take (DEAD END)
    IChoice choiceA = new Choice(WorldA.ACTION_0, WorldA.ACTION_0_VALUE, WorldA.RESULT_0);
    linkPromptToChoice(startNode, choiceA);

    // Action 1 the user can take (CONTINUE TO PROMPT 1)
    IChoice choiceB = new Choice(WorldA.ACTION_1, WorldA.ACTION_1_VALUE, WorldA.RESULT_1);
    choiceB.addToPlayerOnSelection(WorldA.ACTION_1_ADD_OBJECT);
    INode nextB = new Node(WorldA.PROMPT_1);
    linkPromptChoiceResult(startNode, choiceB, nextB);

    // Second decision the user must make IF they take Action 1
    IChoice choiceC = new Choice(WorldA.ACTION_10, WorldA.ACTION_10_VALUE, WorldA.RESULT_10);
    linkPromptToChoice(nextB, choiceC);

    IChoice choiceD = new Choice(WorldA.ACTION_11, WorldA.ACTION_11_VALUE, WorldA.RESULT_11);
    choiceD.addToPlayerOnSelection(WorldA.ACTION_11_ADD_OBJECT);
    linkPromptToChoice(nextB, choiceD);

    // Start the game
    Controller controller = new Controller(startNode);
    controller.run();
  }

  private static void linkPromptToChoice(INode current, IChoice choice) {
    current.addChoice(choice);
  }

  private static void linkPromptChoiceResult(INode current, IChoice choice, INode result) {
    current.addChoice(choice);
    choice.setNextNode(result);
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
