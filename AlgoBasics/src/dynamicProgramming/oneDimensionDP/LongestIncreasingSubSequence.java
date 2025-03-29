package dynamicProgramming.oneDimensionDP;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int arr[] = { 5, 2, 4, 7, 3, 8 };
		int max = longestSubSeqRecur( arr, arr.length - 1 );
		System.out.println( max );

		max = longestSubSeqMemo( arr );
		System.out.println( max );

		max = longestSubSeqDP( arr );
		System.out.println( max );
	}

	private static int longestSubSeqRecur(int[] arr, int index) {

		if( index == 0 ) {
			return 1;
		}
		int max = 0;

		for( int i = 0; i < index; i++  ) {
			int runningList = longestSubSeqRecur(arr, i);

			if( arr[ index ] > arr[ i ] ) {
				runningList++;
			}
			max = Math.max( max, runningList );
		}
		return max;
	}

	private static int longestSubSeqMemo(int[] arr) {
		int memo[] = new int[ arr.length + 1 ];
		return longestSubSeqMemo(arr, memo, arr.length - 1);
	}

	private static int longestSubSeqMemo(int[] arr, int[] memo, int index ) {

		if( index == 0 ) {
			return 1;
		}

		if( memo[ index ] != 0 ) {
			return memo[ index ];
		}
		int max = 0;

		for( int i = 0; i < index; i++  ) {
			int runningList = longestSubSeqMemo(arr, memo, i);

			if( arr[ index ] > arr[ i ] ) {
				runningList++;
			}
			max = Math.max( max, runningList );
		}
		memo[ index ] = max;
		return max;
	}

	private static int longestSubSeqDP(int[] arr) {
		int memo[] = new int[ arr.length ];
		memo[ 0 ] = 1;		

		for( int i = 0; i < arr.length; i++ ) {
			memo[ i ] = 1;
			
			for( int j = 0; j < i; j++  ) {
				int runningList = memo[ j ];

				if( arr[ j ] < arr[ i ] ) {
					runningList++;
				}
				memo[ i ] = Math.max( memo[ i ], runningList );
			}
		}
		return memo[ arr.length - 1 ];
	}
}
