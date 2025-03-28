package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class DeleteDuplicatesFromSortedrray {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6 };
		deleteDuplicatesAndMoveZeroTOBack( arr );
		System.out.println( Arrays.toString( arr ) );
	}

	private static void deleteDuplicatesAndMoveZeroTOBack(int[] arr) {
		int size = arr.length;
		int currentElement = arr[ 0 ];
		int nextIndex = 0;
		boolean movedFirstFlag = false;

		for( int i = 1; i < size; i++ ) {

			if( currentElement == arr[ i ] ) {
				arr[ i ] = 0;
				
				if( movedFirstFlag == false ) {
					nextIndex = i;
				}	
				movedFirstFlag = true;
			} else {
				currentElement = arr[ i ];
				
				if( movedFirstFlag ) {
					arr[ i ] = 0;
					arr[ nextIndex++ ] = currentElement;
				}
			}
		}
	}
}
