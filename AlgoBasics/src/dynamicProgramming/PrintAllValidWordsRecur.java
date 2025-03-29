package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrintAllValidWordsRecur {

	public static void main(String[] args) {
		String str = "catsanddog";
		String[] dictionary = { "cats", "cat", "and", "sand", "dog" };
		Set< String > dict = new HashSet<>();

		for( int i = 0; i < dictionary.length; i++ ) {
			dict.add( dictionary[ i ] );
		}
		wordBreak( str, dict, new ArrayList<String>() );
	}

	private static void wordBreak(String str, Set< String > dict, 
			ArrayList<String> partial) {

		if( str.length() == 0 ) {
			System.out.println( Arrays.toString( partial.toArray() ) );
			return;
		}

		for( int i = 1; i <= str.length(); i++ ) {
			String subStr = str.substring( 0, i );

			if( dict.contains( subStr ) ) {
				partial.add( subStr );
				wordBreak(str.substring( i ), dict, partial );
				partial.remove( partial.size() - 1 );
			}
		}
	}

}
