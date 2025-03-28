package elementsOfProgramming.Arrays;

public class MinimumNumberOfStepToReachEndN {

	public static void main(String[] args) {
		//int[] board = { 3, 3, 1, 0, 2, 0, 1};
		//int[] board = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int[] board = {1, 3, 6, 1, 0, 9};
		int step = minimumStepsRequired( board );
		System.out.println( "Minimum Steps required >> " + step );
	}

	private static int minimumStepsRequired(int[] board) {
		
		if( board[ 0 ] == 0 ) {
			return -1;
		}
		int steps = 1;
		int maximumReachedInARange = board[ 0 ];
		int window = board[ 0 ];
		
		for( int i = 0; i < board.length; i++ ) {
			
			if( i <= maximumReachedInARange ) {
				maximumReachedInARange = Math.max(maximumReachedInARange, board[ i ] + i );
				
				if( i == window ) {
					steps++;
					window = maximumReachedInARange;
				}
			}
			
			if( maximumReachedInARange >= board.length - 1 ) {
				
				if( maximumReachedInARange != window ) {
					steps++;
				}	
				break;
			}
		}
		return steps;
	}
}
