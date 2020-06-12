import java.util.*;

/*
 * Implement an algorithm to determine if a string has all unique characters. What if you can't use additional data structures?
 * Cracking the Coding Interview 1.1
*/
public class UniqueChars{

	public static void main(String[] args) {
		System.out.println(onlyUnqiueChars("abcdefghijklmnopqrstuvqxyz"));
		System.out.println(onlyUnqiueChars("abcdefghijklmnopqrstuvqxyzz"));
	}
	
	/*
	 * Loop over the string and store true in the array if the character has been seen before. Return false if the value is already set to true.
	 */
	private static boolean onlyUnqiueChars(String input) {
	    if (input.length() > 128) {
			return false; 
		}

	    boolean[] charSet = new boolean[128]; //assuming ASCII
		
	    for(int i = 0; i < input.length(); i++) {
		    char c = input.charAt(i);
		    if (charSet[c]) {
		        return false;
		    }
		    charSet[c] = true;
	    }
        return true;
	}
}