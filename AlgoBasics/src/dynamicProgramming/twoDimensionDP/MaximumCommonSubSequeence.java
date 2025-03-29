package dynamicProgramming.twoDimensionDP;

import java.util.Arrays;

public class MaximumCommonSubSequeence {

	public static void main(String[] args) {
		String str1 = "ACHEFMGLP";
		String str2 = "XYCEPQMLG";

		int longestSubSeq = longestSubSeqRecur( str1, str2, str1.length() - 1, 
				str2.length() - 1 );
		System.out.println( longestSubSeq );

		longestSubSeq = longestSubSeqMemo( str1, str2, str1.length() - 1, 
				str2.length() - 1 );
		System.out.println( longestSubSeq );

		longestSubSeq = longestSubSeqDP( str1, str2, str1.length() - 1, 
				str2.length() - 1 );
		System.out.println( longestSubSeq );
	}

	private static int longestSubSeqRecur(String str1, String str2, 
			int index1, int index2) {

		if( index1 < 0 || index2 < 0 ) {
			return 0;
		}

		int count = Integer.MIN_VALUE;

		if( str1.charAt( index1 ) == str2.charAt( index2 ) ) {
			count =  Math.max( count, 
					1 + longestSubSeqRecur( str1, str2, index1 - 1, index2 - 1 ) );
		} else {
			count = Math.max( longestSubSeqRecur( str1, str2, index1 - 1, index2 ) , 
					longestSubSeqRecur( str1, str2, index1, index2 - 1 ) );
		}
		return count;
	}

	private static int longestSubSeqMemo(String str1, String str2, int i, int j) {
		int[][] memo = new int[ i + 1 ][ j + 1 ];

		for( int[] mem : memo ) {
			Arrays.fill( mem , -1 );
		}
		return longestSubSeqMemo( str1, str2, i, j, memo);
	}

	private static int longestSubSeqMemo(String str1, String str2, 
			int index1, int index2, int[][] memo) {

		if( index1 < 0 || index2 < 0 ) {
			return 0;
		}

		if( memo[ index1 ][ index2 ] != -1 ) {
			return memo[ index1 ][ index2 ];
		}

		int count = Integer.MIN_VALUE;

		if( str1.charAt( index1 ) == str2.charAt( index2 ) ) {
			count =  Math.max( count, 
					1 + longestSubSeqMemo( str1, str2, index1 - 1, index2 - 1, memo ) );
		} else {
			count = Math.max( longestSubSeqMemo( str1, str2, index1 - 1, index2, memo ) , 
					longestSubSeqMemo( str1, str2, index1, index2 - 1, memo ) );
		}
		return memo[ index1 ][ index2 ] = count;
	}

	private static int longestSubSeqDP(String str1, String str2, int index1, int index2) {
		int[][] memo = new int[ index1 + 2 ][ index2 + 2 ];

	/*	for( int[] mem : memo ) {
			Arrays.fill( mem , -1 );
		}*/
		
		for( int i = 1; i <= index1 + 1; i++ ) {
			
			for( int j = 1; j <= index2 + 1; j++ ) {
				memo[ i ][ j ] = Integer.MIN_VALUE;

				if( str1.charAt( i - 1 ) == str2.charAt( j - 1 ) ) {
					memo[ i ][ j ] =  Math.max( memo[ i ][ j ], 1 + memo[ i - 1][ j - 1 ]);
				} else {
					memo[ i ][ j ] = Math.max( memo[ i - 1 ][ j ] , memo[ i ][ j - 1 ] );
				}
	
			}
		}
		decipherMemo( memo, str1, str2 );
		return memo[ index1 ][ index2 ];
	}

	private static void decipherMemo(int[][] memo, String str1, String str2) {
		
		for( int[] mem : memo ) {
			System.out.println( Arrays.toString( mem ) );
		}
		// TODO Auto-generated method stub
		
	}

}
