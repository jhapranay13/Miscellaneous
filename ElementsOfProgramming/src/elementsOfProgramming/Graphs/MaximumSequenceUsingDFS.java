package elementsOfProgramming.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumSequenceUsingDFS {

	public static void main(String[] args) {
		int arr[][] = {
				{ 1, 1, 2 },
				{ 1, 2, 3 },
				{ 3, 3, 3 }
		};
		
		StringBuilder maxSequence = new StringBuilder();
		Map<String , String> resolvedPoints = new HashMap<>();
		int startRow = 0;
		int startCol = 0;
		findMaxSequence( arr, maxSequence, resolvedPoints, startRow, startCol );
	}

	private static void findMaxSequence(int[][] arr, StringBuilder maxSequence, Map<String, 
			String> resolvedPoints, int startRow, int startCol) {
		
		List< String > sequence = new ArrayList<>();
		
		for( int i = 0; i < arr.length; i++ ) {
			
			for( int j = 0; j < arr[ i ].length; j++ ) {
				int parentValue = arr[ i ][ j ];
				String key = "["+ i + ", " + j + "]";
				
				if( resolvedPoints.containsKey( key ) ) {
					continue;
				}
				StringBuilder seq = new StringBuilder();
				depthFirst( arr, maxSequence, resolvedPoints, i, j, parentValue, seq );
				sequence.add( seq.toString() );
			}
		}
		
		int max = 0;
		int maxIndex = 0;
		int maxCounter = 0;
		
		for( String string : sequence  ) {
			String[] split = string.split("\\]\\[");
			
			if( split.length > max ) {
				max = split.length;
				maxIndex = maxCounter;
			}
			maxCounter++;
		}
		System.out.println( "MAX Size >> " + max );
		System.out.println( "MAX Sequence >> " + sequence.get( maxIndex ) );
	}

	private static void depthFirst(int[][] arr, StringBuilder maxSequence, Map<String, String> resolvedPoints,
			int startRow, int startCol, int parentValue, StringBuilder seq ) {
		
		if( parentValue != arr[ startRow ][ startCol ] ) {
			return;
		}
		int[][] validMoves = calculateNextValidMoves(arr, startRow, startCol, resolvedPoints);
		String keyVal = "[" + startRow + ", " + startCol + "]";
		resolvedPoints.put( keyVal , keyVal);
		
		for( int i = 0; i < 4; i++ ) {
			int [] tempMove = validMoves[ i ];
			
			if( i == 0 ) {
				seq.append( keyVal );
			}
			
			if( tempMove == null ) {
				continue;
			} 
			parentValue = arr[ startRow ][  startCol  ];
			depthFirst(arr, maxSequence, resolvedPoints, tempMove[ 0 ], tempMove[ 1 ],
					parentValue, seq);
		}
	}
	
	private static int[][] calculateNextValidMoves( int[][] arr, int startRow, int startCol, Map<String, 
			String> resolvedPoints ) {
		int nextValidMoves[][] = new int[ 4 ][ 2 ];
		int nextRow = startRow + 1;
		int nextCol = startCol + 1;
		int previousRow = startRow - 1;
		int previousCol = startCol - 1;
		
		if( previousRow >= 0 ) {
			int[] temp = new int[ 2 ];
			temp[ 0 ] = previousRow;
			temp[ 1 ] = startCol;
			String tempKey = "[" + temp[ 0 ] + ", " + temp[ 1 ] + "]";

			if( !resolvedPoints.containsKey(tempKey) ) {
				nextValidMoves[ 0 ] = temp;
			} else {
				nextValidMoves[ 0 ] = null;
			}
		} else {
			nextValidMoves[ 0 ] = null;
		}
		
		if( previousCol >= 0 ) {
			int[] temp = new int[ 2 ];
			temp[ 0 ] = startRow;
			temp[ 1 ] = previousCol;
			String tempKey = "[" + temp[ 0 ] + ", " + temp[ 1 ] + "]";

			if( !resolvedPoints.containsKey(tempKey) ) {
				nextValidMoves[ 1 ] = temp;
			} else {
				nextValidMoves[ 1 ] = null;
			}
		} else {
			nextValidMoves[ 1 ] = null;
		}
		
		if( nextCol < arr[ 0 ].length ) {
			int[] temp = new int[ 2 ];
			temp[ 0 ] = startRow;
			temp[ 1 ] = nextCol;
			String tempKey = "[" + temp[ 0 ] + ", " + temp[ 1 ] + "]";

			if( !resolvedPoints.containsKey(tempKey) ) {
				nextValidMoves[ 2 ] = temp;
			} else {
				nextValidMoves[ 2 ] = null;
			}
		} else {
			nextValidMoves[ 2 ] = null;
		}
		
		if( nextRow < arr.length ) {
			int[] temp = new int[ 2 ];
			temp[ 0 ] = nextRow;
			temp[ 1 ] = startCol;
			String tempKey = "[" + temp[ 0 ] + ", " + temp[ 1 ] + "]";

			if( !resolvedPoints.containsKey(tempKey) ) {
				nextValidMoves[ 3 ] = temp;
			} else {
				nextValidMoves[ 3 ] = null;
			}
		} else {
			nextValidMoves[ 3 ] = null;
		}
		return nextValidMoves;
	}
}
