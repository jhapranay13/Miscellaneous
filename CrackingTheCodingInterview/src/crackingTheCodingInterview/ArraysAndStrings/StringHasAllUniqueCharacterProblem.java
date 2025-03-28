package crackingTheCodingInterview.ArraysAndStrings;

import java.util.Arrays;

public class StringHasAllUniqueCharacterProblem {

	public static void main(String[] args) {
		String string = "liist";
		System.out.println( isUnique( string ) );
	}

	//n Log n algorithm
	private static boolean isUnique(String string) {
		boolean reaturnFlag = false;
		
		char[] stringCharArr = string.toCharArray();
		Arrays.sort( stringCharArr );
		
		for( int i = 0 ; i < stringCharArr.length - 2; i++ ) {
			
			if( stringCharArr[ i ] == stringCharArr[ i + 1 ] ) {
				reaturnFlag = false;
				break;
			} 
			reaturnFlag = true;
		}
		return reaturnFlag;
	}
}
