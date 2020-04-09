package wasteland.data;

import wasteland.decision.INode;
import wasteland.decision.Node;
import wasteland.util.PhysicalObject;

import java.util.Set;

public class NodePromptGirl extends Node {

  private INode next;

  public NodePromptGirl(String prompt, INode next) {
    super(prompt);
    this.next = next;
  }

  @Override
  public boolean showUserThisPrompt(Set<String> playerInventory) {
    return playerInventory.contains(PhysicalObject.STUFFED_ANIMAL);
  }

  @Override
  public INode getNextNode(boolean isInfected) {
    return this.next;
  }
}
