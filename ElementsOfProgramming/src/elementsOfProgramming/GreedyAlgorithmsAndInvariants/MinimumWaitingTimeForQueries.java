package elementsOfProgramming.GreedyAlgorithmsAndInvariants;

import java.util.Arrays;

public class MinimumWaitingTimeForQueries {

	public static void main(String[] args) {
		int[] queryTime = { 2, 5, 1, 3 };
		minimumWaitingTimeForQueries( queryTime );
	}

	private static void minimumWaitingTimeForQueries(int[] queryTime) {
		Arrays.sort( queryTime );
		int minimumWaitingTime = 0;
		
		for( int i = 0; i < queryTime.length; i++ ) {
			int remainingQueries = queryTime.length - ( i + 1 );
			minimumWaitingTime += queryTime[ i ] * remainingQueries;
		}
		System.out.println( minimumWaitingTime );
	}

}
