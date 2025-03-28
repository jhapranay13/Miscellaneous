package crackingTheCodingInterview.SearchingAndSorting;

public class SparsedSearch {

	public static void main(String[] args) {
		//Sorted and sparsed String
		String[] arr = { "", "at", "", "", "", "ball", "", "", "car", "", "", 
				"", "dad", "" ,"" };
		String termoToSearch = "car";
		int index = modifiedBinarySearch( arr, termoToSearch );

		if( index != -1 ) {
			System.out.println( "Index for " + termoToSearch + " found at index " + index );
		} else {
			System.out.println( "Not found" );
		}
	}

	private static int modifiedBinarySearch(String[] arr, String termoToSearch) {
		int hi = arr.length - 1;
		int lo = 0;

		while( arr[ hi ].trim().equals("") ) {
			hi--;
		}

		while( arr[ lo ].trim().equals("") ) {
			lo++;
		}

		int pivot = lo + ( hi - lo ) / 2;

		while( lo != pivot ) {

			if( arr[ pivot ].trim().equals("") ) {
				int leftIndexPivot = pivot - 1;
				int rightIndexPivot = pivot;
				int leftCounter = 0;

				while( leftIndexPivot >= lo && arr[ leftIndexPivot ].trim().equals("") ) {
					leftIndexPivot--;
					leftCounter++;
				}
				int rightCounter = 0;

				while( rightIndexPivot <= hi && arr[ rightIndexPivot ].trim().equals("") ) {
					rightIndexPivot++;
					rightCounter++;
				}
				pivot = leftCounter > rightCounter ? rightIndexPivot : leftIndexPivot;
			}
			if( termoToSearch.compareTo( arr[ pivot ] ) < 0 ) {
				hi = pivot;
			} else if( termoToSearch.compareTo( arr[ pivot ] ) > 0 ) {
				lo = pivot;
			} else {
				return pivot;
			}
			pivot = lo + ( hi - lo ) / 2;

		}
		return -1;
	}

}
