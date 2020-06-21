import java.util.*;

/*
 * Given an array, rotate its values to the left by the factor specified.
 * 2 solutions
 * Both time O(N), space O(1) (assuming we are excluding the result array)
 * https://www.hackerrank.com/challenges/array-left-rotation
 */
public class LeftRotation {
    /*
     * Solution 1
     * Loop through "a" from index = 0 and calculate the index in result based on the rotation.
     */
    public int[] leftRotation(int[] a, int d) {
        int len = a.length;

        if (d == 0 || len == 0) return a;

        int rotation = d % len;
        
        if (rotation == 0) return a;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = a[getIndex(i + rotation, len)];
        }

        return result;
    }

    private int getIndex(int index, int len) {
        if (index >= len) {
            return index - len;
        } else {
            return index;
        }
    }

    /*
     * Solution 2
     * Start iterating through "a" at "d" and continue to the end of the array, then reset and loop through to "d".
     */
    public static int[] leftRotation(int[] a, int d) {
        int len = a.length;
        
        if (d == 0 || len == 0) return a;
        
        int[] result = new int[len];
        int index = 0, rotatedIndex = d;

        while(rotatedIndex < len) {
            result[index++] = a[rotatedIndex++];
        }

        rotatedIndex = 0;

        while(rotatedIndex < d) {
            result[index++] = a[rotatedIndex++];
        }

        return result;
    }
}