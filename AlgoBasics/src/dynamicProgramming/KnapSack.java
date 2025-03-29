package dynamicProgramming;

public class KnapSack {

	public static void main(String[] args) {
		int value[] = { 4, 14, 10, 5 };
		int weight[] = { 3, 7, 10, 6 };
		int sackCapacity = 20;
		int maximumVal = knapSackRecurr( value, weight, sackCapacity, weight.length - 1 );
		System.out.println( maximumVal );

		maximumVal = knapSackMemo( value, weight, sackCapacity );
		System.out.println( maximumVal );

		maximumVal = knapSackDP( value, weight, sackCapacity );
		System.out.println( maximumVal );
	}

	private static int knapSackRecurr(int[] value, int[] weight, int sackCapacity,
			int index) {

		if( index < 0 || sackCapacity < 0 ) {
			return 0;
		}

		if( weight[ index ] <= sackCapacity ) {
			int include = value[ index ] + knapSackRecurr(value, weight, 
					sackCapacity - weight[ index ], 
					index - 1 );
			int exclude = knapSackRecurr(value, weight, sackCapacity, index - 1 );
			return Math.max( include , exclude );
		} else {
			return knapSackRecurr(value, weight, sackCapacity, index - 1);
		}
	}


	private static int knapSackMemo(int[] value, int[] weight, int sackCapacity) {
		int[][] memo = new int[ weight.length + 1 ][ sackCapacity + 1 ];
		int result = knapSackMemo(value, weight, sackCapacity, weight.length, memo);
		return result;
	}

	private static int knapSackMemo(int[] value, int[] weight, int sackCapacity, 
			int index, int[][] memo) {

		if( index <= 0 || sackCapacity < 0 ) {
			return 0;
		}

		if( weight[ index - 1 ] <= sackCapacity ) {
			int include = value[ index - 1 ] + knapSackMemo(value, weight, 
					sackCapacity - weight[ index - 1 ], 
					index - 1, memo );
			int exclude = knapSackMemo(value, weight, sackCapacity, index - 1, memo );
			memo[ index ][ sackCapacity ] =  Math.max( include , exclude );
		} else {
			memo[ index ][ sackCapacity ] = 
					knapSackMemo(value, weight, sackCapacity, index - 1, memo );
		}
		return memo[ index ][ sackCapacity ];
	}

	private static int knapSackDP(int[] value, int[] weight, int sackCapacity) {
		int memo[][] = new int[ weight.length + 1 ][ sackCapacity + 1 ];
		boolean selected[][] = new boolean[ weight.length + 1 ][ sackCapacity + 1 ];

		for( int i = 1; i <= weight.length; i++ ) {

			for( int j = 1; j <= sackCapacity; j++ ) {

				if( weight[ i - 1 ] <= j ) {
					int capacity = j - weight[ i - 1 ];
					int include = value[ i - 1 ] + memo[ i - 1 ][capacity];
					int exclude = memo[ i - 1 ][ j ];
					memo[ i ][ j ] =  Math.max( include , exclude );

					if( include > exclude ) {
						selected[ i ][ j ] = true;
					}
				} else {
					memo[ i ][ j ] = memo[ i - 1 ][ sackCapacity ];
				}
			}
		}
		decipherSelected( selected, weight, value, sackCapacity );
		return memo[ weight.length ][ sackCapacity ];
	}

	private static void decipherSelected(boolean[][] selected, int[] weight, 
			int[] value, int sackCapacity) {

		int row = weight.length;
		int col = sackCapacity;
		
		while( row > 0 && col > 0 ) {
			
			if( selected[ row ][ col ] ) {
				System.out.println( "Selected weight >> " + weight[ row - 1 ] + 
					 " Value >> " + value[ row - 1 ] );
				
				col -= weight[ row - 1 ];
				row--;
			} else {
				row--;
			}
		}
	}
}
