package datstructureAndAlorithm.Problems;

public class ZeroOneKnapsack {

	public static void main(String[] args) {
		int[] profits = { 31, 26, 72, 17 };
		int[] weights = { 3, 1, 5, 2 };
		int knapSackWeight = 7;
		int maxProfit = knapsackRecurssion(profits, weights, knapSackWeight );
		System.out.println(maxProfit);
	}

	private static int knapsackRecurssion(int[] profits, int[] weights, 
			int knapSackWeight) {
		
		if( knapSackWeight == 0 || profits == null || profits.length == 0 ||
				weights.length == 0 || profits.length != weights.length ) {
			return 0;
		}
		
		int maxProfit = knapsackRecurssion( profits, weights, 
				knapSackWeight, 0 );
		return maxProfit;
	}

	private static int knapsackRecurssion(int[] profits, int[] weights, 
			int knapSackWeight, int index) {
		
		if( index >= profits.length || knapSackWeight <= 0 ) {
			return 0;
		}
		int profitIfSelected = 0;
		
		if( knapSackWeight - weights[ index ] > 0 ) {
			profitIfSelected = profits[ index ] + knapsackRecurssion(profits,
				weights, knapSackWeight - weights[ index ], index + 1);
		}
		int profitIfNotSelected = knapsackRecurssion(profits, weights, 
				knapSackWeight, index + 1);
		return Math.max( profitIfSelected , profitIfNotSelected );
	}

}
