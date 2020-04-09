package wasteland.decision;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Node implements INode {

  protected String prompt;
  private List<IChoice> choices;
  private int numberOfChoices;

  public Node() {
    this.prompt = "";
    this.choices = new ArrayList<IChoice>();
    this.numberOfChoices = 0;
  }


  public Node(String prompt) {
    this.prompt = prompt;
    this.choices = new ArrayList<IChoice>();
    this.numberOfChoices = 0;
  }

  public Node(String prompt, List<IChoice> choices) {
    this.prompt = prompt;
    this.choices = choices;
    this.numberOfChoices = choices.size();
  }

  @Override
  public String getPrompt(boolean isInfected) {
    return this.prompt;
  }

  @Override
  public void addChoice(IChoice choice) {
    this.choices.add(choice);
    this.numberOfChoices++;
  }

  @Override
  public List<IChoice> getAllChoices() {
    return new ArrayList<IChoice>(this.choices);
  }

  @Override
  public int getNumberOfChoices() {
    return this.numberOfChoices;
  }

  @Override
  public boolean hasChoices() {
    return this.numberOfChoices > 0;
  }

  @Override
  public boolean showUserThisPrompt(Set<String> playerInventory) {
    return true;
  }

  @Override
  public INode getNextNode(boolean isInfected) {
    return null;
  }
}
