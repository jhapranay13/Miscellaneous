package crackingTheCodingInterview.hard;

public class CountNumberOfTwoForAGivenRangeOfNumber {

	public static void main(String[] args) {
		int upperRange = 30;
		int numberOfTwo = count( upperRange );
		System.out.println( numberOfTwo );
	}

	private static int count(int upperRange) {
		int totalCount = 0;
		
		for( int i = 2; i <= upperRange; i++ ) {
			totalCount += countNumberOfTwo( i );
		}
		return totalCount;
	}

	private static int countNumberOfTwo(int number) {
		int counter = 0;
				
		while( number != 0 ) {
			
			if( number % 10 == 2 ) {
				counter++;
			}
			number /= 10;
		}
		return counter;
	}

}
