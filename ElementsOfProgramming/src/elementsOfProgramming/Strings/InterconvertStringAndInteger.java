package elementsOfProgramming.Strings;

public class InterconvertStringAndInteger {

	public static void main(String[] args) {
		int integerToConvert = 379023;
		String stringToConvert = "456892";
		int stringToInt = convertStringToInt( stringToConvert );
		String intToString = convertIntToString( integerToConvert );
		System.out.println( "String to Int >> " + stringToInt );
		System.out.println( "Integer To String >> " + intToString );
	}

	private static String convertIntToString(int integerToConvert) {
		StringBuilder convertedValue = new StringBuilder();
		
		while( integerToConvert != 0 ) {
			int temp = integerToConvert %10;
			integerToConvert /= 10;
			convertedValue.insert(0, temp);
		}
		
		return convertedValue.toString();
	}

	private static int convertStringToInt(String stringToConvert) {
		int convertedValue = 0;
		int size = stringToConvert.length();
		
		for( int i = 0; i < size; i++ ) {
			char temp = stringToConvert.charAt( i );
			convertedValue = convertedValue * 10 + ( temp - '0' );
		}
		
		return convertedValue;
	}
}
