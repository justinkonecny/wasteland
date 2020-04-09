package wasteland.data;

import wasteland.util.PhysicalObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class World {

  public static final String PROMPT_WAKE_HOSPITAL_INFECTED = "You wake up in an empty hospital. You look down at your deformed skin covered in " +
      "boils and scars, remembering the discrimination and hate you suffered from your friends and family before you were taken to the hospital.";

  public static final String PROMPT_WAKE_HOSPITAL_IMMUNE = "You wake up in an empty hospital. You look down and see your clear skin, remembering you were one of the lucky few to be immune to the virus.";

  public static final String ACTION_STAY_HOSPITAL = "Stay in the hospital";
  public static final int VALUE_STAY_HOSPITAL = 0;
  public static final String RESULT_STAY_HOSPITAL = "A week passes and no one comes, so you decide to leave anyway. ";

  public static final String ACTION_LEAVE_HOSPITAL = "Leave to go home";
  public static final int VALUE_LEAVE_HOSPITAL = 0;
  public static final String RESULT_LEAVE_HOSPITAL = "You leave the hospital and make your way to your house. You discover your daughter is gone. You had told her to wait at the house in case anything " +
      "happened, however she is nowhere to be found. You remember she had been infected, but was one of the lucky few who had survived, but not without being permanently scarred. You know the " +
      "hate that is held for people like her now, and you fear for her well being.Your main goal is now to find her. You grab a backpack and pack up some supplies, and you start " +
      "on your journey to a nearby military base, which is where the government told everyone to go before The Event.";
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

  public static final String ACTION_ATTACK_BIKERS_NO_DOG = "Attack the bikers to save the travelers";
  public static final int VALUE_ATTACK_BIKERS_NO_DOG = -1;
  public static final String RESULT_ATTACK_BIKERS_NO_DOG = "You rush at the bikers. It only takes a second before they notice you. " + RESULT_BIKERS_COMMON;

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
  public static final String RESULT_LEAVE_ALL = "You run away, thinking about how you shouldn't stick your nose in other people's problems.";

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

  public static final String PROMPT_HOUSE = "You notice a house set back far off the road that looks old and abandoned.";

  public static final String ACTION_HOUSE_LEAVE = "Continue along the road and ignore the house";
  public static final int VALUE_HOUSE_LEAVE = 0;
  public static final String RESULT_HOUSE_LEAVE = "You keep moving. It's not worth the risk to enter the house.";

  public static final String ACTION_HOUSE_ENTER = "Find a way in to look for supplies";
  public static final int VALUE_HOUSE_ENTER = 0;
  public static final String RESULT_HOUSE_ENTER = "You approach the house and find that the front door is unlocked. You open the door and walk inside.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_HOUSE_LADY = "A perfectly clean house, with the table set and ready for dinner. You check the cabinets and they're full of food and supplies. " +
      "An elderly woman comes down the stairs, delighted to see you. She asks you to help her carry a box of medical supplies up the stairs for her.";

  public static final String ACTION_HOUSE_LADY_HELP = "Help the old lady and carry the supplies up the stairs";
  public static final int VALUE_HOUSE_LADY_HELP = +2;
  public static final String RESULT_HOUSE_LADY_HELP = "You pick up the supplies and walk up the stairs. She has you place them in an empty room at the end of the hall.";

  public static final String ACTION_HOUSE_LADY_STEAL = "Grab the box of supplies and run out of the house";
  public static final int VALUE_HOUSE_LADY_STEAL = -2;
  public static final String RESULT_HOUSE_LADY_STEAL = "You pick up the supplies and make a dash for the door. She begins shouting and begging you to come back, but you know that she can't stop you. " +
      "As you step out the door, you hear her scream that she's going to die without those. You continue running away. When you make it far enough, you stop and pack the supplies in your backpack.";
  public static final String ADD_HOUSE_LADY_STEAL = PhysicalObject.MED_SUPPLIES;

  // ================================================================================================================================================== \\

  public static final String PROMPT_HOUSE_DINNER = "The lady is delighted that you helped her. She asks you to sit down for dinner as a thank you.";

  public static final String ACTION_HOUSE_DINNER_STAY = "Accept the offer and stay for dinner";
  public static final int VALUE_HOUSE_DINNER_STAY = 0;
  public static final String RESULT_HOUSE_DINNER_STAY = "She prepares dinner and you both sit down at the table. The woman says a prayer and you eat a nice meal. " +
      "She offers you the extra bed upstairs so you decided to stay for the night. You wake up well-rested, thank her, and leave back out the way you came in.";

  public static final String ACTION_HOUSE_DINNER_LEAVE = "Deny the offer and leave";
  public static final int VALUE_HOUSE_DINNER_LEAVE = 0;
  public static final String RESULT_HOUSE_DINNER_LEAVE = "The longer you stay in the house, the more anxious you feel, so you decide that it's time leave. You thank her quickly walk out the door you entered.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_SCIENTIST = "It’s beginning to get dark as the sun begins to slowly lower below the horizon. You realize it’s not safe to be wandering outside, " +
      "so you begin frantically searching for shelter. You come across a strange looking cement bunker, but it’s the only building in sight so you decide to enter. " +
      "You discover an elevator, so you decide to take it down to the basement to find a good place to sleep. As the doors open, a horrific sight opens up before you. " +
      "A long corridor of jail cells stretches out in front of you, each one with an infected person inside. Some are dead, and the rest are barely alive, " +
      "not even glancing in your direction as you walk past. Most of them appear to have prosthetics and other gadgets attached to their bodies. Eventually " +
      "you reach the end of the corridor and find the scientist that had been performing on all of the infected people. He seems delighted to see you, and asks " +
      "if you can help him capture more infected people to test on in exchange or some enhancements he has been working on.";

  public static final String ACTION_SCIENTIST_ACCEPT = "Accept the task, and spend the rest of the night raiding camps and houses";
  public static final int VALUE_SCIENTIST_ACCEPT = -2;
  public static final String RESULT_SCIENTIST_ACCEPT = "You agree to help and return to the bunker with three prisoners, and the scientist locks them away. " +
      "He then injects you with a serum making you faster and stronger, almost unstoppable in this new world.";

  public static final String ACTION_SCIENTIST_LEAVE = "Do nothing and leave the bunker in search of a different place to shelter";
  public static final int VALUE_SCIENTIST_LEAVE = -1;
  public static final String RESULT_SCIENTIST_LEAVE = "You leave the bunker, confused and conflicted. His practices were clearly very inhumane and evil, " +
      "but you need to look after yourself and find your daughter. That situation simply wasn't your problem.";

  public static final String ACTION_SCIENTIST_KILL = "Kill the scientist and free the test subjects";
  public static final int VALUE_SCIENTIST_KILL = +1;
  public static final String RESULT_SCIENTIST_KILL = "You pull out your shotgun and kill the scientist where he stands. He was clearly an evil man with no value for human life. " +
      "You free the starving test subjects and they thank you and praise you, showing you a better gun that they had seen the scientist working on.";
  public static final String ADD_SCIENTIST_KILL = PhysicalObject.RAY_GUN;

  // ================================================================================================================================================== \\

  public static final String INTERMISSION = "You have made it very far in your journey, but you’ve learned nothing further about the location or " +
      "condition of your daughter. She could very well be dead. However, throughout your journey most of the people you have encountered have " +
      "told you the military base is no longer around, and it has succumbed to The Plague, confirming that society as you knew it was gone. " +
      "Instead, the military base had transformed into a small, lawless town. The only civilization that you knew still existed. However, " +
      "you have heard rumors that the infected are treated as slaves in this small community, meaning your daughter could be in grave danger. " +
      "You decide this will be your best bet to find your daughter, so continue on your journey.\n\n";

  // ================================================================================================================================================== \\

  public static final String PROMPT_BOR = INTERMISSION + "You notice a piece of paper sticking out of a bush. You approach it and realize it’s the Bill of Rights.";

  public static final String ACTION_BOR_PROTECT = "Take the Bill of Rights with the intention to protect it";
  public static final int VALUE_BOR_PROTECT = +2;
  public static final String RESULT_BOR_PROTECT = "You take the Bill of Rights and decide it's worth protecting to preserve it.";
  public static final String ADD_BOR = PhysicalObject.BILL_OF_RIGHTS;

  public static final String ACTION_BOR_ALTER = "Take the Bill of Rights with the intention to change it";
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

  public static final String PROMPT_STUFFED_ANIMAL = "You find a small stuffed animal hidden in a bush along the road. It has the name “Sarah” written on the foot of it.";

  public static final String ACTION_STUFFED_ANIMAL_TAKE = "Pick it up";
  public static final int VALUE_STUFFED_ANIMAL_TAKE = 0;
  public static final String RESULT_STUFFED_ANIMAL_TAKE = "You pick up the stuffed animal.";
  public static final String ADD_STUFFED_ANIMAL_TAKE = PhysicalObject.STUFFED_ANIMAL;

  public static final String ACTION_STUFFED_ANIMAL_LEAVE = "Ignore it and keep going";
  public static final int VALUE_STUFFED_ANIMAL_LEAVE = 0;
  public static final String RESULT_STUFFED_ANIMAL_LEAVE = "You leave the stuffed animal where it was.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_GRAVE = "You find a grave on the side of the road, neatly made with dying flowers all around it. There is a wedding ring carefully " +
      "laid on top of the stone marking the grave, most likely placed there by the significant other of the deceased person.";

  public static final String ACTION_GRAVE_TAKE = "Steal the ring with the intent to sell it";
  public static final int VALUE_GRAVE_TAKE = -1;
  public static final String RESULT_GRAVE_TAKE = "You pick up the wedding ring.";
  public static final String ADD_GRAVE_TAKE = PhysicalObject.WEDDING_RING;

  public static final String ACTION_GRAVE_LEAVE = "Leave the ring to honor the deceased";
  public static final int VALUE_GRAVE_LEAVE = +1;
  public static final String RESULT_GRAVE_LEAVE = "Out of respect to the victim, you decide to leave the ring where it is.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_INF_MOTHER = "You come across a mother and child who are clearly starving on the side of the road, but you only have enough food to last you until the town.";

  public static final String ACTION_INF_MOTHER_GIVE = "Share your food";
  public static final int VALUE_INF_MOTHER_GIVE = +1;
  public static final String RESULT_INF_MOTHER_GIVE = "You give them some food.";
  public static final String REMOVE_INF_MOTHER_GIVE = PhysicalObject.CANNED_FOOD;

  public static final String ACTION_INF_MOTHER_REFUSE = "Keep moving";
  public static final int VALUE_INF_MOTHER_REFUSE = -1;
  public static final String RESULT_INF_MOTHER_REFUSE = "You lie and say you don't have any.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_INF_GIRL = "The child sees the stuffed animal.";

  public static final String ACTION_INF_GIRL_GIVE = "Give her the stuffed animal";
  public static final int VALUE_INF_GIRL_GIVE = +1;
  public static final String RESULT_INF_GIRL_GIVE = "You give her the stuffed animal.";
  public static final String REMOVE_INF_GIRL_GIVE = PhysicalObject.STUFFED_ANIMAL;

  public static final String ACTION_INF_GIRL_REFUSE = "Keep the stuffed animal";
  public static final int VALUE_INF_GIRL_REFUSE = -1;
  public static final String RESULT_INF_GIRL_REFUSE = "You refuse to give the girl the animal and you tell her its for your daughter.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_CAPTURED = "You are captured and brought to a town to work as a slave. They give you food, water, and shelter, but force you to do hard labor all day. You are aware that this town’s existence requires your labor.";

  public static final String ACTION_CAPTURED_AGREE = "Continue on as a slave for the rest of your life";
  public static final int VALUE_CAPTURED_AGREE = 0;
  public static final String RESULT_CAPTURED_AGREE = "TBD";

  public static final String ACTION_CAPTURED_REVOLT = "Start a violent revolt with your fellow slaves";
  public static final int VALUE_CAPTURED_REVOLT = +1;
  public static final String RESULT_CAPTURED_REVOLT = "TBD";

  public static final String ACTION_CAPTURED_EQUAL = "Work with your captors peacefully to try and build a more equal society";
  public static final int VALUE_CAPTURED_EQUAL = +2;
  public static final String RESULT_CAPTURED_EQUAL = "TBD";

  // ================================================================================================================================================== \\

  public static final String PROMPT_IMN_MOTHER = "You finally make it into the military base/town. You come across a mother and child who are clearly starving on the side of the road, but you only have enough food to last you until the town.";

  public static final String ACTION_IMN_MOTHER_GIVE = "Share your food";
  public static final int VALUE_IMN_MOTHER_GIVE = +1;
  public static final String RESULT_IMN_MOTHER_GIVE = "You give them some food.";
  public static final String REMOVE_IMN_MOTHER_GIVE = PhysicalObject.CANNED_FOOD;

  public static final String ACTION_IMN_MOTHER_REFUSE = "Keep moving";
  public static final int VALUE_IMN_MOTHER_REFUSE = -1;
  public static final String RESULT_IMN_MOTHER_REFUSE = "You lie and say you don't have any.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_IMN_GIRL = "The child sees the stuffed animal.";

  public static final String ACTION_IMN_GIRL_GIVE = "Give her the stuffed animal";
  public static final int VALUE_GIRL_IMN_GIVE = +1;
  public static final String RESULT_IMN_GIRL_GIVE = "You give her the stuffed animal.";
  public static final String REMOVE_IMN_GIRL_GIVE = PhysicalObject.STUFFED_ANIMAL;

  public static final String ACTION_IMN_GIRL_REFUSE = "Keep the stuffed animal";
  public static final int VALUE_IMN_GIRL_REFUSE = -1;
  public static final String RESULT_IMN_GIRL_REFUSE = "You refuse to give the girl the animal and you tell her its for your daughter.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_WANDER = " You wander through this town using the infected people as a slave labor force. They are prospering in these difficult times, and the leader of the town asks you to stay, being aware of your many abilities and achievements.";

  public static final String ACTION_WANDER_STAY = "Stay and enjoy a life of luxury";
  public static final int VALUE_WANDER_STAY = -2;
  public static final String RESULT_WANDER_STAY = "TBD";

  public static final String ACTION_WANDER_REVOLT = "Organize a revolt against the town with the slaves";
  public static final int VALUE_WANDER_REVOLT = +1;
  public static final String RESULT_WANDER_REVOLT = "TBD";

  public static final String ACTION_WANDER_EQUAL = "Help the slaves peacefully gain equality knowing the town’s dependence on their labor";
  public static final int VALUE_WANDER_EQUAL = +2;
  public static final String RESULT_WANDER_EQUAL = "TBD";

  // ================================================================================================================================================== \\
}
