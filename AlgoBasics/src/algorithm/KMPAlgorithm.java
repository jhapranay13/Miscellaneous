package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

//Knuth Morris Pratt
public class KMPAlgorithm {

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
		System.out.println( "PI Table >> " + Arrays.toString( piTable ) );
		int patternIndex = 0;

		for( int i = 0; i < sentenceArr.length; i++ ) {

			if( patternArr[ patternIndex ] != sentenceArr[ i ] ) {

				if( patternIndex - 1 > -1 ) {
					patternIndex = piTable[ patternIndex - 1 ];
				}
			}	

			if( patternArr[ patternIndex ] == sentenceArr[ i ]  ) {

				if( patternIndex == patternArr.length - 1 ) {
					System.out.println( "Pattern Exists at >> " + 
							( i - patternIndex) );
					patternIndex = piTable[ patternIndex - 1  ];
				}
				patternIndex++;
			} 
		}
	}

	private static void createPiTable(char[] patternArr, int[] piTable) {
		int i = 0;
		int j = 1;

		for( ; j < piTable.length;  ) {

			if( patternArr[ i ] != patternArr[ j ] && i == 0 ) {
				j++;
				continue;
			} else if( patternArr[ i ] == patternArr[ j ]  ){
				piTable[ j ] = i + 1;
				i++;
				j++;
			} else if( patternArr[ i ] != patternArr[ j ] && i > 0) {

				while( i != 0 ) {
					int tempIndex = piTable[ i - 1 ];
					i = tempIndex;

					if( patternArr[ i ] == patternArr[ j ] ) {
						piTable[ j ] = piTable[ i ] + 1; 
						j++;
						break;
					}
				}
			}
		}
	}
}
