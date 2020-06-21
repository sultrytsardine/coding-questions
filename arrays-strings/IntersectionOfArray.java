import java.util.*;

/*
 * Given 2 arrays, find the intersection between the and return it as a new array.
 * Time complexity = O(N + M), space complexity = O()
 */
public class IntersectionOfArray {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        
        for (int i : nums1) set.add(i);
        
        for (int i : nums2) {
            if (set.contains(i)) intersection.add(i);
        }
        
        int[] result = new int[intersection.size()];
        int j = 0;
        
        for (int i : intersection) result[j++] = i;
        
        return result;
    }
}