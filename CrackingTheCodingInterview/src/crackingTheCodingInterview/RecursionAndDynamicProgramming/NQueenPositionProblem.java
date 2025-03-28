package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.Arrays;

public class NQueenPositionProblem {

	public static void main(String[] args) {
		int numOfQueensAndBoardSize = 8;
		String[][] board = new String[ numOfQueensAndBoardSize ][ numOfQueensAndBoardSize ];

		for( int i = 0; i < board.length; i++ ) {

			for( int j = 0; j < board[ i ].length; j++ ) {
				board[ i ][ j ] = "*";
			}
		}

		for( int i = 0; i < board.length; i++ ) {
			System.out.println( Arrays.toString( board[ i ] ) );		
		}
		int startRow = 0;
		boolean solvedFlag = solve( numOfQueensAndBoardSize, board, startRow );
		System.out.println( "======================================" );

		if( solvedFlag ) {

			for( int i = 0; i < board.length; i++ ) {
				System.out.println( Arrays.toString( board[ i ] ) );		
			}
		}
	}

	private static boolean solve(int numOfQueensAndBoardSize, String[][] board, int startRow) {

		if( numOfQueensAndBoardSize <= 0 ) {
			return true;
		}

		for( int i = 0; i < board.length; i++ ) {
			boolean validMoveFlag = checkValid( startRow, i, board );

			if( !validMoveFlag ) {
				continue;
			}
			board[ startRow ][ i ] = "Q";
			boolean solveOtherFlag = solve( numOfQueensAndBoardSize - 1, board, startRow + 1 );

			if( solveOtherFlag ) {
				return true;
			} 
			board[ startRow ][ i ] = "*";
		}
		return false;
	}

	private static boolean checkValid(int startRow, int startCol, String[][] board) {

		if( startRow == 0  ) {
			return true;
		} else {
			int colCounter = 0;

			for( int i = 0; i < board.length; i++ ) {

				if( board[ startRow ][ colCounter++ ].trim().equals( "Q" ) ) {
					return false;
				}
			}
			int rowCounter = 0;

			for( int i = 0; i < board.length; i++ ) {

				if( board[ rowCounter++ ][ startCol ].trim().equals( "Q" ) ) {
					return false;
				}
			}
			colCounter = startCol;

			for( int i = startRow; i < board.length; i++ ) {

				if( colCounter == board.length ) {
					break;
				}

				if( board[ i ][ colCounter++ ].trim().equals( "Q" ) ) {
					return false;
				}
			}

			if( startRow > 0 ) {
				colCounter = startCol;

				for( int i = startRow; i >= 0; i-- ) {

					if( colCounter < 0 ) {
						break;
					}

					if( board[ i ][ colCounter-- ].trim().equals( "Q" ) ) {
						return false;
					}
				}
			}
			colCounter = startCol;

			for( int i = startRow; i < board.length; i++ ) {

				if( colCounter < 0 ) {
					break;
				}

				if( board[ i ][ colCounter-- ].trim().equals( "Q" ) ) {
					return false;
				}
			}

			if( startRow > 0 ) {
				colCounter = startCol;

				for( int i = startRow; i >= 0; i-- ) {

					if( colCounter == board.length ) {
						break;
					}

					if( board[ i ][ colCounter++ ].trim().equals( "Q" ) ) {
						return false;
					}
				}
			}

		}
		return true;
	}
}
