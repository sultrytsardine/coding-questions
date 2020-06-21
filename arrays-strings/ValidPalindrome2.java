import java.util.*;

/*
 * Given a string, determine if a single character can be removed to turn it into a valid palidrome.
 * https://leetcode.com/problems/valid-palindrome-ii
 */
public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while(i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValidPalidromeSubString(s, i + 1, j)
                    || isValidPalidromeSubString(s, i, j - 1);
            }
            
            i++;
            j--;
        }
        
        return true;
    }
    
    private boolean isValidPalidromeSubString(String s, int i, int j) {
        int a = i, b = j;
        while(a <= b) {
            if (s.charAt(a) != s.charAt(b)) return false;
            a++;
            b--;
        }
        return true;
    }
}