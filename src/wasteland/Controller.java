package wasteland;

import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.util.Constants;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller {
  private INode startNode;
  private Scanner scanner;
  private int playerScore;

  public Controller(INode startNode) {
    this.startNode = startNode;
    this.scanner = new Scanner(System.in);
    this.playerScore = 0;
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
    System.out.println("########################################");
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
    this.playerScore = this.playerScore + action.getPointValue();

    if (action.hasNextNode()) {
      INode next = action.getNextNode();
      if (next.hasChoices()) {
        // CASE: there is another prompt and more choices, so keep going
        return next;
      }

      // CASE: there are no more actions to take, so print the next prompt
      System.out.println("########################################");
      System.out.println(next.getPrompt());
    }

    return null;
  }

  private void endGame() {
    System.out.println();
    System.out.println(String.format(Constants.GAME_END, this.playerScore));
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