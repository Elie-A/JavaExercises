/*
Write a program that takes two numbers from a user,
then asks the user to choose between sum, substraction, multiplication, product,
or all and prints the results
 */

import java.util.Scanner;

public class Exercise_03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number_1 = getNumber(scanner);
        int number_2 = getNumber(scanner);
        String choice = getChoice(scanner);

        performOperations(number_1, number_2, choice);

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

    private static String getChoice(Scanner scanner) {
        String[] choices = {"sum", "+", "subtraction", "-", "multiplication", "*", "division", "//", "all"};
        while (true) {
            System.out.print("Choose an operation (sum or +, subtraction or -, multiplication or *, division or /, all): ");
            String choice = scanner.nextLine().toLowerCase();
            for (String validChoice : choices) {
                if (validChoice.equals(choice)) {
                    return choice;
                }
            }
            System.out.println("Please choose a valid operation.");
        }
    }

    public static void performOperations(int number_1, int number_2, String choice) {
        switch (choice) {
            case "sum":
            case "+":
                int sum = number_1 + number_2;
                System.out.println("Sum is: " + sum);
                break;
            case "subtraction":
            case "-":
                int subtraction = number_1 - number_2;
                System.out.println("Subtraction is: " + subtraction);
                break;
            case "multiplication":
            case "*":
                long multiplication = number_1 * number_2;
                System.out.println("Multiplication is: " + multiplication);
                break;
            case "division":
            case "/":
                double division = 0.0;
                if (number_2 == 0) {
                    System.out.println("Division by zero is not defined.");
                } else {
                    division = number_1 / (double)number_2;
                    System.out.println("Division of number_1 by number_2 is: " + division);
                }
                break;
            case "all":
                performOperations(number_1, number_2, "sum");
                performOperations(number_1, number_2, "subtraction");
                performOperations(number_1, number_2, "multiplication");
                performOperations(number_1, number_2, "division");
                break;
        }
    }
}
