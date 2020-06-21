import java.util.*;

/*
 * Return the sum of all of the array elements
 * https://www.hackerrank.com/challenges/a-very-big-sum
 */
public class AVeryBigSum {
    public long aVeryBigSum(long[] ar) {
        long result = 0;

        for(long i : ar) {
            result += i;
        }
        return result;
    }    
}