package elementsOfProgramming.GreedyAlgorithmsAndInvariants;

import java.util.Arrays;

public class OptimumAssignmentOfTasks {

	public static void main(String[] args) {
		int [] taskTime = { 5, 2, 1, 6, 4, 4 };
		optimumTaskAssingment( taskTime );
	}

	private static void optimumTaskAssingment(int[] taskTime) {
		Arrays.sort( taskTime );
		
		for( int i = 0, j = taskTime.length - 1; i <= j; i++, j-- ) {
			System.out.println( taskTime[ i ] + " " + taskTime[ j ] );
		}
	}
}
