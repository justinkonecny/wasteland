package wasteland.data;

import wasteland.util.PhysicalObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class World {

  public static final String PROMPT_WAKE_HOSPITAL = "You wake up in an empty hospital.";

  public static final String ACTION_STAY_HOSPITAL = "Stay in the hospital";
  public static final int VALUE_STAY_HOSPITAL = 0;
  public static final String RESULT_STAY_HOSPITAL = "A week passes and no one comes, so you decide to leave anyway. ";

  public static final String ACTION_LEAVE_HOSPITAL = "Leave to go home";
  public static final int VALUE_LEAVE_HOSPITAL = 0;
  public static final String RESULT_LEAVE_HOSPITAL = "You leave the hospital and make your way to your house. You discover your daughter is gone. Your main goal is now to find her. " +
      "You grab a backpack and pack up some supplies, and you start on your journey to a nearby military base, which is where the government told everyone to go before the world ending event.";
  public static final Set<String> ADD_LEAVE_HOSPITAL = new HashSet<String>(Arrays.asList(
      PhysicalObject.CANNED_FOOD,
      PhysicalObject.PROTEIN_BARS,
      PhysicalObject.SNACKS,
      PhysicalObject.SHOTGUN,
      PhysicalObject.NECKLACE,
      PhysicalObject.WATER_BOTTLE
  ));

  // ================================================================================================================================================== \\

  public static final String PROMPT_DOG = "As you wander down the street, you see a dog limping on the side of the road. It sees you and backs into some nearby bushes, probably afraid of you. It’s clearly hungry.";

  public static final String ACTION_FEED_DOG = "Approach the dog and feed it some of your snacks";
  public static final int VALUE_FEED_DOG = +1;
  public static final String RESULT_FEED_DOG = "You give the dog some of your snacks. As you begin walking away, the dog gets up and follows you.";
  public static final boolean RESULT_NEW_DOG_STATUS = true;
  public static final String REMOVE_FEED_DOG = PhysicalObject.SNACKS;

  public static final String ACTION_LEAVE_DOG = "Continue down the road, ignore the dog, and preserve the little food you have";
  public static final int VALUE_LEAVE_DOG = -1;
  public static final String RESULT_LEAVE_DOG = "You decide it’s best to save your own food so you leave the dog to fend for its own.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_BIKERS = "You continue on your way and see a small band of bikers attacking a small camp of clearly starving travelers. " +
      "You notice that the bikers only have knives. Since you have a gun, you could easily protect the travelers.";

  public static final String RESULT_BIKERS_COMMON = "The bikers shout at you that the travelers are actually cannibals who ate one of bikers.";

  public static final String ACTION_ATTACK_BIKERS_DOG = "Attack the bikers to save the travelers";
  public static final int VALUE_ATTACK_BIKERS_DOG = -1;
  public static final String RESULT_ATTACK_BIKERS_DOG = "You rush at the bikers, and your dog follows suit. It only takes a second before they notice you. " + RESULT_BIKERS_COMMON;
  public static final boolean ACTION_REQUIRES_DOG = true;

  public static final String ACTION_ATTACK_BIKERS_NO_DOG = "Attack the bikers to save the travelers";
  public static final int VALUE_ATTACK_BIKERS_NO_DOG = -1;
  public static final String RESULT_ATTACK_BIKERS_NO_DOG = "You rush at the bikers. It only takes a second before they notice you. " + RESULT_BIKERS_COMMON;
  public static final boolean ACTION_REQUIRES_NO_DOG = false;

  public static final String ACTION_ASK_BIKERS = "Grab the bikers' attention and ask them whats happening";
  public static final int VALUE_ASK_BIKERS = +2;
  public static final String RESULT_ASK_BIKERS = "You manage to capture the bikers' attention. " + RESULT_BIKERS_COMMON;

  // ================================================================================================================================================== \\

  public static final String PROMPT_BIKERS_NEXT = "You take a second to rethink the situation with this new information.";

  public static final String ACTION_KILL_BIKERS = "Help the cannibals and kill the bikers for attacking them";
  public static final int VALUE_KILL_BIKERS = -2;
  public static final String RESULT_KILL_BIKERS = "The cannibals thank you for the help. In return, they give you REWARD.";
  public static final String ADD_KILL_BIKERS_REWARD = "REWARD FROM CANNIBALS";

  public static final String ACTION_KILL_CANNIBALS = "Help the bikers and kill the cannibals for eating people";
  public static final int VALUE_KILL_CANNIBALS = -1;
  public static final String RESULT_KILL_CANNIBALS = "The bikers thank you for the help. In return, they give you REWARD.";
  public static final String ADD_KILL_CANNIBALS_REWARD = "REWARD FROM BIKERS";

  public static final String ACTION_KILL_ALL = "Kill everyone in hopes of finding good loot";
  public static final int VALUE_KILL_ALL = -3;
  public static final String RESULT_KILL_ALL = "After the battle you notice the road is now littered with blood, guts, and bodies.";
  public static final String ADD_KILL_ALL_REWARD = "REWARD FROM BOTH";

  public static final String ACTION_LEAVE_ALL = "Quickly run away and let them resolve their own problems";
  public static final int VALUE_LEAVE_ALL = 0;
  public static final String RESULT_LEAVE_ALL = "You run away, thinking about how you shouldn't stick your nose in other people's problems";

  // ================================================================================================================================================== \\

  public static final String PROMPT_SHOVEL = "After a few minutes, you notice a shovel laying at the edge of the road. You don't see anyone around. The shovel is " +
      "a little rusted, but it still looks functional. You know that carrying the shovel will slow you down, but it could be useful.";

  public static final String ACTION_TAKE_SHOVEL = "Take the shovel";
  public static final int VALUE_TAKE_SHOVEL = -1;
  public static final String RESULT_TAKE_SHOVEL = "You decide it's definitely worth it to carry the the shovel. You strap it to you backpack and chug along.";
  public static final String ADD_SHOVEL = PhysicalObject.SHOVEL;

  public static final String ACTION_LEAVE_SHOVEL = "Leave the shovel";
  public static final int VALUE_LEAVE_SHOVEL = 0;
  public static final String RESULT_LEAVE_SHOVEL = "You decide that the extra weight is not worth the trouble, especially because you don't know who the shovel belongs to.";

  // ================================================================================================================================================== \\

  // ABANDONED HOUSE

  // ================================================================================================================================================== \\

  // SCIENTIST HUMAN EXPERIMENTS

  // ================================================================================================================================================== \\

  public static final String PROMPT_BOR = "You come across the Bill of Rights.";

  public static final String ACTION_BOR_PROTECT = "Take the Bill of Rights with the intention to protect it";
  public static final int VALUE_BOR_PROTECT = +2;
  public static final String RESULT_BOR_PROTECT = "You take the Bill of Rights and decide it's worth protecting to preserve it.";
  public static final String ADD_BOR = PhysicalObject.BILL_OF_RIGHTS;

  public static final String ACTION_BOR_ALTER = "Take the Bill of Rights with the intention to protect it";
  public static final int VALUE_BOR_ALTER = -2;
  public static final String RESULT_BOR_ALTER = "You take the Bill of Rights and decide to make a few edits to your advantage.";
  public static final String ADD_BOR_ALTERED = PhysicalObject.BILL_OF_RIGHTS_ALTERED;

  public static final String ACTION_BOR_HIDE = "Hide the Bill of Rights and pretend you never found it";
  public static final int VALUE_BOR_HIDE = -1;
  public static final String RESULT_BOR_HIDE = "You hide the Bill of Rights back where you found it.";

  public static final String ACTION_BOR_HIDE_SHOVEL = "Bury the Bill of Rights and pretend you never found it";
  public static final int VALUE_BOR_HIDE_SHOVEL = -1;
  public static final String RESULT_BOR_HIDE_SHOVEL = "You use your shovel to bury Bill of Rights so no one can find it.";


  // ================================================================================================================================================== \\
}
