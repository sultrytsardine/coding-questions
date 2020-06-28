import java.util.*;

/*
 * Implement a method that replaces all spaces in a char array with %20.
 * Cracking the coding interview 1.3
 */
public class URLify {
    public void URLify(char[] chars, int trueLength) {
        int spaces = 0, index;

        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') spaces++;
        }

        index = trueLength + spaces * 3;
        
        if (trueLength < chars.length) chars[trueLength] = '\0';

        for (int i = trueLength - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index - 1] = '0';
                chars[index - 2] = '2';
                chars[index - 3] = '%';
                index -= 2;
            } else {
                chars[index - 1] = chars[i];
                index--;
            }
        }
    }   
}