package crackingTheCodingInterview.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CheckPermutationUsingHashMap {

	//time complexity n
	public static void main(String[] args) {
		String string = "espn";
		String otherString = "npsd";
		System.out.println( isPermutation( string, otherString ) );
	}

	private static boolean isPermutation(String string, String otherString) {
		char[] strArr = string.toCharArray();
		char[] othStrArr = otherString.toCharArray();
		Map< Character, Integer > holder = new HashMap<>();

		if( string.trim().length() != otherString.trim().length() ) {
			return false;
		}

		for( int i = 0; i < strArr.length; i++ ) {

			if( holder.get( strArr[ i ] ) == null ) {
				holder.put( strArr[ i ] , 1 );
			} else {
				int val = holder.get( strArr[ i ] );
				holder.put( strArr[ i ], ( val + 1 ) );
			}
		}

		for( int i = 0; i < othStrArr.length; i++ ) {

			if( holder.get( othStrArr[ i ] ) == null ) {
				return false;
			} else {
				int val = holder.get( othStrArr[ i ] );
				holder.put( othStrArr[ i ], ( val - 1 ) );
			}
		}
		
		Set< Entry< Character, Integer > > entrySet = holder.entrySet();
		
		for( Entry< Character, Integer > entry : entrySet ) {
			
			if( entry.getValue() != 0 ) {
				return false;
			}
		}
		return true;
	}

}
