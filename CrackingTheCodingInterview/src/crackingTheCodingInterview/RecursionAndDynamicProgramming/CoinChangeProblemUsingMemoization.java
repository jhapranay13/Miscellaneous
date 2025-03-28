package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class CoinChangeProblemUsingMemoization {

	public static void main(String[] args) {
		int[] denomination = { 25, 10, 5, 1 };
		int amount = 100;
		int[] count = new int[ denomination.length ]; 
		int index = 0;
		int[][] memo = new int[ denomination.length ][ amount + 1 ];
		printCoinChange( denomination, amount, index, memo, count );
	}

	private static void printCoinChange(int[] denomination, int amount, int index, 
			int[][] memo, int[] count) {
		
		if( index >= denomination.length ) {
			return;
		}
		
		for( int  i = 0; amount >= i * denomination[ index ]; i++ ) {
			int remainingAmount = amount - 
					memo[ index ][ i * denomination[ index ] ] * denomination[ index ];
			
			if( remainingAmount == amount ) {
				remainingAmount = amount - ( i * denomination[ index ] );
				memo[ index ][ i * denomination[ index ] ] = i;
			}
			
			if( i != 0 ) {
				count[ index ]++;
			}
			
			if( remainingAmount == 0 ) {
				System.out.println( "25 >> " + count[ 0 ] + " || 10 >> " + count[ 1 ]  +
						" || 5 >> " + count[ 2 ] + " || 1 >> " + count[ 3 ]);
				count[ index ] = 0;
				return;
			}
			printCoinChange(denomination, remainingAmount, index + 1, memo, count);
		}
		//count[ index ] = 0;
	}
}
