import java.util.*;

/*
 * Using the same logic as InsertionSortPart1, reorder the array so that it is in ascending order.
 * https://www.hackerrank.com/challenges/insertionsort2
 */
public class InsertionSortPart2 {
    public void insertionSort2(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            insertionSort(i, arr);
        }
    }

    private void insertionSort(int n, int arr[]) {
        int i = n;
        int insert = arr[n];

        while(i > 0) {
            if (insert > arr[i - 1]) break;

            arr[i] = arr[i - 1];
            i--;
        }
        arr[i] = insert;
        printArray(arr);
    }

    private void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    } 
}