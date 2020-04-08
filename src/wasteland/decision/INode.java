package wasteland.decision;

import java.util.List;

public interface INode {

  String getPrompt(boolean isInfected);

  void addChoice(IChoice choice);

  List<IChoice> getAllChoices();

  int getNumberOfChoices();

  boolean hasChoices();
}
