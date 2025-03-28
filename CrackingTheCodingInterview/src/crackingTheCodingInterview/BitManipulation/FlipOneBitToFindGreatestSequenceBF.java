package crackingTheCodingInterview.BitManipulation;

import java.util.Arrays;

public class FlipOneBitToFindGreatestSequenceBF {

	public static void main(String[] args) {
		int input = 1775;
		System.out.println( "BINARY REP OF INPUT >> " + Integer.toBinaryString( input ) );
		int greatestSeq = findGreatestSeqByFlippingOneBit( input );
		System.out.println( "Greatest Sequence >> " + greatestSeq );
	}

	private static int findGreatestSeqByFlippingOneBit(int input) {
		int arr[] = new int[ 32 ];
		
		for( int i = 0; i < arr.length; i++ ) {
			int mask = 1 << i;
			//System.out.println( Integer.toBinaryString( mask ) );
			int bitAtPos = input & mask;
			//System.out.println( Integer.toBinaryString( bitAtPos ) );
			
			if( bitAtPos >= 1 ) {
				arr[ i ] = 1;
			}
		}
		System.out.println( Arrays.toString( arr ) );
		int currentSum = 0; 
		int previousSum = 0;
		int zeroCounter = 0;
		int maxVal = 0;
		
		for( int  i = 0; i < arr.length; i++ ) {
			
			if( arr[ i ] == 0 && currentSum == 0 ) {
				continue;
			} else if( arr[ i ] == 1 && zeroCounter == 0 ){
				currentSum++;
			} else if( arr[ i ] == 1 && zeroCounter == 1  ) {
				previousSum++;
			} else if( arr[ i ] == 0 && zeroCounter == 1 && currentSum > 0 && previousSum > 0 ) {
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
