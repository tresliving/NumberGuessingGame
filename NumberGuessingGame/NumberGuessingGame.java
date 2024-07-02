import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        boolean hasWon = false;
        boolean shouldContinue = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have randomly selected a number between 1 and 100.");
        System.out.println("Try to guess it in as few attempts as possible.");

        while (shouldContinue) {
            System.out.print("Enter your guess (1-100): ");
            int playerGuess = 0;

            // Ensure the input is a valid integer
            if (scanner.hasNextInt()) {
                playerGuess = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter an integer between 1 and 100.");
                scanner.next(); // Clear the invalid input
                continue;
            }

            numberOfTries++;

            if (playerGuess < 1 || playerGuess > 100) {
                System.out.println("Invalid guess! Please enter a number between 1 and 100.");
            } else if (playerGuess < numberToGuess) {
                System.out.println("Too low! Try again.");
            } else if (playerGuess > numberToGuess) {
                System.out.println("Too high! Try again.");
            } else {
                hasWon = true;
                shouldContinue = false;
            }
        }

        if (hasWon) {
            System.out.println("Congratulations! You've guessed the number correctly.");
            System.out.println("It took you " + numberOfTries + " tries to guess the number.");
        } else {
            System.out.println("Sorry! You've run out of attempts. The number was: " + numberToGuess);
        }

        scanner.close();
    }
}
