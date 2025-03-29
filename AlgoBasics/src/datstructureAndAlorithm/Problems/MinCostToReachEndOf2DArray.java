package datstructureAndAlorithm.Problems;

public class MinCostToReachEndOf2DArray {

	public static void main(String[] args) {
		int[][] array =
			{
				{ 4, 7, 8, 6, 4 },
				{ 6, 7, 3, 9, 2 },
				{ 3, 8, 1, 2, 4 },
				{ 7, 1, 7, 3, 7 },
				{ 2, 9, 8, 9, 3 }
			};
		System.out.print("The minimum cost is " + 
				findMinCost(array, array.length-1, array[0].length-1));
	}

	private static int findMinCost(int[][] array, int row, int col) {
		
		if (row == -1 || col == -1) {
			return Integer.MAX_VALUE;
		}
		
		if( row == 0 && col == 0 ) {
			return array[ 0 ][ 0 ];
		}
		
		int leftMove =  findMinCost( array, row, col - 1 );
		int rightMove =  findMinCost(array, row - 1, col );
		int minCost = array[ row ][ col ] + Math.min( leftMove, rightMove );
		return minCost;
	}

}
