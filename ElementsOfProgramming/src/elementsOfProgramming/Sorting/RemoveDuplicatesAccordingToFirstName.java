package elementsOfProgramming.Sorting;

public class RemoveDuplicatesAccordingToFirstName {

	public static void main(String[] args) {
		String[][] fullNames = { 
				{ "Ian", "Bell" },
				{ "Ian", "Chappel" },
				{ "Greg", "Norman" },
				{ "James", "Anderson" },
				{ "Ian", "Botham" },
		};
		String[][] duplicateRemoved = removeDuplicates( fullNames );
		
		for( int i = 0; i < duplicateRemoved.length; i++ ) {
			System.out.println( duplicateRemoved[ i ][ 0 ] + ", " +  
				duplicateRemoved[ i ][ 1 ] );
		}
	}

	private static String[][] removeDuplicates(String[][] fullNames) {
		sort( fullNames );
		String[][] fullNamesWithoutDuplicate = new String[ fullNames.length ][ 2 ];
		
		for( int i = 1; i < fullNames.length ; i++ ) {
			
			if( fullNames[ i ][ 0 ].equals( fullNames[ i - 1 ][ 0 ] ) ) {
				
				if( i == fullNames.length - 1 ) {
					fullNamesWithoutDuplicate[ i ] = fullNames[ i ];
				}
				continue;
			}
			fullNamesWithoutDuplicate[ i - 1 ] = fullNames[ i - 1 ];
		}
		return fullNamesWithoutDuplicate;
	}

	private static void sort(String[][] fullNames) {
		int hi = fullNames.length - 1;
		int lo = 0;
		mergeSort( fullNames, hi ,lo );
	}

	private static void mergeSort(String[][] fullNames, int hi, int lo) {

		if( lo < hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			mergeSort(fullNames, hi, pivot + 1);
			mergeSort(fullNames, pivot, lo);
			merge( fullNames, hi, pivot, lo );
		}
	}

	private static void merge(String[][] fullNames, int hi, int pivot, int lo) {
		String[][] helper = new String[ fullNames.length ][ fullNames[ 0 ].length ];
		int startMarker = lo;
		
		while( hi > lo ) {
			
			if( fullNames[ hi ][ 0 ].compareTo( fullNames[ lo ][ 0 ] ) == -1  ) {
				helper[ startMarker++ ] = fullNames[ hi-- ]; 
			} else if( fullNames[ hi ][ 0 ].compareTo( fullNames[ lo ][ 0 ] ) == 1  ) {
				helper[ startMarker++ ] = fullNames[ lo++ ]; 
			} else {
				helper[ startMarker++ ] = fullNames[ hi-- ];
				helper[ startMarker++ ] = fullNames[ lo++ ];
			}
		}
		
		while( lo <= pivot ) {
			helper[ startMarker++ ] = fullNames[ lo++ ];  
		}
		
		while( hi > pivot ) {
			helper[ startMarker++ ] = fullNames[ hi-- ];  
		}
	
		for( int i = 0; i < fullNames.length; i++ ) {
			
			if( helper[ i ][ 0 ] != null ) {
				fullNames[ i ] = helper[ i ];
			}	
		}
	}
}
