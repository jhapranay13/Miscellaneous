package dynamicProgramming;

public class BinomialCoefficient {

	public static void main(String[] args) {
		int n = 6;
		int k = 4;
		System.out.println( biCoeffRec( n, k ) );

		int memo[][] = new int[ n + 1 ][ k + 1 ]; // since in recursive function there 
		//are two parameters that change have to use multidimensional array because for every
		//parameter that changes in recursive function we have to add new dimension.

		System.out.println( biCoeffMemo( n, k, memo ) );

		memo = new int[ n + 1 ][ k + 1 ];
		System.out.println( biCoeffDP( n, k, memo ) );
	}

	private static int biCoeffRec(int n, int k) {

		if( n == k || k == 0 ) {
			return 1;
		}

		return biCoeffRec( n - 1, k - 1 ) + biCoeffRec( n - 1 , k );
	}

	private static int biCoeffMemo(int n, int k, int[][] memo) {

		if( n == k || k == 0 ) {
			return 1;
		}

		if( memo[ n ][ k ] != 0 ) {
			return memo[ n ][ k ];
		}
		memo[ n ][ k ] = biCoeffMemo( n - 1, k, memo ) + 
				biCoeffMemo( n - 1, k - 1, memo ); 
		return memo[ n ][ k ];
	}


	private static int biCoeffDP(int n, int k, int[][] memo) {

		//setting up base cases
		for( int i = 0; i <= n; i++ ) {

			for( int j = 0; j <= k; j++ ) {

				if( i == j || j == 0) {
					memo[ i ][ j ] = 1;
				}
			}
		}

		//using the recursive function to derive and calculate
		for( int i = 1; i <= n; i++ ) {

			for( int j = 1; j <= k; j++ ) {
				memo[ i ][ j ] = memo[ i - 1 ][ j ] + 
						memo[ i - 1 ][ j - 1 ]; 	
			}
		}
		return memo[ n ][ k ];
	}
}
