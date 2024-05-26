import java.util.Arrays;
import java.util.List;

/*
Write a function that returns the largest element in a list.
 */
public class Exercise_08 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7, 2, 8, 10, 1, 4, 6, 9);
        int largest = findLargestElement(numbers);
        System.out.println("The largest element in the list is: " + largest);
    }

    static int findLargestElement(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be null or empty");
        }

        int largest = list.get(0);
        for (int number : list) {
            if (number > largest) {
                largest = number;
            }
        }
        return largest;
    }

}
