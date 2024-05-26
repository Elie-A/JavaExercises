package nonProjects;/*
Write a function that checks whether an element occurs in a list
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise_10 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 10, 1, 4, 6, 9);
        Scanner scanner = new Scanner(System.in);

        int elementToFind = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter the element you want to find: ");
            if (scanner.hasNextInt()) {
                elementToFind = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input
            }
        }

        boolean result = numbers.contains(elementToFind);
        System.out.println("Does the list contain " + elementToFind + "? " + result);

        scanner.close();

    }

    private static boolean containsElement(List<Integer> list, int element) {
        if (list == null || list.isEmpty()) {
            return false;
        }

        for (int number : list) {
            if (number == element) {
                return true;
            }
        }
        return false;
    }
}
