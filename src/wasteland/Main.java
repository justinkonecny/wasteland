package wasteland;

import wasteland.decision.Choice;
import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.decision.Node;

public class Main {

  public static void main(String[] args) {
    // Some welcome message when the game starts
    String welcomeMessage = "Welcome!\n";
    System.out.println(welcomeMessage);

    // First decision the user must make
    INode startNode = new Node("Something happens!");

    // Action A the user can take
    IChoice choiceA = new Choice("Action A");
    INode promptA = new Node("Oh no, you died from action A");
    choiceA.setNextNode(promptA);
    startNode.addChoice(choiceA);

    // Action B the user can take
    IChoice choiceB = new Choice("Action B");
    INode promptB = new Node("Ah, you died from action B");
    choiceB.setNextNode(promptB);
    startNode.addChoice(choiceB);

    // Start the game
    Controller controller = new Controller(startNode);
    controller.run();
  }
}
