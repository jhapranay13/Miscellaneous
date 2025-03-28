package elementsOfProgramming.DynamicProgramming;

import java.util.Arrays;

public class MaximumSubArraySum {

	public static void main(String[] args) {
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int[] indexes = new int[ 2 ];
		int result = calculateMaximumSumOfSubArray( arr, indexes );
		System.out.println( "Maximum sum is " + result + " starting end ending index " + 
				Arrays.toString( indexes ));
	}

	private static int calculateMaximumSumOfSubArray(int[] arr, int[] indexes) {
		int maxTillNow = arr[ 0 ];
		int startingIndex = 0;
		int endingIndex = 0;
		int sum  = 0;
		
		for( int i = 0; i < arr.length; i++ ) {
			sum += arr[ i ];
			
			if( sum > maxTillNow) {
				endingIndex = i;
				maxTillNow = sum;
			}
			
			if( arr[ i ] > sum ) {
				maxTillNow = arr[ i ];
				sum = maxTillNow;
				startingIndex = endingIndex = i;
			}
		}
		indexes[ 0 ] = startingIndex;
		indexes[ 1 ] = endingIndex;
		return maxTillNow;
	}

}
