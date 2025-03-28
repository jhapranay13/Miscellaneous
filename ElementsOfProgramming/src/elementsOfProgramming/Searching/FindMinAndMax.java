package elementsOfProgramming.Searching;

public class FindMinAndMax {

	public static void main(String[] args) {
		int arr[] = { 3, 2, 5, -1, 2, 4 , 7};
		printMinAndMax( arr );
	}

	private static void printMinAndMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for( int i = 0; i + 1 < arr.length; i += 2 ) {
			
			if( i == 0 ) {
				min = arr[ i ] < arr[ i + 1 ] ? arr[ i ] : arr[ i + 1 ];
				max = arr[ i ] > arr[ i + 1 ] ? arr[ i ] : arr[ i + 1 ];
			}
			
			if( arr[ i ] < arr[ i + 1 ] ) {
				min = min < arr[ i ] ? min : arr[ i ];
				max = max > arr[ i + 1 ] ? max : arr[ i + 1 ];
			} else {
				min = min < arr[ i + 1 ] ? min : arr[ i + 1 ];
				max = max > arr[ i ] ? max : arr[ i ];
			}
		}
		
		if( arr.length % 2 != 0 ) {

			min = min < arr[ arr.length - 1 ] ? min : arr[ arr.length - 1 ];
			max = max > arr[ arr.length - 1 ] ? max : arr[ arr.length - 1  ];
		}
		
		System.out.println( "MIN - MAX >> " + min + " - " + max  );
	}

}
