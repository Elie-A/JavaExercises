/*
Write a program that automatically converts English text to Morse code and vice versa.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Exercise_26 {
    private static final Map<Character, String> ENGLISH_TO_MORSE = new HashMap<>();
    private static final Map<String, Character> MORSE_TO_ENGLISH = new HashMap<>();

    static {
        ENGLISH_TO_MORSE.put('A', ".-");
        ENGLISH_TO_MORSE.put('B', "-...");
        ENGLISH_TO_MORSE.put('C', "-.-.");
        ENGLISH_TO_MORSE.put('D', "-..");
        ENGLISH_TO_MORSE.put('E', ".");
        ENGLISH_TO_MORSE.put('F', "..-.");
        ENGLISH_TO_MORSE.put('G', "--.");
        ENGLISH_TO_MORSE.put('H', "....");
        ENGLISH_TO_MORSE.put('I', "..");
        ENGLISH_TO_MORSE.put('J', ".---");
        ENGLISH_TO_MORSE.put('K', "-.-");
        ENGLISH_TO_MORSE.put('L', ".-..");
        ENGLISH_TO_MORSE.put('M', "--");
        ENGLISH_TO_MORSE.put('N', "-.");
        ENGLISH_TO_MORSE.put('O', "---");
        ENGLISH_TO_MORSE.put('P', ".--.");
        ENGLISH_TO_MORSE.put('Q', "--.-");
        ENGLISH_TO_MORSE.put('R', ".-.");
        ENGLISH_TO_MORSE.put('S', "...");
        ENGLISH_TO_MORSE.put('T', "-");
        ENGLISH_TO_MORSE.put('U', "..-");
        ENGLISH_TO_MORSE.put('V', "...-");
        ENGLISH_TO_MORSE.put('W', ".--");
        ENGLISH_TO_MORSE.put('X', "-..-");
        ENGLISH_TO_MORSE.put('Y', "-.--");
        ENGLISH_TO_MORSE.put('Z', "--..");
        ENGLISH_TO_MORSE.put(' ', " ");

        // Populate MORSE_TO_ENGLISH map by reversing the ENGLISH_TO_MORSE map
        for (Map.Entry<Character, String> entry : ENGLISH_TO_MORSE.entrySet()) {
            MORSE_TO_ENGLISH.put(entry.getValue(), entry.getKey());
        }
    }

    private static String englishToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();
        text = text.toUpperCase(); // Convert text to uppercase for consistency
        for (char ch : text.toCharArray()) {
            String code = ENGLISH_TO_MORSE.getOrDefault(ch, "");
            morseCode.append(code).append(" ");
        }
        return morseCode.toString().trim();
    }

    private static String morseToEnglish(String morseCode) {
        StringBuilder englishText = new StringBuilder();
        String[] words = morseCode.split("\\s{3,}"); // Split by longer gaps (spaces)
        for (String word : words) {
            String[] letters = word.split("\\s+"); // Split Morse code by single spaces
            for (String code : letters) {
                char ch = MORSE_TO_ENGLISH.getOrDefault(code, ' ');
                englishText.append(ch);
            }
            englishText.append(" "); // Add space between words
        }
        return englishText.toString().trim();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text to convert to Morse code:");
        String inputText = scanner.nextLine();

        String morseCode = englishToMorse(inputText);
        System.out.println("Morse Code: " + morseCode);

        String convertedBack = morseToEnglish(morseCode);
        System.out.println("Converted Back: " + convertedBack);
    }
}
