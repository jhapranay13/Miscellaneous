package algorithm;

import java.util.ArrayList;

//Used For Document Matching etc.
public class RabinKarpAlgorithm {

	public static void main(String[] args) {
		String sentence = "abxabcabcaby";
		//String pattern = "abcdabca";
		//String pattern = "aabaabaaa";
		String pattern = "abcabc";
		//String pattern = "abc";

		char[] sentenceArr = sentence.toCharArray();
		char[] patternArr = pattern.toCharArray();

		ArrayList<Integer> result = new ArrayList<>();		
		patternMatch( sentenceArr, patternArr  );
	}

	private static void patternMatch(char[] sentenceArr, char[] patternArr) {
		int patternMaxIndex = patternArr.length - 1;
		int sentenceMaxIndex = sentenceArr.length - 1;
		
		long patternHashValue = calculateHash( patternArr, 0, patternMaxIndex, 0 );
		long sentenceHashValue = 0;
		
		for( int i = 0, j = patternMaxIndex; j <= sentenceMaxIndex ; i++, j++  ) {
			sentenceHashValue = calculateHash(sentenceArr, i, j, sentenceHashValue);
			
			if( sentenceHashValue == patternHashValue ) {
				
				if( checkForEquality( patternArr, sentenceArr, i, j ) ) {
					System.out.println( "Pattern Match At Index >> " + i );
				}	
			}
		}
	}

	private static boolean checkForEquality(char[] patternArr, char[] sentenceArr, 
			int start, int end) {
		boolean matchFlag = true;
		
		for( int i = 0; i < patternArr.length && start <= end; i++, start++ ) {
			
			if( patternArr[ i ] != sentenceArr[ start ] ) {
				matchFlag = false;
				break;
			}
		}
		return matchFlag;
	}

	private static long calculateHash(char[] arr, int startIndex, 
			int endIndex, long oldHashValue) {
		int prime = 101;
		long hashValue = 0;
		
		if( oldHashValue == 0 ) {
			
			for( int i = startIndex; i <= endIndex; i++ ) {
				hashValue += arr[ i ] * Math.pow( prime , i);
			}
		} else {
			//Recalculating New Hash. This is the method to calculate rolling Hash
			hashValue = oldHashValue - arr[ startIndex - 1 ]; 
			hashValue /= prime; 
			hashValue += arr[ endIndex ] * Math.pow( prime , 
							( endIndex - startIndex ) );
		}
		return hashValue;
	}

}
