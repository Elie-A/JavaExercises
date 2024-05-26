/*
Write a program that prints the next 20 leap years
 */
public class Exercise_07 {

    public static void main(String[] args) {
        int currentYear = java.time.Year.now().getValue();
        int count = 0;

        System.out.println("The next 20 leap years are:");

        while (count < 20) {
            currentYear++;
            if (isLeapYear(currentYear)) {
                System.out.println(currentYear);
                count++;
            }
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }
}
