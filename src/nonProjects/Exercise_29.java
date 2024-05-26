package nonProjects;/*
29. Given an array with numbers, write a program that efficiently answers queries of the form:
Which is the nearest larger value for the number at position i? ,
where distance is the difference in array indices.
For example in the array [1,4,3,2,5,7], the nearest larger value for 4 is 5.
After linear time preprocessing you should be able to answer queries in constant time.
 */

import java.util.Stack;

public class Exercise_29 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 5, 7};
        int[] nearestLargerArr = nearestLarger(arr);

        // Example queries
        System.out.println("Nearest larger value for each position:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + ": " + nearestLargerQuery(nearestLargerArr, i));
        }
    }

    // Function to preprocess the array and find the nearest larger value for each element
    private static int[] nearestLarger(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack while they are smaller than or equal to the current element
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop(); // Remove elements less than or equal to the current element
            }
            // If stack is not empty, top element is the nearest larger element
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i); // Push current index onto the stack
        }

        return result;
    }

    // Function to answer queries in constant time
    private static int nearestLargerQuery(int[] nearestLargerArr, int index) {
        return nearestLargerArr[index];
    }
}
