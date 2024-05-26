/*
Write a function that takes a number and returns a list of its digits.
So for 2342 it should return [2,3,4,2].
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise_20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter a number: ");
            if (scanner.hasNextLong()) {
                number = scanner.nextLong();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input
            }
        }
        scanner.close();

        List<Integer> digits = getDigits(number);
        System.out.println("Digits of the number: " + digits);
    }

    private static List<Integer> getDigits(long number) {
        List<Integer> digits = new ArrayList<>();
        if (number == 0) {
            digits.add(0);
        } else {
            while (number != 0) {
                digits.add(0, (int) (number % 10));
                number /= 10;
            }
        }
        return digits;
    }
}
