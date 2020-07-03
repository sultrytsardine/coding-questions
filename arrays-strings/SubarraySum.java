import java.util.*;

/*
 * Given an array and a value, find the total number of subarrays in the array that add up to the sum.
 * https://leetcode.com/problems/subarray-sum-equals-k
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0, len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            int diff = sum - k;
            if (map.containsKey(diff)) count += map.get(diff);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}