package crackingTheCodingInterview.SearchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValueNotContainedInTheArray {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 ,4, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 19 };
		List< Integer > notInTheList = findNotInTheList( arr );
		
		System.out.println( Arrays.toString( notInTheList.toArray() ) );
	}

	private static List<Integer> findNotInTheList(int[] arr) {
		List< Integer > returnList = new ArrayList<>();
		int noOfBitsNeeded = arr[ arr.length - 1 ];
		int modVal = noOfBitsNeeded % 8;
		int numBytes = noOfBitsNeeded / 8;
		
		if( modVal != 0 ) {
			numBytes++;
		}
		byte[] resultHolder = new byte[ numBytes ];
		
		for( int i = 0; i < arr.length; i++ ) {
			int arrVal = arr[ i ];
			int byteCounter = arrVal / 7;
			int tempArrVal = arrVal % 7;
			byte mask = (byte) ( 1 << (tempArrVal ));
			resultHolder[ byteCounter ] |= mask; 
			System.out.println( Integer.toBinaryString( mask ) );
			System.out.println( Integer.toBinaryString( resultHolder[ byteCounter ] ) );
		}		
		int counter = 0;
		
		for( int i = 0; i < resultHolder.length; i++ ) {
			byte partialResult = resultHolder[ i ];
			
			for( byte b = partialResult; b > 0; b = (byte) (b >> 1) ) {
				int bit = b & 1;
				
				if( bit == 0 ) {
					returnList.add( counter );
				}
				counter++;
			}
		}
		return returnList;
	}
}
