package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class MinimumNumberOfStepsToReachEndDynamicProgrammingV1 {

	public static void main(String[] args) {
		//int[] board = { 3, 3, 1, 0, 2, 0, 1};
		int[] board = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		//int[] board = {1, 3, 6, 1, 0, 9};
		int [] result = new int[ board.length ];
		minimumStepsRequired( board, result );
		System.out.println( "Minimum Steps required >> " + result[ 0 ] );
	}

	private static void minimumStepsRequired(int[] board, int[] result) {
		Arrays.fill( result , Integer.MAX_VALUE);
		result[ result.length - 1 ] = 0;
		
		for( int i = result.length - 2; i >= 0; i-- ) {
			
			if( board[ i ] == 0 ) {
				continue;
			}
			
			for( int j = board[ i ] + i; j > i; j-- ) {
				
				if( j >= board.length ) {
					j = board.length - 1;
				} 
				
				if( board[ j ] == 0 ) {
					continue;
				}
				int temp = result[ j ] == Integer.MAX_VALUE ? result[ j ] : result[ j ] + 1;
				result[ i ] = Math.min( result[ i ] , temp);
			}
		}
	}
}
