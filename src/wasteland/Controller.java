package wasteland;

import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.util.Constants;

import java.util.ArrayList;
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
  private boolean playerHasDog;

  public Controller(INode startNode) {
    this.startNode = startNode;
    this.scanner = new Scanner(System.in);
    this.playerScore = 0;
    this.playerInventory = new HashSet<String>();
    this.playerHasDog = false;
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
    System.out.println(Constants.DIVIDER);
    System.out.println(startPrompt);
    System.out.println();
    System.out.println(Constants.USER_PROMPT_BEFORE);

    List<IChoice> filteredChoices = new ArrayList<IChoice>();
    for (IChoice choice : node.getAllChoices()) {
      if (choice.getDoesDependOnDog()) {
        if ((choice.getRequiresDog() && !this.playerHasDog) || (!choice.getRequiresDog() && this.playerHasDog)) {
          continue;
        }
      }
      filteredChoices.add(choice);
    }

    for (int i = 0; i < filteredChoices.size(); i++) {
      IChoice choice = filteredChoices.get(i);
      System.out.println(String.format(Constants.FMT_OPTION, i, choice.getChoiceText()));
    }
    System.out.println();


    int selection = this.readChoice(node.getNumberOfChoices());
//    System.out.println(String.format(Constants.FMT_SELECTED, selection));

    IChoice action = filteredChoices.get(selection);  // The option that the user selected
    boolean updatedInventory = action.updatePlayerInventory(this.playerInventory);
    this.playerScore = this.playerScore + action.getPointValue();

    if (action.hasResultText()) {
      System.out.println(action.getResultText());
    }

    if (action.hasNewDogStatus()) {
      this.playerHasDog = action.getNewDogStatus();
    }

    if (updatedInventory) {
      System.out.println();
      System.out.println(Constants.INVENTORY_UPDATE);
      System.out.println(String.format("[%s]", String.join(", ", this.playerInventory)));
      System.out.println();
    }



    if (action.hasNextNode()) {
      INode next = action.getNextNode();
      if (next.hasChoices()) {
        // CASE: there is another prompt and more choices, so keep going
        return next;
      }
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
        System.out.print(Constants.USER_PROMPT_AFTER);
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