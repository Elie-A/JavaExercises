/*
Implement the following sorting algorithms:
Selection sort, Insertion sort, Merge sort, Quick sort, Stooge Sort.

• Selection Sort:
    - Selection sort works by repeatedly finding the minimum element from the unsorted part of the array and moving it to the beginning. It maintains two subarrays: sorted and unsorted. Initially, the sorted subarray is empty, and the unsorted subarray is the entire array.
    The algorithm iterates through the array and for each iteration, it finds the minimum element in the unsorted subarray and swaps it with the first element of the unsorted subarray. This process continues until the entire array is sorted.

• Insertion Sort:
    - Insertion sort works by building a sorted array one element at a time by repeatedly taking elements from the unsorted part and inserting them into their correct position in the sorted part.
    The algorithm iterates through the array from the second element to the last. For each element, it compares it with the elements to its left in the sorted part and shifts the elements to the right until it finds the correct position for the current element.

• Merge Sort:
    - Merge sort is a divide-and-conquer algorithm. It divides the array into two halves, sorts each half independently, and then merges the sorted halves to produce the final sorted array.
    The merge function merges two sorted subarrays into a single sorted subarray. It iterates through both subarrays and compares the elements, copying them to a temporary array in sorted order.
    The sort function recursively divides the array into halves until the size of each subarray becomes 1, and then merges them back together using the merge function.

• Quick Sort:
    - Quick sort is another divide-and-conquer algorithm that works by selecting a 'pivot' element from the array and partitioning the other elements into two subarrays according to whether they are less than or greater than the pivot.
    The partition function selects the last element of the array as the pivot, then rearranges the array so that all elements less than the pivot come before it, and all elements greater than the pivot come after it.
    The sort_2 function recursively sorts the two subarrays created by partitioning until the entire array is sorted.

• Stooge Sort:
    - Stooge sort is a recursive sorting algorithm with a time complexity worse than many other sorting algorithms. It is primarily used for educational purposes.
    The stoogeSort function recursively sorts the first two-thirds and the last two-thirds of the array, then sorts the first two-thirds again recursively to ensure that the entire array is sorted.
 */

public class Exercise_22 {

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};

        System.out.println("Original Array:");
        printArray(arr);

        System.out.println("\nAfter Selection Sort:");
        selectionSort(arr);
        printArray(arr);

        System.out.println("\nAfter Insertion Sort:");
        insertionSort(arr);
        printArray(arr);

        System.out.println("\nAfter Merge Sort:");
        mergeSort(arr);
        printArray(arr);

        System.out.println("\nAfter Quick Sort:");
        quickSort(arr);
        printArray(arr);

        System.out.println("\nAfter Stooge Sort:");
        stoogeSort(arr);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    private static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        // Merge two subarrays of arr[]
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]

        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void sort(int[] arr, int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private static void quickSort(int[] arr) {
        sort_2(arr, 0, arr.length - 1);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private static void sort_2(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private static void stoogeSort(int arr[]) {
        stoogeSort(arr, 0, arr.length - 1);
    }

    private static void stoogeSort(int arr[], int l, int h) {
        if (l >= h)
            return;

        if (arr[l] > arr[h]) {
            int t = arr[l];
            arr[l] = arr[h];
            arr[h] = t;
        }

        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
            stoogeSort(arr, l, h - t);
            stoogeSort(arr, l + t, h);
            stoogeSort(arr, l, h - t);
        }
    }
}
