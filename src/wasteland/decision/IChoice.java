package wasteland.decision;

public interface IChoice {

  String getText();

  int getPointValue();

  boolean hasNextNode();

  void setNextNode(INode nextNode);

  INode getNextNode();
}
