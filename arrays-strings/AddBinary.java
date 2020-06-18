import java.util.*;

/*
 * Add 2 binary strings together and return the result as a string.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0, sum = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            sum = carry;
            int aSum = i >= 0 ? a.charAt(i) - '0' : 0;
            int bSum = j >= 0 ? b.charAt(j) - '0' : 0;
            sum += aSum + bSum;
            sb.insert(0, sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }
        
        if (carry == 1) sb.insert(0, '1');
        
        return sb.toString();
    }
}