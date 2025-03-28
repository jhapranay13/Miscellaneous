package crackingTheCodingInterview.ArraysAndStrings;

import java.util.Arrays;

public class CheckPermutationUsingSorting {

	//n Log n
	public static void main(String[] args) {
		String string = "espn";
		String otherString = "npse";
		System.out.println( isPermutation( string, otherString ) );
	}

	private static boolean isPermutation(String string, String otherString) {
		char[] strArr = string.toCharArray();
		char[] othStrArr = otherString.toCharArray();
		
		if( string.trim().length() != otherString.trim().length() ) {
			return false;
		}
		
		Arrays.sort( strArr );
		Arrays.sort( othStrArr );
		
		string = new String( strArr );
		otherString = new String( othStrArr );
		return string.trim().equals( otherString.trim() );
	}
}
