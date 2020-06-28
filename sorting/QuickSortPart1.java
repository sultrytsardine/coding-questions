import java.util.*;

/*
 * Given an array and a pivot point of array[0], separate the values into left, right and equal based on their value compared to the pivot. Return a merged array that is ordered
 * left -> equal -> right (each separate part isn't necessarily ordered);
 * https://www.hackerrank.com/challenges/quicksort1
 */
public class QuickSortPart1 {
    public int[] quickSort(int[] arr) {
        int len = arr.length;
        int pivot = arr[0];

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int current = arr[i];
            if (current < pivot) left.add(current);
            else if (current > pivot) right.add(current);
        }
        
        int[] result = createResult(left, right, pivot);

        return result;
    }

    private int[] createResult(List<Integer> left, List<Integer> right, int pivot) {        
        int index = 0;
        int l = left.size(), r = right.size();
        int[] result = new int[l + r + 1];

        for (int i = 0; i < l; i++) {
            result[index++] = left.get(i);
        }

        result[index++] = pivot;

        for (int i = 0; i < r; i++) {
            result[index++] = right.get(i);
        }

        return result;
    }  
}