package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RobotInAGridDFS {

	public static void main(String[] args) {
		int maze[][] = {
				{ 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
		};
		int startPointRow = 0;
		int startPointCol = 0;
		int endPointRow = 9;
		int endPointCol = 12;
		List< String > paths = new ArrayList<>();
		HashMap< String, String > visitedNode = new HashMap<>();
		String pathStr = "";
		boolean solvedFlag = solveGridPath( maze, startPointRow, startPointCol, 
				endPointRow, endPointCol, paths, visitedNode, pathStr );	
		
		for( String path : paths ) {
			System.out.println( path );
		}
	}

	private static boolean solveGridPath(int[][] maze, int startPointRow, int startPointCol, int endPointRow,
			int endPointCol, List<String> paths, HashMap<String, String> visitedNode,
			String pathStr) {
		
		if( startPointCol == endPointCol && startPointRow == endPointRow ) {
			pathStr += "[" + startPointRow + ", " + startPointCol + "]";
			paths.add( pathStr );
			return true;
		} else {
			pathStr += "[" + startPointRow + ", " + startPointCol + "]";
			int nextRow = startPointRow + 1;
			int nextCol = startPointCol + 1;
			boolean isValidNextRight = isValid( startPointRow , nextCol, visitedNode, maze );
			boolean rightPathFlag = false;
			
			if( isValidNextRight ) {
				rightPathFlag = solveGridPath(maze, startPointRow, nextCol, endPointRow, endPointCol, 
						paths, visitedNode, pathStr);
			}
			boolean isValidNextDown = isValid( nextRow , startPointCol, visitedNode, maze );
			boolean downPathFlag = false;

			if( isValidNextDown ) {
				downPathFlag = solveGridPath(maze, nextRow, startPointCol, endPointRow, endPointCol, 
						paths, visitedNode, pathStr);
			}
			return rightPathFlag || downPathFlag;
		}
	}

	private static boolean isValid(int row, int col, HashMap<String, String> visitedNode,
			int[][] maze) {
		boolean validFlag = false;
		String key = "[" + row + "," + col + "]";
		
		if( row < maze.length && col < maze[ 0 ].length && maze[ row ][ col ] != 0 && 
				visitedNode.get(key) == null ) {
			validFlag = true;
		} else {
			visitedNode.put( key, key );
		}
		return validFlag;
	}
}
