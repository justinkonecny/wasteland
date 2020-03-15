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

  public Controller(INode startNode) {
    this.startNode = startNode;
    this.scanner = new Scanner(System.in);
  }

  public void run() {
    this.displayPrompt(this.startNode);
  }

  private void displayPrompt(INode node) {
    String startPrompt = node.getPrompt();
    System.out.println(startPrompt);
    System.out.println();

    if (node.getNumberOfChoices() < 1) {
      return;
    }

    List<IChoice> choices = node.getAllChoices();
    for (int i = 0; i < node.getNumberOfChoices(); i++) {
      IChoice choice = choices.get(i);
      System.out.println(String.format(Constants.FMT_OPTION, i, choice.getText()));
    }
    System.out.println();

    int selection = this.readChoice(node.getNumberOfChoices());
    System.out.println(String.format(Constants.FMT_SELECTED, selection));
  }

  private int readChoice(int numberOfChoices) {
    while (true) {
      try {
        System.out.print(Constants.USER_PROMPT);
        int selection = this.scanner.nextInt();
        if (selection < numberOfChoices && selection >= 0) {
          return selection;
        }
      } catch (InputMismatchException e) {
        this.scanner.next();
      }
    }
  }
}
