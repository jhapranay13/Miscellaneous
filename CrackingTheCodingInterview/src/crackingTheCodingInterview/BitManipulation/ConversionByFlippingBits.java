package crackingTheCodingInterview.BitManipulation;

public class ConversionByFlippingBits {

	public static void main(String[] args) {
		int firstInput = 29;
		int secondInput = 15;
		int numberOfBitsToFlip = getNumberOfBitsToFlipToConvertFirstToSecond( firstInput,
				secondInput );
		System.out.println( numberOfBitsToFlip );
	}

	private static int getNumberOfBitsToFlipToConvertFirstToSecond(int firstInput, int secondInput) {
		int differentBits = firstInput ^ secondInput;
		System.out.println( Integer.toBinaryString( firstInput ) );
		System.out.println( Integer.toBinaryString( secondInput ) );
		System.out.println( Integer.toBinaryString( differentBits ) );
		
		int differenceCounter = 0;
		
		//for (int c = a Ab; c != 0; c = c & (c-1)) can also be used.
		for( int i = differentBits; i != 0; i = i >> 1 ) {
			System.out.println( Integer.toBinaryString( i ) );
			differenceCounter += i & 1;
		}
		return differenceCounter;
	}
}
