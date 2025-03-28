package elementsOfProgramming.DynamicProgramming;

import java.util.Arrays;

public class NumberOfMovesToClimbStairs {

	public static void main(String[] args) {
		int numberOfStairs = 5;
		int numberOfMaximumSteps = 3;
		
		int result = calculateNumberOfMovesRecursion( numberOfStairs, numberOfMaximumSteps );
		System.out.println( result );
		int []memo = new int[ numberOfStairs + 1 ];
		Arrays.fill( memo , -1);
		result = calculateNumberOfMovesDP( numberOfStairs, memo);
	}

	private static int calculateNumberOfMovesDP(int numberOfStairs, int[] memo) {

			if( numberOfStairs < 0 ) {
				return 0;
			} else if( numberOfStairs == 0 ) {
				return 1;
			} else if( memo[ numberOfStairs ] > -1 ) {
				return memo[ numberOfStairs ];
			}
			memo[ numberOfStairs ] =  calculateNumberOfMovesDP( numberOfStairs - 1, memo ) + 
					calculateNumberOfMovesDP( numberOfStairs - 2, memo ) + 
					calculateNumberOfMovesDP( numberOfStairs - 3, memo );
			System.out.println( Arrays.toString( memo ) );
			return memo[ numberOfStairs ]; 
	}

	private static int calculateNumberOfMovesRecursion(int numberOfStairs, int numberOfMaximumSteps) {
		
		if( numberOfStairs == 0 ) {
			return 1;
		}
		
		if( numberOfStairs < 0 ) {
			return 0;
		}
		
		int result = 0;
		
		for( int i = numberOfMaximumSteps; i > 0; i-- ) {
			result += calculateNumberOfMovesRecursion(numberOfStairs - i, numberOfMaximumSteps);
		}
		
		return result;
	}

}
