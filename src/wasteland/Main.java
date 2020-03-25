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

    // Action 0 the user can take
    IChoice choiceA = new Choice(WorldA.ACTION_0, WorldA.ACTION_0_VALUE);
    INode resultA = new Node(WorldA.PROMPT_0);
    linkResultToNext(startNode, choiceA, resultA);

    // Action 1 the user can take
    IChoice choiceB = new Choice(WorldA.ACTION_1, WorldA.ACTION_1_VALUE);
    choiceB.addToPlayerOnSelection(WorldA.ACTION_1_ADD_OBJECT);
    INode resultB = new Node(WorldA.PROMPT_1);
    linkResultToNext(startNode, choiceB, resultB);

    // Second decision the user must make IF they take Action 1
    IChoice choiceC = new Choice(WorldA.ACTION_10, WorldA.ACTION_10_VALUE);
    INode resultC = new Node(WorldA.PROMPT_10);
    linkResultToNext(resultB, choiceC, resultC);

    IChoice choiceD = new Choice(WorldA.ACTION_11, WorldA.ACTION_11_VALUE);
    choiceD.addToPlayerOnSelection(WorldA.ACTION_11_ADD_OBJECT);
    INode resultD = new Node(WorldA.PROMPT_11);
    linkResultToNext(resultB, choiceD, resultD);

    // Start the game
    Controller controller = new Controller(startNode);
    controller.run();
  }

  private static void linkResultToNext(INode current, IChoice choice, INode result) {
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
