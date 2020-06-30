import java.util.*;

/*
 * Determine whether a string is a permutation of a palindrome.
 * Cracking the coding interview 1,4
 */
public class PermutationOfAPalindrome {
    public boolean isAPermutationOfAPalindrome(String s) {
        int[] chars = new int[128];
        int len = s.length();
        boolean odd = false;

        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.	isLetterOrDigit(c)) {
                chars[Character.toLowerCase(c) - 'a']++;
            }
        }

        for(int i = 0; i < chars.length; i++) {
            if (chars[i] % 2 != 0) {
                if (odd) return false;
                odd = true;
            }
        }

        return true;

        

    }
}