package nonProjects;/*
Write a function that takes a list of strings an prints them, one per line, in a rectangular frame.
For example the list ["Hello", "World", "in", "a", "frame"] gets printed as:
**********
* Hello  *
* World  *
* in     *
* a      *
* frame  *
**********

 */

import java.util.Arrays;
import java.util.List;

public class Exercise_24 {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World", "in", "a", "frame", "program");
        printInFrame(words);
    }

    private static void printInFrame(List<String> words) {
        // Calculate the maximum length of the words
        int maxLength = 0;
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        // Print the top border
        printBorder(maxLength);

        // Print each word with padding and side borders
        for (String word : words) {
            System.out.print("* " + word);
            int padding = maxLength - word.length();
            for (int i = 0; i < padding; i++) {
                System.out.print(" ");
            }
            System.out.println(" *");
        }

        // Print the bottom border
        printBorder(maxLength);
    }

    private static void printBorder(int length) {
        for (int i = 0; i < length + 4; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
