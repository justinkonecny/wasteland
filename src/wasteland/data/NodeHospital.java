package wasteland.data;

import wasteland.decision.Node;

public class NodeHospital extends Node {

  public NodeHospital() {
    super();
  }

  @Override
  public String getPrompt(boolean isInfected) {
    if (isInfected) {
      this.prompt = World.PROMPT_WAKE_HOSPITAL_INFECTED;
    } else {
      this.prompt = World.PROMPT_WAKE_HOSPITAL_IMMUNE;
    }
    return super.getPrompt(isInfected);
  }
}
