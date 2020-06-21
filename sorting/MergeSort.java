import java.util.*;

/*
 * Implement a merge sort.
 */
public class MergeSort {
    public void mergeSort(int[] arr) {
        mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start <= end) return;
        int mid = (end - start) / 2;
        mergeSort(arr, temp, start, mid);
        mergeSort(arr, temp, mid + 1, end);

        merge(arr, temp, start, end);
    }

    private void merge(int[] arr, int[] temp, int start, int end) {
        int leftEnd = (end + start) / 2;
        int rightStart = leftEnd + 1;
        int size = end - start + 1;

        int left = start;
        int right = rightStart;
        int i = start;

        while(left <= leftEnd && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[i] = arr[left++];
            } else {
                temp[i] = arr[right++];
            }
            i++;
        }

        System.arraycopy(arr, left, temp, i, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, i, end - right + 1);
        System.arraycopy(temp, start, arr, start, size);
    }
}