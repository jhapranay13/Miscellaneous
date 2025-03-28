package elementsOfProgramming.primitive;

public class IfANumberIsPalindrome {

	public static void main(String[] args) {
		int input = 153351;
		boolean isPalindromeFlag = checkIfPalindrome( input );
		System.out.println( isPalindromeFlag );
	}

	private static boolean checkIfPalindrome(int input) {
		boolean returnFlag = false;
		int reversedNumber = numberReverse( input );
		
		if( reversedNumber == input ) {
			returnFlag = true;
		}
		return returnFlag;
	}

	private static int numberReverse(int input) {
		int returnNumber = 0;
		int powerOf10 = 10;
		
		while( input != 0 ) {
			int temp = input % 10;
			returnNumber *= powerOf10;
			returnNumber += temp;
			input /= 10;
		}
		return returnNumber;
	}

}
