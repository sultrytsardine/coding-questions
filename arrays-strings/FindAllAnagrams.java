import java.util.*;

/*
 * Given a string s and a string p, find all anagrams of p in s and return the start index of each anagram in s.
 * https://leetcode.com/problems/find-all-anagrams-in-a-string
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return new ArrayList<>();
        
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < pLen; i++) {
            pMap[p.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < sLen; i++) {
            char c = s.charAt(i);
            sMap[c - 'a']++;
            
            if (i >= pLen) {
                c = s.charAt(i - pLen);
                if (sMap[c - 'a'] > 0) {
                    sMap[c - 'a']--;
                } 
            }
            
            
            if (Arrays.equals(sMap, pMap)) {
                result.add(i - pLen + 1);
            }
        }
        
        return result;
    }
}