import java.util.*;

/*
 * Given a bad version number, find the version number that caused the issues. Use the provided API "isBadVersion" (provided by the problem).
 * Binary search between 1 and n, check if current version is bad, if so, then bad version is lower than or equal to current, else it is greater than current.
 * Time O(logN), space O(1)
 * https://leetcode.com/problems/first-bad-version
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}