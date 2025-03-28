package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class FibonacciUsingTailRecursion {

	public static void main(String[] args) {
		int fibonacciNumber = 8;
		int fib = printFibonaaci( fibonacciNumber );
		System.out.println( fib );
	}

	private static int printFibonaaci(int fibonacciNumber) {
		
		if( fibonacciNumber == 0 || fibonacciNumber == 1 ) {
			return 1;
		}
		return printFibonaaci(fibonacciNumber - 1) + printFibonaaci(fibonacciNumber - 2);
	}

}
