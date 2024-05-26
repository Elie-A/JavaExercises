package nonProjects;/*
Write a function that computes the list of the first 100 Fibonacci numbers.
The first two Fibonacci numbers are 1 and 1.
The n+1-st Fibonacci number can be computed by adding the n-th and the n-1-th Fibonacci number.
The first few are therefore 1, 1, 1+1=2, 1+2=3, 2+3=5, 3+5=8.
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Exercise_19 {

    public static void main(String[] args) {
        List<BigInteger> fibonacciNumbers = generateFibonacci(100);
        System.out.println("First 100 Fibonacci numbers:");
        System.out.println(fibonacciNumbers);
    }

    private static List<BigInteger> generateFibonacci(int n) {
        List<BigInteger> fibonacciNumbers = new ArrayList<>();
        if (n >= 1) {
            fibonacciNumbers.add(BigInteger.ONE); // First Fibonacci number
        }
        if (n >= 2) {
            fibonacciNumbers.add(BigInteger.ONE); // Second Fibonacci number
        }

        for (int i = 2; i < n; i++) {
            BigInteger fibN = fibonacciNumbers.get(i - 1).add(fibonacciNumbers.get(i - 2));
            fibonacciNumbers.add(fibN);
        }

        return fibonacciNumbers;
    }
}
