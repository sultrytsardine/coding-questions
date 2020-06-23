import java.util.*;

/*
 * Given a string containing different characters. Return a new string with any invalid parentheses removed.
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses
 */
class MinRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int balanced = 0;
        int len = s.length();
        
        for (int i = 0; i < len; i++) {
            char current = s.charAt(i);
            if (current == '(') balanced++;
            else if (current == ')') {
                if (balanced == 0) continue;
                balanced--;
            }
            
            sb.append(current);
        }
        
        int sbLen = sb.length();
        StringBuilder result = new StringBuilder();
        for (int i = sbLen - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(' && balanced-- > 0) continue;
            result.append(c);
        }
    
        return result.reverse().toString();
    }
}