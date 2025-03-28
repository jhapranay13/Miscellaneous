package crackingTheCodingInterview.moderate;

import java.util.Arrays;
import java.util.Random;

public class ShuffleCardRecursive {

	public static void main(String[] args) {
		int cardDeck[] = new int[ 52 ];

		for( int i = 0; i < cardDeck.length; i++ ) {
			cardDeck[ i ] = i;
		}
		int level = 0;
		shuffleDeck( cardDeck, level );
		System.out.println( Arrays.toString( cardDeck ) );
	}

	private static void shuffleDeck(int[] cardDeck, int level) {
		
		if( level == cardDeck.length ) {
			return;
		}
		shuffleDeck( cardDeck, level + 1 );
		Random rand = new Random();
		int value = rand.nextInt( cardDeck.length );
		swap( cardDeck, level, value );
		
	}

	private static void swap(int[] cardDeck, int posOne, int posTwo) {
		int temp = cardDeck[ posOne ];
		cardDeck[ posOne ] = cardDeck[ posTwo ];
		cardDeck[ posTwo ] =  temp;
	}
}
