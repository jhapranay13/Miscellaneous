package elementsOfProgramming.GreedyAlgorithmsAndInvariants;

public class ThreeSumWithoutUsingHashMap {

	public static void main(String[] args) {
		int [] arr = { 2, 3, 5, 7, 11 };
		int targetElement = 22;
		System.out.println( hasThreeSum( arr, targetElement ) );
	}

	private static boolean hasThreeSum(int[] arr, int targetElement) {
		
		for( int i = 0; i < arr.length; i++ ) {
			int value = arr[ i ];
			boolean twoSumFlag = hasTwoSum(arr, targetElement - value);
			
			if( twoSumFlag ) {
				return true;
			}
		}
		return false;
	}

	private static boolean hasTwoSum(int[] arr, int target) {

		for( int  i = 0, j = arr.length - 1; i < j; ) {

			if( arr[ i ] + arr[ j ] == target ) {
				System.out.println( arr[ i ] + " " + arr[ j ] );
				return true;
			}

			if( arr[ i ] + arr[ j ] < target ) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}
