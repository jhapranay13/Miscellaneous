package elementsOfProgramming.DynamicProgramming;

public class LevenshtienDistance {

	public static void main(String[] args) {
		String string1 = "abcdef";
		String string2 = "azced";
		int result = editDistanceRecursive(string1, string2);
		System.out.println( result );
		
		int[][] table = new int[ string2.length() + 1 ][ string1.length() + 1 ];
		result = editDistanceDP( string1, string2, table );
		System.out.println( result );
		analyzeTable( table, string1, string2 );
	}

	private static void analyzeTable(int[][] table, String string1, String string2) {
		int index1 = table.length - 1;
		int index2 = table[ 0 ].length - 1;
		
		while( index1 != 0 && index2 != 0 ) {
			
			//check if it is coming for diagonal and are not same that means conversion
			//if moving diagonal and value is same do nothing.
			if( table[ index1 ][ index2 ] == table[ index1 - 1 ][ index2 - 1 ] + 1  && 
					string1.charAt( index2 - 1 ) != string2.charAt(index1 - 1 ) ) {
				System.out.println( "Substitute " + string1.charAt( index2 - 1 ) + " -> " + 
						string2.charAt(index1 - 1 ) );
				index1--;
				index2--;
				continue;
			} else if( table[ index1 ][ index2 ] == table[ index1 - 1 ][ index2 - 1 ]  && 
					string1.charAt( index2 - 1 ) == string2.charAt(index1 - 1 ) ) {
				index1--;
				index2--;
				continue;
			}
 			
			//Moving left MEans delete this
			if( table[ index1 ][ index2 ] == table[ index1 ][ index2 - 1 ] + 1 ) {
				System.out.println( "Deleted -> " + string1.charAt(index2 - 1)  );
				index2--;
			}
		}
	}

	private static int editDistanceDP(String string1, String string2, int[][] table) {
		
		for( int i = 0; i <= string1.length(); i++ ) {
			table[ 0 ][ i ] = i;
		}
		
		for( int i = 0; i <= string2.length(); i++ ) {
			table[ i ][ 0 ] = i;
		}
		//two for loops for each charachter to demarcate the moves neede to change from row string
		//to column string
		
		for( int i = 1; i <= string2.length(); i++ ) {
			
			for( int j = 1; j <= string1.length(); j++ ) {
				
				if( string1.charAt( j - 1 ) == string2.charAt( i - 1 ) ) {
					table[ i ][ j ] = table[ i - 1 ][ j - 1 ];
				} else {
					int minimumVal = getMinimumValue( table, i, j );
					table[ i ][ j ] = minimumVal + 1;

				}
			}
		}
		printTable(table);
		return table[ string2.length() ][ string1.length() ];
	}

	private static int getMinimumValue(int[][] table, int i, int j) {
		int val1 = table[ i -1 ][ j ];
		int val2 = table[ i - 1 ][ j - 1 ];
		int val3 = table[ i ][ j - 1 ];
		//getting the minimum of 1 above and same row and diagnol;
		return Math.min( val1 , Math.min( val2 , val3 ) );
	}

	private static int editDistanceRecursive(String string1, String string2) {
		
		if( string1.isEmpty() ) {
			return string2.length();
		}
		
		if( string2.isEmpty() ) {
			return string1.length();
		}
		
		int substitution = editDistanceRecursive(string1.substring(1), string2.substring(1) ) + 
				costOfSubstitution( string1.charAt(0) , string2.charAt(0));
		int insertion = editDistanceRecursive(string1, string2.substring(1)) + 1;
		int deletion = editDistanceRecursive(string1.substring(1), string2) + 1;
		
		return Math.min( substitution , Math.min( insertion , deletion));
	}

	private static int costOfSubstitution(char char1, char char2) {
		return char1 == char2 ? 0 : 1;
	}

	private static void printTable(int[][] table) {
		
		System.out.println("============================");
		for( int i = 0; i < table.length; i++ ) {
			
			for( int j = 0; j < table[ i ].length; j++ ) {
				System.out.print( table[ i ][ j ] + " " );
			}
			System.out.println();
		}
	}
}
