package nonProjects;/*
    Write a program that takes a number (n) from a user (positive or negative) and prints the sum of 1/-1 to n
    Solution: loops and recursion
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_01 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        while(true)

        {
            try {
                System.out.print("Enter a positive, negative number or 0: ");
                String input = reader.readLine();
                number = Integer.parseInt(input);
                System.out.println("The sum using recursion is: " + calculateSumRecursive(number));
                System.out.println("The sum using for loop is: " + calculateSumForLoop(number));
                System.out.println("The sum using while loop is: " + calculateSumWhileLoop(number));
                break;
            } catch (IOException e) {
                System.out.println("An error occurred while reading input. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    private static int calculateSumRecursive(int number) {
        if (number == 0) return 0;
        else if (number == 1) return 1;
        else if (number == -1) return -1;
        if (number > 0) return number + calculateSumRecursive(number - 1);
        else return number + calculateSumRecursive(number + 1);
    }

    private static int calculateSumForLoop(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        if (number == -1) return -1;

        int sum = 0;
        if(number > 0) {
            for(int i = 1; i <= number; i++) sum += i;
        } else {
            for(int i = -1; i >= number; i--){
                sum += i;
            }
        }
        return sum;
    }

    private static int calculateSumWhileLoop(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        if (number == -1) return -1;

        int sum = 0;

        if (number < 0) {
            int i = -1;
            while (i >= number) {
                sum += i;
                i--;
            }
        } else {
            int i = 1;
            while (i <= number) {
                sum += i;
                i++;
            }
        }
        return sum;
    }
}