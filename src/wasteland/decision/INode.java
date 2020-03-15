package wasteland.decision;

import java.util.List;

public interface INode {

  String getPrompt();

  void addChoice(IChoice choice);

  List<IChoice> getAllChoices();

  int getNumberOfChoices();
}
