package dynamicProgramming.oneDimensionDP;

public class CubeJumping {

	public static void main(String[] args) {
		int[] cubeWithCosts = { 0, 20, 30, 40, 25, 15, 20, 28 };  
		int numberOfJumps = 3;
		int minCost = minCostRecur( cubeWithCosts, cubeWithCosts.length - 1, 
				numberOfJumps );
		System.out.println( minCost );
		
		minCost = minCostMemo( cubeWithCosts, numberOfJumps);
		System.out.println( minCost );
		
		minCost = minCostDP( cubeWithCosts, numberOfJumps);
		System.out.println( minCost );
	}

	private static int minCostRecur(int[] cubeWithCosts, int index, int numberOfJumps) {

		if( index <= 0 ) {
			return 0;
		}
		int min = Integer.MAX_VALUE;

		for( int i = index - numberOfJumps; i < index; i++ ) {

			if( i < 0 ) {
				continue;
			}
			min = Math.min( cubeWithCosts[ index ] + 
					minCostRecur(cubeWithCosts, i, numberOfJumps) , min); 
		}
		return min;
	}

	private static int minCostMemo(int[] cubeWithCosts, int numberOfJumps) {
		int memo[] = new int[ cubeWithCosts.length ];
		return minCostMemo(cubeWithCosts, cubeWithCosts.length - 1, memo, numberOfJumps);
	}

	private static int minCostMemo(int[] cubeWithCosts, int index, int[] memo, 
			int numberOfJumps) {

		if( index <= 0 ) {
			return 0;
		}
		
		if( memo[ index ] != 0 ) {
			return memo[ index ];
		}
		int min = Integer.MAX_VALUE;

		for( int i = index - numberOfJumps; i < index; i++ ) {

			if( i < 0 ) {
				continue;
			}
			min = Math.min( cubeWithCosts[ index ] + 
					minCostMemo(cubeWithCosts, i, memo, numberOfJumps) , min); 
			memo[ index ] = min;
		}
		return memo[ index ];
	}
	
	private static int minCostDP(int[] cubeWithCosts, int numberOfJumps) {
		int[] memo = new int[ cubeWithCosts.length ];
		int[] jump = new int[ memo.length ];
		
		for( int i = 0; i < numberOfJumps; i++ ) {
			memo[ i ] = cubeWithCosts[ i ];
		}
		
		for( int i = numberOfJumps - 1; i < cubeWithCosts.length; i++ ) {
			int min = Integer.MAX_VALUE;
			
			for( int j = i - numberOfJumps; j >= 0 && j < i; j++ ) {
				
				if( cubeWithCosts[ i ] + memo[ j ] < min ) {
					jump[ i ] = j;
				}
				min = Math.min( cubeWithCosts[ i ] + 
						memo[ j ], min ); 
				
				
				memo[ i ] = min;
			}
		}
		decipherMemo( memo, cubeWithCosts, jump  );
		return memo[ memo.length - 1 ];
	}

	private static void decipherMemo(int[] memo, int[] cubeWithCosts, int[] jump) {
		
		for( int i = memo.length - 1; i > 0 ; i-- ) {
			System.out.println( "Reached index >> " + i + " from >> " + jump[ i ] );
			i = jump[ i ] + 1;
		}
	}
}
