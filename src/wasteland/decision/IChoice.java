package wasteland.decision;

import wasteland.util.PhysicalObject;

import java.util.Set;

public interface IChoice {

  String getText();

  void addToPlayerOnSelection(String objectToAdd);

  void removeFromPlayerOnSelection(String objectToRemove);

  boolean updatePlayerInventory(Set<String> playerInventory);

  int getPointValue();

  boolean hasNextNode();

  void setNextNode(INode nextNode);

  INode getNextNode();
}
