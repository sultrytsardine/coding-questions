import java.util.*;

/*
 * Find the pivot index of a given array, which is defined as the point where the total value of the elements to the left equal to value of the elements on the right.
 * https://leetcode.com/problems/find-pivot-index
 */
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int left = 0, sum = 0;
        
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        
        for (int i = 0; i < len; i++) {
            if (left == sum - nums[i] - left) return i;
            left += nums[i];
        }
        
        return -1;
    }
}