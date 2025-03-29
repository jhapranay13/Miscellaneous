package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 *  Manhattan Distance –
It is nothing but the sum of absolute values of differences in the goal’s x and y coordinates and the current cell’s x and y coordinates respectively, i.e.,
 h = abs (current_cell.x – goal.x) + 
     abs (current_cell.y – goal.y) 
When to use this heuristic? – When we are allowed to move only in four directions only (right, left, top, bottom)

Diagonal Distance-
It is nothing but the maximum of absolute values of differences in the goal’s x and y coordinates and the current cell’s x and y coordinates respectively, i.e.,
 h = max { abs(current_cell.x – goal.x),
           abs(current_cell.y – goal.y) } 
When to use this heuristic? – When we are allowed to move in eight directions only (similar to a move of a King in Chess)

 Euclidean Distance-
As it is clear from its name, it is nothing but the distance between the current cell and the goal cell using the distance formula
 h = sqrt ( (current_cell.x – goal.x)2 + 
            (current_cell.y – goal.y)2 ) 
When to use this heuristic? – When we are allowed to move in any directions.
 */

class NodeCS {
	private int row;
	private int col;
	private List< NodeCS > parents = new ArrayList<>();
	private int hueristicValueFromDestination;
	private int hueristicValueFromSource;
	private int hueristicValue;

	public NodeCS(int row, int col, int hueristicValue) {
		super();
		this.row = row;
		this.col = col;
		this.hueristicValue = hueristicValue;
	}
	
	public int getHueristicValueFromDestination() {
		return hueristicValueFromDestination;
	}

	public void setHueristicValueFromDestination(int hueristicValueFromDestination) {
		this.hueristicValueFromDestination = hueristicValueFromDestination;
	}

	public int getHueristicValueFromSource() {
		return hueristicValueFromSource;
	}

	public void setHueristicValueFromSource(int hueristicValueFromParent) {
		this.hueristicValueFromSource = hueristicValueFromParent;
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

	public List<NodeCS> getParents() {
		return parents;
	}

	public void setParents(List<NodeCS> parents) {
		this.parents = parents;
	}

	public int getHueristicValue() {
		return hueristicValue;
	}

	public void setHueristicValue(int hueristicValue) {
		this.hueristicValue = hueristicValue;
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
		NodeCS other = (NodeCS) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NodeCS [row=" + row + ", col=" + col + "]";
	}
}

public class AStarByQueenTravelingProblem {

	public static void main(String[] args) {
		int chessBoard[][] = {
				{ 2, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 0, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 0 },
				{ 0, 1, 0, 0, 0, 0, 3, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 1 }				
		};
		int startRow = 0;
		int startCol = 0;
		int endRow = 6;
		int endCol = 6;
		Map< String, NodeCS > visited = new HashMap<>();
		calculateShortestPath( chessBoard, startRow, startCol, endCol, endRow, visited );
		String endKey = endRow + "," + endCol;
		NodeCS endNode = visited.get( endKey );
		printPath( endNode, "", chessBoard );
		System.out.println( "" );
		
		for( int i = 0; i < chessBoard.length; i++ ) {
			
			for( int j = 0; j < chessBoard[ i ].length; j++ ) {
				
				if( j > 0 ) {
					System.out.print( ", ");
				}
				System.out.print( chessBoard[ i ][ j ] );
			}
			System.out.println( "" );
		}
	}

	private static void printPath(NodeCS endNode, String endPath, int chessBoard[][]) {
		
		if( endNode != null ) {
			
			List<NodeCS> parents = endNode.getParents();
			String currentPath = "[" +endNode.getRow() + ", " + endNode.getCol() + "]";
			chessBoard[ endNode.getRow() ][ endNode.getCol() ] = 7;
			
			if( !parents.isEmpty() ) {
				printPath( parents.get( 0 ), currentPath + endPath, chessBoard );
			}
			System.out.print( currentPath );
		}
	}

	private static void calculateShortestPath(int[][] chessBoard, int startRow, int startCol, 
			int endCol, int endRow, Map<String, NodeCS> visited) {
		NodeCS startNode = new NodeCS(startRow, startCol, 0);
		List< NodeCS > unsetteledQueue = new LinkedList<>();
		unsetteledQueue.add(startNode);
		Map< String, NodeCS > unsetteledHelper = new HashMap<>();
		unsetteledHelper.put(startNode.getRow() + "," + startNode.getCol(), startNode);

		while( !unsetteledQueue.isEmpty() ) {
			int currentIndex = getMinimumHuresticValueNodeIndex( unsetteledQueue );
			NodeCS currentNode = unsetteledQueue.get( currentIndex );

			if( currentNode.getRow() == endRow && currentNode.getCol() == endCol ) {
				String key = currentNode.getRow() + "," + currentNode.getCol();
				visited.put( key, currentNode );
				break;
			}
			List< NodeCS > nextMoves = calculateNextMovesAndAddHuresticValue( chessBoard, currentNode, 
					startRow, startCol, endRow, endCol );
			
			if( !nextMoves.isEmpty() ) {
				
				for( NodeCS unsetteledNode : nextMoves ) {
					String key = unsetteledNode.getRow() + "," + unsetteledNode.getCol();
					NodeCS temp = visited.get( key );
					
					if( temp != null ) {
						/*NodeCS parent = unsetteledNode.getParents().get(0);
						
						if( parent.getHueristicValueFromSource() > currentNode.getHueristicValueFromSource() ) {
							temp.getParents().remove(0);
							temp.getParents().add(currentNode);
						}*/
						continue;
					}	
					temp = unsetteledHelper.get(key); 
					
					if( temp != null ) {
						NodeCS parent = unsetteledNode.getParents().get(0);
						
						if( parent.getHueristicValueFromSource() > currentNode.getHueristicValueFromSource() ) {
							temp.getParents().remove(0);
							temp.getParents().add(currentNode);
						}
						continue;
					}					
					unsetteledQueue.add( unsetteledNode );
					unsetteledHelper.put( key, unsetteledNode );
				}
			}
			unsetteledQueue.remove( currentNode );
			unsetteledHelper.remove( currentNode.getRow() + "," + currentNode.getCol() );
			String key = currentNode.getRow() + "," + currentNode.getCol();
			visited.put( key, currentNode );
		}
	}

	private static List< NodeCS > calculateNextMovesAndAddHuresticValue(int[][] chessBoard, 
			NodeCS currentNode, int startRow, int startCol, int endRow, int endCol) {
		List< NodeCS > nextMoves = new LinkedList<>();		
		NodeCS move = null;
		int nextRow = currentNode.getRow() + 1;
		int previousRow = currentNode.getRow() - 1;
		int nextCol = currentNode.getCol() + 1;
		int previousCol = currentNode.getCol() - 1;

		if( isValid( chessBoard, nextRow, currentNode.getCol() ) && 
				chessBoard[ nextRow ][ currentNode.getCol() ] != 1 ) {
			int huresticValueDestination = calculateHueristicDiagnolMethod( nextRow, currentNode.getCol(),
					endRow, endCol);
			int huresticValueSource = calculateHueristicDiagnolMethod( startRow, 
					startCol, nextRow, currentNode.getCol());
			int hueristic = huresticValueDestination + huresticValueSource;
			move = new NodeCS(nextRow, currentNode.getCol(), hueristic );
			move.setHueristicValueFromDestination( huresticValueDestination );
			move.setHueristicValueFromSource( huresticValueSource );
			move.getParents().add( currentNode );
			nextMoves.add(move);
		}

		if( isValid( chessBoard, previousRow, currentNode.getCol() ) && 
				chessBoard[ previousRow ][ currentNode.getCol() ] != 1 ) {
			int huresticValueDestination = calculateHueristicDiagnolMethod( previousRow, currentNode.getCol(),
					endRow, endCol);
			int huresticValueSource = calculateHueristicDiagnolMethod( startRow, 
					startCol, previousRow, currentNode.getCol());
			int hueristic = huresticValueDestination + huresticValueSource;
			move = new NodeCS(previousRow, currentNode.getCol(), hueristic );
			move.setHueristicValueFromDestination( huresticValueDestination );
			move.setHueristicValueFromSource( huresticValueSource );
			move.getParents().add(currentNode);
			nextMoves.add(move);
		}

		if( isValid( chessBoard, nextRow, previousCol ) && 
				chessBoard[ nextRow ][ previousCol ] != 1 ) {
			int huresticValueDestination = calculateHueristicDiagnolMethod( nextRow, previousCol,
					endRow, endCol);
			int huresticValueSource = calculateHueristicDiagnolMethod( startRow, 
					startCol, nextRow, previousCol);
			int hueristic = huresticValueDestination + huresticValueSource;
			move = new NodeCS(nextRow, previousCol, hueristic );
			move.setHueristicValueFromDestination( huresticValueDestination );
			move.setHueristicValueFromSource( huresticValueSource );
			move.getParents().add( currentNode );
			nextMoves.add(move);
		}

		if( isValid( chessBoard, previousRow, previousCol ) && 
				chessBoard[ previousRow ][ previousCol ] != 1 ) {
			int huresticValueDestination = calculateHueristicDiagnolMethod( previousRow, previousCol,
					endRow, endCol);
			int huresticValueSource = calculateHueristicDiagnolMethod( startRow, 
					startCol, previousRow, previousCol );
			int hueristic = huresticValueDestination + huresticValueSource;
			move = new NodeCS(previousRow, previousCol, hueristic );
			move.setHueristicValueFromDestination( huresticValueDestination );
			move.setHueristicValueFromSource( huresticValueSource );
			move.getParents().add( currentNode );
			nextMoves.add(move);
		}

		if( isValid( chessBoard, currentNode.getRow(), nextCol ) && 
				chessBoard[ currentNode.getRow() ][ nextCol ] != 1 ) {
			int huresticValueDestination = calculateHueristicDiagnolMethod( currentNode.getRow(), nextCol,
					endRow, endCol);
			int huresticValueSource = calculateHueristicDiagnolMethod( startRow, 
					startCol, currentNode.getRow(), nextCol );
			int hueristic = huresticValueDestination + huresticValueSource;
			move = new NodeCS(currentNode.getRow(), nextCol, hueristic );
			move.setHueristicValueFromDestination( huresticValueDestination );
			move.setHueristicValueFromSource( huresticValueSource );
			move.getParents().add( currentNode );
			nextMoves.add(move);
		}

		if( isValid( chessBoard, currentNode.getRow(), previousCol ) && 
				chessBoard[ currentNode.getRow() ][ previousCol ] != 1 ) {
			int huresticValueDestination = calculateHueristicDiagnolMethod( currentNode.getRow(), previousCol,
					endRow, endCol);
			int huresticValueSource = calculateHueristicDiagnolMethod( startRow, 
					startCol, currentNode.getRow(), previousCol);
			int hueristic = huresticValueDestination + huresticValueSource;
			move = new NodeCS(currentNode.getRow(), previousCol, hueristic );
			move.setHueristicValueFromDestination( huresticValueDestination );
			move.setHueristicValueFromSource( huresticValueSource );
			move.getParents().add( currentNode );
			nextMoves.add(move);
		}

		if( isValid( chessBoard, nextRow, nextCol ) && 
				chessBoard[ nextRow ][ nextCol ] != 1 ) {
			int huresticValueDestination = calculateHueristicDiagnolMethod( nextRow, nextCol,
					endRow, endCol);
			int huresticValueSource = calculateHueristicDiagnolMethod( startRow, 
					startCol, nextRow, nextCol);
			int hueristic = huresticValueDestination + huresticValueSource;
			move = new NodeCS(nextRow, nextCol, hueristic );
			move.setHueristicValueFromDestination( huresticValueDestination );
			move.setHueristicValueFromSource( huresticValueSource );
			move.getParents().add( currentNode );
			nextMoves.add(move);
		}

		if( isValid( chessBoard, previousRow, nextCol ) && 
				chessBoard[ previousRow ][ nextCol ] != 1 ) {
			int huresticValueDestination = calculateHueristicDiagnolMethod( previousRow, nextCol,
					endRow, endCol);
			int huresticValueSource = calculateHueristicDiagnolMethod( startRow, 
					startCol, previousRow, nextCol);
			int hueristic = huresticValueDestination + huresticValueSource;
			move = new NodeCS(previousRow, nextCol, hueristic );
			move.setHueristicValueFromDestination( huresticValueDestination );
			move.setHueristicValueFromSource( huresticValueSource );
			move.getParents().add( currentNode );
			nextMoves.add(move);
		}
		return nextMoves;
	}

	private static int calculateHueristicDiagnolMethod(int nextRow, int col, int endRow, int endCol) {
		int huresticValue = Math.max( Math.abs(nextRow - endRow ), Math.abs(col - endCol ) ); 
		return huresticValue;
	}

	private static int getMinimumHuresticValueNodeIndex( List< NodeCS > unsetteled ) {
		int index = 0;
		int huersiticValue = 0;
		int size = unsetteled.size();

		for( int i = 0; i < size; i++ ) {
			NodeCS tempNode = unsetteled.get( i );

			if( huersiticValue == 0 ) {
				huersiticValue = tempNode.getHueristicValue();
				continue;
			}

			if( huersiticValue > tempNode.getHueristicValue() ) {
				index = i;
			}
		}
		return index;
	}

	private static boolean isValid(int[][] maze, int startPointRow, int startPointCol) {
		int rowMax = maze.length;
		int colMax = maze[ 0 ].length;
		boolean isValid = false;

		if( startPointRow >= 0 && startPointRow < rowMax && startPointCol >=0 &&
				startPointCol < colMax) {
			isValid = true;
		}
		return isValid;
	}

}
