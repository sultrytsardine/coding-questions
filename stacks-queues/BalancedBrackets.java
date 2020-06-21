import java.util.*;

/*
 * Given a string of opening and closing branckets, determine whether the brackets all match up.
 * https://www.hackerrank.com/challenges/balanced-brackets
 */
public class BalancedBrackets {
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int i = 0;

        while (i < len) {
            char c = s.charAt(i);

            if (isOpening(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return "NO";
                }
            }

            i++;
        }

        if (!stack.isEmpty()) return "NO";

        return "YES";
    }

    private static boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isMatching(char matching, char c) {
        switch(matching) {
            case '(':
                return c == ')';
            case '{':
                return c == '}';
            case '[':
                return c == ']';
            default:
                return false;
        }
    }
}