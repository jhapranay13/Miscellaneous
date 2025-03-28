package elementsOfProgramming.Arrays;

import java.util.Arrays;

//Can be done using stack too.
public class IncrementArbitaryPrecisionInteger {

	public static void main(String[] args) {
		//int arr[] = { 9, 9, 9, 9 };
		//int arr[] = { 1, 3, 9 };
		//int arr[] = { 1, 9 };
		int arr[] = { 9 };
		int[] incrementedArr = getIncrementArray( arr );
		System.out.println( Arrays.toString( incrementedArr ) );
	}

	private static int[] getIncrementArray(int[] arr) {
		int incrementedArr[] = arr;
		int lastIndex = arr.length - 1;
		int carry = 0;
		arr[ lastIndex ] += 1;
		
		do {
			arr[ lastIndex ] += carry;
			carry = arr[ lastIndex ] / 10;
			arr[ lastIndex ] = arr[ lastIndex-- ] % 10;
		} while( carry != 0 && lastIndex >= 0 );
		
		if( carry != 0 ) {
			incrementedArr = new int[ arr.length + 1 ];
			incrementedArr[ 0 ] = carry;
			
			for( int i = 0; i < arr.length; i++ ) {
				incrementedArr[ i + 1 ] = arr[ i ];
			}
		}
		return incrementedArr;
	}
}
