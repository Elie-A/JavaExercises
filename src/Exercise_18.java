/*
Write a function that rotates a list by k elements.
For example [1,2,3,4,5,6] rotated by two becomes [3,4,5,6,1,2].
Try solving this without creating a copy of the list.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercise_18 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        int k = 0;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!validInput) {
            System.out.print("Enter the value of k: ");
            if (scanner.hasNextInt()) {
                k = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // Consume the invalid input
            }
        }
        scanner.close();

        rotateList(list, k);
        System.out.println(list);
    }

    private static void rotateList(List<?> list, int k) {
        int size = list.size();
        k %= size; // In case k is larger than size of list

        reverseList(list, 0, k - 1);
        reverseList(list, k, size - 1);
        reverseList(list, 0, size - 1);
    }

    private static void reverseList(List<?> list, int start, int end) {
        while (start < end) {
            swap(list, start, end);
            start++;
            end--;
        }
    }

    private static void swap(List<?> list, int i, int j) {
        if (list instanceof java.util.RandomAccess) {
            // If list supports random access (like ArrayList), swap directly
            List<Object> arrayList = (List<Object>) list;
            Object temp = arrayList.get(i);
            arrayList.set(i, arrayList.get(j));
            arrayList.set(j, temp);
        } else {
            // Otherwise, swap indirectly
            List<Object> linkedList = (List<Object>) list;
            Object temp = linkedList.get(i);
            linkedList.set(i, linkedList.get(j));
            linkedList.set(j, temp);
        }
    }
}
