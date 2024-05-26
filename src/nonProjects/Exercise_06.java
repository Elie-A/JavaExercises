package nonProjects;

import java.util.HashSet;
import java.util.Scanner;

/*
Write a guessing game where the user has to guess a secret number.
After every guess the program tells the user whether their number was too large or too small.
At the end the number of tries needed should be printed.
It counts only as one try if they input the same number multiple times consecutively.
 */
public class Exercise_06 {

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        int secretNumber = generateSecretNumber();
        int numberOfTries = 0;
        int previousGuess = -1;
        HashSet<Integer> uniqueGuesses = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("Try to guess it!");

        while (true) {
            int userGuess = getUserGuess(scanner);

            if (userGuess == previousGuess) {
                System.out.println("You've already guessed that number, try a different one.");
                continue;
            }

            uniqueGuesses.add(userGuess);
            previousGuess = userGuess;

            if (userGuess == secretNumber) {
                System.out.println("Congratulations! You've guessed the number.");
                numberOfTries = uniqueGuesses.size();
                break;
            } else {
                provideFeedback(userGuess, secretNumber);
            }
        }

        System.out.println("You guessed the number in " + numberOfTries + " tries.");
        scanner.close();
    }

    private static int generateSecretNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    private static int getUserGuess(Scanner scanner) {
        System.out.print("Enter your guess: ");
        return scanner.nextInt();
    }

    private static void provideFeedback(int guess, int secretNumber) {
        if (guess > secretNumber) {
            System.out.println("Too high! Try again.");
        } else {
            System.out.println("Too low! Try again.");
        }
    }
}
