package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class FibonaciUsingMemoization {

	public static void main(String[] args) {
		int fibonacciNumber = 8;
		printFibonaaci( fibonacciNumber );
	}

	private static void printFibonaaci(int fibonacciNumber) {
		int[] holder = new int[ fibonacciNumber ];
		holder[ 0 ] = 1;
		holder[ 1 ] = 2;
		System.out.println( holder[ 0 ] );
		System.out.println( holder[ 1 ] );
		
		for( int i = 2; i < holder.length; i++ ) {
			holder[ i ] = holder[ i - 1 ] + holder[ i - 2 ];
			System.out.println( holder[ i ] );
		}
	}

}
