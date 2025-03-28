package elementsOfProgramming.DynamicProgramming;

public class LargestCommonSubsequence {

	public static void main(String[] args) {
		String string1 = "abcdef";
		String string2 = "acf";

		int maxSubSequence = largestCommonSubSequenceRecursion( string1, string2, 0 , 0 );
		System.out.println( maxSubSequence );

		int[][] table = new int[ string2.length() ][ string1.length() + 1 ];
		maxSubSequence = largestCommonSubSequenceDP( string1, string2, table );
		System.out.println( maxSubSequence );
	}

	private static int largestCommonSubSequenceDP(String string1, String string2, int[][] table) {

		for( int i = 0; i < string2.length(); i++ ) {

			for( int j = 1; j <= string1.length(); j++ ) {

				if( i == 0 ) {
					
					if( string1.charAt( j - 1 ) == string2.charAt( i ) ) {
						table[ i ][ j ] = 1;
					} else {
						table[ i ][ j ] += table[ i ][ j - 1 ];
					}
				} else {
					
					if( string1.charAt( j - 1 ) == string2.charAt( i ) ) {
						table[ i ][ j ] = 1 + table[ i - 1 ][ j ];
					} else {
						table[ i ][ j ] += Math.max( table[ i - 1][ j ], table[ i ][ j - 1 ] );
					}
				}
			}
		}
		printTable(table);
		return table[ string2.length() - 1 ][ string1.length() ] ;
	}

	private static int largestCommonSubSequenceRecursion(String string1, String string2,
			int index1, int index2) {

		if( index1 == string1.length() || index2 == string2.length() ) {
			return 0;
		} 
		//If selected. Happens only when both are equal 

		if( string1.charAt( index1 ) == string2.charAt( index2 ) ) {
			return 1 + largestCommonSubSequenceRecursion(string1, string2, index1 + 1, 
					index2 + 1);
		}
		//Both the other condition one of the two is not selected
		return Math.max( largestCommonSubSequenceRecursion(string1, string2, index1 + 1, index2),
				largestCommonSubSequenceRecursion(string1, string2, index1, index2 + 1) );
	}

	private static void printTable(int[][] table) {

		System.out.println("============================");
		for( int i = 0; i < table.length; i++ ) {

			for( int j = 0; j < table[ i ].length; j++ ) {
				System.out.print( table[ i ][ j ] + " " );
			}
			System.out.println();
		}
	}
}
