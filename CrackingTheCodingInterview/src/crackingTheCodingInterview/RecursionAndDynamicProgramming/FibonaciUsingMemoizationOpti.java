package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class FibonaciUsingMemoizationOpti {

	public static void main(String[] args) {
		int fibonacciNumber = 8;
		printFibonaaci( fibonacciNumber );
	}

	private static void printFibonaaci(int fibonacciNumber) {
		int first = 1;
		int second = 2;
		
		for( int i = 2; i < fibonacciNumber; i++ ) {
			int fibVal = first + second;
			System.out.println( fibVal );
			first = second;
			second = fibVal;
		}
	}
}
