import java.util.*;

/*
 * Given an array of size 2n in the format [x1, x2, ..., xn, y1, y2, ..., yn], shuffle the array so that it's in the format [x1, y1, x2, y2, ..., xn, yn];
 * https://leetcode.com/problems/shuffle-the-array
 */
public class ShuffleArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        
        for(int i = 0; i < n * 2; i++) {
            if (i % 2 == 0) {
                result[i] = nums[i / 2];
            } else {
                result[i] = nums[n + i / 2];
            }
        }
        
        return result;
    }
}