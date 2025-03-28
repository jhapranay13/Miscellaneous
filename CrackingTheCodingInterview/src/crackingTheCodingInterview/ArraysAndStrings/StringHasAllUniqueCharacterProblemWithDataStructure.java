package crackingTheCodingInterview.ArraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class StringHasAllUniqueCharacterProblemWithDataStructure {

	public static void main(String[] args) {
		String string = "liist";
		System.out.println( isUnique( string ) );
	}

	private static boolean isUnique(String string) {
		char[] strCharArr = string.toCharArray();
		Map< Character, Integer > holder = new HashMap<>();
		
		for( int i = 0; i < strCharArr.length; i++ ){
			
			if( holder.get( strCharArr[ i ] ) != null ) {
				return false;
			}
			holder.put( strCharArr[ i ] , 1);
		}
		return true;
	}
}
