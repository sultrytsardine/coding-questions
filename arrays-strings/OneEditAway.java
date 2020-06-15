import java.util.*;

/*
 * Write a function that takes 2 strings as an argument and determines whether they are "1 edit" away from one another.
 * https://leetcode.com/problems/one-edit-distance/
 */
public class OneEditAway {
    public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        
        if (sLen == tLen) return isOneReplaceAway(s, t, sLen);
        else if (sLen == tLen - 1) return isOneInsertionOrDeletionAway(s, t, sLen, tLen);
        else if (sLen == tLen + 1) return isOneInsertionOrDeletionAway(t, s, tLen, sLen);
        
        return false;
    }
    
    private boolean isOneInsertionOrDeletionAway(String s, String t, int sLen, int tLen) {
        int i = 0, j = 0;
        
        while(i < sLen && j < tLen) {
            if (s.charAt(i) != t.charAt(j)) {
                if (i != j) return false;
                j++;
            } else {
                i++;
                j++;
            }
        }
        
        return true; 
    }
    
    private boolean isOneReplaceAway(String s, String t, int len) {
        boolean difference = false;
        
        for(int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (difference) return false;
                difference = true;
            }
        }
        
        return difference;
    }
}