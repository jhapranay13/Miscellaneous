package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class KMPAlgorithmTusharRoy {

	public static void main(String[] args) {
		String sentence = "abxabcabcaby";
		//String pattern = "abcdabca";
		//String pattern = "aabaabaaa";
		String pattern = "abcaby";
		//String pattern = "abc";

		char[] sentenceArr = sentence.toCharArray();
		char[] patternArr = pattern.toCharArray();

		ArrayList<Integer> result = new ArrayList<>();		
		patternMatch( sentenceArr, patternArr  );

	}

	private static void patternMatch(char[] sentenceArr, char[] patternArr) {
		int[] piTable = new int[ patternArr.length ];
		createPiTable( patternArr, piTable );
		System.out.println( "PI TABLE >> " + Arrays.toString( piTable ));
		
		int index = 0;
		int patternIndex = 0;
		
		while( index < sentenceArr.length ) {
			
			if( sentenceArr[ index ] == patternArr[ patternIndex ]  ) {
				
				if( patternIndex >= patternArr.length - 1 ) {
					System.out.println( "Pattern Found At >> " + 
						( index - patternIndex ) );
				}
				index++;
				patternIndex++;
			} else {
				
				if( patternIndex != 0 ) {
					patternIndex = piTable[ patternIndex - 1 ];
				} else {
					index++;
				}
			}
		}
	}

	private static void createPiTable(char[] patternArr, int[] piTable) {
		int index = 0;
		
		for( int i = 1; i< patternArr.length; ) {
			
			if( patternArr[ i ] == patternArr[ index ] ) {
				piTable[ i++ ] = index++ + 1;
			} else {
				
				if( index != 0 ) {
					index = piTable[ index - 1 ];
				} else {
					piTable[ i++ ] = 0;
				}
			}
		}
	}

}
