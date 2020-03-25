package wasteland.data;

import wasteland.util.PhysicalObject;

public class WorldA {

  public static final String PROMPT = "Something happens!";

  public static final String ACTION_0 = "Action 0";
  public static final int ACTION_0_VALUE = 2;
  public static final String PROMPT_0 = "Oh no, you died from action 0.";

  public static final String ACTION_1 = "Action 1: take shovel";
  public static final String ACTION_1_ADD_OBJECT = PhysicalObject.SHOVEL;
  public static final int ACTION_1_VALUE = -1;
  public static final String PROMPT_1 = "Another thing happens!";

  public static final String ACTION_10 = "Action 1-0";
  public static final int ACTION_10_VALUE = -2;
  public static final String PROMPT_10 = "Ah, you died from Action 1-0.";

  public static final String ACTION_11 = "Action 1-1: take bible";
  public static final String ACTION_11_ADD_OBJECT = PhysicalObject.BIBLE;
  public static final int ACTION_11_VALUE = 4;
  public static final String PROMPT_11 = "Ah, you died from Action 1-1.";
}
