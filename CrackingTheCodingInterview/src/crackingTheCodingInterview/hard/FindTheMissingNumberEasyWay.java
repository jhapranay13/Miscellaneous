package crackingTheCodingInterview.hard;

public class FindTheMissingNumberEasyWay {

	public static void main(String[] args) {
		int [] arr = { 1, 2, 3, 5, 6, 7, 8 };
		int missingNumber = findMissingNumber( arr );
		System.out.println( missingNumber );
	}

	private static int findMissingNumber(int[] arr) {
		int normalSum = 0;
		
		for( int i = 0; i <= arr[ arr.length - 1 ]; i++ ) {
			normalSum += i;
		}
		int arrSum = 0;
		
		for( int i = 0; i < arr.length; i++ ) {
			arrSum += arr[ i ];
		}
		return normalSum - arrSum;
	}

}
