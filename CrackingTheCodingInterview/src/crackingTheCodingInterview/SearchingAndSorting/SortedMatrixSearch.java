package crackingTheCodingInterview.SearchingAndSorting;

public class SortedMatrixSearch {

	public static void main(String[] args) {
		int arr[][] = {
				{ 15, 20, 40, 85 },
				{ 20, 35, 80, 95 },
				{ 30, 55, 95, 105 },
				{ 40, 80, 100, 120 }
		};
		int numberToFind = 100;
		findAndPrintCoordinate( arr, numberToFind );
	}

	private static void findAndPrintCoordinate(int[][] arr, int numberToFind) {
		int startRow = 0;
		int startCol = 0;
		int index = -1;
		
		while( startRow < arr.length && startCol < arr[ 0 ].length ) {
			
			if( arr[ startRow ][ startCol ] < numberToFind ) {
				startRow++;
				startCol++;
				continue;
			}
	
			if( arr[ startRow ][ 0 ] < numberToFind ) {
				index = binarySearchRow( arr, startRow, startCol, numberToFind );
			}
			
			if( index != -1 ) {
				System.out.println( "Found at " + startRow + ", " + index );
				break;
			}
			
			if( arr[ 0 ][ startCol ] < numberToFind && index == -1 ) {
				index = binarySearchCol( arr, startRow, startCol, numberToFind );
			}
			
			if( index != -1 ) {
				System.out.println( "Found at " + index + ", " + startCol );
				break;
			}
		}
	}

	private static int binarySearchCol(int[][] arr, int startRow, int startCol, int numberToFind) {
		int returnVal = -1;
		int hi = startRow;
		int lo = 0;
		int pivot = lo + ( hi - lo ) / 2;
		
		while( lo < pivot ) {
			
			if( arr[ hi ][ startCol ] == numberToFind ) {
				returnVal = hi;
				break;
			}
			
			if( arr[ lo ][ startCol ] == numberToFind ) {
				returnVal = lo;
				break;
			}
			
			if( arr[ pivot ][ startCol ] > numberToFind ) {
				hi = pivot;
			} else if ( arr[ pivot ][ startCol ] < numberToFind ) {
				lo = pivot;
			} else {
				returnVal = pivot;
				break;
			}
			pivot = lo + ( hi - lo ) / 2;
		}
		return returnVal;
	}

	private static int binarySearchRow(int[][] arr, int startRow, int startCol, int numberToFind) {
		int returnVal = -1;
		int hi = startCol;
		int lo = 0;
		int pivot = lo + ( hi - lo ) / 2;
		
		while( lo < pivot ) {
			
			if( arr[ startRow ][ hi ] == numberToFind ) {
				returnVal = hi;
				break;
			}
			
			if( arr[ startRow ][ lo ] == numberToFind ) {
				returnVal = lo;
				break;
			}
			
			if( arr[ startRow ][ pivot ] > numberToFind ) {
				hi = pivot;
			} else if ( arr[ startRow ][ pivot ] < numberToFind ) {
				lo = pivot;
			} else {
				returnVal = pivot;
				break;
			}
			pivot = lo + ( hi - lo ) / 2;
		}
		return returnVal;
	}
}
