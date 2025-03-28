package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class BuyAndSellStockTwiceNTime1Space {

	public static void main(String[] args) {
		int[] stockPrice = { 10, 22, 5, 75, 65, 80 };
		int maximumProfit = getMaximumProfit( stockPrice );
		System.out.println( "Maximum Profit >> " + maximumProfit );
	}

	private static int getMaximumProfit(int[] stockPrice) {
		int maximumProfit = 0;
		int minimumSoFar = stockPrice[ 0 ];
		stockPrice[ 0 ] = 0;
		int flipSwitch = 2;
		int currentValueRunning = 0;
		
		for( int i = 1; i < stockPrice.length; i++ ) {
			
			if( stockPrice[ i ] < minimumSoFar ) {
				minimumSoFar = stockPrice[ i ];
			}
			stockPrice[ i ] = Math.max( stockPrice[ i ] - minimumSoFar, stockPrice[ i - 1 ] );
		}
		maximumProfit = stockPrice[ stockPrice.length - 1 ];
		currentValueRunning = maximumProfit;
		System.out.println( "Array >> " + Arrays.toString( stockPrice )  );
		
		for( int i = stockPrice.length - 2; i > 0; i-- ) {
			
			if( stockPrice[ i ] <  currentValueRunning ) {
				flipSwitch--;
				currentValueRunning = stockPrice[ i ];
			}
			
			if( flipSwitch == 0 ) {
				maximumProfit += stockPrice[ i ];
				break;
			}
		}
		return maximumProfit;
	}

}
