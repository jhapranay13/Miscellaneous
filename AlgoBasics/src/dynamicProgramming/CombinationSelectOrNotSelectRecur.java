package dynamicProgramming;

import java.util.HashSet;

public class CombinationSelectOrNotSelectRecur {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8 };
		int k = 3;
		printCombination( arr, new HashSet<Integer>(), k, 0 );
	}

	private static void printCombination(int[] arr, HashSet<Integer> partial, int k, 
			int start) {
		
		if( partial.size() == k ) {
			System.out.println( partial );
			return;
		}
		
		if( k < start ) {
			return;
		}
		
		partial.add( arr[ start ] );
		printCombination(arr, partial, k, start + 1);
		partial.remove( arr[ start ] );
		printCombination(arr, partial, k, start + 1);
	}
}
