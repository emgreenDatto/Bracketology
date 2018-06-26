public class BracketChecker {
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