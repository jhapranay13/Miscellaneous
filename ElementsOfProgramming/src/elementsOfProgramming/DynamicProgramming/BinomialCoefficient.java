package elementsOfProgramming.DynamicProgramming;

//how many ways in which k is selected from n.
//So if n is less than k ways.
public class BinomialCoefficient {

	public static void main(String[] args) {
		int n = 5;
		int k = 2;
		int result = binomialCoefficientRecursive( n, k );
		System.out.println( result );
		result = binomialCoefficientDP(n, k);
		System.out.println( result );
	}

	private static int binomialCoefficientDP(int n, int k) {
		int table[][] = new int[ n + 1][ k + 1 ];
		
		// Base Cases 
		for (int i = 0; i <= k; i++) {
			table[i][i] = 1;
		}
		
		for (int i = 0; i <= n; i++) {
			table[i][0] = 1;
		}

		for(int i = 1 ; i <= n; i++ ) {

			for(int j = 1 ; j <= k; j++ ) {
				table[i][j] = table[i-1][j-1] + table[i-1][j]; 
			}
			printTable(table);
		}
		return table[ n ][ k ];
	}

	private static int binomialCoefficientRecursive(int n, int k) {

		if( k == 0 || k == n ) {
			return 1;
		}
		return binomialCoefficientRecursive(n - 1, k - 1) + // taking both the elements
				binomialCoefficientRecursive(n - 1, k);    //Skipping this element
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
