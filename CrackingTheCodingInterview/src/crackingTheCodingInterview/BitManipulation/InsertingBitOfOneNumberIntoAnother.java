package crackingTheCodingInterview.BitManipulation;

public class InsertingBitOfOneNumberIntoAnother {

	public static void main(String[] args) {
		System.out.println( Integer.toBinaryString( 2048 ) );
		System.out.println( Integer.toBinaryString( 29 ) );
		int firstBit = 2048;
		int secondBit = 29;

		int result = insertSecondIntoFirstInPosition( firstBit, secondBit, 3, 8 );
		System.out.println( result );
		System.out.println( Integer.toBinaryString( result ) );
	}

	private static int insertSecondIntoFirstInPosition(int firstBit, int secondBit, 
			int endPos, int startPos) {
		int returnVal = 0;
		int allOne = ~0;
		int leftAllOne = allOne << ( startPos + 1 );
		System.out.println( "ALL ONE AFTER LEFT POS >> " + Integer.toBinaryString( leftAllOne ) );
		int rightAllOneToIntitalPos = ( ( 1 << endPos) - 1 );
		System.out.println( "RIGHT ALL ONE TO RIGHT POS >> " + Integer.toBinaryString( rightAllOneToIntitalPos ) );
		int mask = leftAllOne | rightAllOneToIntitalPos;
		System.out.println( Integer.toBinaryString( mask ) );
		
		int clearedBits = firstBit & mask;
		System.out.println( "CLEARED BIT >> " + Integer.toBinaryString( clearedBits ) );
		int secondBitCorrectPosition = secondBit << endPos;
		System.out.println(  "SECOND BIT MOVED TO CORRECT POS >> " + 
				Integer.toBinaryString( secondBitCorrectPosition ) );
		returnVal = clearedBits | secondBitCorrectPosition;
		return returnVal;
	}

}
