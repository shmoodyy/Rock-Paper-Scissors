package rockpaperscissors;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class RockPaperScissors extends ScoreSheet {
    final static String[] basic = {"rock", "paper", "scissors"};
    static boolean gameOver;
    String[] choices;
    StringBuilder compHand;
    Scanner scanner = new Scanner(System.in);

    RockPaperScissors() {
        System.out.print("Enter your name: ");
        playerName = scanner.next();
        System.out.println("Hello, " + playerName);
        playerScore = playerRecord(playerName);
        choiceMaker();
        do {
            String userInput = scanner.next();
            if (Objects.equals(userInput, "!rating")) {
                System.out.println("Your rating: " + playerScore);
                continue;
            }
            if (Objects.equals(userInput, "!exit")) {
                gameOver = true;
                break;
            } else {
                playGame(userInput);
            }
        } while (!gameOver);
    }

    public void choiceMaker() {
        if (scanner.hasNextLine()) { //IMPORTANT METHOD TO ACCEPT ENTER KEY AS INPUT AND CONTINUE
            scanner.nextLine();
            String userChoices = scanner.nextLine();
            choices = userChoices.length() != 0 ? userChoices.split(",") : basic;
        } else {
            choices = basic;
        }
        System.out.println("Okay, let's start");
    }

    public void playGame(String user) {
        String compInput = computerGuesser();
        int userPos = Arrays.asList(choices).indexOf(user.toLowerCase());
        int compPos = Arrays.asList(choices).indexOf(compInput);
        int threshold = choices.length / 2;
        String result;

        if (!Arrays.asList(choices).contains(user)) {
            result = "Invalid input";
        } else if (userPos == compPos) {
            result = "There is a draw (" + compInput + ")"; //draw
            playerScore += 50;
        } else if (userPos < compPos) {
            if (Math.abs(userPos - compPos) > (threshold)) {
                result = "Well done. The computer chose " + compInput + " and failed"; //win
                playerScore += 100;
            } else {
                result = "Sorry, but the computer chose " + compInput;
            }
        } else {
            if (Math.abs(userPos - compPos) <= (threshold)) {
                result = "Well done. The computer chose " + compInput + " and failed"; //win
                playerScore += 100;
            } else {
                result = "Sorry, but the computer chose " + compInput;
            }
        }
        System.out.println(result);
    }

    public String computerGuesser() {
        int computerGuess = (int) (Math.random() * choices.length);
        compHand = new StringBuilder();
        compHand.append(choices[computerGuess]);

        return compHand.toString();
    }
}