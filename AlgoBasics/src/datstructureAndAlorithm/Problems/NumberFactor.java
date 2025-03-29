package datstructureAndAlorithm.Problems;

public class NumberFactor {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4 };
		int n = 5;
		int numberOfWaysToGetN = numberOfWays( arr, n );
		System.out.println( numberOfWaysToGetN );
		numberOfWaysToGetN = numberOfWaysTopDown( arr, n );
		System.out.println( numberOfWaysToGetN );
		numberOfWaysToGetN = numberOfWaysBottomUp( arr, n );
		System.out.println( numberOfWaysToGetN );
	}

	private static int numberOfWaysBottomUp(int[] arr, int n) {
		int memo[] = new int[ n + 1 ];
		memo[ 0 ] = 1;



		for( int j = 0; j <= n; j++ )
			
			for( int i = 0; i < arr.length; i++ ) {
				
				if( j - arr[ i ] >= 0 ) {
					memo[ j ] += memo[ j - arr[ i ] ];
				}
			}
		return memo[ n ];
	}

	private static int numberOfWaysTopDown(int[] arr, int n) {
		int memo[] = new int[ n + 1 ];
		memo[ 0 ] = 1;
		return numberOfWaysTopDown( arr, n, memo );
	}

	private static int numberOfWaysTopDown(int[] arr, int n, int[] memo) {

		if( arr.length == 0 || n < 0 ) {
			return 0;
		}

		if( memo[ n ] > 0 ) {
			return memo[ n ];
		}

		for( int i = 0; i < arr.length; i++ ) {
			memo[ n ] += numberOfWaysTopDown(arr, n - arr[ i ], memo );
		}
		return memo[ n ];
	}

	private static int numberOfWays(int[] arr, int n) {

		if( arr.length == 0 || n < 0 ) {
			return 0;
		}

		if( n == 0 ) {
			return 1;
		}
		int numberOfWays = 0;

		for( int i = 0; i < arr.length; i++ ) {
			numberOfWays += numberOfWays(arr, n - arr[ i ] );
		}
		return numberOfWays;
	}
}
