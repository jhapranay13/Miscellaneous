package elementsOfProgramming.Strings;

import java.util.Arrays;

public class ReverseSentence {

	public static void main(String[] args) {
		char[] sentence = { 'T', 'h', 'i', 's', ' ','i', 's', ' ', 'g', 'o', 'o', 'd' };
		System.out.println( Arrays.toString( sentence ) );
		reverseSentence( sentence );
		System.out.println( Arrays.toString( sentence ) );
	}

	private static void reverseSentence(char[] sentence) {
		int startIndex = 0;
		int endIndex = sentence.length - 1;
		
		while( startIndex < endIndex ) {
			char temp = sentence[ startIndex ];
			sentence[ startIndex++ ] = sentence[ endIndex ];
			sentence[ endIndex-- ] = temp;
		}
		reverseEachWord( sentence );
	}

	private static void reverseEachWord(char[] sentence) {
		int start = 0;
		int end = 0;
		
		for( int i = 0; i < sentence.length; i++ ) {
			
			if( sentence[ i ] == ' ' || i == sentence.length - 1 ) {
				end = i == sentence.length - 1 ? i : i - 1;
				reverseWord( sentence, start, end );
				start = i + 1;
			}
		}
	}

	private static void reverseWord(char[] sentence, int start, int end) {
		
		while( start <= end ) {
			char temp = sentence[ start ];
			sentence[ start++ ] = sentence[ end ];
			sentence[ end-- ] = temp;
		}
	}
}
