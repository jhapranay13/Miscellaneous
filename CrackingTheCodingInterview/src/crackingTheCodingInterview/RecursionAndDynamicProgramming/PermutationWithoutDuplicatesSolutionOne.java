package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithoutDuplicatesSolutionOne {

	public static void main(String[] args) {
		String string = "abcd";
		List< String > permutations = getPermutations( string );
		
		for( String permutation : permutations ) {
			System.out.println( permutation );
		}
	}

	private static List<String> getPermutations(String string) {
		
		if( string == null || string.trim().equals( "" ) ) {
			return null;
		}
		String firstChar = string.charAt( 0 ) + "";
		String forwardWord = string.substring( 1 , string.length() );
		List< String > wordPermutation = getPermutations( forwardWord );
		
		if( wordPermutation == null ) {
			wordPermutation = new ArrayList<>();
			wordPermutation.add( forwardWord );
		}
		List< String > permutations = new ArrayList<>();
		
		for( String word : wordPermutation ) {
			
			for( int i = 0; i <= word.length(); i++ ) {
				String wordAfterInsert = insertCharAt( i, firstChar, word );
				permutations.add( wordAfterInsert );
			}
		}
		return permutations;
	}

	private static String insertCharAt(int index, String firstChar, String word) {
		StringBuilder returnStr = new StringBuilder();
		
		if( index == 0 ) {
			returnStr.append( firstChar );
			returnStr.append( word );
		} else if( index == word.length() ) {
			returnStr.append( word );
			returnStr.append( firstChar );
		} else {
			returnStr.append( word.substring(0, index) );
			returnStr.append( firstChar );
			returnStr.append( word.substring( index ) );
		}
		
		return returnStr.toString();
	}
}
