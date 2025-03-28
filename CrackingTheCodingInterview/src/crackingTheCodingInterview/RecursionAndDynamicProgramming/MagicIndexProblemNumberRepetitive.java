package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class MagicIndexProblemNumberRepetitive {

	public static void main(String[] args) {
		int[] arr = { -40, -20, 2, 2, 2, 3, 5, 7, 9, 12, 13 };
		int hi = arr.length - 1;
		int lo = 0;
		int magicIndex = getMagicIndex( arr, hi, lo );
		System.out.println( magicIndex );
	}

	private static int getMagicIndex(int[] arr, int hi, int lo) {
		int returnVal = Integer.MIN_VALUE;

		if( lo < hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			int pivotVal = arr[ pivot ];

			if( pivotVal == pivot ) {
				return pivot;
			}
			returnVal = getMagicIndex(arr, hi, pivot);

			if( returnVal != Integer.MIN_VALUE ) {
				return returnVal;
			}

			returnVal = getMagicIndex(arr, pivot, lo);

			if( returnVal != Integer.MIN_VALUE ) {
				return returnVal;
			}
		}
		return returnVal;
	}
}