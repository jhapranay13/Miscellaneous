package elementsOfProgramming.DynamicProgramming;

public class KnapSackProblem {

	public static void main(String[] args) {
		int [] weight = { 1, 3, 4, 5 };
		int [] value = { 1, 4, 5, 7 };
		//both weight and value should be sorted according to the weight.

		int sackCapacity = 7;
		int maximumValue = knapSackRecursive( weight, value, sackCapacity, weight.length - 1, 0 );
		System.out.println( maximumValue );

		int[][] table = new int[ weight.length ][ sackCapacity + 1];
		maximumValue = knapSackDP( weight, value, sackCapacity, table );
		System.out.println( maximumValue );
		printWhatValuesWillGetSelected( table, weight, value );
	}

	private static void printWhatValuesWillGetSelected(int[][] table, int[] weight, int[] value) {
		
		int row = table.length - 1;
		int col = table[ 0 ].length - 1;
		
		int val = table[ row ][ col ];
		
		while( row != 0 && col != 0 ) {
			
			//check if value is coming from left. If this weight is selected the value
			//will come from left.
			if( val == table[ row ][ col - 1 ] ) {
				col--;
				System.out.println( weight[ row ] + " " + value[ row ] );
			} else {

				if( val == table[ row - 1 ][ col ] ) {
					row--;
				} else {
					//go back that many values to reach next value
					System.out.println( weight[ row ] + " " + value[ row ] );
					
					if( table[ row ][ col ] == table[ row ][ col - 1 ] ) {
						col--;
					} else {
						col = col - weight[ row ];
						row = row - 1;
					}
				}
			}
		}
	}

	private static int knapSackDP(int[] weight, int[] value, int sackCapacity, int[][] table) {

		for( int i = 0; i < weight.length; i++ ) {

			for( int j = 1; j <= sackCapacity; j++ ) {

				if( i == 0 ) {
					table[ i ][ j ] = value[ i ];
				} else {

					if( weight[ i ] > j ) { 
						table[ i ][ j ] = table[ i - 1 ][ j ];
					} else {

						if( weight[ i ] == j ) {
							table[ i ][ j ] = Math.max( table[ i - 1 ][ j ] ,  value[ i ] );
						}
						//Go one row up and jth column back for calculating if this is selected
						if( weight[ i ] < j ) {
							int prevRow = i - 1;
							int prevCol = j - weight[ i ];
							int valueWithoutSelecting = table[ prevRow ][ j ];
							int valueWithSelecting = table[ prevRow ][ prevCol ] +
									value[ i ];
							table[ i ][ j ] = Math.max( valueWithoutSelecting ,
									valueWithSelecting);
						}
					}
				}
			}
			printTable(table);
		}
		return table[ weight.length - 1 ][ sackCapacity ];
	}

	private static int knapSackRecursive(int[] weight, int[] value, int sackCapacity, 
			int startIndex, int currentValue ) {

		if( startIndex < 0 || sackCapacity <= 0) {
			return currentValue;
		}

		int maximumIfSelected = -1;
		//If the Current Value is selected.
		//If 1. e five is picked or not So on and so forth.
		if( sackCapacity >= weight[ startIndex ] ) {

			maximumIfSelected = knapSackRecursive(weight, value, 
					sackCapacity - weight[ startIndex ], 
					startIndex - 1, currentValue + value[ startIndex ] );
		}
		int maximumIfNotSelected = knapSackRecursive(weight, value, 
				sackCapacity, 
				startIndex - 1, currentValue );
		return Math.max( maximumIfNotSelected , maximumIfSelected);
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
