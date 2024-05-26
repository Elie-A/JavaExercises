/*
30. Given two strings, write a program that outputs the shortest sequence of character
insertions and deletions that turn one string into the other.
 */

import java.util.Scanner;

public class Exercise_30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();
        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();

        String editSequence = shortestEditSequence(str1, str2);
        System.out.println("Shortest edit sequence: " + editSequence);
    }

    // Function to find the shortest edit sequence
    private static String shortestEditSequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store edit distances
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp array with base cases
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j; // If str1 is empty, insert all characters of str2
                } else if (j == 0) {
                    dp[i][j] = i; // If str2 is empty, delete all characters of str1
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // If characters match, no operation needed
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]); // Insertion or deletion
                }
            }
        }

        // Reconstruct the shortest edit sequence
        StringBuilder result = new StringBuilder();
        int i = m, j = n;
        while (i > 0 || j > 0) {
            if (i > 0 && dp[i][j] == dp[i - 1][j] + 1) {
                result.insert(0, "D" + str1.charAt(i - 1)); // Deletion
                i--;
            } else if (j > 0 && dp[i][j] == dp[i][j - 1] + 1) {
                result.insert(0, "I" + str2.charAt(j - 1)); // Insertion
                j--;
            } else {
                result.insert(0, "M" + str2.charAt(j - 1)); // Match (or no operation)
                i--;
                j--;
            }
        }

        return result.toString();
    }
}
