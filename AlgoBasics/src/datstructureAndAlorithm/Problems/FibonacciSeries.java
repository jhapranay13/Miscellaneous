package datstructureAndAlorithm.Problems;

public class FibonacciSeries {

	public static void main(String[] args) {
		int n = 7;
		int nthFibonacci = calculateFibonacciRecursion( n );
		System.out.println( nthFibonacci );
		nthFibonacci = calculateFibonacciTopDown( n );
		System.out.println( nthFibonacci );
		nthFibonacci = calculateFibonacciBottomUP( n );
		System.out.println( nthFibonacci );
	}

	private static int calculateFibonacciBottomUP(int n) {
		int arr[] = new int[ n ];
		
		for( int i = 0; i < arr.length; i++ ) {
			
			if( i == 0 || i == 1 ) {
				arr[ i ] = 1;
				continue;
			}
			arr[ i ]= arr[ i - 1 ] + arr[ i  - 2 ];
		}
		return arr[ n - 1 ];
	}

	private static int calculateFibonacciTopDown(int n) {
		int[] arr = new int[ n ];
		return calculateFibonacciTopDown( n, arr );
	}

	private static int calculateFibonacciTopDown(int n, int[] arr) {
		
		if( n <= 0 ) {
			return 0;
		} else if( n == 1 ) {
			return 1;
		} 
		
		if( arr[ n - 1 ] >= 1 ) {
			return arr[ n - 1 ];
		}
		return arr[ n - 1 ] = calculateFibonacciTopDown(n - 1, arr) + 
				calculateFibonacciTopDown( n - 2, arr);
	}

	private static int calculateFibonacciRecursion(int n) {
		
		if( n <= 0 ) {
			return 0;
		} else if( n == 1 ) {
			return 1;
		}
		return calculateFibonacciRecursion( n - 1 ) +
				calculateFibonacciRecursion( n - 2 );
	}

}
