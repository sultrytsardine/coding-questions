/*
 * Given 2 strings, write a method to decide if one is a permutation of the other
 */
import java.util.*;

public class Permutation {

     	public static void main(String[] args) {
            System.out.println(isPermutation("dog", "god"));
            System.out.println(isPermutationSort("GOD", "DOG"));
	}
    
    /*
     * Process the first string and store the count of the characters in an array. Then loop over the second string and decrement the character count for each char. 
     * If the count is ever < 0 then that means that the strings didn't have the same number of each char and therefore aren't permutations of each other
     */
	private static boolean isPermutation(String s1, String s2) {
	    if (s1.length() != s2.length()) {
	        return false;
	    }
        
        int[] letters = new int[128]; //asuming ASCII
	    
	    for (int i = 0; i < s1.length(); i++) {
	        letters[s1.charAt(i)]++;
	    }
	    
	    for(int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0) {
                return false;
            }
	    }
	    
	    return true;
	}
    
    /*
     * Sort the 2 strings using the Arrays.sort method and then compare them to see if they are equal 
     */
	private static boolean isPermutationSort(String s1, String s2) {
	    if (s1.length() != s2.length()) {
	        return false;
	    }
	    
	    return sort(s1).equals(sort(s2));
    }
    
    private static String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}