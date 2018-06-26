/**
 * BracketChecker.java
 * 
 * Version: $Id$
 * 
 * Revisions: $Log$
 * 
 */

/**
 * 
 * Determines whether or not the string or strings provided have a valid parenthetical structure.
 * 
 * @author Eric Green
 *
 */
public class BracketChecker {
	
	/**
	 * Runs the bracket check against each string provided.
	 * 
	 * @param args A String array of arguments that contains one or more Strings for evaluation.
	 */
	public static void main (String[] args) {
		if(args.length == 0) {
			System.err.println("Usage: No arguments provided.\n");
			System.exit(0);
		}
		for(int count = 0; count < args.length; count++) {
			System.out.println("Input: " + args[count]);
			System.out.println("Output: " + bracketsAreMatched(args[count]));
			if(count != args.length-1) {
				System.out.println();
			}
		}
	}
	
	/**
	 * Determines whether or not all parentheses are matched in the string provided.
	 * 
	 * @param checkString The string to be checked.
	 * @return True if all parenthesis in checkString match or if none are present, false otherwise.
	 */
	private static boolean bracketsAreMatched(String checkString) {
		int openBracketCount = 0;
		char[] checkStringCharArray = checkString.toCharArray();
		
		for(int count = 0; count < checkStringCharArray.length && openBracketCount >= 0; count++) {
			if(checkStringCharArray[count] == '(') {
				openBracketCount++;
			}
			if(checkStringCharArray[count] == ')') {
				openBracketCount--;
			}
		}
		if(openBracketCount == 0) {
			return true;
		}
		else {
			return false;
		}		
	}
}
