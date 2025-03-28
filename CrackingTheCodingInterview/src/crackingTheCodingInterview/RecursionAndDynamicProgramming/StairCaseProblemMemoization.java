package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.Arrays;

public class StairCaseProblemMemoization {

	public static void main(String[] args) {
		int numberOfStairs = 36;
		int arr[] = new int[ numberOfStairs + 1 ];
		Arrays.fill(arr, -1);
		int ways = countWays( numberOfStairs, arr );
		System.out.println( ways );
	}

	private static int countWays(int numberOfStairs, int[] arr) {

		if( numberOfStairs < 0 ) {
			return 0;
		} else if( numberOfStairs == 0 ) {
			return 1;
		} else if( arr[ numberOfStairs ] > -1 ) {
			return arr[ numberOfStairs ];
		}
		arr[ numberOfStairs ] =  countWays( numberOfStairs - 1, arr ) + countWays( numberOfStairs - 2, arr ) + 
				countWays( numberOfStairs - 3, arr );
		return arr[ numberOfStairs ]; 
	}
}
