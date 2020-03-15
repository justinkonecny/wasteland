package wasteland.decision;

public interface IChoice {

  String getText();

  boolean hasNextNode();

  void setNextNode(INode nextNode);

  INode getNextNode();
}
