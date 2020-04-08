package wasteland;

import org.apache.commons.text.WordUtils;
import wasteland.util.Constants;

import java.io.IOException;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    System.out.println("\033[H\033[2J");
    boolean isInfected = new Random().nextBoolean();

    // Some welcome message when the game starts
    printWrap(Constants.GAME_WELCOME);
    waitOnKeyPressEnter();
    printWrap(Constants.GAME_START);

    // Start the game
    Controller controller = new Controller(isInfected);
    controller.run();
  }

  private static int waitOnKeyPressEnter() {
    try {
      return System.in.read();
    } catch (IOException e) {
      return -1;
    }
  }

  private static void printWrap() {
    System.out.println();
  }

  private static void printWrap(String text) {
    System.out.println(WordUtils.wrap(text, Constants.WRAP_LEN));
  }
}
