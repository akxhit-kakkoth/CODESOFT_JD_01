import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100; 
        int maxAttempts = 10;
        int rounds = 0;
        int totalAttempts = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess the number between " + minRange + " and " + maxRange + ":");

            do {
                int userGuess = getUserInput(scanner);

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + (attempts + 1) + " attempts.");
                    totalAttempts += attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
            } while (attempts < maxAttempts);

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Your current score: " + totalAttempts + " attempts.");
            rounds++;

            System.out.println("\nDo you want to play again? (yes/no):");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("Thank you for playing! Your final score: " + totalAttempts + " attempts in " + rounds + " rounds.");
        scanner.close();
    }

    private static int getUserInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number:");
            }
        }
    }
}
