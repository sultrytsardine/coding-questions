import java.util.*;

/*
 * Find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * https://leetcode.com/problems/maximum-subarray/
 */
public class MaxSubarray {
    
    public static void main(String[] args) {

    }

    /*
     * Store the max value for each subarray in a separate array as you loop through. Space and time complixity O(n)
     */
    public int maxSubArray(int[] nums) {
        int[] table = new int[nums.length];
        int max = nums[0];
        table[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            table[i] = Math.max(nums[i], nums[i] + table[i - 1]);
            max = Math.max(max, table[i]);
        }
        
        
        return max;
    }

    /*
     * Solution wihtout using an additional array to store the max values of each subarray (instead modifying the original array). Time complexity O(n), space complexity O(1)
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);;
            max = Math.max(max, nums[i]);
        }
        
        return max;
    }

}