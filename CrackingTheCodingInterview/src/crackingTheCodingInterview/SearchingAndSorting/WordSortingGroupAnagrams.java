package crackingTheCodingInterview.SearchingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSortingGroupAnagrams {

	public static void main(String[] args) {
		String[] words = { "race", "dog", "sim", "acer", "god", "mid", "dim" , "mis" };
		List< String > result = sortWordsAndGroupThemAccordingToAnagram( words );
		System.out.println( Arrays.toString( result.toArray() ) );
	}

	private static List<String> sortWordsAndGroupThemAccordingToAnagram(String[] words) {
		List< String > result = new ArrayList<>();
		Map< String, ArrayList< String > > holder = new HashMap<>();
		
		for( int i = 0; i < words.length; i++ ) {
			String sortedWord = sortWord( words[ i ] );
			List< String > temp = holder.get( sortedWord );
			
			if( temp == null ) {
				temp = new ArrayList<>();
			}
			temp.add( words[ i ] );
			holder.put( sortedWord , (ArrayList<String>) temp);
		}
		
		Set< String > keySet = holder.keySet();
		
		for( String key : keySet ) {
			result.addAll( holder.get( key ) );
		}
		return result;
	}

	private static String sortWord(String string) {
		char[] charArr = string.toCharArray();
		mergeSort( charArr );
		return new String( charArr );
	}

	private static void mergeSort(char[] charArr) {
		int lo = 0;
		int hi = charArr.length - 1;
		sort( charArr, lo, hi );
	}

	private static void sort(char[] charArr, int lo, int hi) {
		
		if( lo < hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			sort(charArr, lo, pivot);
			sort( charArr, pivot + 1, hi );
			merge( charArr, lo, pivot, hi );
		}
	}

	private static void merge(char[] charArr, int lo, int pivot, int hi) {
		char[] holder = new char[ charArr.length ];
		
		int counter = lo;
		int lowOne = lo;
		int lowTwo = pivot + 1;
		
		for( ;lowOne <= pivot && lowTwo <= hi;  ) {
			
			if( charArr[ lowOne ] < charArr[ lowTwo ] ) {
				holder[ counter++ ] = charArr[ lowOne++ ];
			} else {
				holder[ counter++ ] = charArr[ lowTwo++ ];
			}
		} 

		while( lowOne <= pivot ) {
			holder[ counter++ ] = charArr[ lowOne++ ];
		}
		
		while( lowTwo <= hi ) {
			holder[ counter++ ] = charArr[ lowTwo++ ];
		}
		
		for( int i = lo; i <= hi; i++ ) {
			charArr[ i ] = holder[ i ];
		}
	}
}
