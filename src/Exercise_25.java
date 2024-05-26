/*
25. Write function that translates a text to Pig Latin and back.
English is translated to Pig Latin by taking the first letter of every word,
moving it to the end of the word and adding.
The quick brown fox becomes heTay uickqay rownbay oxfay.
 */

public class Exercise_25 {

    public static void main(String[] args) {
        String text = "The quick brown fox";
        String pigLatinText = toPigLatin(text);
        System.out.println("Pig Latin: " + pigLatinText);
        System.out.println("English: " + toEnglish(pigLatinText));
    }

    private static String toPigLatin(String text) {
        StringBuilder pigLatinText = new StringBuilder();
        String[] words = text.split("\\s+");

        for (String word : words) {
            char firstLetter = word.charAt(0);
            String restOfWord = word.substring(1);
            pigLatinText.append(restOfWord).append(firstLetter).append("ay ");
        }

        return pigLatinText.toString().trim();
    }

    private static String toEnglish(String pigLatinText) {
        StringBuilder englishText = new StringBuilder();
        String[] words = pigLatinText.split("\\s+");

        for (String word : words) {
            if (word.length() > 2 && word.endsWith("ay")) {
                char lastLetter = word.charAt(word.length() - 3);
                String restOfWord = word.substring(0, word.length() - 3);
                englishText.append(lastLetter).append(restOfWord).append(" ");
            }
        }

        return englishText.toString().trim();
    }
}
