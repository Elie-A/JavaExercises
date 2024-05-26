/*
Given two strings, write a program that efficiently finds the longest common subsequence.
 */

import java.util.Scanner;

public class Exercise_28 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string:");
        String text1 = scanner.nextLine();
        System.out.println("Enter the second string:");
        String text2 = scanner.nextLine();

        String longestCommonSubsequence = longestCommonSubsequence(text1, text2);
        System.out.println("Longest Common Subsequence: " + longestCommonSubsequence);
    }

    private static String longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Building the dp table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Building the longest common subsequence
        StringBuilder result = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                result.insert(0, text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return result.toString();
    }
}
