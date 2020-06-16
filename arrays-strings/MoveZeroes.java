/* 
 * Given an array, move all of the zeroes to the end of the array, preserving the order of the other non-zero elements.
 * The reordering should be done inline with no additional data structures.
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeroes {
    /*
     * 2 proposed solutions
     */

    /*
     * This solution does 2 passes over the array, firstly it shifts all of the elements to the left to replace any zeroes. The second pass then fills in the required zeroes at the end. Time O(N), space O(1).
     * Leetcode suggests that the swap approach is better because we only have to loop over the array once, however the performance seemed to be equivalent and this method
     * used slightly less memory.
     */    
    public void moveZeroes(int[] nums) {              
        int lastNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZero++] = nums[i];
            }
        }
        
        for(int i = lastNonZero; i < nums.length; i++) {
            nums[i] = 0;
        }   
    }

     /*
      * This method does an inline swap inline and removes the necessity to do a second pass over the array which fills in the zeroes. Time - O(N), space O(1).
      */
    public void moveZeroes(int[] nums) {              
        for (int i = 0, lastNonZero = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[lastNonZero];
                nums[lastNonZero++] = nums[i];
                nums[i] = temp;
            }
        }
        
    }
}