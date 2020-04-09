package wasteland.data;

import wasteland.decision.Choice;
import wasteland.util.PhysicalObject;

import java.util.Set;

public class ChoiceCapturedEqual extends Choice {

  public ChoiceCapturedEqual() {
    super();
  }

  @Override
  public String getChoiceText(Set<String> playerInventory, boolean isInfected, boolean hasDog) {
    this.choiceText = World.ACTION_CAPTURED_EQUAL;
    return super.getChoiceText(playerInventory, isInfected, hasDog);
  }

  @Override
  public String getResultText(Set<String> playerInventory, boolean isInfected, boolean hasDog) {
    if (playerInventory.contains(PhysicalObject.BILL_OF_RIGHTS) || playerInventory.contains(PhysicalObject.BILL_OF_RIGHTS_ALTERED)) {
      this.resultText = World.RESULT_CAPTURED_EQUAL_BILL;
    } else {
      this.resultText = World.RESULT_CAPTURED_EQUAL_NO_BILL;
    }
    return super.getResultText(playerInventory, isInfected, hasDog);
  }

  @Override
  public boolean hasResultText() {
    return true;
  }

  @Override
  public int getPointValue(Set<String> playerInventory, boolean isInfected, boolean hasDog) {
    this.pointValue = World.VALUE_CAPTURED_EQUAL;
    return super.getPointValue(playerInventory, isInfected, hasDog);
  }
}
