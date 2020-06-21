import java.util.*;

/*
 * Given an array and a target sum, return an array of the indexes of the first 2 values that add up to this sum.
 * https://leetcode.com/problems/two-sum/
 * Very similar to https://www.hackerrank.com/challenges/icecream-parlor
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        
        for (int i = 0; i < len; i++) {
            int current = nums[i];
            int complement = target - current;
            
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            
            map.put(current, i);
        }
        
        throw new IllegalArgumentException("No valid sum found");
    }
}