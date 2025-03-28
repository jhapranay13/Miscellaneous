package elementsOfProgramming.Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergingIntervals {

	public static void main(String[] args) {
		Integer[][] intervals = {
				{ -4, -1 },
				{ 0, 2 },
				{ 3, 6 },
				{ 7, 9 },
				{ 11, 12 },
				{ 14, 17 }
		};
		int[][] valueToBeUnioned = {
				{ 1, 8 }
		};
		List< Integer[] > result = new ArrayList<>();
		unionIntervals( valueToBeUnioned, intervals, result );
		
		for( Integer[] value : result ) {
			System.out.println( value[ 0 ] + ", " + value[ 1 ] );
		}
	}

	private static void unionIntervals(int[][] valueToBeUnioned, Integer[][] intervals,
			List<Integer[]> result) {
		int tempStart = Integer.MAX_VALUE;
		int tempEnd = Integer.MIN_VALUE;
		boolean changedFlag = false;
		
		for( int i = 0; i< intervals.length; i++ ) {
			
			if( intervals[ i ][ 1 ] < valueToBeUnioned[ 0 ][ 0 ] || 
					intervals[ i ][ 0 ] > valueToBeUnioned[ 0 ][ 1 ] ) {
				
				if( changedFlag ) {
					changedFlag = false;
					Integer[] temp = { tempStart, tempEnd };
					result.add( temp );
				}
				result.add( intervals[ i ] );
			} else {
				changedFlag = true;
				tempStart = intervals[ i ][ 0 ] < tempStart ? intervals[ i ][ 0 ] : tempStart;
				tempEnd = intervals[ i ][ 1 ] > tempEnd ? intervals[ i ][ 1 ] : tempEnd;
			}
		}
	}

}
