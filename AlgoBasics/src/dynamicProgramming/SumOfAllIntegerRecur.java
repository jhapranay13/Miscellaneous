package dynamicProgramming;

public class SumOfAllIntegerRecur {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		int sum = calculateSumRecur( arr, arr.length - 1 );
		System.out.println( sum );
	}

	private static int calculateSumRecur( int[] arr, int index ) {
		
		if( index == 0 ) {
			return arr[ index ];
		}
		return arr[ index ] + calculateSumRecur( arr, index - 1 );
	}

}
