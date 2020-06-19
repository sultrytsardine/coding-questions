import java.util.*;

/*
 * Given an array on integers, return an array where every position is the product of all of the other values (excluding the current value).
 * Don't use division to achieve this.
 * Two solutions are listed here, one with space complexity = O(N) and one with space complexity O(1) (not including the output array).
 * https://leetcode.com/problems/product-of-array-except-self
 */
public class ProductOfArrayExceptSelf {

    /*
     * Solution 1
     * Create a left and right array and loop through in each direction, saving the value of the product of all of the values that came before it.
     * Loop through one final time and multiple the values at each index and add it to the output array.
     * Time - O(N), Space - O(N)
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        int[] output = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        
        left[0] = 1;
        right[len - 1] = 1;
        
        for(int i = 1; i < len; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        
        for(int i = len - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        
        for(int i = 0; i < len; i++) {
            output[i] = left[i] * right[i];
        }
        
        return output;
    }

    /*
     * Solution 2
     * Loop through nums and add the product of all of the values to the left of the current value to the output array. 
     * Loop through the output array from right to left and maintain a current total of all of the value to the right and 
     * multiply by the value in output.
     * Time - O(N), space - O(1) (excluding output array)
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        
        int[] output = new int[len];
        int rightProduct = 1;
        
        output[0] = 1;
        
        for(int i = 1; i < len; i++) {
            output[i] = nums[i - 1] * output[i - 1];
        }
        
        for(int i = nums.length - 1; i >= 0; i--) {
            output[i] = rightProduct * output[i];
            rightProduct *= nums[i];
        }
        
        return output;
    }


}