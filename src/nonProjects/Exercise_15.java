package nonProjects;/*
Write a function on_all that applies a function to every element of a list.
Use it to print the first twenty perfect squares.
The perfect squares can be found by multiplying each natural number with itself.
The first few perfect squares are 11= 1, 22=4, 33=9, 44=16.
Twelve for example is not a perfect square because there is no natural number m so that m*m=12.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Exercise_15 {

    public static void main(String[] args) {
        // Define a function to calculate square
        Function<Integer, Integer> squareFunction = x -> x * x;

        // Print the first twenty perfect squares
        onAll(squareFunction, generateNaturalNumbers(1, 20));
    }

    // Function to apply a function to every element of a list
    private static <T, R> void onAll(Function<T, R> func, List<T> list) {
        for (T element : list) {
            R result = func.apply(element);
            System.out.println(result);
        }
    }

    // Function to generate a list of natural numbers from start to end
    private static List<Integer> generateNaturalNumbers(int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
