package elementsOfProgramming.GreedyAlgorithmsAndInvariants;

public class GasUpProblem {

	/*
	 * 
	 * Suppose there is a circle. There are n petrol pumps on that circle. You are given
	 *  two sets of data.
			The amount of petrol that every petrol pump has.
			Distance from that petrol pump to the next petrol pump.
		Calculate the first point from where a truck will be able to complete the circle 
		(The truck will stop at each petrol pump and it has infinite capacity). 
		Expected time complexity is O(n). Assume for 1-litre petrol, the truck can go 1 unit 
		of distance.

		For example, let there be 4 petrol pumps with amount of petrol and distance to next 
		petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The first point from 
		where the truck can make a circular tour is 2nd petrol pump. Output should be 
		“start = 1” (index of 2nd petrol pump).
	 * 
	 * 
	 * 
	 * An efficient approach is to use a Queue to store the current tour. We first enqueue 
	 * first petrol pump to the queue, we keep enqueueing petrol pumps till we either complete
	 *  the tour, or the current amount of petrol becomes negative. If the amount becomes 
	 *  negative, then we keep dequeuing petrol pumps until the queue becomes empty.

		Instead of creating a separate queue, we use the given array itself as a queue.
		 We maintain two index variables start and end that represent the rear and front 
		 of the queue.
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int gas[] = { 4, 6, 7, 4 };
		int cost[] = { 6, 5, 3, 5 };
		
		int indexToStartFrom = getGasStationToStartFromToMakeAFullTour( gas, cost );
		System.out.println( indexToStartFrom );
	}

	private static int getGasStationToStartFromToMakeAFullTour(int[] gas, int[] cost) {
		int returnIndex = -1;
		int start = -1;
		int end = 0;
		int gasLeft = 0;
		
		while( start != end ) {
			gasLeft += gas[ end ] - cost[ end ];
			
			if( gasLeft < 0 ) {
				end++;
				start %= cost.length;
				end %= cost.length;
				gasLeft = 0;
			} else {
				
				if( start == -1 ) {
					start = end;
				}
				end++;
				end %= cost.length;
				
				if( start == end ) {
					returnIndex = start;
				}
			}
		}
		return returnIndex;
	}

}
