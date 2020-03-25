package wasteland.decision;

import java.util.HashSet;
import java.util.Set;

public class Choice implements IChoice {

  private String text;
  private INode nextNode;
  private int pointValue;
  private Set<String> objectsToAdd;
  private Set<String> objectsToRemove;

  public Choice(String text, int pointValue) {
    this.text = text;
    this.nextNode = null;
    this.pointValue = pointValue;
    this.objectsToAdd = new HashSet<String>();
    this.objectsToRemove = new HashSet<String>();
  }


  @Override
  public String getText() {
    return this.text;
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
