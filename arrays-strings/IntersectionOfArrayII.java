import java.util.*;

/*
 * Find the intersection of 2 arrays.
 * 2 Solutions:
 * 1 - store the count of each int in a hashmap and then iterate over the second array and check if the values exit in the hashmap.
 * 2 - order the arrays and then iterate over using a pointer for each array.
 * https://leetcode.com/problems/intersection-of-two-arrays-ii
 */
public class IntersectionOfArrayII {
    /*
     * Solution 1
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> intersections = new ArrayList<>();
        
        for (int i : nums1) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        
        for (int i : nums2) {
            int currentCount = counts.getOrDefault(i, 0);
            if (currentCount > 0) {
                intersections.add(i);
                counts.put(i, --currentCount);
            }
        }
        
        int[] result = new int[intersections.size()];
        
        for (int i = 0; i < result.length; i++) {
            result[i] = intersections.get(i);
        }
        
        return result;
    }

    /*
     * Solution 2
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> intersections = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersections.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        int[] result = new int[intersections.size()];
        
        for(int index = 0; index < intersections.size(); index++) {
            result[index] = intersections.get(index);
        }
        
        return result;
    }
}