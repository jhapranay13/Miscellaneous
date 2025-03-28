package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueenPositionProblemAllSolution {

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
		ArrayList< String[][] > result = new ArrayList<>();
		boolean solvedFlag = solve( numOfQueensAndBoardSize, board, startRow, result );
		System.out.println( "======================================" );

		if( solvedFlag ) {
			
			for( String[][] solvedBoard : result ) {

				for( int i = 0; i < board.length; i++ ) {
					System.out.println( Arrays.toString( solvedBoard[ i ] ) );	
				}
				System.out.println( "==========================================" );		
			}
		}
	}

	private static boolean solve(int numOfQueensAndBoardSize, String[][] board, int startRow, 
			ArrayList<String[][]> result) {

		if( numOfQueensAndBoardSize <= 0 ) {
			String temp[][] = new String[ board.length ][ board.length ];
			
			for( int i = 0; i < board.length; i++ ) {
			
				for( int j = 0; j < board.length; j++ ) {
					temp[ i ][ j ] = board[ i ][ j ];
				}
			}
			result.add( temp );
			return true;
		}
		boolean returnFlag = false;

		for( int i = 0; i < board.length; i++ ) {
			boolean validMoveFlag = checkValid( startRow, i, board );

			if( !validMoveFlag ) {
				continue;
			}
			board[ startRow ][ i ] = "Q";
			boolean solveOtherFlag = solve( numOfQueensAndBoardSize - 1, board, startRow + 1, result );

			if( solveOtherFlag ) {
				returnFlag = true;
			} 
			board[ startRow ][ i ] = "*";
		}
		return returnFlag;
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
