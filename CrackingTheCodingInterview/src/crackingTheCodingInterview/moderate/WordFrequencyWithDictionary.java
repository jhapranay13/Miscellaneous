package crackingTheCodingInterview.moderate;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencyWithDictionary {

	private static Map<String, Integer> dictonary = new HashMap<>();
	
	public static void main(String[] args) {
		String[] words = { "ant", "giraffe", "ant" };
		createDictionary( words );
		int frequency = calculateFrequency( "anti" );
		System.out.println( frequency );
	}

	private static int calculateFrequency(String string) {
		int frequency = 0;
		
		if( dictonary.containsKey( string.trim().toLowerCase() ) ) {
			frequency = dictonary.get( string.trim().toLowerCase() );
		}
		return frequency;
	}

	private static void createDictionary(String[] words) {
		
		for( int i = 0; i < words.length; i++ ) {
			String tempHolder = words[ i ].trim().toLowerCase();
			
			if( dictonary.get( tempHolder ) != null ) {
				int val = dictonary.get( tempHolder );
				dictonary.put( tempHolder , ++val );
			} else {
				dictonary.put( tempHolder , 1 );
			}
		}
	}

}
