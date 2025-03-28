package elementsOfProgramming.primitive;

public class ReverseBitToGetTheSAmeWeightAndCLosestNumberPossible {

	public static void main(String[] args) {
		int input = 8;
		int result = findClosestByFlippingBits( input );
		System.out.println( "BInary >> " + Integer.toBinaryString( input )  + " | " + input);
		System.out.println( "Result BInary >> " + Integer.toBinaryString( result ) +
				" | " + result );
	}

	private static int findClosestByFlippingBits(int input) {
		int result = 0;
		int inputHolder = input;
		int firstBit = 0;
		int secondBit = 0;
		int counter = 0;
		
		do {
			firstBit = inputHolder >> counter++;
			System.out.println( "firstBit BInary >> " + Integer.toBinaryString( firstBit ) );
			secondBit = inputHolder >> counter;
			System.out.println( "secondBit BInary >> " + Integer.toBinaryString( secondBit ) );

		} while( (firstBit & 1) == (secondBit & 1) );
		int mask = 1 << counter | 1 << --counter;
		result = input ^ mask;
		return result;
	}

}
