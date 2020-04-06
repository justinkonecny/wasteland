package wasteland.data;

import wasteland.decision.Choice;
import wasteland.util.PhysicalObject;

import java.util.Set;

public class ChoiceBillOfRightsHide extends Choice {

  public ChoiceBillOfRightsHide() {
    super();
  }

  @Override
  public String getChoiceText(Set<String> playerInventory, boolean isInfected) {
    if (playerInventory.contains(PhysicalObject.SHOVEL)) {
      this.choiceText = World.ACTION_BOR_HIDE_SHOVEL;
    } else {
      this.choiceText = World.ACTION_BOR_HIDE;
    }
    return super.getChoiceText(playerInventory, isInfected);
  }

  @Override
  public String getResultText(Set<String> playerInventory, boolean isInfected) {
    if (playerInventory.contains(PhysicalObject.SHOVEL)) {
      this.resultText = World.RESULT_BOR_HIDE_SHOVEL;
    } else {
      this.resultText = World.RESULT_BOR_HIDE;
    }
    return super.getResultText(playerInventory, isInfected);
  }

  @Override
  public boolean hasResultText() {
    return true;
  }

  @Override
  public int getPointValue(Set<String> playerInventory, boolean isInfected) {
    if (playerInventory.contains(PhysicalObject.SHOVEL)) {
      this.pointValue = World.VALUE_BOR_HIDE_SHOVEL;
    } else {
      this.pointValue = World.VALUE_BOR_HIDE;
    }
    return super.getPointValue(playerInventory, isInfected);
  }
}
