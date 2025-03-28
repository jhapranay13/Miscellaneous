package elementsOfProgramming.Arrays;

import java.util.HashSet;
import java.util.Set;

public class PartialSudokuChecker {

	public static void main(String[] args) {
		int board[][] = {
				{ 5, 3, 0, 0, 7, 0, 0, 0, 0 },
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 },
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 },
				{ 4, 0, 0, 8, 0, 3, 0, 0, 1 },
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 },
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 },
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 }
		};

		boolean isValidFlag = isValidSudokuPartial( board );
		System.out.println( isValidFlag );
	}

	private static boolean isValidSudokuPartial(int[][] board) {

		for( int row = 0; row < board.length; row++ ) {
			Set< Integer > holder = new HashSet<>();

			for( int col = 0; col < board[ row ].length; col++ ) {
				int tempVal = board[ row ][ col ];

				if( tempVal > 0 ) {

					if( holder.contains( tempVal ) ) {
						return false;
					} else {
						holder.add( tempVal );
					}
				}
			}
		}

		for( int col = 0; col < board.length; col++ ) {
			Set< Integer > holder = new HashSet<>();

			for( int row = 0; row < board.length; row++ ) {
				int tempVal = board[ row ][ col ];

				if( tempVal > 0 ) {

					if( holder.contains( tempVal ) ) {
						return false;
					} else {
						holder.add( tempVal );
					}
				}
			}
		}
		int startRow = 0;
		int startCol = 0;
		int endRow = 2;
		int endCol = 2;
		Set< Integer > holder = new HashSet<>();
		
		for( int row = startRow; row <= endRow && row < board.length; row++ ) {
			int col = startCol;
					
			for( ; col <= endCol; col++ ) {
				int tempVal = board[ row ][ col ];

				if( tempVal > 0 ) {

					if( holder.contains( tempVal ) ) {
						return false;
					} else {
						holder.add( tempVal );
					}
				}
			}
			
			if( row == endRow && col == endCol ) {
				row += 3;
				col += 3;
				endRow += 3;
				endCol += 3;
			}
		}


		return true;
	}

}
