package elementsOfProgramming.HashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestForPalindromicPermutation {

	public static void main(String[] args) {
		String word = "root";
		boolean isPossiblePalindromicFlag = canPermutationBePalindromic( word );
		System.out.println( isPossiblePalindromicFlag );
	}

	private static boolean canPermutationBePalindromic(String word) {
		Map< Character, Integer > charFrequency = getCharFrequency( word );
		Set<Entry<Character, Integer>> entrySet = charFrequency.entrySet();
		int oddCounter = 0;
		
		for( Entry<Character, Integer> entry : entrySet ) {
			
			if( oddCounter > 1 ) {
				return false;
			}
			
			if( entry.getValue() % 2 != 0 ) {
				oddCounter++;
			}
		}
		return true;
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
