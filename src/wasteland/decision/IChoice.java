package wasteland.decision;

import wasteland.util.PhysicalObject;

import java.util.Set;

public interface IChoice {

  String getChoiceText(Set<String> playerInventory, boolean isInfected, boolean hasDog);

  String getResultText(Set<String> playerInventory, boolean isInfected, boolean hasDog);

  boolean hasResultText();

  void updateDogStatus(boolean hasDog);

  boolean hasNewDogStatus();

  boolean getNewDogStatus();

  void addToPlayerOnSelection(Set<String> objectsToAdd);

  void addToPlayerOnSelection(String objectToAdd);

  void removeFromPlayerOnSelection(String objectToRemove);

  boolean updatePlayerInventory(Set<String> playerInventory);

  int getPointValue(Set<String> playerInventory, boolean isInfected, boolean hasDog);

  boolean hasNextNode();

  void setNextNode(INode nextNode);

  INode getNextNode();
}
