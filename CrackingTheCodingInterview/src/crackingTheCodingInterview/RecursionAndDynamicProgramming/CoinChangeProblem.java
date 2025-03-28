package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class CoinChangeProblem {

	public static void main(String[] args) {
		int[] denomination = { 25, 10, 5, 1 };
		int[] count = new int[ denomination.length ];
		int amount = 100;
		int index = 0;
		printCoinChange( denomination, amount, count, index );
	}

	private static void printCoinChange(int[] denomination, int amount, int[] count, int index) {
		
		if( index >= denomination.length) {
			return;
		}
		
		for( int i = 0; amount >= denomination[ index ] * i; i++ ) {
			
			if( i != 0 ) {
				count[ index ]++;
			}	
			int amountRemaining = amount - denomination[ index ] * i;
			
			if( amountRemaining == 0 ) {
				System.out.println( "25 >> " + count[ 0 ] + " || 10 >> " + count[ 1 ]  +
						" || 5 >> " + count[ 2 ] + " || 1 >> " + count[ 3 ]);
				//clearing the count at this index so will not interfere with ther counts
				count[ index ] = 0;
				return;
			}
			printCoinChange(denomination, amountRemaining, count, index + 1);
		}
		
	}

}
