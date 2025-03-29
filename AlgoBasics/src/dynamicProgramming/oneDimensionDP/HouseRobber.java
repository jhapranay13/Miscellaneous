package dynamicProgramming.oneDimensionDP;

public class HouseRobber {

	public static void main(String[] args) {
		int[] houseCash = { 20, 25, 30, 15, 10 };
		int maxProfit = maxProfitRecur( houseCash, houseCash.length - 1 );
		System.out.println( maxProfit );
		
		maxProfit = maxProfitMemo( houseCash );
		System.out.println( maxProfit );
		
		maxProfit = maxProfitDP( houseCash );
		System.out.println( maxProfit );
	}

	private static int maxProfitRecur( int[] houseCash, int index ) {
		
		if( index < 0 ) {
			return 0;
		}
		int includeProfit = houseCash[ index ] + maxProfitRecur( houseCash, index - 2 );
		int excludeProfit = maxProfitRecur( houseCash, index - 1 );
		return Math.max( includeProfit , excludeProfit );
	}

	private static int maxProfitMemo(int[] houseCash) {
		int memo[] = new int[ houseCash.length ];
		int max = maxProfitMemo(houseCash , houseCash.length - 1, memo );
		return max;
	}

	private static int maxProfitMemo(int[] houseCash, int index, int[] memo) {
		
		if( index < 0 ) {
			return 0;
		}
		
		if( memo[ index ] != 0 ) {
			return memo[ index ];
		}
		int includeProfit = houseCash[ index ] + maxProfitRecur( houseCash, index - 2 );
		int excludeProfit = maxProfitRecur( houseCash, index - 1 );
		memo[ index ] = Math.max( includeProfit , excludeProfit );
		return memo[ index ];
	}
	

	private static int maxProfitDP(int[] houseCash) {
		int memo[] = new int[ houseCash.length + 1 ];
		boolean[] selection = new boolean[ houseCash.length ];
		memo[ 1 ] = houseCash[ 0 ];
		selection[ 0 ] = true;
		
		for( int i = 2; i <= houseCash.length; i++ ) {
			memo[ i ] =  Math.max( memo[ i - 1 ], memo[ i - 2 ] + houseCash[ i - 1 ] );
			selection[ i - 1 ] = memo[ i - 2 ] + houseCash[ i - 1 ] > memo[ i - 1 ] ? true :
				false;
		}
		decipherMemoSelection( houseCash, selection );
		return memo[ memo.length - 1 ];
	}

	private static void decipherMemoSelection(int[] houseCash, boolean[] selection) {
		int index = selection.length - 1;
		
		while( index >= 0 ) {
			
			if( selection[ index ] ) {
				System.out.println( "Selected House at index >> " + index + 
						" house Cash >> " + houseCash[ index ] );
				index -= 2;
			} else {
				index--;
			}
		}
	}
}
