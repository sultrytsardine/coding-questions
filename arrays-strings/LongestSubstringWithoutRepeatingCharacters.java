import java.util.*;

/*
 * Given a string, return the max length of the substring that contains no repeating characters.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0, i = 0, j = 0;
        Set<Character> chars = new HashSet<>();
        
        while(j < len) {
            char c = s.charAt(j);
            
            if (chars.contains(c)) {
                chars.remove(s.charAt(i++));
            } else {
                chars.add(c);
                max = Math.max(max, chars.size());
                j++;
            }
        }
        
        return max;
    }
}