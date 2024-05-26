/*
Write a function that returns the position(s) where an element occurs in a list
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_11 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 5, 10, 1, 5, 6, 9);
        int elementToFind = 5;
        List<Integer> positions = findElementPositions(numbers, elementToFind);
        if (positions.isEmpty()) {
            System.out.println("Element " + elementToFind + " not found in the list.");
        } else {
            System.out.println("Element " + elementToFind + " found at position(s): " + positions);
        }
    }

    private static List<Integer> findElementPositions(List<Integer> list, int element) {
        List<Integer> positions = new ArrayList<>();

        if (list == null || list.isEmpty()) {
            return positions;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == element) {
                positions.add(i);
            }
        }
        return positions;
    }
}
