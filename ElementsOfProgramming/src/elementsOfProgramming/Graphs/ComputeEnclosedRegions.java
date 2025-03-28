package elementsOfProgramming.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Let A be a 2D array whose entries are either WorB. Write a program that takes A,
//and replaces all Ws that cannot reach the boundary with a B.

public class ComputeEnclosedRegions {

	public static void main(String[] args) {
		char[][] board1 = {
				{ 'B', 'B', 'B', 'B' },
				{ 'W', 'B', 'W', 'B' },
				{ 'B', 'W', 'W', 'B' },
				{ 'B', 'B', 'B', 'B' },
		};
		List< List<Character> > board = new ArrayList<>();
		List<Character> pos = new ArrayList<>(  );
		pos.add( 'B');
		pos.add( 'B');
		pos.add( 'B');
		pos.add( 'B');
		board.add( pos );
		pos = new ArrayList<>(  );
		pos.add( 'W');
		pos.add( 'B');
		pos.add( 'W');
		pos.add( 'B');
		board.add( pos );
		pos = new ArrayList<>(  );
		pos.add( 'B');
		pos.add( 'W');
		pos.add( 'W');
		pos.add( 'B');
		board.add( pos );
		pos = new ArrayList<>(  );
		pos.add( 'B');
		pos.add( 'B');
		pos.add( 'B');
		pos.add( 'B');
		board.add( pos );
		fillSurroundedRegions(board);
		System.out.println();
	}

	
	public static void fillSurroundedRegions(List <List <Character >> board) {
		if (board.isEmpty () ) {
			return ;
		}
		List<List <Boolean>> visited = new ArrayList<>(board.size ()) ;
		for (int i = 0; i < board.size () ; ++i) {
			visited.add (
					new ArrayList(Collections.nCopies(board.get(i).size() , false) ) ) ;
		}
		// Identifies the regions that are reachable via white path starting from
		// the first or last columns.
		for (int i = 0; i < board.size () ; ++i) {
			
			if (board.get(i).get(0) == 'W' && ! visited.get(i).get(0) ) {
				markBoundaryRegion(i , 0, board, visited);
			}
			if (board.get(i).get(board.get(i).size () - 1) == 'W'
					&& !visited.get(i).get(board . get (i).size() - 1)) {
				markBoundaryRegion(i , board.get(i).size () - 1, board, visited);
			}
		}
		// Identifies the regions that are reachable via white path starting from
		// the first or last rows.
		for (int j = 0; j < board.get(0).size () ; ++j) {
			if (board.get(0) . get(j)== 'W' && ! visited.get(0).get (j )) {
				markBoundaryRegion (0 , j, board, visited);
			}
			if (board.get (board.size () - 1).get(j) == 'W'
					&& ! visited . get (board . size () - 1).get(j)) {
				markBoundaryRegion(board . size () - 1, j, board, visited);
			}
		}
		
		// Marks the surrounded white regions as black.
		for (int i = 1; i < board.size() - 1; ++i) {
			for (int j = 1; j < board.get(i).size() - 1; ++j){
				if (board.get(i).get(j)== 'W' && !visited.get(i).get(j)){
					board.get(i).set(j, 'B');
				}
			}
		}
	}
	
	private static void markBoundaryRegion(int i, int j,
			List<List<Character>> board,
			List<List<Boolean>> visited) {
		Queue<CoOrdinate> q = new LinkedList<>();
		q.add(new CoOrdinate(i , j));
		visited.get(i).set(j, true);
		// Uses BFS to traverse this region.

		while(!q.isEmpty()){
			CoOrdinate curr = q.poll();
			final int DIRS[][] = {{0, 1}, {0, -1}, {1, 0} , {-1, 0}};

			for (int[] dir : DIRS) {
				CoOrdinate next = new CoOrdinate(curr.x + dir[0], curr.y + dir[1]);
				
				if (next.x >= 0 && next.x < board.size() && next.y >= 0
						&& next.y < board.get(next.x).size()
						&& board.get(next.x).get(next.y) == 'W'
						&& !visited.get(next.x).get(next.y)){
					visited.get(next.x).set(next.y, true);
					q.add(next);
				}
			}
		}
	}
	
	private static void printTable(int[][] table) {

		System.out.println("============================");
		for( int i = 0; i < table.length; i++ ) {

			for( int j = 0; j < table[ i ].length; j++ ) {
				System.out.print( table[ i ][ j ] + " " );
			}
			System.out.println();
		}
	}
}
