import java.util.*;

/*
 * Write a function to covert a Roman numeral to a string.
 * https://leetcode.com/problems/roman-to-integer/
*/
public class RomanNumeralToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> numerals = createNumeralMapping();
        int len = s.length();
        int result = 0, i = 0;
        
        while (i < len) {
            char c = s.charAt(i);
            int mappedInt = numerals.get(c);
            
            if (i != len - 1) {
                char nextChar = s.charAt(i + 1);
                
                if (c == 'I' && (nextChar == 'V' || nextChar == 'X')) {
                    mappedInt = numerals.get(nextChar) - mappedInt;
                    i++;
                } else if (c == 'X' && (nextChar == 'L' || nextChar == 'C')) {
                    mappedInt = numerals.get(nextChar) - mappedInt;
                    i++;
                } else if (c == 'C' && (nextChar == 'D' || nextChar == 'M')) {
                    mappedInt = numerals.get(nextChar) - mappedInt;
                    i++;
                }
            }
            
            result += mappedInt;
            i++;
        }
        
        return result;
    }
    
    private Map<Character, Integer> createNumeralMapping() {
        Map<Character, Integer> numerals = new HashMap<>();
        
        numerals.put('I', 1);
        numerals.put('V', 5);
        numerals.put('X', 10);
        numerals.put('L', 50);
        numerals.put('C', 100);
        numerals.put('D', 500);
        numerals.put('M', 1000);
        
        return numerals;
    }
}