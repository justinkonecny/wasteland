package wasteland.decision;

import java.util.HashSet;
import java.util.Set;

public class Choice implements IChoice {

  private String choiceText;
  private String resultText;
  private INode nextNode;
  private int pointValue;
  private Set<String> objectsToAdd;
  private Set<String> objectsToRemove;

  public Choice(String choiceText, int pointValue) {
    this.choiceText = choiceText;
    this.resultText = null;
    this.nextNode = null;
    this.pointValue = pointValue;
    this.objectsToAdd = new HashSet<String>();
    this.objectsToRemove = new HashSet<String>();
  }

  public Choice(String choiceText, int pointValue, String resultText) {
    this.choiceText = choiceText;
    this.resultText = resultText;
    this.nextNode = null;
    this.pointValue = pointValue;
    this.objectsToAdd = new HashSet<String>();
    this.objectsToRemove = new HashSet<String>();
  }


  @Override
  public String getChoiceText() {
    return this.choiceText;
  }

  @Override
  public String getResultText() {
    return this.resultText;
  }

  @Override
  public boolean hasResultText() {
    return this.resultText != null;
  }

  @Override
  public void addToPlayerOnSelection(Set<String> objectsToAdd) {
    this.objectsToAdd.addAll(objectsToAdd);
  }

  @Override
  public void addToPlayerOnSelection(String objectToAdd) {
    this.objectsToAdd.add(objectToAdd);
  }

  @Override
  public void removeFromPlayerOnSelection(String objectToRemove) {
    this.objectsToRemove.add(objectToRemove);
  }

  @Override
  public boolean updatePlayerInventory(Set<String> playerInventory) {
    playerInventory.addAll(this.objectsToAdd);
    playerInventory.removeAll(this.objectsToRemove);

    return (this.objectsToAdd.size() > 0 || this.objectsToRemove.size() > 0);
  }

  @Override
  public int getPointValue() {
    return this.pointValue;
  }

  @Override
  public boolean hasNextNode() {
    return this.nextNode != null;
  }

  @Override
  public void setNextNode(INode nextNode) {
    this.nextNode = nextNode;
  }

  @Override
  public INode getNextNode() {
    return this.nextNode;
  }
}
