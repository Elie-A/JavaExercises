/*
Write function that reverses a list,
preferably in place (without using classes by manipulating the array directly)
 */

import java.util.Arrays;

public class Exercise_09 {
    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 2, 8, 10, 1, 4, 6, 9};
        System.out.println("Original array: " + Arrays.toString(numbers));
        reverseArray(numbers);
        System.out.println("Reversed array: " + Arrays.toString(numbers));
    }

    private static void reverseArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Swap the elements at left and right indices
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Move towards the center
            left++;
            right--;
        }
    }
}
