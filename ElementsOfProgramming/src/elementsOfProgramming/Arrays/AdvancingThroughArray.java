package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class AdvancingThroughArray {

	public static void main(String[] args) {
		int[] board = { 3, 3, 1, 0, 2, 0, 1};
		boolean canReachEndFlag = canReachEnd( board );
		System.out.println( "CAN REACH END FOR " + Arrays.toString( board ) + " >> " +
				canReachEndFlag );
	}

	private static boolean canReachEnd(int[] board) {
		int maxReached = 0;
		
		for( int i = 0; i <= maxReached && maxReached <= board.length - 1; ++i ) {
			maxReached = Math.max(maxReached, i + board[ i ] );
		}
		return maxReached >= board.length - 1;
	}

}
