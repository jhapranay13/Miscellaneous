package dynamicProgramming;

public class MaximumInAnArrayRecursion {

	public static void main(String[] args) {
		int arr[] = { 4, 3, 6, 7, 0, 9, 2 };
		int maximum = getMaximumRecur( arr, arr.length - 1 );
		System.out.println( maximum );
	}

	private static int getMaximumRecur(int[] arr, int index) {
		
		if( index == 0 ) {
			return arr[ 0 ];
		}
		
		return Math.max( arr[ index ],  getMaximumRecur( arr, index - 1 ) );
	}

}
