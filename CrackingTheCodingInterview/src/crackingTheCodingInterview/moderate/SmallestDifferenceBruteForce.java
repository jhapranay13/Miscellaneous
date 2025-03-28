package crackingTheCodingInterview.moderate;

public class SmallestDifferenceBruteForce {

	public static void main(String[] args) {
		int [] firstArr = { 1, 3, 15, 11, 2 };
		int [] secondArr = {23, 127, 235, 19, 8};
		int [] result = new int[2];
		int minimum = getMinimumDifference( firstArr, secondArr, result );
		System.out.println( minimum + " for values " + result[ 0 ] + ", " + result[ 1 ]  );
	}

	private static int getMinimumDifference(int[] firstArr, int[] secondArr, int[] result) {
		int minimum = Integer.MAX_VALUE;
		
		for( int i = 0; i < firstArr.length; i++ ) {
			
			for( int j = 0; j < secondArr.length; j++ ) {
				int tempResult = Math.abs( firstArr[ i ] - secondArr[ j ] );
				
				if( tempResult < minimum ) {
					minimum = tempResult;
					result[ 0 ] = firstArr[ i ];
					result[ 1 ] = secondArr[ j ];
				}
			}
		}
		return minimum;
	}

}
