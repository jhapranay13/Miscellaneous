package elementsOfProgramming.primitive;

public class ParityOfAWord {

	//Parity if number of 1's in the bit is odd
	public static void main(String[] args) {
		long word = 34;
		boolean parityFlag = checkParity( word );
		System.out.println( parityFlag );
	}

	private static boolean checkParity(long word) {
		int counter = 0;
		
		for( long i = word; i > 0; i = i >> 1 ){
			long mask = 1;
			long result = i & mask;
			
			if( result > 0 ) {
				counter++;
			}
		}
		
		if( counter % 2 == 0 ) {
			return false;
		}
		return true;
	}
}
