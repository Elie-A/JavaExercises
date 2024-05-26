package projects.hagman;

import java.util.List;
import java.util.Set;

public interface LetterSelectionStrategy {
    char selectNextLetter(Set<Character> guessedLetters, List<String> dictionary, String wordToGuess, char[] currentGuess);
}

