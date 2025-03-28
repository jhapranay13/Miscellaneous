package elementsOfProgramming.Recursion;

import java.util.Arrays;

public class NQueenProblem {

	public static void main(String[] args) {
		int numberOfQueens = 5;
		int result[] = new int[ numberOfQueens ];
		solve( numberOfQueens, result, 0 );
		System.out.println( Arrays.toString( result ) );
		System.out.println("===============");

		for( int i = 0; i < result.length; i++ ) {

			for( int j = 0; j < result.length; j++ ) {

				if( j != result[ i ] ) {
					System.out.print( 0 + " " );
				} else {
					System.out.print( 1 + " " );
				}
			}
			System.out.println();
		}	
	}
	
	private static boolean solve(int numberOfQueens, int[] result, int row ) {
		
		if( row == result.length ) {
			return true;
		}

		for( int i = 0; i < result.length; i++ ) {
			boolean isValid = false;
			
			if( row == 0 ) {
				result[ row ] = i;
				isValid = true;
			} else {
				isValid = checkValid( result, row, i );
			}	
			
			if( isValid ) {
				result[ row ] = i;
				isValid = solve(numberOfQueens - 1, result, row + 1 );
				
				if( isValid ) {
					return true;
				}
			}	
		}	
		return false;
	}

	private static boolean checkValid(int[] result, int row, int col) {
		
		for( int i = 0; i < row; i++ ) {
			int columnUnderConsideration = result[ i ];
			int rowUnderConsideration = i;
			
			int resultRow = Math.abs( row - rowUnderConsideration );
			int resultCol = Math.abs( col - columnUnderConsideration );
			
			if( resultRow == resultCol || resultCol == 0 ) {
				return false;
			}
		}
		
		return true;
	}

}
