package elementsOfProgramming.Arrays;

public class BuyAndSellAStockOnce {

	public static void main(String[] args) {
		int[] stockPrice = { 310, 315, 275, 295, 260, 270, 290, 230, 255, 250 }; 
		int maximumProfit = getMaximumProfit( stockPrice );
		System.out.println( "Max Profit To be Made >> " + maximumProfit );
	}

	private static int getMaximumProfit(int[] stockPrice) {
		int minimumPriceSoFar = stockPrice[ 0 ];
		int maximumProfit = 0;
		
		for( int i = 1; i < stockPrice.length; i++ ) {
			
			if( minimumPriceSoFar > stockPrice[ i ] ) {
				minimumPriceSoFar = stockPrice[ i ];
			} else {
				maximumProfit = Math.max( maximumProfit, stockPrice[ i ] - minimumPriceSoFar ); 
			}
		}
		return maximumProfit;
	}

}
