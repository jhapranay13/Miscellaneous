package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class MagicIndexProblemBF {

	public static void main(String[] args) {
		int[] arr = { -40, -20, -1, 1, 2, 3, 5, 7, 9, 12, 13 };
		int magicIndex = getMagicIndex( arr );
		System.out.println( magicIndex );
	}

	private static int getMagicIndex(int[] arr) {
		
		for( int i = 0; i < arr.length; i++ ) {
			
			if( arr[ i ] == i ) {
				return i;
			}
		}
		return Integer.MIN_VALUE;
	}  

}
