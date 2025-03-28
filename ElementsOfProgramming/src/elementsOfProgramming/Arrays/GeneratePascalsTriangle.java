package elementsOfProgramming.Arrays;

public class GeneratePascalsTriangle {

	public static void main(String[] args) {
		int numberOfRows = 5;
		int[][] pascalsTriangle = generatePascalsTriangle( numberOfRows );
		
		for( int i = 0; i < pascalsTriangle.length; i++ ) {

			for( int j = 0; j < pascalsTriangle[ i ].length; j++ ) {
				System.out.print( pascalsTriangle[ i ][ j ] + " " );
			}
			System.out.println();
		}
	}

	private static int[][] generatePascalsTriangle(int numberOfRows) {
		int[][] pascalsTriangle = new int[ numberOfRows ][];

		for( int i = 1; i <= numberOfRows; i++ ) {
			pascalsTriangle[ i - 1 ] = new int[ i ];
		}

		for( int i = 1; i <= numberOfRows; i++ ) {

			if( i == 1 ) {
				pascalsTriangle[ i - 1 ][ i - 1 ] = 1;
				continue;
			}

			if( i == 2 ) {
				pascalsTriangle[ i - 1 ][ i - 2 ] = 1;
				pascalsTriangle[ i - 1 ][ i - 1 ] = 1;
				continue;
			}
			
			for( int j = 0; j < pascalsTriangle[ i - 1].length - 1; j++ ) {
				
				if( j == 0 ) {
					pascalsTriangle[ i - 1 ][ j ] = 1;
					pascalsTriangle[ i - 1 ][ pascalsTriangle[i - 1].length - 1 ] = 1;
					continue;
				}
				
				pascalsTriangle[ i - 1 ][ j ] = pascalsTriangle[ i - 2 ][ j - 1 ] +
						pascalsTriangle[ i - 2 ][ j ];
			}
		}
		return pascalsTriangle;
	}
}
