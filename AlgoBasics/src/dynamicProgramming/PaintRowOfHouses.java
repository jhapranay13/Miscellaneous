package dynamicProgramming;

import java.util.Arrays;

enum Color {
	RED, BLUE, GREEN;
}

//Two consecutive houses cannot be of same color
public class PaintRowOfHouses {

	public static void main(String[] args) {
		int[][] costs = {
				{ 17, 2, 17},
				{ 16, 16, 5 },
				{ 14, 3, 9 }
		};
		int minCost = minCostRecur( costs );
		System.out.println( minCost );
		
		minCost = minCostMemo( costs );
		System.out.println( minCost );
		
		minCost = minCostDP( costs );
		System.out.println( minCost );
	}

	private static int minCostRecur(int[][] costs) {
		int minimumCost = Integer.MAX_VALUE;
		Color[] colorValue =  Color.values();

		for( int i = 0; i < costs.length; i++ ) {
			minimumCost = Math.min( minimumCost, 
					minCostRecur( costs, 0, colorValue[ i ] ) );
		}	
		return minimumCost;
	}

	private static int minCostRecur(int[][] costs, int index, Color color) {

		if( index == costs.length ) {
			return 0;
		}

		switch( color ) {

			case RED : {
				int costBlue = minCostRecur( costs, index + 1, color.GREEN );
				int costGreen =minCostRecur( costs, index + 1, color.BLUE );
				return costs[ index ][ color.ordinal() ] + 
						Math.min( costBlue , costGreen);
			}
			case BLUE : {
				int costRed = minCostRecur( costs, index + 1, color.GREEN );
				int costGreen =minCostRecur( costs, index + 1, color.RED );
				return costs[ index ][ color.ordinal() ] + 
						Math.min( costRed , costGreen);
			}
			case GREEN : {
				int costRed = minCostRecur( costs, index + 1, color.BLUE );
				int costBlue =minCostRecur( costs, index + 1, color.RED );
				return costs[ index ][ color.ordinal() ] + 
						Math.min( costRed , costBlue);
			}
		}
		return 0;
	}
	
	private static int minCostMemo(int[][] costs) {
		int memo[][] = new int[ costs.length + 1 ][ costs.length + 1 ];

		for( int i = 0; i < memo.length; i++ ) {
			Arrays.fill( memo[ i ] , -1 );
		}
		int minimumCost = Integer.MAX_VALUE;
		Color[] colorValue =  Color.values();

		for( int i = 0; i < costs.length; i++ ) {
			minimumCost = Math.min( minimumCost, 
					minCostMemo( costs, 0, colorValue[ i ], memo ) );
		}	
		return minimumCost;
	}

	private static int minCostMemo(int[][] costs, int index, Color color, int[][] memo) {
		
		if( index == costs.length ) {
			return 0;
		}
		
		if( memo[ index ][ color.ordinal() ] != -1 ) {
		 return memo[ index ][ color.ordinal() ];	
		}	
		
		switch( color ) {

			case RED : {
				int costBlue = minCostMemo( costs, index + 1, color.GREEN, memo );
				int costGreen =minCostMemo( costs, index + 1, color.BLUE, memo );
				memo[ index ][ color.ordinal() ] = costs[ index ][ color.ordinal() ] + 
						Math.min( costBlue , costGreen);
				break;
			}
			case BLUE : {
				int costRed = minCostMemo( costs, index + 1, color.GREEN, memo );
				int costGreen =minCostMemo( costs, index + 1, color.RED, memo );
				memo[ index ][ color.ordinal() ] = costs[ index ][ color.ordinal() ] + 
						Math.min( costRed , costGreen);
				break;
			}
			case GREEN : {
				int costRed = minCostMemo( costs, index + 1, color.BLUE, memo );
				int costBlue =minCostMemo( costs, index + 1, color.RED, memo );
				memo[ index ][ color.ordinal() ] = costs[ index ][ color.ordinal() ] + 
						Math.min( costRed , costBlue);
				break;
			}
		}
		return memo[ index ][ color.ordinal() ];
	}

	private static int minCostDP(int[][] costs) {
		int memo[][] = new int[ costs.length + 1 ][ costs.length + 1 ];

		for( int i = costs.length - 1; i >= 0; i-- ) {
			memo[ i ][ Color.GREEN.ordinal() ] = costs[ i ][ Color.GREEN.ordinal() ] +
					Math.min( memo[ i + 1 ][ Color.BLUE.ordinal() ],
					memo[ i + 1 ][ Color.RED.ordinal() ] );
			memo[ i ][ Color.BLUE.ordinal() ] = costs[ i ][ Color.BLUE.ordinal() ] + 
					Math.min( memo[ i + 1 ][ Color.RED.ordinal() ],
					memo[ i + 1 ][ Color.GREEN.ordinal() ] );
			memo[ i ][ Color.RED.ordinal() ] = costs[ i ][ Color.RED.ordinal() ] + 
					Math.min(  memo[ i + 1 ][ Color.BLUE.ordinal() ],
					memo[ i + 1 ][ Color.GREEN.ordinal() ] );
		}
		return Math.min( memo[ 0 ][ Color.RED.ordinal() ] , 
				Math.min( memo[ 0 ][ Color.GREEN.ordinal() ], 
						memo[ 0 ][ Color.BLUE.ordinal() ]));
	}
}