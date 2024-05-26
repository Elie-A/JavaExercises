package nonProjects;/*
33. The results from the mayor's race have been reported by each precinct as follows:

              Candidate  Candidate  Candidate  Candidate

    Precinct A B C D
    1 192 48 206 37
    2 147 90 312 21
    3 186 12 121 38
    4 114 21 408 39
    5 267 13 382 29

Write a program to do the following:
a. Read the raw vote totals from a data file that contains one row for each precinct.
b. Display the table with appropriate headings for the rows and columns.
c. Compute and display the total number of votes received by each candidate and the percent of the total votes cast.
d. If any one candidate received over 50% of the votes, the program should print a message declaring that candidate the winner.
e. If no candidate received 50% of the votes, the program should print a message declaring a run-off between the two candidates receiving the highest number of votes; the two candidates should be identified by their letter names.
f. For testing, run the program with the above data, and also with another data file where Candidate C receives only 108 votes in precinct
 */

import java.io.*;

public class Exercise_33 {

    public static void main(String[] args) {
        int[][] votes = readVotesFromFile("votes.txt");
        displayVotesTable(votes);
        calculateAndDisplayResults(votes);
    }

    private static int[][] readVotesFromFile(String filename) {
        int[][] votes = new int[5][4];
        File file = new File("src/test data/" + filename);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < 5) {
                String[] parts = line.trim().split("\\s+");
                for (int col = 0; col < 4 && col < parts.length; col++) {
                    votes[row][col] = Integer.parseInt(parts[col]);
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return votes;
    }

    private static void displayVotesTable(int[][] votes) {
        System.out.println("Precinct\tCandidate A\tCandidate B\tCandidate C\tCandidate D");
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + "\t\t");
            for (int j = 0; j < 4; j++) {
                System.out.print(votes[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void calculateAndDisplayResults(int[][] votes) {
        int totalVotes = 0;
        int[] candidateVotes = new int[4];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                candidateVotes[j] += votes[i][j];
                totalVotes += votes[i][j];
            }
        }

        double[] percentages = new double[4];
        for (int i = 0; i < 4; i++) {
            percentages[i] = (double) candidateVotes[i] / totalVotes * 100;
            System.out.printf("Candidate %c received %d votes (%.2f%%)\n", 'A' + i, candidateVotes[i], percentages[i]);
        }

        boolean winnerFound = false;
        for (int i = 0; i < 4; i++) {
            if (percentages[i] > 50) {
                System.out.printf("Candidate %c is the winner!\n", 'A' + i);
                winnerFound = true;
                break;
            }
        }

        if (!winnerFound) {
            int maxVotesIndex1 = 0;
            int maxVotesIndex2 = 0;
            for (int i = 1; i < 4; i++) {
                if (candidateVotes[i] > candidateVotes[maxVotesIndex1]) {
                    maxVotesIndex2 = maxVotesIndex1;
                    maxVotesIndex1 = i;
                } else if (candidateVotes[i] > candidateVotes[maxVotesIndex2]) {
                    maxVotesIndex2 = i;
                }
            }
            System.out.printf("Run-off between candidates %c and %c\n", 'A' + maxVotesIndex1, 'A' + maxVotesIndex2);
        }
    }
}
