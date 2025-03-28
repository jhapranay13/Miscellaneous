package elementsOfProgramming.Strings;

public class ChangeTheBaseOfNumber {

	public static void main(String[] args) {
		String number = "615";
		int currentBase = 7;
		int toBase = 13;
		String convertedBaseNumber = convertNumberBase( number, currentBase, toBase );
		System.out.println( "Converted From " + currentBase + " to " + 
				toBase + " >> " + convertedBaseNumber );
	}

	private static String convertNumberBase(String number, int currentBase, int toBase) {
		int numAsDecimal = 0;
		
		for( int i = 0; i < number.length(); i++ ) {
			
			if( Character.isDigit((number.charAt(i)) ) ) {
				numAsDecimal = numAsDecimal * currentBase +  number.charAt(i) - '0';
			} else {
				numAsDecimal = numAsDecimal * currentBase +  number.charAt(i) - 'A' + 10;
			}
		}
		System.out.println( numAsDecimal );

		return "" + constructNumberToBase( numAsDecimal , toBase );
	}

	private static String constructNumberToBase(int numAsDecimal, int toBase) {
		String returnValue = "";
		
		while( numAsDecimal != 0 ) {
			
			if( numAsDecimal % toBase >= 10 ) {
				returnValue = ( char )( 'A' + numAsDecimal % toBase - 10 ) + returnValue;		
			} else {
				returnValue = ( char )( '0' + numAsDecimal % toBase ) + returnValue;
			}
			numAsDecimal /= toBase;
		}
		return returnValue;
	}

}
