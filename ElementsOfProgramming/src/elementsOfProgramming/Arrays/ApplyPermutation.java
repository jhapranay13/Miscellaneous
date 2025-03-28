package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class ApplyPermutation {

	public static void main(String[] args) {
		String[] stringArr = { "a", "b", "c", "d", "e" };
		int[] permuteArr = { 3, 2, 0, 4, 1 };
		apply( stringArr, permuteArr );
		System.out.println( Arrays.toString( stringArr ) );
	}

	private static void apply(String[] stringArr, int[] permuteArr) {

		for( int i = 0; i < stringArr.length; i++ ) {

			if( permuteArr[ i ] < 0 ) {
				continue;
			}
			int indexCurrentlyOn = i;
			int indexToGoTo = permuteArr[ i ];
			
			while( i < stringArr.length ) {
				
				if( indexToGoTo == indexCurrentlyOn || indexToGoTo == i ) {
					permuteArr[ indexCurrentlyOn ] = indexToGoTo - permuteArr.length;
					break;
				}
				swap( stringArr, indexCurrentlyOn, indexToGoTo );
				permuteArr[ indexCurrentlyOn ] = indexToGoTo - permuteArr.length;
				indexCurrentlyOn = indexToGoTo;
				indexToGoTo = permuteArr[ indexCurrentlyOn ];
			}
		}
	}
	
	private static void swap(String[] stringArr, int permuteIndex, int currentIndex) {
		String temp = stringArr[ permuteIndex ];
		stringArr[ permuteIndex ] = stringArr[ currentIndex ];
		stringArr[ currentIndex ] = temp;
	}

	
}
