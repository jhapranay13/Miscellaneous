package elementsOfProgramming.Sorting;

import java.util.Arrays;

public class MergeTwoSortedArrayInTheFirstArrayWithSpaces {

	public static void main(String[] args) {
		int[] arrOne = { 5, 13, 17, -1 , -1 , -1 , -1, - 1 };
		int[] arrTwo = { 3, 7, 11, 19 };
		mergeArrays( arrOne, arrTwo );
		System.out.println( Arrays.toString( arrOne ) );
	}

	private static void mergeArrays(int[] arrOne, int[] arrTwo) {
		int startPointer1 = 0;
		int startPointer2 = 0;
		int insertIndex = 0;
		
		while( startPointer1 < arrOne.length - 1 && arrOne[ startPointer1 + 1] != -1 ) {
			startPointer1++;
		}
		
		while( startPointer2 < arrTwo.length - 1 && arrTwo[ startPointer2 + 1] != -1 ) {
			startPointer2++;
		}
		insertIndex = startPointer1 + startPointer2 + 1;
		
		while( startPointer1 >= 0 && startPointer2 >= 0 ) {
			
			if( arrOne[ startPointer1 ] == arrTwo[ startPointer2 ] ) {
				arrOne[ insertIndex-- ] = arrOne[ startPointer1-- ];
				arrOne[ insertIndex-- ] = arrOne[ startPointer2-- ];
				continue;
			}
			
			if( arrOne[ startPointer1 ] > arrTwo[ startPointer2 ] ) {
				arrOne[ insertIndex-- ] = arrOne[ startPointer1-- ];
			} else {
				arrOne[ insertIndex-- ] = arrTwo[ startPointer2-- ];
			}
		}
		int index = startPointer1 < 0 ? startPointer2 : startPointer1;
		int[] arrStillNotTraversed = startPointer1 < 0 ? arrTwo : arrOne;
		
		while( index >= 0 ) {
			arrOne[ insertIndex-- ] = arrStillNotTraversed[ index-- ];
		}
	}
}
