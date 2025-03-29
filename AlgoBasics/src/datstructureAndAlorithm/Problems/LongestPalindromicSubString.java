package datstructureAndAlorithm.Problems;

public class LongestPalindromicSubString {

	public static void main(String[] args) {
		System.out.println("Longest Palindromic Substring: " + 
				findLPSLengthRecurrsion("ABCCBUA"));
	}

	private static int findLPSLengthRecurrsion(String string) {
		
		if( string == null || string.length() <= 2 ) {
			return 0;
		}
		return findLPSLengthRecurrsion( string, 0, string.length() - 1 );
	}

	private static int findLPSLengthRecurrsion(String string, 
			int startIndex, int endIndex) {
		
		if( startIndex > endIndex ) {
			return 0;
		}
		
		if( startIndex == endIndex ) {
			return 1;
		}
		char firstChar = string.charAt( startIndex );
		char secondChar = string.charAt( endIndex );
		int lengthIfEqual = 0;
		int lengthIncrFirst = 0;
		int lengthDecrLast = 0;
		
		if( firstChar == secondChar ) {
			int remainingLength = endIndex - startIndex - 1;
			int tmpHolder = findLPSLengthRecurrsion(string, 
					startIndex + 1, endIndex - 1 );
			
			if( tmpHolder == remainingLength ) {
				lengthIfEqual += 2 + tmpHolder;
			} 
		}
		lengthIncrFirst = findLPSLengthRecurrsion(string, 
				startIndex + 1, endIndex);
		lengthDecrLast = findLPSLengthRecurrsion(string, startIndex, 
				endIndex - 1 );
		return Math.max( lengthIfEqual , Math.max( lengthIncrFirst , lengthDecrLast ) );
	}

}
