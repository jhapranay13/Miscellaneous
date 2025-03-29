package datstructureAndAlorithm.Problems;

public class LongestPalindromicSubSequence {

	public static void main(String[] args) {
		System.out.println("Longest Palindromic Sequence: " + 
				findLPSLengthRecurrsion("elrmenmet"));
	}

	private static int findLPSLengthRecurrsion(String string) {

		if( string == null || string.length() <= 2 ) {
			return 0;
		}
		return findLPSLengthRecurrsion( string, 0, string.length() - 1 );
	}

	private static int findLPSLengthRecurrsion(String string, int index, int lastIndex) {

		if( index > lastIndex ) {
			return 0;
		} else if( index == lastIndex) {
			return 1;
		}
		char firstChar = string.charAt( index );
		char lastChar = string.charAt( lastIndex );
		int equalChar = 0;
		int incrFirst = 0;
		int incrLast = 0;

		if( firstChar == lastChar ) {
			equalChar += 2 + findLPSLengthRecurrsion(string, index + 1, lastIndex - 1 );
		}
		incrFirst += findLPSLengthRecurrsion(string, index + 1, lastIndex );
		incrLast += findLPSLengthRecurrsion( string, index, lastIndex - 1 ); 

		return Math.max( equalChar , Math.max( incrFirst, incrLast ) );
	}

}
