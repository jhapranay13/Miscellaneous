package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class GeneratePrime {

	public static void main(String[] args) {
		int number = 10;
		printPrimes( number );
	}

	private static void printPrimes(int number) {
		boolean[] isPrime = new boolean[ number + 1 ];
		System.out.println( Arrays.toString( isPrime ) );
		Arrays.fill( isPrime, true);
		isPrime[ 0 ] = false;
		isPrime[ 1 ] = false;
		
		for( int i = 2; i <= number; i++  ) {
			
			if( isPrime[ i ] ) {
				
				for( int j = i + i; j <= number; j += i ) {
					isPrime[ j ] = false;
				}
			}
		}
		
		for( int i = 0; i < isPrime.length; i++  ) {
			System.out.println( "Number >> " + i + " || Is a Prime >> " + isPrime[ i ] );
		}
	}
}
