package wasteland.decision;

import wasteland.util.PhysicalObject;

import java.util.Set;

public interface IChoice {

  String getChoiceText(Set<String> playerInventory, boolean isInfected);

  String getResultText(Set<String> playerInventory, boolean isInfected);

  boolean hasResultText();

  void updateDogStatus(boolean hasDog);

  boolean hasNewDogStatus();

  boolean getNewDogStatus();

  void setDependOnDog(boolean hasDog);

  boolean getDoesDependOnDog();

  boolean getRequiresDog();

  void addToPlayerOnSelection(Set<String> objectsToAdd);

  void addToPlayerOnSelection(String objectToAdd);

  void removeFromPlayerOnSelection(String objectToRemove);

  boolean updatePlayerInventory(Set<String> playerInventory);

  int getPointValue(Set<String> playerInventory, boolean isInfected);

  boolean hasNextNode();

  void setNextNode(INode nextNode);

  INode getNextNode();
}
