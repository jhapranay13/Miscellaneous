package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramRecur {

	public static void main(String[] args) {
		String str = "god";
		printAnangrams( str );
	}

	private static void printAnangrams(String str) {
		boolean used[] = new boolean[ str.length() ];
		List< Character > partial = new ArrayList<>();
		printAnangrams(str, used, partial);
	}

	private static void printAnangrams(String str,
			boolean[] used, List< Character > partial) {
		
		if( partial.size() == str.length() ) {
			System.out.println( Arrays.toString( partial.toArray() ) );
			return;
		}
		
		for( int i = 0; i < str.length(); i++ ) {
			
			if( !used[ i ] ) {
				partial.add( str.charAt( i ) );
				used[ i ] = true;
				printAnangrams( str, used, partial );
				used[ i ] = false;
				partial.remove( partial.size() - 1 );
			}
		}
	}
}
