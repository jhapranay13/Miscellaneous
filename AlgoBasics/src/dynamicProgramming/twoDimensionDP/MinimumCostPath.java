package dynamicProgramming.twoDimensionDP;

import java.util.Arrays;

public class MinimumCostPath {

	public static void main(String[] args) {
		int[][] pathCosts = {
				{ 0, 47, 8, 18, 1 },
				{ 43, 25, 39, 36, 13 },
				{ 22, 8, 13, 38, 46 },
				{ 41, 41, 40, 25, 44 },
				{ 29, 43, 22, 50, 10 }
		};

		int minimumCost = minCostRecur( pathCosts, pathCosts.length - 1, 
				pathCosts[ 0 ].length - 1 );
		System.out.println( minimumCost );

		minimumCost = minCostMemo( pathCosts);
		System.out.println( minimumCost );

		minimumCost = minCostDP( pathCosts);
		System.out.println( minimumCost );
	}

	private static int minCostRecur(int[][] pathCosts, int row, int col) {

		if( row == 0 && col == 0 ) {
			return 0;
		}
		int cost = Integer.MAX_VALUE;

		if( row > 0 ) {
			cost = Math.min( minCostRecur( pathCosts, row - 1, col) , cost ); 
		}

		if( col > 0 ) {
			cost = Math.min( cost, minCostRecur(pathCosts, row, col - 1 ) );
		}	
		cost += pathCosts[ row ][ col ];
		return cost;
	}



	private static int minCostMemo(int[][] pathCosts) {
		int[][] memo = new int[ pathCosts.length ][ pathCosts[ 0 ].length ];

		for( int[] mem : memo ) {
			Arrays.fill( mem , -1);
		}
		memo[ 0 ][ 0 ] = 0;
		return minCostMemo(pathCosts, pathCosts.length - 1, 
				pathCosts[ 0 ].length - 1, memo );
	}

	private static int minCostMemo(int[][] pathCosts, int row, int col, int[][] memo) {
		if( row == 0 && col == 0 ) {
			return 0;
		}

		if( memo[ row ][ col ] != -1 ) {
			return memo[ row ][ col ];
		}
		int cost = Integer.MAX_VALUE;

		if( row > 0 ) {
			cost = Math.min( minCostMemo( pathCosts, row - 1, col, memo) , cost ); 
		}

		if( col > 0 ) {
			cost = Math.min( cost, minCostMemo(pathCosts, row, col - 1, memo ) );
		}	
		cost += pathCosts[ row ][ col ];
		memo[ row ][ col ] = cost;
		return memo[ row ][ col ];
	}


	private static int minCostDP(int[][] pathCosts) {
		int maxRow = pathCosts.length - 1;
		int maxCol = pathCosts[ 0 ].length - 1;
		int[][] memo = new int[ pathCosts.length ][ pathCosts[ 0 ].length ];

		for( int[] mem : memo ) {
			Arrays.fill( mem , -1);
		}
		memo[ 0 ][ 0 ] = 0;

		for( int i = 0; i <= maxRow; i++ ) {

			for( int j = 0; j <= maxCol; j++ ) {

				if( i == 0 && j == 0 ) {
					continue;
				}
				memo[ i ][ j ] = Integer.MAX_VALUE;

				if( j > 0 ) {
					memo[ i ][ j ] = Math.min( memo[ i ][ j ], memo[ i ][ j - 1 ] ) +
							pathCosts[ i ][ j ];
				}

				if( i > 0 ) {
					memo[ i ][ j ] = Math.min(memo[ i ][ j ], memo[ i - 1 ][ j ] ) +
							pathCosts[ i ][ j ];
				}
			}
		}

		for( int[] mem : memo ) {
			System.out.println( Arrays.toString( mem ) );
		}
		decipherMemo( memo, pathCosts );
		return memo[ maxRow ][ maxCol ];
	}

	private static void decipherMemo(int[][] memo, int[][] pathCosts) {

		int i = memo.length - 1;
		int j = memo[ 0 ].length - 1;

		while( i > 0 || j > 0 ) {

			if( i > 0  && j > 0) {

				if( memo[i - 1][ j ] < memo[ i ][ j - 1 ] ) {
					System.out.println( pathCosts[ i - 1 ][ j ] );
					i = i - 1;
				} else {
					System.out.println( pathCosts[ i ][ j - 1 ] );
					j = j - 1;
				}
			} else if( i == 0 && j > 0 ) {
				System.out.println( pathCosts[ i ][ j - 1 ] );
				j = j - 1;
			} else if( i > 0 && j == 0 ) {
				System.out.println( pathCosts[ i - 1 ][ j ] );
				i = i - 1;
			}
		}
	}
}
