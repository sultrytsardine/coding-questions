/*
 * Given a sorted array of integers, remove all duplicates and return the length of the dupe-free part of the array. Alter the array in line, without using additional data structures.
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDupes {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 0;
        
        for(int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}