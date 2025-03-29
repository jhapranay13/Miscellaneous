package dynamicProgramming.twoDimensionDP;

import java.util.Arrays;

public class EditDistance {

	public static void main(String[] args) {
		String str1 = "GET";
		String str2 = "GOAT";

		int distance = editDistanceRecur( str1, str2, str1.length() - 1, 
				str2.length() - 1 );
		System.out.println( distance );

		distance = editDistanceMemo( str1, str2 );
		System.out.println( distance );

		distance = editDistanceDP( str1, str2 );
		System.out.println( distance );
	}

	private static int editDistanceRecur(String str1, String str2, int index1, int index2) {

		if( index1 < 0  ) {
			return index2 + 1;
		}

		if( index2 < 0  ) {
			return index1 + 1;
		}
		int count = 0;

		if( str1.charAt(index1) == str2.charAt(index2) ) {
			count = editDistanceRecur(str1, str2, index1 - 1, index2 - 1 );
		} else {
			count = 1 +  Math.min( editDistanceRecur(str1, str2, index1 - 1, index2),
					Math.min( editDistanceRecur(str1, str2, index1, index2 - 1), 
							editDistanceRecur(str1, str2, index1 - 1, index2 - 1 ) ) );
		}
		return count;
	}

	private static int editDistanceMemo(String str1, String str2) {
		int [][] memo = new int[ str1.length() ][ str2.length() ];

		for( int mem[] : memo ) {
			Arrays.fill( mem , -1);
		}
		return editDistanceMemo(str1, str2, str1.length() - 1, str2.length() - 1, memo);
	}

	private static int editDistanceMemo(String str1, String str2, int index1, int index2,
			int[][] memo) {

		if( index1 < 0  ) {
			return index2 + 1;
		}

		if( index2 < 0  ) {
			return index1 + 1;
		}

		if( memo[ index1 ][ index2 ] != -1 ) {
			return memo[ index1 ][ index2 ];
		}
		int count = 0;

		if( str1.charAt(index1) == str2.charAt(index2) ) {
			count = editDistanceMemo( str1, str2, index1 - 1, index2 - 1, memo );
		} else {
			count = 1 +  Math.min( editDistanceMemo( str1, str2, index1 - 1, index2, memo ),
					Math.min( editDistanceMemo( str1, str2, index1, index2 - 1, memo ),
							editDistanceMemo( str1, str2, index1 - 1, index2 - 1, memo )) );
		}
		return memo[ index1 ][ index2 ] = count;
	}

	private static int editDistanceDP(String str1, String str2) {
		int [][] memo = new int[ str1.length() + 1 ][ str2.length() + 1 ];

		for( int i = 0; i <= str1.length(); i++ ) {
			
			for( int j = 0; j <= str2.length(); j++ ) {
				
				if( i == 0 ) {
					memo[ i ][ j ] = j;
				} else if( j == 0 ) {
					memo[ i ][ j ] = i;
				} else if( str1.charAt( i - 1 ) == str2.charAt( j - 1 ) ) {
					memo[ i ][ j ] = memo[ i - 1 ][ j - 1 ];
				} else {
					memo[ i ][ j ] = 1 + Math.min( memo[ i ][ j - 1 ] , 
							Math.min( memo[ i - 1 ][ j ], memo[ i - 1 ][ j - 1 ] ) );
				}
			}
		}
		return memo[ str1.length() ][ str2.length() ];
	}
}
