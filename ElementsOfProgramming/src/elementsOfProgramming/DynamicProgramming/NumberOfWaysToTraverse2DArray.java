package elementsOfProgramming.DynamicProgramming;

public class NumberOfWaysToTraverse2DArray {

	public static void main(String[] args) {
		int boardSize = 5;
		int board[][] = new int[ boardSize ][ boardSize ];
		int result = numberOfWaysIfWeGoRightAndLeftOnlyDP( board );
		//System.out.println( result );
		//int result = numberOfWaysIfWeGoRightAndLeftOnlyRecursive( board, board.length - 1, 
		//		board.length - 1 );
		System.out.println( result );
	}

	//bottom up approach.mostly used in all recursions.
	private static int numberOfWaysIfWeGoRightAndLeftOnlyRecursive(int[][] board,
			int index1, int index2) {
		
		if( index1 == 0 || index2 == 0 ) {
			return 1;
		}
		return numberOfWaysIfWeGoRightAndLeftOnlyRecursive(board, index1 - 1 , index2) +
				numberOfWaysIfWeGoRightAndLeftOnlyRecursive(board, index1, index2 - 1 );
	}

	//The Logic is the numberOf ways To get to its immediate left + number of ways to get to its 
	//immediate top
	private static int numberOfWaysIfWeGoRightAndLeftOnlyDP(int[][] board) {
		int i = 0;
		int j = 0;
		
		for( ; i < board.length; i++ ) {
			
			for( ; j < board[ i ].length; j++ ) {
				
				if( i == 0 || j == 0 ) {
					board[ i ][ j ] = 1;
					//since one move will take it out of the board
				} else {
					board[ i ][ j ] = board[ i - 1 ][ j ] + board[ i ][ j - 1 ];
				}
			}
			printTable(board);
			j = 0;
		}

		return board[ i - 1 ][ i - 1 ];
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
