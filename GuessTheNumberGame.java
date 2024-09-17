
import java.util.Scanner;

public class GuessTheNumberGame {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalScore = 0;
        int seed = (int) (System.currentTimeMillis() % 100); 

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.print("Enter the number of rounds you want to play: ");
        int rounds = scanner.nextInt();

        for (int roundNum = 1; roundNum <= rounds; roundNum++) {
            System.out.println("\nRound " + roundNum);
            int number = generateRandomNumber(seed); 
            int attempts = 0;
            int maxAttempts = 10;
            int roundScore = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + " - Guess the number (between 1 and 100): ");
                int guess = scanner.nextInt();

                if (guess < number) {
                    System.out.println("Too low!");
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    roundScore = maxAttempts - attempts;
                    guessedCorrectly = true;
                    break;
                }
                
                attempts++; 
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + number + ".");
            }

            totalScore += roundScore;
            System.out.println("Round " + roundNum + " Score: " + roundScore);
            System.out.println("Total Score: " + totalScore);
        }

        System.out.println("\nGame Over! Your final score is " + totalScore + ". Thanks for playing!");
        scanner.close();
    }
    public static int generateRandomNumber(int seed) {
        int a = 1664525;
        int c = 1013904223;
        int m = (int) Math.pow(2, 32);

        seed = (a * seed + c) % m; 
        return Math.abs(seed % 100) + 1; 
    }
}
