package elementsOfProgramming.HashTables;

import java.util.HashSet;
import java.util.Set;

public class MaxIntervalSize {

	public static void main(String[] args) {
		int arr[] = { 3, -2, 7, 9, 8, 1, 2, 0, -1, 5 ,8 };
		printMaximumInterval( arr );
	}

	private static void printMaximumInterval(int[] arr) {
		int maximumInterval = 0;
		Set< Integer > entries = new HashSet<>();
		
		for( int i = 0; i < arr.length; i++ ) {
			entries.add( arr[ i ] );
		}
		
		while( !entries.isEmpty() ) {
			int val = entries.iterator().next();
			entries.remove( val );
			int lowerThan = val - 1;
			
			while( entries.contains( lowerThan ) ) {
				entries.remove( lowerThan );
				lowerThan--;
			}
			int heigherThan = val + 1;
			
			while( entries.contains( heigherThan ) ) {
				entries.remove( heigherThan );
				heigherThan++;
			}
			maximumInterval = Math.max( maximumInterval , heigherThan - lowerThan - 1 );
		}
		
		System.out.println( maximumInterval );
	}

}
