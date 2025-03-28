package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class BuyAndSellAStockTwice {

	public static void main(String[] args) {
		int[] stockPrice = { 10, 22, 5, 75, 65, 80 };
		int maximumProfit = getMaximumProfit( stockPrice );
		System.out.println( "Maximum Profit >> " + maximumProfit );
	}

	private static int getMaximumProfit(int[] stockPrice) {
		int maximumProfit = 0;
		int[] leftToRight = new int[ stockPrice.length ];
		int[] rightToLeft = new int[ stockPrice.length ];
		int minimumPriceEncounteredSoFar = stockPrice[ 0 ];
		int maximumPriceEncounteredSoFar = stockPrice[ stockPrice.length - 1 ];
		
		for( int i = 1; i < stockPrice.length; i++ ) {
			
			if( stockPrice[ i ] > minimumPriceEncounteredSoFar ) {
				leftToRight[ i ]  = stockPrice[ i ] - minimumPriceEncounteredSoFar;
			} else {
				minimumPriceEncounteredSoFar = stockPrice[ i ];
			}
			leftToRight[ i ] = Math.max( leftToRight[ i ] , leftToRight[ i - 1 ] );
		}
		System.out.println( "LEFT TO RIGHT >> " + Arrays.toString( leftToRight ) );
		
		for( int i = stockPrice.length - 2; i >= 0; i-- ) {
			
			if( stockPrice[ i ] < maximumPriceEncounteredSoFar ) {
				rightToLeft[ i ] = maximumPriceEncounteredSoFar - stockPrice[ i ];
			} else {
				maximumPriceEncounteredSoFar = stockPrice[ i ];
			}
			rightToLeft[ i ] = Math.max( rightToLeft[ i ] , rightToLeft[ i + 1 ] );
		}
		System.out.println( "RIGHT TO LEFT >> " + Arrays.toString( rightToLeft ) );
		
		for( int i = 0; i < leftToRight.length - 2; i++  ) {
			maximumProfit = Math.max( maximumProfit ,  leftToRight[ i ] + rightToLeft[ i + 1 ]  );
		}
		return maximumProfit;
	}

}
