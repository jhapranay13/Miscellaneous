package crackingTheCodingInterview.BitManipulation;

public class FlipOneBitToFindGreatestSequence {

	public static void main(String[] args) {
		int input = 1775;
		System.out.println( "BINARY REP OF INPUT >> " + Integer.toBinaryString( input ) );
		int greatestSeq = findGreatestSeqByFlippingOneBit( input );
		System.out.println( "Greatest Sequence >> " + greatestSeq );
	}

	private static int findGreatestSeqByFlippingOneBit(int input) {	
		int currentSum = 0; 
		int previousSum = 0;
		int zeroCounter = 0;
		int maxVal = 0;
		
		for( int  i = 0; i < Integer.BYTES * 8; i++ ) {
			int mask = 1 << i;
			int currentBitVal = ( input & mask ) == 0 ? 0 : 1;
			
			if( currentBitVal == 0 && currentSum == 0 ) {
				continue;
			} else if( currentBitVal == 1 && zeroCounter == 0 ){
				currentSum++;
			} else if( currentBitVal == 1 && zeroCounter == 1  ) {
				previousSum++;
			} else if( currentBitVal == 0 && zeroCounter == 1 && currentSum > 0 && previousSum > 0 ) {
				maxVal = ( currentSum + previousSum ) > maxVal ? 
						( currentSum + previousSum ) : maxVal;
				currentSum = 0;
				zeroCounter = 0;
			} else {
				zeroCounter++;
			}
		}	
		return maxVal + 1;
	}
}
