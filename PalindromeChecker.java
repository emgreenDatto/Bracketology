/**
 * PalindromeChecker.java
 * 
 * Version: $Id$
 * 
 * Revisions: $Log$
 * 
 */

/**
 * 
 * Determines whether or not the String given is a Palindrome.
 * 
 * @author Eric Green
 *
 */
public class PalindromeChecker {
	
	/**
	 * Determines whether or not the String or Strings provided are Palindromes.
	 * 
	 * @param args A String array of arguments that contains a String or Strings to be checked.
	 */
	public static void main (String[] args) {
		if(args.length == 0) {
			System.err.println("Usage: No arguments provided.\n");
			System.exit(0);
		}
		for(int count = 0; count < args.length; count++) {
			System.out.println("Input: " + args[count]);
			System.out.println("Output: " + isPalindrome(args[count]));
			if(count != args.length-1) {
				System.out.println();
			}
		}
	}
	
	/**
	 * Determines whether or not the string provided is a palindrome.
	 * 
	 * @param inputString The string to be checked.
	 * @return True if the inputString is a Palindrome, false otherwise.
	 */
	private static boolean isPalindrome(String inputString) {
		String[] words;
		char[] characters;
		String simplifiedString = "";
		String reversedString = "";
		
		//Remove all space and punctuation from the input
		words = inputString.split("\\s|\\p{Punct}");
		for(int count = 0; count < words.length; count++) {
			simplifiedString += words[count];
		}
		
		simplifiedString = simplifiedString.toLowerCase();
		characters = simplifiedString.toCharArray();
		
		for(int count = characters.length -1; count >= 0; count--) {
			reversedString += characters[count];
		}
		System.out.println(reversedString);
		return simplifiedString.compareTo(reversedString) == 0;
	}
}
