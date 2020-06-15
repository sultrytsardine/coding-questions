import java.util.*;

/*
 * Given a string containing a range of different characters, write a function to determine whether the alphanumeric part of the string is a palindrome.
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        
        int i = 0, j = s.length() - 1;
        
        while(i < j) {
            char ci = Character.toLowerCase(s.charAt(i));
            char cj = Character.toLowerCase(s.charAt(j));
            
            if(!Character.isLetterOrDigit(ci)) i++;
            else if (!Character.isLetterOrDigit(cj)) j--;
            else {
                if (ci != cj) return false;
                i++;
                j--;
            }
        }
        return true;
    }
}