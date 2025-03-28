package elementsOfProgramming.Strings;

public class PalindromicityUsingOOneSpace {

	public static void main(String[] args) {
		//String string = "Able was I, ere I saw Elba!";
		String string = "Ray a Ray";
		boolean palindromeFlag = checkPalindromicity( string );
		System.out.println( palindromeFlag );
	}

	private static boolean checkPalindromicity(String string) {
		int startIndex = 0;
		int maxIndex = string.length() - 1;
		
		while( startIndex < maxIndex ) {
			
			while( !Character.isLetterOrDigit(string.charAt( startIndex ) ) ) {
				startIndex++;
			}
			
			while( !Character.isLetterOrDigit(string.charAt( maxIndex ) ) ) {
				maxIndex--;
			}
			
			if( Character.toLowerCase( string.charAt( startIndex ) ) != 
					Character.toLowerCase( string.charAt( maxIndex ) ) ) {
				return false;
			}
			startIndex++;
			maxIndex--;
		}
		
		return true;
	}
}
