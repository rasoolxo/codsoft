import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int totalScore = 0;

        while (true) {
            totalRounds++;
            int attemptsLeft = 10;
            int numberToGuess = random.nextInt(100) + 1;
            boolean guessedCorrectly = false;

            System.out.println("Round " + totalRounds);
            System.out.println("I have generated a number between 1 and 100. Try to guess it!");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.println("\nYou have " + attemptsLeft + " attempts left.");
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please guess a number between 1 and 100.");
                    continue;
                }

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    System.out.println("Correct! You've guessed the number!");
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + numberToGuess);
            }

            if (guessedCorrectly) {
                totalScore += (11 - attemptsLeft);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            scanner.nextLine();
            String playAgain = scanner.nextLine();
            
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over! You played " + totalRounds + " rounds.");
        System.out.println("Your final score is: " + totalScore);
    }
}
