package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PaintFillProblemBFS {

	public static void main(String[] args) {
		int arr[][] = {
				{ 1, 1, 2 },
				{ 2, 2, 4 },
				{ 3, 3, 4 },
				{ 3, 3, 4 }
		};
		int row = 2;
		int col = 1;
		int colorToChange = 7;
		int initColor = arr[ row ][ col ];
		paintFillLocation( row, col, arr, initColor, colorToChange );
		
		for( int i = 0; i < arr.length; i++ ) {
			System.out.println( Arrays.toString( arr[ i ] ) );
		}
	}

	private static void paintFillLocation(int row, int col, int[][] arr, int initColor, 
			int colorToChange) {
		Queue< String > visited = new LinkedList<>();
		Queue< String > unsetteled = new LinkedList<>();
		String key = row + ", " + col;
		unsetteled.add( key );
		
		while( !unsetteled.isEmpty() ) {
			String[] coOrdinate = unsetteled.poll().split( "," ); 
			int rowNum = Integer.parseInt( coOrdinate[ 0 ].trim() );
			int colNum = Integer.parseInt( coOrdinate[ 1 ].trim() );
			arr[ rowNum ][ colNum ] = colorToChange;
			String currentKey = rowNum + ", " + colNum;
			visited.add( currentKey );
			
			if( (rowNum + 1) < arr.length && arr[ rowNum + 1 ][ col ] == initColor ) {
				String tempKey = (rowNum + 1) + ", " + colNum ;
				
				if( !visited.contains( tempKey ) ) {
					unsetteled.add( tempKey );
				}
			}
			
			if( (rowNum - 1) >= 0 && arr[ rowNum - 1 ][ colNum ] == initColor ) {
				String tempKey = (rowNum - 1) + ", " + colNum ;
				
				if( !visited.contains( tempKey ) ) {
					unsetteled.add( tempKey );
				}
			}
			
			if( (colNum - 1) >= 0 && arr[ rowNum ][ colNum - 1 ] == initColor ) {
				String tempKey = rowNum  + ", " + ( colNum - 1 ) ;
				
				if( !visited.contains( tempKey ) ) {
					unsetteled.add( tempKey );
				}
			}
			
			if( (colNum + 1) < arr[ 0 ].length && arr[ rowNum ][ colNum + 1 ] == initColor ) {
				String tempKey = rowNum + ", " + ( colNum + 1 ) ;
				
				if( !visited.contains( tempKey ) ) {
					unsetteled.add( tempKey );
				}
			}
		}
	}
}
