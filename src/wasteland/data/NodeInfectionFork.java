package wasteland.data;

import wasteland.decision.INode;
import wasteland.decision.Node;

import java.util.Set;

public class NodeInfectionFork extends Node {
  private INode promptInfected;
  private INode promptImmune;

  public NodeInfectionFork(INode promptInfected, INode promptImmune) {
    super();
    this.promptInfected = promptInfected;
    this.promptImmune = promptImmune;
  }

  @Override
  public boolean showUserThisPrompt(Set<String> playerInventory) {
    return false;
  }

  @Override
  public INode getNextNode(boolean isInfected) {
    if (isInfected) {
      return this.promptInfected;
    } else {
      return this.promptImmune;
    }
  }
}
