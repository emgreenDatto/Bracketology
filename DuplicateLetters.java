import java.util.ArrayList;

public class DuplicateLetters {
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
	private static String getWordWithMostDuplicateLetters(String inputString) {
		
		ArrayList<Character> characters = new ArrayList<Character>();
		ArrayList<Integer> characterCounts = new ArrayList<Integer>();
		String duplicateLetterWord = null;
		String[] words;
		char currentCharacter;
		int characterIndex;
		int greatestDuplicateCount = 0;
		int duplicateCount = 0;
		
		words = inputString.split("\\s|\\p{Punct}");  //Split the string as delineated by a Regex that
												   //denotes space or punctuation
		
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