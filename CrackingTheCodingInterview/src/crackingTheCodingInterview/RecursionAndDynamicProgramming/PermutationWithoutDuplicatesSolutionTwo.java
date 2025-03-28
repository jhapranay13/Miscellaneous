package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PermutationWithoutDuplicatesSolutionTwo {

	public static void main(String[] args) {
		String string = "abcd";
		String prefix = "";
		List< String > permutations = getPermutations( string, prefix );
		
		for( String permutation : permutations ) {
			System.out.println( permutation );
		}
	}

	private static List<String> getPermutations(String string, String prefix) {
		
		if( string == null || string.trim().equals( "" ) ) {
			return null;
		}
		List< String > returnList = new ArrayList<>();
		
		for( int i = 0; i < string.length(); i++ ) {
			String prefx = string.charAt( i ) + "";
			String word = getWord( i, string );
			List<String> partialPermute = getPermutations( word , prefix + prefx );
			
			if( partialPermute == null ) {
				partialPermute = new ArrayList<>();
				partialPermute.add( word );
			} else {
				returnList.addAll( partialPermute );
			}

			
			if( string.length() == 1 ) {
				returnList.add( prefix + prefx + word );
			}	
		}
		return returnList;
	}

	private static String getWord(int i, String string) {
		String returnStr = "";
		
		if( i == 0 ) {
			returnStr = string.substring( 1, string.length() );
		} else {
			returnStr = string.substring( 0, i );
			returnStr += string.substring( i + 1 );
		}
		return returnStr;
	}

}
