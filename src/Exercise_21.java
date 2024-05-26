/*
Write functions that add, subtract, and multiply two numbers in their digit-list representation
(and return a new digit list).
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise_21 {

    public static void main(String[] args) {
        List<Integer> num1 = Arrays.asList(1, 2, 3); // Representing 123
        List<Integer> num2 = Arrays.asList(3, 4, 5); // Representing 345

        System.out.println("Addition: " + add(num1, num2)); // Result: [4, 6, 8]
        System.out.println("Subtraction: " + subtract(num1, num2)); // Result: [-2, -2, -2]
        System.out.println("Multiplication: " + multiply(num1, num2)); // Result: [4, 1, 6, 8, 5]
    }

    public static List<Integer> add(List<Integer> num1, List<Integer> num2) {
        int carry = 0;
        List<Integer> result = new ArrayList<>();
        int i = num1.size() - 1;
        int j = num2.size() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.get(i--) : 0;
            int digit2 = (j >= 0) ? num2.get(j--) : 0;
            int sum = digit1 + digit2 + carry;
            result.add(sum % 10);
            carry = sum / 10;
        }

        Collections.reverse(result);
        return result;
    }

    public static List<Integer> subtract(List<Integer> num1, List<Integer> num2) {
        int borrow = 0;
        List<Integer> result = new ArrayList<>();
        int i = num1.size() - 1;
        int j = num2.size() - 1;

        while (i >= 0 || j >= 0) {
            int digit1 = (i >= 0) ? num1.get(i--) : 0;
            int digit2 = (j >= 0) ? num2.get(j--) : 0;
            int diff = digit1 - digit2 - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.add(diff);
        }

        Collections.reverse(result);
        return result;
    }

    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2) {
        List<Integer> result = new ArrayList<>();
        for (int i = num1.size() - 1; i >= 0; i--) {
            int carry = 0;
            List<Integer> tempResult = new ArrayList<>();
            // Add zeros for place value
            for (int k = num1.size() - 1; k > i; k--) {
                tempResult.add(0);
            }
            int digit1 = num1.get(i);
            for (int j = num2.size() - 1; j >= 0; j--) {
                int digit2 = num2.get(j);
                int product = digit1 * digit2 + carry;
                tempResult.add(product % 10);
                carry = product / 10;
            }
            if (carry > 0) {
                tempResult.add(carry);
            }
            Collections.reverse(tempResult);
            result = add(result, tempResult);
        }
        return result;
    }
}

