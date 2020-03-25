package wasteland;

import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.util.Constants;
import wasteland.util.PhysicalObject;

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

  public Controller(INode startNode) {
    this.startNode = startNode;
    this.scanner = new Scanner(System.in);
    this.playerScore = 0;
    this.playerInventory = new HashSet<String>();
  }

  public void run() {
    INode next = this.startNode;

    while (next != null) {
      next = this.displayPrompt(next);
    }

    this.endGame();
  }

  private INode displayPrompt(INode node) {
    String startPrompt = node.getPrompt();
    System.out.println("##################################################");
    System.out.println(startPrompt);
    System.out.println();

    List<IChoice> choices = node.getAllChoices();
    for (int i = 0; i < node.getNumberOfChoices(); i++) {
      IChoice choice = choices.get(i);
      System.out.println(String.format(Constants.FMT_OPTION, i, choice.getText()));
    }
    System.out.println();

    int selection = this.readChoice(node.getNumberOfChoices());
//    System.out.println(String.format(Constants.FMT_SELECTED, selection));

    IChoice action = choices.get(selection);  // The option that the user selected
    boolean updatedInventory = action.updatePlayerInventory(this.playerInventory);
    this.playerScore = this.playerScore + action.getPointValue();

    if (updatedInventory) {
      System.out.println(Constants.INVENTORY_UPDATE);
      System.out.println(String.format("[%s]", String.join(", ", this.playerInventory)));
    }

    if (action.hasNextNode()) {
      INode next = action.getNextNode();
      if (next.hasChoices()) {
        // CASE: there is another prompt and more choices, so keep going
        return next;
      }

      // CASE: there are no more actions to take, so print the next prompt
      System.out.println("##################################################");
      System.out.println(next.getPrompt());
    }

    return null;
  }

  private void endGame() {
    System.out.println();
    System.out.println(String.format(Constants.GAME_END, this.playerScore));
    System.out.println();
    System.out.println(Constants.GAME_END_INVENTORY);
    System.out.println(String.format("[%s]", String.join(", ", this.playerInventory)));
  }

  private int readChoice(int numberOfChoices) {
    while (true) {
      try {
        System.out.print(Constants.USER_PROMPT);
        int selection = this.scanner.nextInt();
        if (selection < numberOfChoices && selection >= 0) {
          System.out.println();
          return selection;
        }
      } catch (InputMismatchException e) {
        this.scanner.next();
      }
    }
  }
}