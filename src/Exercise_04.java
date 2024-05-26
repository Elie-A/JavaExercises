/*
Write a program that takes a number (n) from a user and prints the multiplication table from 1 to n
 */

import java.util.Scanner;

public class Exercise_04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = getNumber(scanner);
        printMultiplicationTable(number);
        scanner.close();
    }

    private static int getNumber(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter a number: ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static void printMultiplicationTable(int number) {
        System.out.println("Multiplication Table for " + number + ":");
        for (int i = 0; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
}
