import java.util.*;

/*
 * Write a function that checks that a sequence of brackets is balanced.
 * https://leetcode.com/problems/valid-parentheses/
 */
public class MatchingBrackets {
    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        
        Stack<Character> openBraces = new Stack<>();
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (isOpeningBrace(c)) {
                openBraces.push(c);
            } else {
                if (openBraces.isEmpty() || !bracesMatch(openBraces.pop(), c)) {
                    return false;
                }
            }
        }
        
        return openBraces.isEmpty();
    }
    
    private boolean isOpeningBrace(char c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    private boolean bracesMatch(char c1, char c2) {
        switch(c1) {
            case '(':
                return c2 == ')';
            case '[':
                return c2 == ']';
            case '{':
                return c2 == '}';
            default:
                return false;
        }
    }
}