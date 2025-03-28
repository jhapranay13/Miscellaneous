package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.Arrays;

public class PaintFillProblemDFS {

	//Similar to MaximumSequence using DFS or BFS
	public static void main(String[] args) {
		//number Represents different Colors
		int arr[][] = {
				{ 1, 1, 2 },
				{ 2, 2, 4 },
				{ 3, 3, 4 },
				{ 3, 3, 4 }
		};
		int row = 1;
		int col = 2;
		int colorToChange = 7;
		int initColor = arr[ row ][ col ];
		paintFillLocation( row, col, arr, initColor, colorToChange );
		
		for( int i = 0; i < arr.length; i++ ) {
			System.out.println( Arrays.toString( arr[ i ] ) );
		}
	}

	private static void paintFillLocation(int row, int col, int[][] arr, int initColor, 
			int colorToChange) {
		if( initColor == colorToChange ) {
			return;
		}
		
		if( row >= arr.length || row < 0 || col >= arr[ 0 ].length || col < 0  ) {
			return;
		}
		
		if( arr[ row ][ col ] != initColor ) {
			return;
		}
		arr[ row ][ col ] = colorToChange;
		paintFillLocation(row + 1, col, arr, initColor, colorToChange);
		paintFillLocation(row - 1, col, arr, initColor, colorToChange);
		paintFillLocation(row, col + 1, arr, initColor, colorToChange);
		paintFillLocation(row, col - 1, arr, initColor, colorToChange);
	}

}
