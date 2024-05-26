/*
Write a function that returns the elements in odd positions in the list
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_12 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 5, 10, 1, 5, 6, 9);
        List<Integer> oddPositionElements = getOddPositionElements(numbers);
        System.out.println("Elements in odd positions: " + oddPositionElements);
    }

    private static List<Integer> getOddPositionElements(List<Integer> list) {
        List<Integer> oddPositionElements = new ArrayList<>();

        if (list == null || list.isEmpty()) {
            return oddPositionElements;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) { // Check if the index is odd
                oddPositionElements.add(list.get(i));
            }
        }
        return oddPositionElements;
    }
}
