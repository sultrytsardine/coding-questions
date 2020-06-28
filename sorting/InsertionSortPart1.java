import java.util.*;

/*
 * Perform an insertion sort on an array, where the last value needs to be inserted into the correct position to maintain the ordering.
 * https://www.hackerrank.com/challenges/insertionsort1
 */
public class InsertionSortPart1 {
    public void insertionSort1(int n, int[] arr) {
        int insert = arr[n - 1];
        int i = n - 1;

        while(i > 0) {
            if (insert > arr[i - 1]) break;
            arr[i] = arr[i - 1];
            printArray(arr);
            i--;
        }

        arr[i] = insert;
        printArray(arr);
    }

    private void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}