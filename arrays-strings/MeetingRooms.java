import java.util.*;

/*
 * Given an array with a list of meeting start and end times, determine whether the person can attend all of the meetings.
 * Easier version of MergeIntervals.
 * https://leetcode.com/problems/meeting-rooms
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) return true;
        
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] current = intervals[i];
            int currentEnd = current[1];
            
            if (currentEnd > intervals[i + 1][0]) return false;
        }
        
        return true;
    }
}