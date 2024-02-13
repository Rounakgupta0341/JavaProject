import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int userScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int secretNumber = randomGenerator.nextInt(100) + 1;
            int userAttempts = 0;
            int maxUserAttempts = 5;

            System.out.println("I have selected a number between 1 and 100. Can you guess it?");

            while (userAttempts < maxUserAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = inputScanner.nextInt();
                inputScanner.nextLine();

                userAttempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " in " + userAttempts + " attempts.");
                    userScore++;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (userAttempts >= maxUserAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + secretNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = inputScanner.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Your score: " + userScore);

        inputScanner.close();
    }
}
