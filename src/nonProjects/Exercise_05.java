package nonProjects;/*
Write a program that prints all prime numbers between 1 and 100
 */

public class Exercise_05 {

    public static void main(String[] args) {
        for(int i = 1; i <= 100; i++) {
            if(isPrime(i)) System.out.println(i);
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false; // Any other even number is not prime
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
