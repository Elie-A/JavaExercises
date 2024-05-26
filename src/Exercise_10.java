/*
Write a function that checks whether an element occurs in a list
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise_10 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 10, 1, 4, 6, 9);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the element you want to find: ");
        int elementToFind = scanner.nextInt();

        boolean result = containsElement(numbers, elementToFind);
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
