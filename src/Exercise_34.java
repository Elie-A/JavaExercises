import java.util.Scanner;

public class Exercise_34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
            System.out.print("Enter a number: ");
            number = scanner.nextInt();

            if (isHarshad(number)) {
                System.out.println(number + " is a Harshad number.");
            } else {
                System.out.println(number + " is not a Harshad number.");
            }
        scanner.close();
    }

    // Function to check if a number is Harshad or not
    private static boolean isHarshad(int number) {
        // Check if the number is positive
        if (number <= 0) {
            return false;
        }

        // Calculate the sum of digits
        int sumOfDigits = 0;
        int originalNumber = number;
        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }

        // Check if the original number is divisible by the sum of its digits
        return originalNumber % sumOfDigits == 0;
    }
}
