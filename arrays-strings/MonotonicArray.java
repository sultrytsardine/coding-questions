import java.util.*;

/*
 * Given an array, determine whether it is monotonic (increasing or decreasing).
 * https://leetcode.com/problems/monotonic-array
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        boolean increasing = true, decreasing = true;
        int len = A.length;
        
        for (int i = 0; i < len - 1; i++) {
            if (!increasing && !decreasing) return false;
            
            int current = A[i];
            int next = A[i + 1];
            
            if (current < next) {
                decreasing = false;
            } else if (current > next) {
                increasing = false;
            }

        }
        
        return increasing || decreasing;
    }    
}