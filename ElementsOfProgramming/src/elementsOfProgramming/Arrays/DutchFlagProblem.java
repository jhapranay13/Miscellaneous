package elementsOfProgramming.Arrays;

import java.util.Arrays;

//can also be solved with any sorting algorithm for nlog( n ) time complexity
// this is o( n ) with constant space
public class DutchFlagProblem {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 0, 0, 2, 2, 1, 1, 1 };
		sort( arr );
		System.out.println( Arrays.toString( arr ) );
	}

	private static void sort(int[] arr) {
		int lowPointer = 0;
		int highPointer = arr.length - 1;
		int runningPointer = 1;

		/*while( runningPointer < highPointer ) {

			if( arr[ runningPointer ] == 0 ) {
				swap( arr, runningPointer++, lowPointer++ );
			} else if( arr[ runningPointer ] == 1  ) {
				runningPointer++;
			} else if( arr[ runningPointer ] ==  2 ) {
				swap(arr, runningPointer++, highPointer--);
			}
		}*/
		
		int pivot = lowPointer + ( highPointer - lowPointer ) / 2;
		
		while( lowPointer < highPointer ) {
			int pivotVal = arr[ pivot ];
			int lowPointerVal = arr[ lowPointer ];
			
			if( pivotVal < lowPointerVal  ) {
				swap( arr, lowPointerVal, highPointer-- );
			} else if( pivotVal == lowPointerVal  ) {
				lowPointer++;
			} else if( lowPointerVal <  pivotVal ) {
				swap(arr, lowPointer++, pivot);
			}
		}

	}

	private static void swap(int[] arr, int runningPointer, int lowPointer) {
		int temp = arr[ runningPointer ];
		arr[ runningPointer ] = arr[ lowPointer ];
		arr[ lowPointer ] = temp;
	}

}
