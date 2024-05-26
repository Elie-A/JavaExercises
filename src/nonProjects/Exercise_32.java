package nonProjects;/*
32. Write a program to search for the "saddle points" in a 5 by 5 array of integers.
A saddle point is a cell whose value is greater than or equal to any in its row,
and less than or equal to any in its column. There may be more than one saddle point in the array.
Print out the coordinates of any saddle points your program finds.
Print out "No saddle points" if there are none.
 */

public class Exercise_32 {

    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        findSaddlePoints(array);
    }

    private static void findSaddlePoints(int[][] array) {
        boolean saddlePointFound = false;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int value = array[i][j];
                boolean isSaddlePoint = true;

                // Check if the value is greater than or equal to any in its row
                for (int k = 0; k < array[i].length; k++) {
                    if (value < array[i][k]) {
                        isSaddlePoint = false;
                        break;
                    }
                }

                // Check if the value is less than or equal to any in its column
                for (int k = 0; k < array.length; k++) {
                    if (value > array[k][j]) {
                        isSaddlePoint = false;
                        break;
                    }
                }

                // If the value is a saddle point, print its coordinates
                if (isSaddlePoint) {
                    System.out.println("Saddle point found at coordinates: (" + i + ", " + j + ")");
                    saddlePointFound = true;
                }
            }
        }

        // If no saddle points were found, print "No saddle points"
        if (!saddlePointFound) {
            System.out.println("No saddle points");
        }
    }

}
