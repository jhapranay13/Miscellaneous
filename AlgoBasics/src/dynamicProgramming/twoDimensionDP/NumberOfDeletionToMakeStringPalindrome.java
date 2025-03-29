package dynamicProgramming.twoDimensionDP;

import java.util.Arrays;

public class NumberOfDeletionToMakeStringPalindrome {

	public static void main(String[] args) {
		String word = "KAZAYAKE";

		int count = numOfDeleteToMakePaliRecur( word, word.length() - 1, 0 );
		System.out.println( count );

		count = numOfDeleteToMakePaliMemo( word );
		System.out.println( count );

		count = numOfDeleteToMakePaliDP( word );
		System.out.println( count );
	}

	private static int numOfDeleteToMakePaliRecur(String word, int end, int start) {

		if( end <= start ) {
			return 0;
		}
		int count = 0;

		if( word.charAt( start ) == word.charAt( end ) ) {
			count = numOfDeleteToMakePaliRecur(word, end - 1, start + 1);
		} else {
			count = 1 +  Math.min( numOfDeleteToMakePaliRecur(word, end, start + 1) , 
					numOfDeleteToMakePaliRecur(word, end - 1, start ) );
		}
		return count;
	}

	private static int numOfDeleteToMakePaliMemo(String word) {
		int[][] memo = new int[ word.length() ][ word.length() ];

		for( int[] mem : memo ) {
			Arrays.fill( mem , -1 );
		}
		return numOfDeleteToMakePaliMemo( word, memo, word.length() - 1, 0 );
	}

	private static int numOfDeleteToMakePaliMemo(String word, int[][] memo,
			int end, int start) {

		if( end <= start ) {
			return 0;
		}

		if( memo[ end ][ start ] != -1 ) {
			return memo[ end ][ start ];
		}
		int count = 0;

		if( word.charAt( start ) == word.charAt( end ) ) {
			count = numOfDeleteToMakePaliRecur(word, end - 1, start + 1);
		} else {
			count = 1 +  Math.min( numOfDeleteToMakePaliMemo(word, memo, end, start + 1), 
					numOfDeleteToMakePaliMemo(word, memo, end - 1, start ) );
		}
		return memo[ end ][start] = count;
	}

	//sliding window technique
	private static int numOfDeleteToMakePaliDP(String word) {

		int[][] memo = new int[ word.length() ][ word.length() ];
		
		for( int l = 1; l <= word.length(); l++ ) {
			
			for( int i = 0; i <= word.length() - l; i++ ) {
				int j = l + i - 1; //Sliding window to triangulate
				
				if( i == j ) {
					memo[ i ][ j ] = 0;
					continue;
				}
				
				if( word.charAt( i ) == word.charAt( j  ) ) {
					memo[ i ][ j ] = memo[ i + 1][ j - 1 ];
				} else {
					memo[ i ][ j ] = 1 +  Math.min( memo[ i + 1 ][ j ], 
							memo[ i ][ j - 1 ] );
				}
			}
		}
		
		for( int[] mem : memo ) {
			System.out.println( Arrays.toString( mem ) );
		}
		return memo[ 0 ][ word.length() - 1 ];
	}
}
