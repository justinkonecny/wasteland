package wasteland.decision;

import java.util.List;
import java.util.Set;

public interface INode {

  String getPrompt(boolean isInfected);

  void addChoice(IChoice choice);

  List<IChoice> getAllChoices();

  int getNumberOfChoices();

  boolean hasChoices();

  boolean showUserThisPrompt(Set<String> playerInventory);

  INode getNextNode(boolean isInfected);
}
