package projects.hagman;

import java.util.*;

public class FrequencyBasedLetterSelectionStrategy implements LetterSelectionStrategy {

    @Override
    public char selectNextLetter(Set<Character> guessedLetters, List<String> dictionary, String wordToGuess, char[] currentGuess) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (String word : dictionary) {
            if (word.length() == wordToGuess.length()) {
                for (char c : word.toCharArray()) {
                    if (!guessedLetters.contains(c)) {
                        frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
                    }
                }
            }
        }
        return Collections.max(frequencyMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}

