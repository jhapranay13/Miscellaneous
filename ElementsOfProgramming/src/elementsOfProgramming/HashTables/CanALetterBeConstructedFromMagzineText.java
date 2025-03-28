package elementsOfProgramming.HashTables;

import java.util.HashMap;
import java.util.Map;

public class CanALetterBeConstructedFromMagzineText {

	public static void main(String[] args) {
		String letterText = "root";
		String magzineText = "rotxyz";
		boolean canLetterBeConstructedFlag = canLetterBeConstructed( letterText, magzineText );
		System.out.println( canLetterBeConstructedFlag );
	}


	private static boolean canLetterBeConstructed(String letterText, String magzineText) {
		Map< Character, Integer > charFrequency = getCharFrequency(letterText);
		
		for( int i = 0; i < magzineText.length(); i++ ) {
			
			if( charFrequency.isEmpty() ) {
				break;
			}
			char temp = magzineText.charAt(i);
			Integer value = charFrequency.get( temp );
			
			if( value != null ) {
				value--;
				
				if( value == 0 ) {
					charFrequency.remove( temp );
				} else {
					charFrequency.put( temp , value);
				}
			}
		}
		return charFrequency.isEmpty();
	}


	private static Map<Character, Integer> getCharFrequency(String word) {
		Map< Character, Integer > charFrequency = new HashMap<Character, Integer>();
		
		for( int i = 0; i < word.length(); i++ ) {
			char temp = word.charAt( i );
			
			if( charFrequency.containsKey( temp ) ) {
				int value = charFrequency.get( temp );
				charFrequency.put(temp, ++value);
			} else {
				charFrequency.put(temp, 1);
			}
		}
		return charFrequency;
	}
}
