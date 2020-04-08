package wasteland.decision;

import java.util.HashSet;
import java.util.Set;

public class Choice implements IChoice {

  protected String choiceText;
  protected String resultText;
  protected int pointValue;
  private INode nextNode;
  private Set<String> objectsToAdd;
  private Set<String> objectsToRemove;
  private boolean hasNewDogStatus;
  private boolean newDogStatus;
  private boolean dependsOnDog;
  private boolean requiresDog;

  public Choice(String choiceText, int pointValue) {
    this.choiceText = choiceText;
    this.pointValue = pointValue;
    this.resultText = null;
    init();
  }

  public Choice(String choiceText, int pointValue, String resultText) {
    this.choiceText = choiceText;
    this.pointValue = pointValue;
    this.resultText = resultText;
    init();
  }

  public Choice() {
    this.pointValue = 0;
    this.choiceText = "";
    this.resultText = "";
    init();
  }

  private void init() {
    this.nextNode = null;
    this.objectsToAdd = new HashSet<String>();
    this.objectsToRemove = new HashSet<String>();
    this.hasNewDogStatus = false;
    this.newDogStatus = false;
    this.dependsOnDog = false;
    this.requiresDog = false;
  }


  @Override
  public String getChoiceText(Set<String> playerInventory, boolean isInfected, boolean hasDog) {
    return this.choiceText;
  }

  @Override
  public String getResultText(Set<String> playerInventory, boolean isInfected, boolean hasDog) {
    return this.resultText;
  }

  @Override
  public boolean hasResultText() {
    return this.resultText != null;
  }

  @Override
  public void updateDogStatus(boolean newDogStatus) {
    this.hasNewDogStatus = true;
    this.newDogStatus = newDogStatus;
  }

  @Override
  public boolean hasNewDogStatus() {
    return this.hasNewDogStatus;
  }

  @Override
  public boolean getNewDogStatus() {
    return this.newDogStatus;
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
  public int getPointValue(Set<String> playerInventory, boolean isInfected, boolean hasDog) {
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
