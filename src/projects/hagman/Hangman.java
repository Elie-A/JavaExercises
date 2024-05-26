package projects.hagman;

import java.io.*;
import java.util.*;

public class Hangman {

    private static final String DICTIONARY_FILE = "src/test data/hangmanDictionary.txt"; // Path to the dictionary file
    private static List<String> dictionary = new ArrayList<>();
    private static Set<Character> guessedLetters = new HashSet<>();
    private static String wordToGuess;
    private static char[] currentGuess;
    private static int maxIncorrectGuesses = 6; // Set the maximum number of incorrect guesses allowed
    private static int incorrectGuesses = 0; // Track the number of incorrect guesses

    public static void main(String[] args) {
        loadDictionary();
        initializeGame();
        playGame();
    }

    // Load the dictionary from a file
    private static void loadDictionary() {
        try (BufferedReader br = new BufferedReader(new FileReader(DICTIONARY_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Initialize the game
    private static void initializeGame() {
        Random rand = new Random();
        wordToGuess = dictionary.get(rand.nextInt(dictionary.size()));
        currentGuess = new char[wordToGuess.length()];
        Arrays.fill(currentGuess, '_');
    }

    // Play the game
    private static void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Current guess: " + String.valueOf(currentGuess));
            printRemainingLetters(); // Print remaining letters
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() == 1) {
                char guess = input.charAt(0);

                if (guessedLetters.contains(guess)) {
                    System.out.println("You already guessed that letter.");
                    continue;
                }

                guessedLetters.add(guess);
                System.out.println("Guessed letter: " + guess);
                updateGameState(guess);
            } else if (input.length() == wordToGuess.length()) {
                guessWord(scanner); // Guess the full word
            } else {
                System.out.println("Invalid input. Please enter a single letter or a full word guess.");
                continue;
            }

            if (isGameWon()) {
                System.out.println("You've won! The word was: " + wordToGuess);
                break;
            }

            if (isGameLost()) {
                System.out.println("You've lost! The word was: " + wordToGuess);
                break;
            }
        }

        scanner.close();
    }


    // Update the game state based on the guessed letter
    private static void updateGameState(char guess) {
        boolean correctGuess = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                currentGuess[i] = guess;
                correctGuess = true;
            }
        }
        if (!correctGuess) {
            System.out.println("Incorrect guess!");
            incorrectGuesses++; // Increment the incorrect guess counter
        }
    }

    // Check if the game is won
    private static boolean isGameWon() {
        return wordToGuess.equals(String.valueOf(currentGuess));
    }

    // Check if the game is lost (optional: limit the number of incorrect guesses)
    private static boolean isGameLost() {
        return incorrectGuesses >= maxIncorrectGuesses;
    }

    // Print the remaining letters after each guess with separation
    private static void printRemainingLetters() {
        System.out.print("Remaining letters: ");
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (!guessedLetters.contains(letter)) {
                System.out.print(letter + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println(); // Add a newline after printing all letters
        System.out.println(); // Add a newline after printing all letters
    }

    // Guess the full word
    private static void guessWord(Scanner scanner) {
        System.out.print("Enter your full word guess: ");
        String guess = scanner.nextLine().trim().toLowerCase();

        if (guess.equals(wordToGuess)) {
            System.out.println("Congratulations! You've guessed the word correctly: " + wordToGuess);
            System.exit(0); // Exit the program since the game is won
        } else {
            System.out.println("Sorry, your guess is incorrect.");
            incorrectGuesses++; // Increment incorrect guess counter
        }
    }
}
