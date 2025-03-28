package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class RobotGridNodeBFS {
	private int row;
	private int col;
	private Set< RobotGridNodeBFS > parents = new HashSet<>();
	
	public RobotGridNodeBFS(int row, int col) {
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
	
	public Set<RobotGridNodeBFS> getParents() {
		return parents;
	}
	
	public void setParents(Set<RobotGridNodeBFS> parents) {
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
		RobotGridNodeBFS other = (RobotGridNodeBFS) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RobotGridNode [row=" + row + ", col=" + col + "]";
	}
}
 
public class RobotInAGridBFS {

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
		HashMap< String, RobotGridNodeBFS > visitedNode = new HashMap<>();
		solveGridPath( maze, startPointRow, startPointCol, 
				endPointRow, endPointCol, visitedNode );	
		RobotGridNodeBFS endNode = visitedNode.get( "[" + endPointRow + ", " + endPointCol + "]" );
		printPaths(endNode, "");
	}

	private static void solveGridPath(int[][] maze, int startPointRow, int startPointCol, int endPointRow,
			int endPointCol, HashMap<String, RobotGridNodeBFS> visitedNode) {
		Queue< RobotGridNodeBFS > unSetteled = new LinkedList<>();
		RobotGridNodeBFS root = new RobotGridNodeBFS( startPointRow, startPointCol );
		unSetteled.add( root );
		
		while( !unSetteled.isEmpty() ) {
			RobotGridNodeBFS node = unSetteled.poll();
			String key = "[" + node.getRow() + ", " + node.getCol() + "]";
			int nextPosRow = node.getRow() + 1;
			int nextPosCol = node.getCol() + 1;
			
			RobotGridNodeBFS nextNodeRight = new RobotGridNodeBFS( node.getRow(), nextPosCol );
			boolean validFlag = checkValidPosition( nextNodeRight, maze, visitedNode );
			processInVisitedOrInUnSetteled( nextNodeRight, node,  visitedNode, unSetteled, 
					validFlag );			
			RobotGridNodeBFS nextNodeDown = new RobotGridNodeBFS( nextPosRow, node.getCol() );
			validFlag = checkValidPosition( nextNodeDown, maze, visitedNode );
			processInVisitedOrInUnSetteled( nextNodeDown, node,  visitedNode, unSetteled, 
					validFlag );
			visitedNode.put( key , node );
		}
	}

	private static void processInVisitedOrInUnSetteled(RobotGridNodeBFS node,
			RobotGridNodeBFS parentNode, HashMap<String, RobotGridNodeBFS> visitedNode, Queue<RobotGridNodeBFS> unSetteled, 
			boolean validFlag) {
		
		if( !validFlag ) {
			String key = "[" + node.getRow() + ", " + node.getCol() + "]";
			visitedNode.put( key , node);
		} else {
			
			if( !unSetteled.contains( node ) ) {
				node.getParents().add( parentNode );
				unSetteled.add( node );
			} else {
				
				for( RobotGridNodeBFS temp : unSetteled ) {
					
					if( temp.getCol() == node.getCol() && 
							temp.getRow() == node.getRow() ) {
						temp.getParents().add( parentNode );
						break;
					}
				}
			}
		}		
	}

	private static boolean checkValidPosition(RobotGridNodeBFS node, int[][] maze,
			HashMap<String, RobotGridNodeBFS> visitedNode ) {
		boolean validFlag = false;
		int maxRows = maze.length;
		int maxCols = maze[ 0 ].length;
		String key = "[" + node.getRow() + "," + node.getCol() + "]";
		
		if( node.getRow() < maxRows && node.getCol() < maxCols && 
				maze[ node.getRow() ][ node.getCol() ] != 0 && visitedNode.get(key) == null ) {
			validFlag = true;
		}
		return validFlag;
	}

	private static void printPaths(RobotGridNodeBFS endNode, String endPath) {
		Set< RobotGridNodeBFS > parentNodes = endNode.getParents();
		String currentString = "[" + endNode.getRow() + ", "+ endNode.getCol() + "]";

		if( !parentNodes.isEmpty() ) {			
			Iterator< RobotGridNodeBFS > iter = parentNodes.iterator();
			
			while( iter.hasNext() ) {
				 printPaths(iter.next(),  currentString + endPath );
			}
		} else {
			System.out.println( currentString + "," + endPath  );
		}		
	}
}
