package elementsOfProgramming.Searching;

public class SearchAKeyInShiftedArray {

	public static void main(String[] args) {
		int[] arr = { 378, 478, 550, 631, 1103, 1203, 220, 234, 279, 368 };
		int indexKey = getIndexForKey( arr, 234 );
		System.out.println( "Index key >> " + indexKey );
	}

	private static int getIndexForKey(int[] arr, int key) {
		int returnIndex = -1;
		int lo = 0;
		int hi = arr.length - 1;
		
		while( lo <= hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			
			if( arr[ pivot ] == key ) {
				returnIndex = pivot;
				break;
			}
			
			if( ( key > arr[ pivot ] && key > arr[ lo ] ) || 
					( key < arr[ pivot ] && key > arr[ lo ] ) ) {
				hi = pivot + 1;
			} else {
				lo = pivot;
			}
		}	
		return returnIndex;
	}

}
