package dynamicProgramming;

public class NQueenRecur {

	public static void main(String[] args) {
		int numberOfQueens = 5;
		int[] board = new int[ numberOfQueens ];

		if( solveNQueenRecur( board, 0 ) ) {
			System.out.println( "SOLVED" );
		}
	}

	private static boolean solveNQueenRecur( int[] board, int start ) {

		if( board.length == start ) {

			for( int i = 0; i < board.length; i++ ) {

				for( int j = 0; j < board.length; j++ ) {

					if( j == board[ i ] ) {
						System.out.print( "X" );
					} else {
						System.out.print( "O" );
					}
				}
				System.out.println();
			}
			return true;
		}

		for( int i = 0; i < board.length; i++ ) {
			boolean validFlag = true;

			for( int j = start - 1; j >= 0; j-- ) {

				if( board[ j ] == i || 
						Math.abs( board[ j ] - i ) == start - j ) {
					validFlag = false;
					break;
				}
			}

			if( !validFlag ) {
				continue;
			}
			board[ start ] = i;

			if( solveNQueenRecur( board, start + 1 ) ) {
				return true;
			}
		}
		return false;
	}
}
