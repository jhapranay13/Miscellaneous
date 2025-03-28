package elementsOfProgramming.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MaximumSequenceUsingBFS {
	public static void main(String[] args) {
		int arr[][] = {
				{ 3, 7, 7 },
				{ 6, 7, 7 },
				{ 3, 1, 3 }
		};

		Map<String , String> resolvedPoints = new HashMap<>();
		int startRow = 0;
		int startCol = 0;
		findMaxSequence( arr, resolvedPoints, startRow, startCol );
	}

	private static void findMaxSequence(int[][] arr, Map<String, 
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
				breadthFirst( arr, resolvedPoints, i, j, parentValue, seq );
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

	private static void breadthFirst(int[][] arr, Map<String, String> resolvedPoints,
			int startRow, int startCol, int parentValue, StringBuilder seq ) {
		Queue< String > unresolved = new LinkedList<>();
		String unresolvdKey = startRow + ", " + startCol;
		unresolved.add( unresolvdKey );

		while( !unresolved.isEmpty() ) {
			LinkedHashSet< String > convertor = new LinkedHashSet<>( unresolved );
			unresolved.clear();
			unresolved.addAll( convertor );
			// In Order to avoid this you can also use 	unresolved.contains( unresolvdKey )
			String key = unresolved.poll();
			String[] keyParts = key.split(",");
			int start = Integer.parseInt( keyParts[ 0 ].trim() );
			int end = Integer.parseInt( keyParts[ 1 ].trim() );
			int[][] validMoves = calculateNextValidMoves(arr, start, end, resolvedPoints);

			for( int i = 0; i < validMoves.length; i++ ) {

				if( validMoves[ i ] == null  ) {
					continue;
				}
				String chkVisited ="[" + validMoves[ i ][ 0 ] + ", " + validMoves[ i ][ 1 ] + "]";
				
				if( arr[ validMoves[ i ][ 0 ] ][ validMoves[ i ][ 1 ] ] != parentValue ||
						resolvedPoints.containsKey( chkVisited ) ) {
					continue;
				}
				unresolvdKey = validMoves[ i ][ 0 ] + ", " + validMoves[ i ][ 1 ];
				unresolved.add( unresolvdKey );
			}
			String resolvedKey = "[" + start + ", " + end + "]";
			resolvedPoints.put(resolvedKey, resolvedKey);
			seq.append( resolvedKey );
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
