package elementsOfProgramming.GreedyAlgorithmsAndInvariants;

public class MaximumWaterTrapping {

	public static void main(String[] args) {
		int arr[] = { 0, 1, 0, 2, 0, 1, 0, 4, 1, 3, 2, 4, 2, 1 };
		int maximumWaterTrapped = getMaxTrappedWater( arr );
		System.out.println( maximumWaterTrapped );
	}

	public static int getMaxTrappedWater(int[] heights) {
		int lo = 0, 
			hi = heights.length - 1, 
			maxWater = 0;
		
		while (lo < hi){
			int width = hi - lo ;
			maxWater = Math.max(maxWater ,
					width * Math.min(heights[ lo ], heights[ hi ] ) );
			
			if (heights[ lo ] > heights[ hi ] ){
				--hi ;
			} else if (heights[ lo ] < heights[ hi ] ){
				++lo ;
			} else {
				++lo ;
				--hi ;
			}
		}
		return maxWater;
	}
}
