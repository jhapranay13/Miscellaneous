package crackingTheCodingInterview.moderate;

import java.util.Arrays;
import java.util.Random;

public class ShuffleCardsIterative {

	public static void main(String[] args) {
		int cardDeck[] = new int[ 52 ];
		
		for( int i = 0; i < cardDeck.length; i++ ) {
			cardDeck[ i ] = i;
		}
		shuffleDeck( cardDeck );
		System.out.println( Arrays.toString( cardDeck ) );
	}

	private static void shuffleDeck(int[] cardDeck) {
		Random rand = new Random();
		
		for( int j = 0; j < cardDeck.length; j++ ) {
			int value = rand.nextInt( cardDeck.length );
			swap( cardDeck, j , value );
		}
	}

	private static void swap(int[] cardDeck, int posOne, int posTwo) {
		int temp = cardDeck[ posOne ];
		cardDeck[ posOne ] = cardDeck[ posTwo ];
		cardDeck[ posTwo ] =  temp;
	}
}
