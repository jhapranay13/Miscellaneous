package elementsOfProgramming.GreedyAlgorithmsAndInvariants;

public class TwoSumWithoutHashMap {

	public static void main(String[] args) {
		int[] arr = { -2, 1, 2, 4, 7, 11 }; // already sorted or else would have sorted
		int target = 13;
		printTwoSum( arr, target );
	}

	private static void printTwoSum(int[] arr, int target) {
		
		for( int  i = 0, j = arr.length - 1; i < j; ) {
			
			if( arr[ i ] + arr[ j ] == target ) {
				System.out.println( arr[ i ] + " " + arr[ j ] );
				return;
			}
			
			if( arr[ i ] + arr[ j ] < target ) {
				i++;
			} else {
				j--;
			}
		}
	}

}
