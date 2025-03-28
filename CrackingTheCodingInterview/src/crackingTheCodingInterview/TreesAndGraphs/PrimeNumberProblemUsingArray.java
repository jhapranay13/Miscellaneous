package crackingTheCodingInterview.TreesAndGraphs;

public class PrimeNumberProblemUsingArray {

	public static void main(String[] args) {
		int input = 56;
		printAllPrimes( input );
	}

	private static void printAllPrimes(int input) {
		boolean[] resultHolder = new boolean[ input + 1 ];
		
		int numberofLoops = input / 2;
		
		for( int i = 2; i < numberofLoops; i++ ) {
			int number = i;
			int counter = 2;
			int multiple = 0;
			
			while( multiple <= input ) {
				multiple  = number * counter++;

				if( multiple <= input ) {
					resultHolder[ multiple ] = true;
				}
			}
		}
		
		for( int i = 1; i < resultHolder.length; i++) {
			
			if( !resultHolder[ i ] ) {
				System.out.println( i );
			}
		}   
	}

}
