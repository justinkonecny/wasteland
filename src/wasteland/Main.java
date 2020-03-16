package wasteland;

import wasteland.data.WorldA;
import wasteland.decision.Choice;
import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.decision.Node;
import wasteland.util.Constants;

import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    // Some welcome message when the game starts
    System.out.println(Constants.GAME_WELCOME);
    System.out.print("Press 'ENTER' to start... ");
    waitOnKeyPressEnter();

    // First decision the user must make
    INode startNode = new Node(WorldA.PROMPT);

    // Action 0 the user can take
    IChoice choiceA = new Choice(WorldA.ACTION_0);
    INode resultA = new Node(WorldA.PROMPT_0);
    link(startNode, choiceA, resultA);

    // Action 1 the user can take
    IChoice choiceB = new Choice(WorldA.ACTION_1);
    INode resultB = new Node(WorldA.PROMPT_1);
    link(startNode, choiceB, resultB);

    // Second decision the user must make IF they take Action 1
    IChoice choiceC = new Choice(WorldA.ACTION_10);
    INode resultC = new Node(WorldA.PROMPT_10);
    link(resultB, choiceC, resultC);

    // Start the game
    Controller controller = new Controller(startNode);
    controller.run();
  }

  private static void link(INode current, IChoice choice, INode result) {
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
