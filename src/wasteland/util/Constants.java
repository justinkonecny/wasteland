package wasteland.util;

public class Constants {

  public static final int WRAP_LEN = 82;

  public static final String DIVIDER = "####################################################################################################";

  public static final String GREEN = "\u001B[32m";
  public static final String RESET = "\033[0m";

  public static final String GAME_WELCOME = "Welcome to the Apocalypse. In this simulation, you will be faced with many different scenarios and situations that will push you to make a choice on how to proceed. " +
      "Each choice you make affects the course of the story, and the outcome of your journey. Who will you become in this post-apocalyptic world? Will you be a guardian angel, " +
      "upholding your morals and helping those in need, or will you succumb to the lawlessness of your new world, and become a dangerous and greedy killer? " + GREEN + "Hit ENTER to begin" + RESET + ".";

  public static final String GAME_START = "A plague has swept across the globe, killing most of the world’s population. Very few people remain on this crumbling planet, " +
      "and a stark division has been created amongst the remaining survivors of The Event. Very few people were able to survive the horrible ordeal induced by The Plaque, " +
      "causing paralysis, madness, and eventually death. However, the few that were able to withstand the virus were not left unscathed. Their skin became visibly marked by " +
      "horrendous boils and scars covering their body; a reminder for eternity of the pain they had to suffer through. However, this reminder was not just for themselves. " +
      "Even fewer people were immune to the virus, but they were able to come out of the The Event in near perfect conditions, with no scars on their body, but permanent " +
      "scars in their mind of the countless loved ones they lost to the Infected. Because of these visible markings, the Immune discriminate heavily against those that " +
      "survived the virus, believing them to be the reason for The Event. No help or compassion are offered to the infected, and in some cases slavery has risen again, " +
      "using these deformed people as a source of cheap and replaceable labor...";

  public static final String INTRO_INFECTED = "You are a survivor of the infection.";
  public static final String INTRO_SAFE = "You are lucky enough to had never had the infection.";

  public static final String USER_PROMPT_BEFORE = "You can...";
  public static final String USER_PROMPT_AFTER = "What do you do? ";

  public static final String FMT_OPTION = "[%d] %s";

  public static final String FMT_SELECTED = "User selected: [%d]";

  public static final String INVENTORY_UPDATE = "Your inventory has been updated, you now have:";

  public static final String GAME_END = "This is the end of your journey. You have made it far, and accomplished much. You have made many decisions along the way, all which may have " +
      "had an impact on other people or yourself. Throughout this simulation, each decision you have made has given you a score, based on the morals of the current society we live in. " +
      "For example, pursuing a peaceful resolution awards +2 points and a violent one may remove 2 points. This simulation was meant to present many difficult situations, where the " +
      "morally correct choice may not be obvious, but it was graded off our beliefs, and therefore the score is up to interpretation. Your “Karma Score” is displayed below.\n\n" +
      "The game has ended! Your karma score is: %d";

  public static final String GAME_END_INVENTORY = "Your final inventory is:";

  public static final String KARMA_NEGATIVE = "You used the lawlessness of this new post-apocalyptic world to your advantage. You chose to make decisions that  either hurt other people, " +
      "or would have been considered wrong in your society. However, in this simulation society is gone, and therefore it’s morals have no enforcers other than yourself. ";

  public static final String KARMA_ZERO = "You were neither good or bad in this new post-apocalyptic world. You decided to make decisions that would benefit you, " +
      "while also keeping a foundation of morals in the back of your head. ";

  public static final String KARMA_POSITIVE = "You were compassionate and noble in this otherwise lawless simulation. You had the options and the capability " +
      "to live however you wanted, but you decided to uphold the morals of the society that came before this post-apocalyptic world. The morals of a " +
      "society can only survive if they are upheld by the people in it, and you decided to be one of the last enforcers of good.";
}
