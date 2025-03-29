package datstructureAndAlorithm.Problems;

public class HouseThief {

	public static void main(String[] args) {
		int[] HouseNetWorth = {6, 7, 1, 30, 8, 2, 4};
		System.out.println( maxMoneyRecurssion(HouseNetWorth) );
		HouseNetWorth = new int[] {20, 5, 1, 13, 6, 11, 40};
		System.out.println( maxMoneyRecurssion(HouseNetWorth) );
		HouseNetWorth = new int[] {6, 7, 1, 30, 8, 2, 4};
		System.out.println( maxMoneyTopDown(HouseNetWorth) );
		HouseNetWorth = new int[] {20, 5, 1, 13, 6, 11, 40};
		System.out.println( maxMoneyTopDown(HouseNetWorth) );
		HouseNetWorth = new int[] {6, 7, 1, 30, 8, 2, 4};
		System.out.println( maxMoneyBottomUp(HouseNetWorth) );
		HouseNetWorth = new int[] {20, 5, 1, 13, 6, 11, 40};
		System.out.println( maxMoneyBottomUp(HouseNetWorth) );
	}

	private static int maxMoneyBottomUp(int[] houseNetWorth) {
		int memo[] = new int[ houseNetWorth.length  + 2 ];
		
		for( int i = houseNetWorth.length - 1; i >= 0; i-- ) {
		
			memo[ i ] = Math.max( houseNetWorth[ i ] + 
					memo[ i + 2 ], 
					memo[ i + 1 ] );
		}
		return memo[ 0 ];
	}

	private static int maxMoneyTopDown(int[] houseNetWorth) {
		int memo[] = new int[ houseNetWorth.length ];
		
		return maxMoneyTopDown(houseNetWorth, 0, memo);
	}

	private static int maxMoneyTopDown(int[] houseNetWorth, int index, int[] memo) {
		
		if( index >= houseNetWorth.length ) {
			return 0;
		}
		
		if( memo[ index ] > 0 ) {
			return memo[ index ];
		}	
		int maxMoney = Math.max( houseNetWorth[ index ] + 
				maxMoneyTopDown( houseNetWorth , index + 2, memo ), 
				maxMoneyTopDown( houseNetWorth, index + 1, memo ) );
		return memo[ index  ] = maxMoney;
	}

	private static int maxMoneyRecurssion(int[] houseNetWorth) {
		
		if( houseNetWorth == null || houseNetWorth.length == 0 ) {
			return 0;
		}
		int maxMoney = maxMoneyRecurssion( houseNetWorth, 0);
		return maxMoney;
	}

	private static int maxMoneyRecurssion(int[] houseNetWorth, int index) {
		
		if( index >= houseNetWorth.length ) {
			return 0;
		}
		int maxMoney = Math.max( houseNetWorth[ index ] + 
				maxMoneyRecurssion( houseNetWorth , index + 2 ), 
				maxMoneyRecurssion( houseNetWorth, index + 1 ) );
		return maxMoney;
	}
}
