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
  public static final String RESULT_KILL_BIKERS = "The cannibals thank you for the help. In return, they give you some food and ammunition for your gun.";
  public static final Set<String> ADD_KILL_BIKERS_REWARD = new HashSet<String>(Arrays.asList(
      PhysicalObject.FOOD,
      PhysicalObject.AMMO
  ));

  public static final String ACTION_KILL_CANNIBALS = "Help the bikers and kill the cannibals for eating people";
  public static final int VALUE_KILL_CANNIBALS = -1;
  public static final String RESULT_KILL_CANNIBALS = "The bikers thank you for the help. In return, they give you a leather jacket to keep you warm.";
  public static final String ADD_KILL_CANNIBALS_REWARD = PhysicalObject.LEATHER_JACKET;

  public static final String ACTION_KILL_ALL = "Kill everyone in hopes of finding good loot";
  public static final int VALUE_KILL_ALL = -3;
  public static final String RESULT_KILL_ALL = "After the battle you notice the road is now littered with blood, guts, and bodies. You take the leather jacket " +
      "off one of the bikers and you find some ammunition and food scrapes that the travelers had.";
  public static final Set<String> ADD_KILL_ALL_REWARD = new HashSet<String>(Arrays.asList(
      PhysicalObject.LEATHER_JACKET,
      PhysicalObject.FOOD,
      PhysicalObject.AMMO
  ));

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
      "She offers you the extra bed upstairs but you decided not to stay for the night. You leave back out the way you came in.";

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

  public static final String PROMPT_BOR = INTERMISSION + "You notice a piece of paper sticking out of a bush. You approach the piece of paper and end up finding " +
      "a couple of sheets of paper with the fist one titled “The Bill of Rights.” You start reading it and discover that this what you have in your hands are a " +
      "set of laws that the founders of the country have designed to protect the basic rights of the citizens, guaranteeing the freedom of speech, press, " +
      "assembly, and exercise of religion; the right to fair legal procedure and to bear arms; and that powers not delegated to the central government were " +
      "to be made by the people. Protecting and delivering this document to the people would empower them with rights that they once possessed. Altering the " +
      "document then delivering it to the people can help you achieve personal goals. Hiding it would be a simple solution.";

  public static final String ACTION_BOR_PROTECT = "Take the Bill of Rights with the intention to protect it";
  public static final int VALUE_BOR_PROTECT = +2;
  public static final String RESULT_BOR_PROTECT = "You decided to protect The Bill of Rights. Therefore, that document can be used to peacefully restore your broken society.";
  public static final String ADD_BOR = PhysicalObject.BILL_OF_RIGHTS;

  public static final String ACTION_BOR_ALTER = "Take the Bill of Rights with the intention to change it";
  public static final int VALUE_BOR_ALTER = -2;
  public static final String RESULT_BOR_ALTER = "You chose to alter the document. You have added amendments that you think would help you achieve your " +
      "personal goals. While your main goal is to find and rescue your daughter, you still have other goals such as achieving a better socioeconomic " +
      "standing and becoming a part of the governing body within the town.";
  public static final String ADD_BOR_ALTERED = PhysicalObject.BILL_OF_RIGHTS_ALTERED;

  public static final String ACTION_BOR_HIDE = "Hide the Bill of Rights and pretend you never found it";
  public static final int VALUE_BOR_HIDE = -1;
  public static final String RESULT_BOR_HIDE = "You chose to hide The Bill of Rights. Because of that, the oppressed continue to be oppressed and laws " +
      "that were put in place to guarantee basic human rights do not exist anymore. You simply hide it in the place you found it.";

  public static final String ACTION_BOR_HIDE_SHOVEL = "Bury the Bill of Rights and pretend you never found it";
  public static final int VALUE_BOR_HIDE_SHOVEL = -1;
  public static final String RESULT_BOR_HIDE_SHOVEL = "You chose to hide The Bill of Rights. Because of that, the oppressed continue to be oppressed and " +
      "laws that were put in place to guarantee basic human rights do not exist anymore. You use your shovel to bury Bill of Rights so no one can find it.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_STUFFED_ANIMAL = "You leave the bush, you continue walking towards the town. You are still in what seems to be a " +
      "darkly foreboding forest. You hear ominous sounds, creaking and the whispering of the trees. You pass through thick leaves, overhanging branches, " +
      "narrow and twisting paths, denser wood, thicker bushes, ditched, sprawling branches. and stiff branches. You are paying every ounce of attention " +
      "while walking through that forest because you want to reach the town and rescue your daughter. As the tree density decreases and you are less " +
      "occupied by clearing out your path, you find a small stuffed animal hidden in a bush along the road. It has the name “Sarah” written on the foot of it. ";

  public static final String ACTION_STUFFED_ANIMAL_TAKE = "Pick it up";
  public static final int VALUE_STUFFED_ANIMAL_TAKE = 0;
  public static final String RESULT_STUFFED_ANIMAL_TAKE = "You think to yourself and find ways that you can use this toy to your benefit later on. " +
      "You think that you could give it to a child to find water or shelter. You think you could give it to your daughter when you see her, an act " +
      "that would make her really happy. You keep thinking of ways that this stuffed animal could help you so you decided to pick it up and take it with you.";
  public static final String ADD_STUFFED_ANIMAL_TAKE = PhysicalObject.STUFFED_ANIMAL;

  public static final String ACTION_STUFFED_ANIMAL_LEAVE = "Ignore it and keep going";
  public static final int VALUE_STUFFED_ANIMAL_LEAVE = 0;
  public static final String RESULT_STUFFED_ANIMAL_LEAVE = "You are wandering and doing your best to reach the town to save your daughter. You do not think " +
      "this toy is going to benefit you in any way during your journey so you decide to leave it as is and keep going.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_GRAVE = "While trying to safely reach the town, you start to think about death. You imagine your death — the heart stopping, " +
      "no breath, the circulation stopping, the muscle relaxing, the skin succumbing to gravity, the skin going pale, blood setting in parts of the body " +
      "closest to the ground, the exposed surface of the body radiating heat; blood leaving from the walls of the vessels to stain the tissues, purple-red " +
      "blotches on the skin merging to form large areas of discoloration, the muscles of the eyelids stiffening, the brain liquefying — and while you are " +
      "still thinking you come across a strange sight. You find a grave on the side of the road, neatly made with dying flowers all around it. There is a " +
      "wedding ring carefully laid on top of the stone marking the grave, most likely placed there by the significant other of the deceased person.";

  public static final String ACTION_GRAVE_TAKE = "Steal the ring with the intent to sell it";
  public static final int VALUE_GRAVE_TAKE = -1;
  public static final String RESULT_GRAVE_TAKE = "You decided to take the ring and sell it because you know that during this time, a wedding " +
      "ring can be sold for a great sum of money. You do not know what you are going to face later on and how much money you are going to need " +
      "so you use that as a justification for taking the ring and selling it.";
  public static final String ADD_GRAVE_TAKE = PhysicalObject.WEDDING_RING;

  public static final String ACTION_GRAVE_LEAVE = "Leave the ring to honor the deceased";
  public static final int VALUE_GRAVE_LEAVE = +1;
  public static final String RESULT_GRAVE_LEAVE = "You decided to leave the ring. You have been in your thoughts about the helplessness of death and the sorrow you have been living in after the kidnapping of your " +
      "daughter. You feel for the significant other who left the ring at the tomb and decide to leave it as to respect the significant other and to honor the victim.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_INF_MOTHER = "You finally see the outline of a town far off in the distance at the end of the road. You daughter could be " +
      "in that town, but you know it’s dangerous to go. You know the hate that is held by The Immune towards infected people such as yourself, and you’ve " +
      "heard rumors of your kind being used as slaves, but you decide to press on. Not even half a mile later, you discover a starving mother and child c" +
      "owering beneath the wreckage of a truck. You approach them and notice they are infected like you. They are clearly starving and need food.";

  public static final String ACTION_INF_MOTHER_GIVE = "Share your food with the mother and child";
  public static final int VALUE_INF_MOTHER_GIVE = +1;
  public static final String RESULT_INF_MOTHER_GIVE = "The mother is eternally grateful for your kind actions. She and her daughter will be able to live another day. " +
      "You tell her of your journey to the town, and she warns you of the harsh treatment The Infected receive in that town.";
  public static final String REMOVE_INF_MOTHER_GIVE = PhysicalObject.CANNED_FOOD;

  public static final String ACTION_INF_MOTHER_REFUSE = "Refuse to share your food with the mother and child, and leave them";
  public static final int VALUE_INF_MOTHER_REFUSE = -1;
  public static final String RESULT_INF_MOTHER_REFUSE = "You decided you can’t waste anymore food. You’ve come this far and you’re starving. Food may be a valuable resource in the town ahead that you could use to your advantage. ";

  // ================================================================================================================================================== \\

  public static final String PROMPT_INF_GIRL = "As you turn away from the starving people, the little girl sees the stuffed animal you had picked up a while ago. She softly asks you if she can have it with a huge smile on her face.";

  public static final String ACTION_INF_GIRL_GIVE = "Give the little girl the stuffed animal";
  public static final int VALUE_INF_GIRL_GIVE = +1;
  public static final String RESULT_INF_GIRL_GIVE = "The mother and child are thankful for your generosity, and the girl holds the stuffed animal close to her, happy to have a new friend.";
  public static final String REMOVE_INF_GIRL_GIVE = PhysicalObject.STUFFED_ANIMAL;

  public static final String ACTION_INF_GIRL_REFUSE = "Keep the stuffed animal for yourself, deciding to give it to your daughter later on";
  public static final int VALUE_INF_GIRL_REFUSE = -1;
  public static final String RESULT_INF_GIRL_REFUSE = "You decline her request, and walk away with the stuffed animal securely in your backpack. The happiness of your daughter is more important to you than anyone else.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_CAPTURED = "The town gets closer and closer as you continue to make your way along the road. Excitement fills your head with the belief that your daughter " +
      "will be there waiting for you. Suddenly, you hear the loud engine of a car getting closer and closer. You turn around, a huge truck is driving straight for you. You begin to run towards " +
      "the town, but the truck pulls in front of you and two Immune men jump out and grab you, tying you up and throwing you into the trunk. You struggle and kick, attempting to escape, but it’s no use.\n\n" +
      "Hours later, you wake up and find yourself in a cell with a couple other infected people looking nervously at you. You ask them where you are, and they tell you that you’re in the town you " +
      "were searching for, but infected people such as yourself are used for hard labor, and you have a life of slavery and oppression stretched out before you. You decide you have a couple options for what to do next.";

  public static final String ACTION_CAPTURED_AGREE = "Continue on as a slave for the rest of your life, making the most of your work and hoping to achieve freedom someday";
  public static final int VALUE_CAPTURED_AGREE = 0;
  public static final String RESULT_CAPTURED_AGREE = "Weeks pass as you wake up each and every day, washing clothes and gathering food for The Immune. They barely give you enough food and water to live, " +
      "and you spend your sleepless nights in a cold and damp cell with four other Infected. All hope of finding your daughter, and you have committed yourself to servitude. Then, one day you " +
      "find your daughter serving food to The Immune, and you hug her as you have a brief reunion. Your captors scream at you, and tell you to continue working, but you have found your daughter and you know she is safe.";

  public static final String ACTION_CAPTURED_REVOLT = "Revolt violently with your fellow slaves";
  public static final int VALUE_CAPTURED_REVOLT = +1;
  public static final String RESULT_CAPTURED_REVOLT = "You decide living as a slave is no way to continue, so over the next coming weeks you organize a revolt amongst the other infected, " +
      "arming yourselves with rocks and planks of wood. The day comes to fight for your freedom, and when you hear the horn sound throughout the town, you attack your captors, taking whatever " +
      "weapons you can. In the middle of the fight, you look to your right and see your daughter joining in the conflict. You run to her, fighting alongside, eventually driving out the rest " +
      "of the Immune. When the day is won, you celebrate and look forward to a long and difficult road to recreating society.";

  public static final String ACTION_CAPTURED_EQUAL = "Work with your captors peacefully to try and build a more equal society";
  public static final int VALUE_CAPTURED_EQUAL = +2;
  public static final String RESULT_CAPTURED_EQUAL_BILL = "You decide living as a slave is no way to continue, so over the next coming weeks you gather the other Infected and teach them of the world before, " +
      "showing them the Bill of Rights you had obtained. You organize a strike and peaceful protests throughout the town. It takes weeks, but eventually the Immune decide " +
      "to free you and you fellow Infected. One day you begin to rebuild your home with some other Infected people, and you hear a knock on your door. You open it, and standing there is your daughter. " +
      "You live together happily ever after, starting a new life together.";
  public static final String RESULT_CAPTURED_EQUAL_NO_BILL = "You decide living as a slave is no way to continue, so over the next coming weeks you gather the other Infected and teach them of the world before. " +
      "You organize a strike and peaceful protests throughout the town. It takes weeks, but eventually the Immune decide " +
      "to free you and you fellow Infected. One day you begin to rebuild your home with some other Infected people, and you hear a knock on your door. You open it, and standing there is your daughter. " +
      "You live together happily ever after, starting a new life together.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_IMN_MOTHER = "Days later, you finally see the outline of civilization in the distance. Hope fills your heart as you try to believe that your " +
      "daughter is waiting for you there. You finally make it into the town, and the first thing you see is a mother and child who are clearly starving huddling in a dark alley. " +
      "You have some food available to give them, but you know that might be a valuable resource here.";

  public static final String ACTION_IMN_MOTHER_GIVE = "Share your food with the starving mother and child";
  public static final int VALUE_IMN_MOTHER_GIVE = +1;
  public static final String RESULT_IMN_MOTHER_GIVE = "You take the little scraps of food you have left in your backpack and hand it over to the mother. She softly smiles and thanks you for your kindness.";
  public static final String REMOVE_IMN_MOTHER_GIVE = PhysicalObject.CANNED_FOOD;

  public static final String ACTION_IMN_MOTHER_REFUSE = "Keep moving, keeping your food for something else";
  public static final int VALUE_IMN_MOTHER_REFUSE = -1;
  public static final String RESULT_IMN_MOTHER_REFUSE = "You decline the mothers beg for help, believing you’ll need this valuable food for something more important. This may have been their last chance for survival.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_IMN_GIRL = "As you turn away from the starving people, the little girl sees the stuffed animal you had picked up a while ago. She softly asks you if she can have it with a huge smile on her face.";

  public static final String ACTION_IMN_GIRL_GIVE = "Give the girl the stuffed animal";
  public static final int VALUE_GIRL_IMN_GIVE = +1;
  public static final String RESULT_IMN_GIRL_GIVE = "The mother and child are thankful for your generosity, and the girl holds the stuffed animal close to her, happy to have a new friend.";
  public static final String REMOVE_IMN_GIRL_GIVE = PhysicalObject.STUFFED_ANIMAL;

  public static final String ACTION_IMN_GIRL_REFUSE = "Keep the stuffed animal for yourself, deciding to give it to your daughter later on";
  public static final int VALUE_IMN_GIRL_REFUSE = -1;
  public static final String RESULT_IMN_GIRL_REFUSE = "You decline her request, and walk away with the stuffed animal securely in your backpack. The happiness of your daughter is more important to you than anyone else.";

  // ================================================================================================================================================== \\

  public static final String PROMPT_WANDER = "You continue wandering through town, much to your surprise seeing Immune people everywhere living almost a life of luxury. The Infected " +
      "wander the town with lifeless eyes, and skinny to the bone. The divide between populations is clear here, with the Immune ruling over the defeated Infected. You eventually find " +
      "the leader of the town, and he recognizes you immediately from the rumors he had heard of your feats. He promises you a life of luxury, which Infected looking after your every wish.";

  public static final String ACTION_WANDER_STAY = "Stay and enjoy a life of luxury";
  public static final int VALUE_WANDER_STAY = -2;
  public static final String RESULT_WANDER_STAY = "You decide you just want to live out the rest of your days in luxury, hiding from the horrible world outside the town. " +
      "Over the following weeks, you enjoy good food and plenty to drink whenever you ask for it. Every request is granted to you by The Infected, and you begin to grow " +
      "comfortable and lazy with your new life. Then, one day when you order more food to your room, your infected daughter walks in carrying your plate. Your old life " +
      "flashes back to you, and you realize how wrong your new position is over The Infected. You and your daughter escape that night, fleeing into the unknown areas around the town.";

  public static final String ACTION_WANDER_REVOLT = "Organize a revolt against the town with the slaves";
  public static final int VALUE_WANDER_REVOLT = +1;
  public static final String RESULT_WANDER_REVOLT = "You decide this new way of life is inhumane, and you need to do something about it. You agree with the leader of the town, " +
      "but later that night you sneak into the holding cells with all The Infected. You free them, and quietly give them weapons from the armory. With the cover of darkness, " +
      "you and The Infected capture and kill most of the Immune in their sleep. With the town now yours, you celebrate with The Infected. In the celebration, " +
      "you find your daughter amongst the crowd of freed people. You and her happily recreate a new town with equality for all.";

  public static final String ACTION_WANDER_EQUAL = "Help the slaves peacefully gain equality knowing the town’s dependence on their labor";
  public static final int VALUE_WANDER_EQUAL = +2;
  public static final String RESULT_WANDER_EQUAL_BILL = "You decide slavery is inhumane and not how the new world should work, so over the next coming weeks you gather " +
      "The Infected and teach them of the world before, showing them the Bill of Rights you had obtained. You organize a strike and peaceful " +
      "protests throughout the town. It takes weeks, but eventually the Immune decide to free The Infected. The Infected begin to make houses and begin their new lives, " +
      "and one day you see your daughter amongst the crowd of Infected. You reunite, and begin work on your new home as well. You live together happily ever after, starting a new life together.";
  public static final String RESULT_WANDER_EQUAL_NO_BILL = "You decide slavery is inhumane and not how the new world should work, so over the next coming weeks you gather " +
      "The Infected and teach them of the world before. You organize a strike and peaceful " +
      "protests throughout the town. It takes weeks, but eventually the Immune decide to free The Infected. The Infected begin to make houses and begin their new lives, " +
      "and one day you see your daughter amongst the crowd of Infected. You reunite, and begin work on your new home as well. You live together happily ever after, starting a new life together.";

  // ================================================================================================================================================== \\
}
