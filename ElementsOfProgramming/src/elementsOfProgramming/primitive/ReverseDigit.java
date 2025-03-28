package elementsOfProgramming.primitive;

public class ReverseDigit {

	public static void main(String[] args) {
		int input = -413;
		long reversedNumber = reverseNumber( input );
		System.out.println( reversedNumber );
	}

	private static long reverseNumber(int input) {
		long returnNumber = 0;
		int powerOfTen = 10;
		boolean negativeFlag = input < 0 ? true : false;
		
		while( input != 0 ) {
			returnNumber *= powerOfTen;  
			returnNumber += ( input % 10 );
			input = input / 10;
		}
		
		if( negativeFlag ) {
			returnNumber = 0-returnNumber;
		}	
		return  returnNumber;
	}
}
