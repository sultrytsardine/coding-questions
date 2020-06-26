import java.util.*;

/*
 * Given an array of words, and a string containing the lexicographic representation of an alien alphabet, determine whether the list of words is sorted
 * according to the alien alphabet.
 * https://leetcode.com/problems/verifying-an-alien-dictionary
 */
public class VerifyingAnAlienLanguage {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[order.charAt(i) - 'a'] = i;
        }
        
        int len = words.length;
        
        for(int i = 0; i < len - 1; i++) {
            String current = words[i];
            String next = words[i + 1];
            int curLen = current.length();
            int nextLen = next.length();
            int letters = Math.max(curLen, nextLen);
            
            for (int j = 0; j < letters; j++) {
                char c1 = j >= curLen ? '0' : current.charAt(j);
                char c2 = j >= nextLen ? '0' : next.charAt(j);
                int idx1 = j >= curLen ? -1 : map[c1 - 'a'];
                int idx2 = j >= nextLen ? -1 : map[c2 - 'a'];
                
                if(idx1 == idx2) continue;
                else if (idx1 < idx2) break;
                else return false;
            }
        }
        
        return true;
    }
}