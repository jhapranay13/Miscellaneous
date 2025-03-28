package crackingTheCodingInterview.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SameNumberOfLetterAndNumberInSubArrayBruteForce {

	public static void main(String[] args) {
		String[] arr = {  "a", "a", "a", "a", "1", "1", "a", "1", "1", "a", "a",
				"1", "a", "a", "1", "a", "a", "a", "a"};
		Object result[] = getLongestSubArray( arr );
		System.out.println( Arrays.toString( result ) );
	}

	private static Object[] getLongestSubArray(String[] arr) {
		HashSet< ArrayList<String> > subArray = new HashSet<>();

		getAllSubArrays( subArray, arr );
		ArrayList<ArrayList<String>> listArr = removeArrayWithUnequalLetterANdNumber( subArray );

		int maxLength = 0;
		Object[] maxArray = null;

		for( List< String > temp : listArr ) {

			if( maxLength < temp.size() ) {
				maxLength = temp.size();
				maxArray =  temp.toArray();
			}
		}
		return maxArray;
	}

	private static ArrayList<ArrayList<String>> removeArrayWithUnequalLetterANdNumber(HashSet<ArrayList<String>> subArray) {
		ArrayList<ArrayList<String>> returnList = new ArrayList<>();
		Iterator<ArrayList<String>> iter = subArray.iterator();

		while( iter.hasNext() ) {
			List< String > sub = iter.next();
			int counter = 0;

			if( sub == null ) {
				continue;
			}

			for( String element : sub ) {

				if( element.trim().equals( "a" ) ) {
					counter++;
				} else {
					counter--;
				}
			}

			if( counter == 0 ) {
				returnList.add( (ArrayList<String>) sub );
			} 
		}
		return returnList;
	}

	private static void getAllSubArrays(HashSet<ArrayList<String>> subArray, String[] arr) {
		ArrayList< String > arrStore = null;

		for( int i = 0; i < arr.length; i++ ) {
			arrStore = new ArrayList<>();
			arrStore.add( arr[ i ] );
			subArray.add( (ArrayList<String>) arrStore.clone() );

			for( int j = i + 1; j < arr.length; j++ ) {
				arrStore.add( arr[ j ] );
				subArray.add( (ArrayList<String>) arrStore.clone() );
			}
		}
	}

}
