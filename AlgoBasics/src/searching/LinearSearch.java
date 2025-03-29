package searching;

public class LinearSearch {

	public static void main(String[] args) {
		int[] intList = { 1, 3, 56, 32, 33, 23, 67, 45, 43, 54, 52 };
		int targetElement = 43;
		linearSearch( intList, targetElement );
	}

	private static void linearSearch(int[] intList, int targetElement) {
		
		for(int i = 0; i < intList.length; i++) {
		
			if( intList[ i ] == targetElement ) {
				System.out.println( "Target Foun at index : " + i );
				return;
			}
		}
		System.out.println( "Target Not Found." );
	}

}
