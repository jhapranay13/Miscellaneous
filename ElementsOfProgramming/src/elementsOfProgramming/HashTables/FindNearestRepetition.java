package elementsOfProgramming.HashTables;

import java.util.HashMap;
import java.util.Map;

public class FindNearestRepetition {

	public static void main(String[] args) {
		String[] sentence = { "All", "work", "and", "no", "play",
				"makes", "for", "no", "work", "no", "fun", "and", "no", "results" };

		int nearestRepetition = findNearestRep( sentence );
		System.out.println( nearestRepetition );
	}

	private static int findNearestRep(String[] sentence) {
		Map<String , Integer> wordToLatestIndex = new HashMap<>();
		int nearestRepeatedDistance = Integer.MAX_VALUE ;
		
		for (int i = 0; i < sentence.length; ++i) {
			
			if( wordToLatestIndex.containsKey( sentence[ i ] ) ) {
				nearestRepeatedDistance
				= Math.min(nearestRepeatedDistance ,
						i - wordToLatestIndex.get(sentence[ i ]));
			}
			wordToLatestIndex.put(sentence[ i ], i);
		}
		return nearestRepeatedDistance ;
	}

}
