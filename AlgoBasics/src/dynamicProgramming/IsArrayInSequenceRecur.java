package dynamicProgramming;

public class IsArrayInSequenceRecur {

	public static void main( String args[] ) {
		//int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int arr[] = { 1, 2, 4, 5, 6, 7 };
		boolean sequenceFlag = isSeqRec( arr, 0 );
		System.out.println( sequenceFlag );
	}

	private static boolean isSeqRec(int[] arr, int index ) {

		if( index == arr.length - 1 ) {
			return true;
		}
		return arr[ index ] + 1 == arr[ index + 1 ] && isSeqRec( arr, index + 1 );
	}
}
