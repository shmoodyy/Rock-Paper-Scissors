package rockpaperscissors;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class ScoreSheet {
    final static String pathToFile = "rating.txt";
    String playerName;
    int playerScore;

    public int playerRecord(String playerName) {
        File file = new File(pathToFile);
        try (Scanner scanner = new Scanner(file)) {
            while (true) {
                if (Objects.equals(scanner.next(), playerName)) {
                    playerScore = scanner.nextInt();
                    break;
                } else scanner.next();
            }
        } catch (Exception e) {
            System.out.print("");;
        }
        return playerScore;
    }
}