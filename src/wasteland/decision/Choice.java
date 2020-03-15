package wasteland.decision;

public class Choice implements IChoice {

  private String text;

  private INode nextNode;

  public Choice(String text) {
    this.text = text;
    this.nextNode = null;
  }


  @Override
  public String getText() {
    return this.text;
  }

  @Override
  public boolean hasNextNode() {
    return this.nextNode == null;
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
