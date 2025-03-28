package elementsOfProgramming.HashTables;

import java.util.LinkedHashMap;

public class LongestSubArrayWithDistinctEntries {

	public static void main(String[] args) {
		char[] sequence = { 'f', 's', 'f', 'e', 't', 'w', 'e', 'n', 'w', 'e' };
		printMaximumSubArrayDistinctSequence( sequence );
	}

	private static void printMaximumSubArrayDistinctSequence(char[] sequence) {
		LinkedHashMap<Character, Integer> cache = new LinkedHashMap<>();
		int seqStartIndex = 0;
		int result = 0;
		
		for( int i = 0; i < sequence.length; i++ ) {
			Integer value = cache.put( sequence[ i ] , i);
			
			if( value != null ) {
				
				if( i > seqStartIndex ) {
					result = Math.max( result , i - seqStartIndex );
					seqStartIndex = value + 1;
				}
			}
		}
		System.out.println( result );
	}

}
