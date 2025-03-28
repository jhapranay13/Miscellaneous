package elementsOfProgramming.GreedyAlgorithmsAndInvariants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumNumberOfVisitsForTaskStatus {

	public static void main(String[] args) {
		int[][] taskTiming = {
				{ 1, 2 }, 
				{ 2, 3 }, 
				{ 3, 4 }, 
				{ 2, 3 }, 
				{ 3, 4 }, 
				{ 4, 5 }
		};
		calulcateMinimumVisitToCheckAllTaskStatus( taskTiming );
	}

	private static void calulcateMinimumVisitToCheckAllTaskStatus(int[][] taskTiming) {
		Arrays.sort(taskTiming, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[ 1 ] < o2[ 1 ] ? -1 : o1[ 1 ] > o2[ 1 ] ? 1 : 0;
			}

		});
		List<Integer> visits = new ArrayList<>();
		Integer lastVisitTime = taskTiming[ 0 ][ 1 ] ;
		visits.add(lastVisitTime);
		
		for (int[] timing : taskTiming) {
			
			if(timing[ 0 ] > lastVisitTime) {
				// The current right endpoint , lastVisitTime , will not cover any more
				// intervals .
				lastVisitTime = timing[ 1 ] ;
				visits.add(lastVisitTime);
			}
		}
		System.out.println( Arrays.toString( visits.toArray() ) );
	}

}
