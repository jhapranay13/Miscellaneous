package elementsOfProgramming.primitive;

public class SwapBits {

	public static void main(String[] args) {
		int word = 49;
		System.out.println( Integer.toBinaryString( word ) );
		int swappedWord = swapBits( 1, 4, word );
		System.out.println( Integer.toBinaryString( swappedWord ) );
	}

	private static int swapBits(int positionOne, int positionTwo, int word) {
		int result = 0;
		int maskPositionOne = 1 << positionOne;
		int maskPositionTwo = 1 << positionTwo;
		int mainMask = maskPositionOne | maskPositionTwo;
		result = word ^ mainMask;
		return result;
	}

}
