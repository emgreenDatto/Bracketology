
public class PalindromeChecker {
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
	
	private static boolean isPalindrome(String inputString) {
		String[] words;
		char[] characters;
		String simplifiedString = "";
		String reversedString = "";
		
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
