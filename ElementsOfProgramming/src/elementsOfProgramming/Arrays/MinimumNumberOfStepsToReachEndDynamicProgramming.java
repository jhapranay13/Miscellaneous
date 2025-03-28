package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class MinimumNumberOfStepsToReachEndDynamicProgramming {

	public static void main(String[] args) {
		int[] board = { 3, 3, 1, 0, 2, 0, 1};
		//int[] board = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		//int[] board = {1, 3, 6, 1, 0, 9};
		int [] result = new int[ board.length ];
		minimumStepsRequired( board, result );
		System.out.println( "Minimum Steps required >> " + result[ board.length - 1 ] );
	}

	private static void minimumStepsRequired(int[] board, int[] result) {
		Arrays.fill( result , Integer.MAX_VALUE);
		result[ 0 ] = 0;

		for( int i = 0; i < board.length; i++ ) {

			if( board[ i ] == 0 ) {
				continue;
			} else {

				for( int j = board[ i ] + i; j >= 0; j-- ) {

					if( j >= board.length - 1  ) {
						result[ board.length - 1 ] = Math.min( result[ i ] + 1,
								result[ board.length - 1 ]);
						j = board.length - 1;
					} else {

						if( board[ j ] != 0 ) {
							result[ j ] = Math.min( result[ i ] + 1, result[ j ]);
						}
					}

				}
			}
		}
	}
}
