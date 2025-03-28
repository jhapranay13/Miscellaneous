package elementsOfProgramming.Graphs;

import java.util.List;
import java.util.ArrayList;

public class MazePathProblemDFS {

	public static void main(String[] args) {
		int maze[][] = {
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		};
		int startPointRow = 1;
		int startPointCol = 0;
		int endPointRow = 9;
		int endPointCol = 12;
		List< String > paths = new ArrayList<>();
		solveMaze( maze, startPointRow, startPointCol, endPointRow, endPointCol, paths, "" );	

		for( String path : paths ) {
			System.out.println( path );
		}
	}

	private static boolean solveMaze(int[][] maze, int startPointRow, int startPointCol, 
			int endPointRow, int endPointCol, List<String> paths, String initPath) {
		String path = "[" + startPointRow + ", " + startPointCol + "]";
		boolean solvedFlag = false;

		if( isValidPath( maze, startPointRow, startPointCol ) ) {

			if( startPointRow == endPointRow && startPointCol == endPointCol ) {
				paths.add( initPath + "->" + path );
				return true;
			}
			int validMoves[][] = calculateNextValidMoves( maze, startPointRow, startPointCol );

			for( int i = 0; i < 2; i++ ) {

				if( validMoves[ i ] == null ) {
					continue;
				}
				solvedFlag = solveMaze(maze, validMoves[ i ][ 0 ], validMoves[ i ][ 1 ], 
						endPointRow, endPointCol, paths, initPath + "->" + path);
			}
		}
		return solvedFlag;
	}

	private static int[][] calculateNextValidMoves( int[][] maze, int startPointRow, int startPointCol ) {
		int nextValidMoves[][] = new int[ 2 ][ 2 ];
		int nextStartRow = startPointRow + 1;

		if( isValidPath(maze, nextStartRow, startPointCol) && 
				maze[ nextStartRow ][ startPointCol ] != 0  ) {
			nextValidMoves[ 0 ][ 0 ] = nextStartRow;
			nextValidMoves[ 0 ][ 1 ] = startPointCol;
		} else {
			nextValidMoves[ 0 ] = null;
		}
		int nextStartCol = startPointCol + 1;

		if( isValidPath(maze, startPointRow, nextStartCol) && 
				maze[ startPointRow ][ nextStartCol ] != 0  ) {
			nextValidMoves[ 1 ][ 0 ] = startPointRow;
			nextValidMoves[ 1 ][ 1 ] = nextStartCol;
		} else {
			nextValidMoves[ 1 ] = null;
		}
		return nextValidMoves;
	}

	private static boolean isValidPath(int[][] maze, int startPointRow, int startPointCol) {
		int rowMax = maze.length;
		int colMax = maze[ 0 ].length;
		boolean isValid = false;

		if( startPointRow >= 0 && startPointRow < rowMax &&
				startPointCol < colMax) {
			isValid = true;
		}
		return isValid;
	}
}
