package elementsOfProgramming.Strings;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToDecimal {

	public static void main(String[] args) {
		String romanNumber = "LVIIII";
		int number = convertToInteger( romanNumber );
		System.out.println( "Roman Number " + romanNumber + " to Integer >> " + number );
	}

	private static int convertToInteger(String romanNumber) {
		int returnValue = 0;
		Map<Character , Integer> romanToIntegerMapping = new HashMap<Character , Integer>();

		romanToIntegerMapping.put( 'I', 1);
		romanToIntegerMapping.put( 'V', 5);
		romanToIntegerMapping.put( 'X', 10);
		romanToIntegerMapping.put( 'L', 50);
		romanToIntegerMapping.put( 'C', 100);
		romanToIntegerMapping.put( 'D', 500);
		romanToIntegerMapping.put( 'M', 1000);
		returnValue = romanToIntegerMapping.get( romanNumber.charAt( romanNumber.length() - 1 ) );

		for( int i = romanNumber.length() - 2; i >= 0; i-- ) {
			char partialNum = romanNumber.charAt( i );

			if( returnValue <= partialNum ) {
				returnValue += romanToIntegerMapping.get( partialNum );
			} else {
				returnValue -= romanToIntegerMapping.get( partialNum );
			}
		}
		return returnValue;
	}
}
