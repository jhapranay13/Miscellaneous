package elementsOfProgramming.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class MazeNodeBFS {
	private int row;
	private int col;
	private Set< MazeNodeBFS > parents = new HashSet<>();
	
	public MazeNodeBFS(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	public Set<MazeNodeBFS> getParents() {
		return parents;
	}
	
	public void setParents(Set<MazeNodeBFS> parents) {
		this.parents = parents;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MazeNodeBFS other = (MazeNodeBFS) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MazeNodeBFS [row=" + row + ", col=" + col + "]";
	}
}

public class MazePathProblemBFS {

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
		HashMap< String, MazeNodeBFS > visitedNode = new HashMap<>();
		solveMaze( maze, startPointRow, startPointCol, endPointRow, endPointCol, paths, visitedNode );	
		MazeNodeBFS endNode = visitedNode.get( endPointRow + "," + endPointCol );
		printPaths(endNode, "");
	}
	
	private static void printPaths(MazeNodeBFS endNode, String endPath) {
		Set< MazeNodeBFS > parentNodes = endNode.getParents();
		String currentString = "[" + endNode.getRow() + ", "+ endNode.getCol() + "]";

		if( !parentNodes.isEmpty() ) {			
			Iterator<MazeNodeBFS> iter = parentNodes.iterator();
			
			while( iter.hasNext() ) {
				 printPaths(iter.next(),  currentString + endPath );
			}
		} else {
			System.out.println( currentString + "," + endPath  );
		}
			
	}

	private static void solveMaze(int[][] maze, int startPointRow, int startPointCol, int endPointRow, int endPointCol,
			List<String> paths, HashMap<String, MazeNodeBFS> visitedNode) {
		
		if( isValidPath( maze, startPointRow, startPointCol ) ) {
			MazeNodeBFS mazeStartNode = new MazeNodeBFS( startPointRow, startPointCol );
			List< MazeNodeBFS > unsetteled = new LinkedList<>();
			unsetteled.add( mazeStartNode );
			
			while( !unsetteled.isEmpty() ) {
				MazeNodeBFS currentNode = unsetteled.remove( 0 );
				/*if( currentNode.getRow() == endPointRow && currentNode.getCol() == endPointCol ) {
					visitedNode.put( currentNode.getRow() + "," + currentNode.getCol() , currentNode );
					return;
				}*/
				int[][] nextValidMoves = calculateNextValidMoves( maze, currentNode.getRow(), 
						currentNode.getCol() );
				
				for( int i = 0; i < 2; i++ ) {
					
					if( nextValidMoves[ i ] == null ) {
						continue;
					}
					MazeNodeBFS nextNode = visitedNode.get( nextValidMoves[ i ][ 0 ] +"," + 
							nextValidMoves[ i ][ 1 ] );
					
					if( nextNode == null ) {
						nextNode = new MazeNodeBFS( nextValidMoves[ i ][ 0 ], 
							nextValidMoves[ i ][ 1 ] );
					}	
					nextNode.getParents().add( currentNode );
					unsetteled.add( nextNode );
				}
				MazeNodeBFS tempVisitNode = visitedNode.get( currentNode.getRow() + "," + currentNode.getCol() );
				
				if( tempVisitNode != null ) {
					currentNode.getParents().addAll( tempVisitNode.getParents());
					visitedNode.put( currentNode.getRow() + "," + currentNode.getCol() , currentNode );
				} else {
					visitedNode.put( currentNode.getRow() + "," + currentNode.getCol() , currentNode );
				}
			}
		}
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
