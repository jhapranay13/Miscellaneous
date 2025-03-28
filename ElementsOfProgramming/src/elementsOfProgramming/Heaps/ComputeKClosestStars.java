package elementsOfProgramming.Heaps;

import java.util.Arrays;

public class ComputeKClosestStars {

	public static void main(String[] args) {
		int[] distance = { 45, 55, 32, 12, 65, 31, 27, 17, 11, 3 };
		int numberOfClosestStars = 4;
		int[] closestStars = getClosestStars( distance, numberOfClosestStars );
		System.out.println( Arrays.toString( closestStars ) );
	}

	private static int[] getClosestStars(int[] distance, int numberOfClosestStars) {
		int[] closestStar = null;
		
		if( numberOfClosestStars <= distance.length ) {
			closestStar = new int[ numberOfClosestStars ];
			buildMinHeap( distance );
			System.out.println( "Min Heap >> "  + Arrays.toString( distance ));
			int size = distance.length - 1;
			
			for( int i = 0; i < closestStar.length; i++ ) {
				closestStar[ i ] = distance[ 0 ];
				int temp = distance[ 0 ];
				distance[ 0 ] = distance[ size ];
				distance[ size ] = temp;
				heapify(distance, 0, --size);
			}
		}
		return closestStar;
	}

	private static void buildMinHeap(int[] distance) {
		
		for( int i = ( distance.length - 2 ) / 2; i >= 0; i-- ) {
			heapify( distance, i , distance.length - 1 );
		}
	}

	private static void heapify(int[] distance, int start, int end) {
		int leftNode = 2 * start + 1;
		int rightNode = 2 * start + 2;
		int minIndex = start;
		
		if( leftNode <= end ) {
			minIndex = distance[ minIndex ] > distance[ leftNode ]  ? leftNode : minIndex;
		}
		
		if( rightNode <= end ) {
			minIndex = distance[ minIndex ] > distance[ rightNode ]  ? rightNode : minIndex;
		}
		
		if( minIndex != start ) {
			int temp = distance[ minIndex ];
			distance[ minIndex ] = distance[ start ];
			distance[ start ] = temp;
			heapify(distance, minIndex, end);
		}
	}
}
