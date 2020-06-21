import java.util.*;

/* 
 * Given an array of prices and a total spend, calculate the indexes of the 2 prices that add up to the total. Indexing is 1-based (starts at 1) and return array
 * should be sorted in ascending order.
 * time - O(N), space O(N)
 * https://www.hackerrank.com/challenges/icecream-parlor
 * Very similar to https://leetcode.com/problems/two-sum
 */
public class IceCreamParlour {
    
    /*
     * Store each index against its value in a hashmap and lookup each complement value to see if it exists in the hashmap.
     */
    static int[] icecreamParlor(int m, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int current = arr[i];
            int complement = m - current;

            if (map.containsKey(complement)) {
                int complementIdx = map.get(complement);
                
                return new int[]{Math.min(complementIdx, i + 1), Math.max(complementIdx, i + 1)};
            }

            map.put(current, i + 1);
        }

        throw new IllegalArgumentException("No matches found");
    }
}