package wasteland.decision;

public class Choice implements IChoice {

  private String text;
  private INode nextNode;
  private int pointValue;

  public Choice(String text, int pointValue) {
    this.text = text;
    this.nextNode = null;
    this.pointValue = pointValue;
  }


  @Override
  public String getText() {
    return this.text;
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
