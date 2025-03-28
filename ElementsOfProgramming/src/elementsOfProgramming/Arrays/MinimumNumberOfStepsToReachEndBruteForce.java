package elementsOfProgramming.Arrays;

public class MinimumNumberOfStepsToReachEndBruteForce {

	public static void main(String[] args) {
		//int[] board = { 3, 3, 1, 0, 2, 0, 1};
		//int[] board = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		int[] board = {1, 3, 6, 1, 0, 9};
		int startPosition = 0;
		int steps = 0;
		int minimumSteps = minimumStepsRequired( board, startPosition, steps );
		System.out.println( "Minimum Steps required >> " + minimumSteps );
	}

	private static int minimumStepsRequired(int[] board, int startPosition, int steps) {
		
		if( startPosition >= board.length - 1 ) {
			return steps;
		}
		
		int stepsToBeTaken = board[ startPosition ];
		int minimumStep = Integer.MAX_VALUE;
		
		for( int i = stepsToBeTaken; i > 0; i-- ) {
			int step = startPosition + i;
			
			if( step == 0 ) {
				return Integer.MAX_VALUE;
			} else {
				minimumStep = Math.min( minimumStep, 
						minimumStepsRequired(board, step, steps + 1) );
			}
		}
		return minimumStep;
	}
}
