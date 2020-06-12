/*
 * Given 2 sorted arrays, merge array2 into array1. Assume that array1 is long enough to facilitate array2.
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int i = nums1.length - 1 ;
        
        while (i >= 0) {
            if (m < 0) {
                nums1[i] = nums2[n--];
            } else if (n < 0) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
            }
            i--;
        }
    }
}