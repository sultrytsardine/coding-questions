import java.util.*;

/*
 * Given an array, rotate its values to the left by the factor specified.
 * https://www.hackerrank.com/challenges/array-left-rotation
 */
public class LeftRotation {
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
}