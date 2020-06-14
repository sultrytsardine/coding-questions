import java.util.*;

/*
 * Write a function that convers a string into an integer. If the int is greater than Integer.MAX_VALUE or less than Integer.MIN_VALUE then return MAX_VALUE or MIN_VALUE respectively.
 * https://leetcode.com/problems/string-to-integer-atoi/
*/
public class ATOI {
    public int myAtoi(String str) {
        int index = 0, result = 0, negative = 1, len = str.length();
        
        while(index < len && str.charAt(index) == ' ') {
            index++;
        }
        
        if (str == null || str.isEmpty() || index == len) {
            return result;
        }
        
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            negative = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        
        while(index < len && isInt(str.charAt(index))) {
            int toAdd = str.charAt(index) - '0';

            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < toAdd) {
                return negative < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;   
            }
            
            result = result * 10 + toAdd;
            index++;       
        }
        
        return result * negative;
    }
    
    private boolean isInt(char c) {
        return c >= '0' && c <= '9';
    }
}