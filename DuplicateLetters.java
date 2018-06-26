/**
 * DuplicateLetters.java
 * 
 * Version: $Id$
 * 
 * Revisions: $Log$
 * 
 */

import java.util.ArrayList;

/**
 * 
 * Finds the word with the most letters in a given string.
 * 
 * @author Eric Green
 *
 */
public class DuplicateLetters {
	/**
	 * Determines the word with the most duplicate letters each string (sentence) provided.
	 * 
	 * @param args A String array of arguments that contains a String or Strings to be processed.
	 */
	public static void main (String[] args) {
		if(args.length == 0) {
			System.err.println("Usage: No arguments provided.\n");
			System.exit(0);
		}
		for(int count = 0; count < args.length; count++) {
			System.out.println("Input: " + args[count]);
			System.out.println("Output: " + getWordWithMostDuplicateLetters(args[count]));
			if(count != args.length-1) {
				System.out.println();
			}
		}
	}
	
	/**
	 * Finds the word that is a substring of of the String provided that has the most duplicate characters.
	 * This method does not handle hypehnated words properly at this time, but this could be easily
	 * corrected by changing the regular expression used.  It has been left as is because the current form
	 * is considerably shorter and more readable. 
	 * 
	 * @param inputString The source string from which to find the word with the greatest occurrences
	 * of duplicate letters.
	 * 
	 * @return The word in inputString that contains the most duplicate characters.
	 */
	private static String getWordWithMostDuplicateLetters(String inputString) {
		
		ArrayList<Character> characters = new ArrayList<Character>();
		ArrayList<Integer> characterCounts = new ArrayList<Integer>();
		
		String duplicateLetterWord = null;
		String[] words;
		char currentCharacter;
		int characterIndex;
		int greatestDuplicateCount = 0;
		int duplicateCount = 0;
		
		words = inputString.split("\\s|\\p{Punct}");  /**Split the string as delineated by a Regex that
												   		 denotes space or punctuation **/
				
		/**
		 * Iterate through each word and then each character in each word.  Keeping track of the number
		 * of times each character is seen for each word.
		 * 
		 * The characters and characterCounts ArrayLists are used here like a single associative array.
		 */
		for(int count = 0; count < words.length; count ++) {
			if(words[count].length() > 0) {
				if(duplicateLetterWord == null) {
					duplicateLetterWord = words[count];
				}
				for(int count2 = 0; count2 < words[count].length(); count2++) {
					currentCharacter = words[count].charAt(count2);
					characterIndex = characters.indexOf(currentCharacter);
					if(characterIndex == -1) {
						characters.add(currentCharacter);
						characterCounts.add(1);
					}
					else {
						characterCounts.set(characterIndex, characterCounts.get(characterIndex)+1);
					}
				}
				
				//Determine the greatest number of duplicate letters for this word
				characterCounts.sort(null);
				duplicateCount = characterCounts.get(characterCounts.size() - 1);
				
				if(duplicateCount > greatestDuplicateCount) {
					greatestDuplicateCount = duplicateCount;
					duplicateLetterWord = words[count]; 
				}
				characterCounts.clear();
				characters.clear();
			}
		}
		return duplicateLetterWord;
	}
}
