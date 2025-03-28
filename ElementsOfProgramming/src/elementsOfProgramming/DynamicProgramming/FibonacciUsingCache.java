package elementsOfProgramming.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class FibonacciUsingCache {
	
	private static Map< Integer, Integer > fibonacciCache = new HashMap<>();
	
	public static void main(String[] args) {
		int numberOfFibonacci = 6;
		int result = calculateFibonacci( numberOfFibonacci );
		System.out.println( result );
	}

	private static int calculateFibonacci(int numberOfFibonacci) {
		
		if( numberOfFibonacci <= 1 ) {
			return 1;
		} else {
			
			if( !fibonacciCache.containsKey( numberOfFibonacci ) ) {
				fibonacciCache.put( numberOfFibonacci , calculateFibonacci(numberOfFibonacci - 1) + 
						calculateFibonacci(numberOfFibonacci - 2));
			}
		}
		return fibonacciCache.get(numberOfFibonacci);
	}

}
