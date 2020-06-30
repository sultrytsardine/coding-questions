import java.util.*;

/* 
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).
 * https://leetcode.com/problems/find-common-characters
 */
public class FindCommonChars {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        int[] charFrequencies = new int[26];
        Arrays.fill(charFrequencies, Integer.MAX_VALUE);
        
        for(String word : A) {
            int len = word.length();
            int[] currentFrequencies = new int[26];
            
            for(int i = 0; i < len; i++) {
                currentFrequencies[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                charFrequencies[i] = Math.min(charFrequencies[i], currentFrequencies[i]);
            }
        }
        
        for (int i = 0; i < 26; i++) {
            while(charFrequencies[i] > 0) {
                result.add("" + (char)(i + 'a'));
                charFrequencies[i]--;
            }
            
        }
        
        return result;
    }
}