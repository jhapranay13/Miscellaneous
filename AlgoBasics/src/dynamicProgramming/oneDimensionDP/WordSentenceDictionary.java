package dynamicProgramming.oneDimensionDP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordSentenceDictionary {

	public static void main(String[] args) {
		String str = "pineapplepenapple";
		String[] dictionary = { "apple", "pen", "applepen", "pine", "pineapple" };
		Set< String > dict = new HashSet<>();
		
		for( int i = 0; i < dictionary.length; i++ ) {
			dict.add( dictionary[ i ] );
		}
		int count = countRecur( str, dict, str.length() - 1 );
		System.out.println( count );
		
		int memo[] = new int[ str.length() ];
		Arrays.fill( memo , -1 );
		count = countMemo( str, dict, str.length() - 1, memo );
		System.out.println( count );
		
		count = countDP( str, dict );
		System.out.println( count );
	}

	private static int countRecur(String str, Set<String> dict, int index) {
		
		if( index < 0 ) {
			return 1;
		}
		int count = 0;
		
		for( int i = index; i >= 0; i-- ) {
			String sub = str.substring( i );
			
			if( dict.contains( sub ) ) {
				count += countRecur(str.substring( 0, i ), dict, i - 1 ) ;
			}
		}
		return count;
	}

	private static int countMemo(String str, Set<String> dict, int index, int[] memo) {
		
		if( index < 0 ) {
			return 1;
		}
		
		if( memo[ index ] != -1 ) {
			return memo[ index ];
		}
		int count = 0;
		
		for( int i = index; i >= 0; i-- ) {
			String sub = str.substring( i );
			
			if( dict.contains( sub ) ) {
				count += countMemo(str.substring( 0, i ), dict, i - 1, memo ) ;
			}
		}
		memo[ index ] = count;
		return memo[ index ];
	}
	
	private static int countDP(String str, Set<String> dict) {
		int memo[] = new int[ str.length() + 1 ];
		memo[ 0 ] =  1;
		
		for( int i = 1; i <= str.length(); i++ ) {
			
			for( int j = 0; j <= i; j++ ) {
				String sub = str.substring( j , i );
				
				if( dict.contains( sub ) ) {
					memo[ i ] += memo[ j ];
				}
			}
		}
		return memo[ str.length() ];
	}
}
