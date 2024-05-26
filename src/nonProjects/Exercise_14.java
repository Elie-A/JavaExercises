package nonProjects;/*
Write three functions that compute the sum of the numbers in a list:
using a for-loop, a while-loop and recursion
 */

import java.util.ArrayList;
import java.util.List;

public class Exercise_14 {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Using a for-loop
        int sumForLoop = sumUsingForLoop(numbers);
        System.out.println("Sum using for-loop: " + sumForLoop);

        // Using a while-loop
        int sumWhileLoop = sumUsingWhileLoop(numbers);
        System.out.println("Sum using while-loop: " + sumWhileLoop);

        // Using recursion
        int sumRecursion = sumUsingRecursion(numbers);
        System.out.println("Sum using recursion: " + sumRecursion);
    }

    // Function to compute sum using a for-loop
    private static int sumUsingForLoop(List<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        return sum;
    }

    // Function to compute sum using a while-loop
    private static int sumUsingWhileLoop(List<Integer> numbers) {
        int sum = 0;
        int i = 0;
        while (i < numbers.size()) {
            sum += numbers.get(i);
            i++;
        }
        return sum;
    }

    // Function to compute sum using recursion
    private static int sumUsingRecursion(List<Integer> numbers) {
        return sumUsingRecursionHelper(numbers, 0);
    }

    private static int sumUsingRecursionHelper(List<Integer> numbers, int index) {
        if (index == numbers.size()) {
            return 0;
        }
        return numbers.get(index) + sumUsingRecursionHelper(numbers, index + 1);
    }
}
