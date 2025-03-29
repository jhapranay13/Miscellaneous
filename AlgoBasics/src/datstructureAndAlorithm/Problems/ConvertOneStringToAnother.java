package datstructureAndAlorithm.Problems;

public class ConvertOneStringToAnother {

	public static void main(String[] args) {
		System.out.println( findMinOperationsRecurssion( "table", "tbres" ) );
		System.out.println( findMinOperationsRecurssion( "abcd", "abcderf" ) );
		System.out.println( findMinOperationsRecurssion( "abcd", "apbqcrde" ) );
		System.out.println( findMinOperationsTopDown( "table", "tbres" ) );
		System.out.println( findMinOperationsTopDown( "abcd", "abcderf" ) );
		System.out.println( findMinOperationsTopDown( "abcd", "apbqcrde" ) );
		System.out.println( findMinOperationsBottomUp( "table", "tbres" ) );
		System.out.println( findMinOperationsBottomUp( "abcd", "abcderf" ) );
		System.out.println( findMinOperationsBottomUp( "abcd", "apbqcrde" ) );
	}

	private static int findMinOperationsBottomUp(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i1 = 0; i1 <= s1.length(); i1++) // if we have reached the end of s1, then insert all the remaining characters of s2
			dp[i1][0] = i1;

		for (int i2 = 0; i2 <= s2.length(); i2++) // if we have reached the end of s2, then delete all the remaining characters of s1
			dp[0][i2] = i2;

		for (int i1 = 1; i1 <= s1.length(); i1++) {
			for (int i2 = 1; i2 <= s2.length(); i2++) { // If the strings have a matching character, recursively match for the remaining lengths.
				if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
					dp[i1][i2] = dp[i1 - 1][i2 - 1];
				else
					dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2], // delete
							         Math.min(dp[i1][i2 - 1], // insert
								      	dp[i1 - 1][i2 - 1])); // replace
			}
		}
		return dp[s1.length()][s2.length()];
	}

	private static int findMinOperationsTopDown(String string1, String string2) {
		Integer memo[][] = new Integer[ string1.length() ][ string2.length() ];
		return findMinOperationsTopDown( string1, string2, 0, 0, memo );
	}

	private static int findMinOperationsTopDown(String string1, String string2,
			int index1, int index2,Integer[][] memo) {

		if( index1 == string1.length() ) {
			return index2;
		}

		if( index2 == string2.length() ) {
			return index1;
		}

		if( memo[ index1 ][ index2 ] != null ) {
			return memo[ index1 ][ index2 ];
		}
		char charStr1 = string1.charAt( index1 );
		char charStr2 = string2.charAt( index2 );
		int substitutionOrSame = operationCost( charStr1, charStr2 ) +
				findMinOperationsTopDown(string1, string2, index1 + 1, index2 + 1, memo ); 
		int deletion = 1 + 
				findMinOperationsTopDown(string1, string2, index1 + 1, index2, memo ); 
		int insertion = 1 +
				findMinOperationsTopDown(string1, string2, index1, index2 + 1, memo );
		memo[ index1 ][ index2 ] = Math.min( substitutionOrSame , 
				Math.min( deletion ,  insertion ));
		return memo[ index1 ][ index2 ];
	}

	private static int findMinOperationsRecurssion(String string1, String string2) {

		if( string1 == null && string2 == null ) {
			return 0;
		}
		return findMinOperationsRecurssion( string1, string2, 0, 0 );
	}

	private static int findMinOperationsRecurssion(String string1, String string2,
			int index1, int index2) {

		if( index1 == string1.length() ) {
			return index2;
		}

		if( index2 == string2.length() ) {
			return index1;
		}
		char charStr1 = string1.charAt( index1 );
		char charStr2 = string2.charAt( index2 );
		int substitutionOrSame = operationCost( charStr1, charStr2 ) +
				findMinOperationsRecurssion(string1, string2, index1 + 1, index2 + 1 ); 
		int deletion = 1 + 
				findMinOperationsRecurssion(string1, string2, index1 + 1, index2 ); 
		int insertion = 1 +
				findMinOperationsRecurssion(string1, string2, index1, index2 + 1 );
		return Math.min( substitutionOrSame , Math.min( deletion ,  insertion ));
	}

	private static int operationCost(char charStr1, char charStr2) {
		return charStr1 == charStr2 ? 0 : 1;
	}

}
