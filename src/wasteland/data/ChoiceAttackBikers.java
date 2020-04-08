package wasteland.data;

import wasteland.decision.Choice;
import wasteland.util.PhysicalObject;

import java.util.Set;

public class ChoiceAttackBikers extends Choice {

  public ChoiceAttackBikers() {
    super();
  }

  @Override
  public String getChoiceText(Set<String> playerInventory, boolean isInfected, boolean hasDog) {
    if (hasDog) {
      this.choiceText = World.ACTION_ATTACK_BIKERS_DOG;
    } else {
      this.choiceText = World.ACTION_ATTACK_BIKERS_NO_DOG;
    }
    return super.getChoiceText(playerInventory, isInfected, hasDog);
  }

  @Override
  public String getResultText(Set<String> playerInventory, boolean isInfected, boolean hasDog) {
    if (hasDog) {
      this.resultText = World.RESULT_ATTACK_BIKERS_DOG;
    } else {
      this.resultText = World.RESULT_ATTACK_BIKERS_NO_DOG;
    }
    return super.getResultText(playerInventory, isInfected, hasDog);
  }

  @Override
  public boolean hasResultText() {
    return true;
  }

  @Override
  public int getPointValue(Set<String> playerInventory, boolean isInfected, boolean hasDog) {
    if (hasDog) {
      this.pointValue = World.VALUE_ATTACK_BIKERS_DOG;
    } else {
      this.pointValue = World.VALUE_ATTACK_BIKERS_NO_DOG;
    }
    return super.getPointValue(playerInventory, isInfected, hasDog);
  }
}
