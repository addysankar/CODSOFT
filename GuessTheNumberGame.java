import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 5;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            // Step 1: Generate a random number within the specified range.
            int secretNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
            int attempts = 0;

            System.out.println("Guess the number between " + lowerLimit + " and " + upperLimit + ". You have " + maxAttempts + " attempts.");

            
               while (attempts < maxAttempts) {
    // Step 2: Prompt the user to enter their guess for the generated number.
    System.out.print("Enter your guess: ");

    int userGuess = scanner.nextInt();
    attempts++;

    // Step 3: Compare the user's guess with the generated number and provide feedback.
    if (userGuess < secretNumber) {
        System.out.println("Too low! Try again.");

    } else if (userGuess > secretNumber) {
        System.out.println("Too high! Try again.");
    } else {
        System.out.println("Congratulations! You guessed the correct number " + secretNumber + " in " + attempts + " attempts!");
        score++;
        break;
    }
    
    // Additional feedback conditions
    if (Math.abs(userGuess - secretNumber) >= 10) {
        System.out.println("Way too " + (userGuess < secretNumber ? "low" : "high") + "! Try again.");
    } else if (Math.abs(userGuess - secretNumber) >= 5) {
        System.out.println("A bit too " + (userGuess < secretNumber ? "low" : "high") + ". Try again.");
    }
}


            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The secret number was " + secretNumber + ".");
            }

            // Step 6: Add the option for multiple rounds.
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                // Step 7: Display the user's score.
                System.out.println("Your score: " + score + " round(s) won.");
                break;
            }
        }

        scanner.close();
    }
}


