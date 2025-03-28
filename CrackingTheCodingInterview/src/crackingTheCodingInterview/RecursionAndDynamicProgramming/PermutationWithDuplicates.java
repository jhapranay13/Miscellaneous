package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermutationWithDuplicates {

	public static void main(String[] args) { 
		String string = "AABBBBCCD"; 
		List< String > allPermutations = getAllPrmutations( string ); 
		
		for( String permutation : allPermutations ) {
			System.out.println( permutation );
		}
	}

	private static List<String> getAllPrmutations(String string) {
		Map< String, Integer > frequencyMap = new HashMap<>(); 
		int totalElementsRemaining = getFrequencyMap( string, frequencyMap );
		String prefix = "";
		List< String > permutationList = new ArrayList<>();
		allPermutation( frequencyMap, string, prefix, permutationList, totalElementsRemaining );
		return permutationList;
	}

	private static void allPermutation(Map<String, Integer> frequencyMap, String string, 
			String prefix, List<String> permutationList, int totalElementsRemaining) {
		
		if( totalElementsRemaining == 0 ) {
			permutationList.add( prefix );
			return;
		}
		Set< String > keyset = frequencyMap.keySet();
		
		for( String key : keyset ) {
			int count = frequencyMap.get( key );
		
			if( count != 0 ) {
				frequencyMap.put( key, count - 1 );
				allPermutation(frequencyMap, string, prefix + key, permutationList, 
						totalElementsRemaining - 1 );
				frequencyMap.put( key, count );
			}
		}
	}

	private static int getFrequencyMap(String string, Map<String, Integer> frequencyMap) {
		char[] charArray = string.toCharArray();
		int elementcounter = 0;
		
		for( char character : charArray ) {
			elementcounter++;
			
			if( frequencyMap.get( character + "" ) == null ) {
				frequencyMap.put( character +"" , 1 );
			} else {
				frequencyMap.put( character +"" , frequencyMap.get( character + "" ) + 1 );
			}
		}
		return elementcounter;
	} 

}
