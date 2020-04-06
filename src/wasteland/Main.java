package wasteland;

import wasteland.data.World;
import wasteland.decision.Choice;
import wasteland.decision.IChoice;
import wasteland.decision.INode;
import wasteland.decision.Node;
import wasteland.util.Constants;
import wasteland.util.PhysicalObject;

import java.io.IOException;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    boolean isInfected = new Random().nextBoolean();

    // Some welcome message when the game starts
    System.out.println(Constants.GAME_WELCOME);

    String infectionStatus = isInfected ? Constants.INTRO_INFECTED : Constants.INTRO_SAFE;
    System.out.println(infectionStatus);

    System.out.print("Press 'ENTER' to start... ");
    waitOnKeyPressEnter();

    // Start the game
    Controller controller = new Controller(isInfected);
    controller.run();
  }

  private static int waitOnKeyPressEnter() {
    try {
      int val = System.in.read();
      System.out.println();
      return val;
    } catch (IOException e) {
      return -1;
    }
  }
}
