package elementsOfProgramming.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

//Will give distinct values. i.e it does not compute the permutation of steps.
//So all result sets are unique
public class NumberOfWaysToReachAScore {

	public static void main(String[] args) {
		int[] score = { 2, 3, 7 };
		int finalScore = 12;
		int numberOfWays = caluclateNumberOfWaysDP( score, finalScore );
		System.out.println( numberOfWays );
		ArrayList< Integer > partialScore = new ArrayList<>();
		calculateNumberOfWaysRecursion( score, finalScore, 0, partialScore, 0 );
	}

	private static void calculateNumberOfWaysRecursion(int[] score, int finalScore, 
			int partialCalculation, ArrayList<Integer> partialScore, int currentIndex ) {
		
		if( finalScore == partialCalculation ) {
			System.out.println( Arrays.toString( partialScore.toArray() ) );
		} 
		
		if( finalScore < partialCalculation  ) {
			return;
		}
		
		for( int i = currentIndex; i < score.length; i++ ) {
			partialScore.add( score[ i ] );
			calculateNumberOfWaysRecursion(score, finalScore, 
					partialCalculation + score[ i ], partialScore, i );
			partialScore.remove( partialScore.size() - 1 );
		}
	}

	//Single Dimension Array Can also be utilized to do this.
	private static int caluclateNumberOfWaysDP(int[] score, int finalScore) {
		int table[][] = new int[ score.length ][ finalScore + 1 ];
		
		for( int i = 0; i < table.length; i++ ) {
			table[ i ][ 0 ] = 1;
		}
		
		for( int i = 0; i < score.length; i++ ) {
			
			for( int j = 0; j <= finalScore; j++ ) {
				
				if( i == 0 ) {
					
					if( j >= score[ i ]  ) {
						table[ i ][ j ] = table[ i ][ j ] + table[ i ][ j - score[ i ] ];
					}	
				} else {
					
					if( j < score[ i ]  ) {
						table[ i ][ j ] = table[ i - 1 ][ j ];
						continue;
					}
					table[ i ][ j ] = table[ i - 1 ][ j ] + table[ i ][ j - score[ i ] ];
				}
			}
		}
		printTable(table);
		return table[ score.length -1 ][ table[ 0 ].length - 1 ];
	}

	private static void printTable(int[][] table) {
		
		for( int i = 0; i < table[ 0 ].length; i++ ) {
			System.out.print( i + " " );
		}
		System.out.println();
		System.out.println("============================");
		for( int i = 0; i < table.length; i++ ) {
			
			for( int j = 0; j < table[ i ].length; j++ ) {
				System.out.print( table[ i ][ j ] + " " );
			}
			System.out.println();
		}
	}

}
