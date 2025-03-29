package dynamicProgramming.oneDimensionDP;

import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		int[] length = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] value = { 1, 5, 8, 9, 10, 14, 17, 20, 24, 30 };
		int size = 8;

		int maxProfit = maxProfitRecur( length, value, size );
		System.out.println( maxProfit );

		int [] memo = new int[ size + 1 ];
		Arrays.fill( memo , - 1 );
		maxProfit = maxProfitMemo( length, value, size, memo );
		System.out.println( maxProfit );

		maxProfit = maxProfitDP( length, value, size );
		System.out.println( maxProfit );
	}

	private static int maxProfitRecur(int[] length, int[] value, int size) {

		if( size <= 0 ) {
			return 0;
		}
		int maxProfit = Integer.MIN_VALUE;

		for( int i = 0; i < size; i++ ) {
			maxProfit = Math.max( maxProfit ,
					value[ i ] + maxProfitRecur(length, value, 
							size - i - 1 ) );
		}
		return maxProfit;
	}

	private static int maxProfitMemo(int[] length, int[] value, int size, int [] memo) {

		if( size <= 0 ) {
			return 0;
		}

		if( memo[ size - 1 ] != -1 ) {
			return memo[ size - 1 ];
		}
		int maxProfit = Integer.MIN_VALUE;

		for( int i = 0; i < size; i++ ) {
			maxProfit = Math.max( maxProfit ,
					value[ i ] + maxProfitMemo(length, value, 
							size - i - 1, memo ) );
		}
		memo[ size - 1 ] =  maxProfit;
		return memo[ size - 1 ];
	}

	private static int maxProfitDP(int[] length, int[] value, int size ) {
		int[] memo = new int[ size + 1 ];
		int[] cuts = new int[ size + 1 ];

		for( int j = 1; j <= size; j++ ) {
			int cut =  -1;
			
			for( int i = 0; i < j; i++ ) {
				
				if( value[ i ] + memo[ j - i - 1 ] > memo[ j ] ) {
					cut = i + 1;
					memo[ j ] =  value[ i ] + memo[ j - i - 1 ];
				}
			}
			cuts[ j ] = cut;
		}
		decipherResult( cuts, size );
		return memo[ size ];
	}

	private static void decipherResult(int[] cuts, int size) {
		int l = size;
		int cut = cuts[ l ];
		
		while( l != 0 ) {
			System.out.println( cut );
			l -= cut;
			cut = cuts[ l ];
		}
	}


}
