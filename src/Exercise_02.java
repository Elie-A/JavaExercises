/*
Write a program that takes a number (n) from a user and prints the sum of all the numbers
that are multiple of 3 and 5 between 1 and n
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise_02 {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = 0;
        while(true)
        {
            try {
                do {
                    System.out.print("Enter a positive number: ");
                    String input = reader.readLine();
                    number = Integer.parseInt(input);
                } while (number <= 0);
                System.out.println("The sum of numbers multiple of 3 and 5 using recursion is: " + sumNummbersMultipleRecursive(number));
                System.out.println("The sum of numbers multiple of 3 and 5 using for loop is: " + sumOfNumbersMultipleForLoop(number));
                System.out.println("The sum of numbers multiple of 3 and 5 using while loop is: " + sumOfNumbersMultipleWhileLoop(number));
                break;
            } catch (IOException e) {
                System.out.println("An error occurred while reading input. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static int sumOfNumbersMultipleForLoop(int number){
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int sumOfNumbersMultipleWhileLoop(int number){
        int sum = 0;
        int i = 1;
        while (i <= number) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
            i++;
        }
        return sum;
    }

    public static int sumNummbersMultipleRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n % 3 == 0 || n % 5 == 0) {
            return n + sumNummbersMultipleRecursive(n - 1);
        } else {
            return sumNummbersMultipleRecursive(n - 1);
        }
    }
}