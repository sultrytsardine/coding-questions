import java.util.*;

/*
 * Given a 2D array, where each sub array contains a lower and an upper value. Return a new 2D array representing the places where the intervals overlap.
 * https://leetcode.com/problems/merge-intervals
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0],a2[0]));
        
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);
        
        for (int[] interval : intervals) {
            int curMax = current[1];
            int nextMin = interval[0];
            int nextMax = interval[1];
            
            if (curMax >= nextMin) {
                current[1] = Math.max(curMax, nextMax);    
            } else {
                current = interval;
                result.add(current);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}