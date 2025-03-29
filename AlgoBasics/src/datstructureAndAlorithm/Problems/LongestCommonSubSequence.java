package datstructureAndAlorithm.Problems;

public class LongestCommonSubSequence {
	
	public static void main( String args[] ) {
		System.out.println( findLCSLengthRecurssion("houdini", "hdupti") );
		System.out.println( findLCSLengthRecurssion("elephant", "erepat") );

	}

	private static int findLCSLengthRecurssion(String string1, String string2) {
		
		if( string1 == null || string1.length() == 0 ||
				string2 == null || string2.length() == 0 ) {
			return 0;
		}
		return findLCSLengthRecurssion(string1, string2, 0, 0);
	}

	private static int findLCSLengthRecurssion(String string1, String string2,
			int index1, int index2) {
		
		if( index1 == string1.length() || index2 == string2.length() ) {
			return 0;
		}
		char str1Char = string1.charAt( index1 );
		char str2Char = string2.charAt( index2 );
		int longestLengthIfEqual = 0;
		int longestLengthIfIncrementFirst = 0;
		int longestLengthIfIncrementSecond = 0;
		
		if( str1Char == str2Char ) {
			longestLengthIfEqual = 1 + findLCSLengthRecurssion(string1, string2, index1 + 1, index2 + 1 );
		} else {
			longestLengthIfIncrementFirst += findLCSLengthRecurssion(string1, 
					string2, index1 + 1, index2);
			longestLengthIfIncrementSecond += findLCSLengthRecurssion(string1, 
					string2, index1, index2 + 1 );
		}
		return Math.max( longestLengthIfEqual, Math.max( longestLengthIfIncrementFirst,
				longestLengthIfIncrementSecond ) );
	}
}
