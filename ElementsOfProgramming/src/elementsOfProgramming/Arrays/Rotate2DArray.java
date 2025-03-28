package elementsOfProgramming.Arrays;

public class Rotate2DArray {

	public static void main(String[] args) {
		
		  int arr[][] = { 
				  { 1, 2, 3, 4 }, 
				  { 5, 6, 7, 8 }, 
				  { 9, 10, 11, 12 }, 
				  { 13, 14, 15, 16} 
		  };
		  rotateMatrix( arr );
		  
		  for( int i = 0; i < arr.length; i++ ) {
			  
			  for( int j = 0; j < arr.length; j++ ) {
				  System.out.print( arr[ i ][ j ] + " " );
			  }
			  System.out.println();
		  }
	}

	private static void rotateMatrix(int[][] arr) {
		int size = arr.length;
		int maxRow = size / 2;
		int startIndex = 0;
		int endIndex = size - 1;
		
		for( int i = 0; i < maxRow; i++ ) {
			
		}
	}

}
