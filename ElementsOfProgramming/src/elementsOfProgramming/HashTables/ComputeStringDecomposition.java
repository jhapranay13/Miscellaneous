package elementsOfProgramming.HashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeStringDecomposition {

	public static void main(String[] args) {
		String sentence = "amanaplanacanal";
		List< String > words = new ArrayList<>();
		words.add( "can" );
		words.add( "apl" );
		words.add( "ana" );
		List< Integer > result = new ArrayList<>();

		findSubString( sentence, words, result );

		for( int i : result ) {
			System.out.println( result );
		}
	}

	private static void findSubString(String sentence, List<String> words, List<Integer> result) {
		Map< String, Integer > dictionaryFrequency = new HashMap<>();

		for( String word: words ) {

			if( !dictionaryFrequency.containsKey( word ) ) {
				dictionaryFrequency.put( word, 1 );
			} else {
				int value = dictionaryFrequency.get( word );
				dictionaryFrequency.put(word, ++value);
			}
		}
		int unitSize = words.get(0).length();

		for( int i = 0; i + unitSize * words.size() < sentence.length(); i++ ) {
			boolean matchFlag = true;
			HashMap<String, Integer> tempFreqHolder = new HashMap<>();

			for( int j = 0; j < words.size(); j++ ) {
				String valueUnderConsideration = sentence.substring( i + j * unitSize, 
						i + ( j  + 1 ) * unitSize);
				Integer freq = dictionaryFrequency.get( valueUnderConsideration );

				if( freq == null ) {
					matchFlag = false;
					break;
				}
				Integer currentVal = tempFreqHolder.get(valueUnderConsideration);

				if( currentVal == null ) {
					tempFreqHolder.put( valueUnderConsideration, 1 );
				} else {
					tempFreqHolder.put( valueUnderConsideration, ++currentVal );
				}
				
				if( tempFreqHolder.get(valueUnderConsideration) > freq ) {
					matchFlag = false;
				}
			}

			if( matchFlag ) {
				result.add( i );
			}
		}
	}
}
