package elementsOfProgramming.Strings;

public class FirstInstanceOfPattern {

	public static void main(String[] args) {
		String sentence = "abxabcabcaby";
		//String pattern = "abcdabca";
		//String pattern = "aabaabaaa";
		String pattern = "abcaby";
		//String pattern = "abc";

		char[] sentenceArr = sentence.toCharArray();
		char[] patternArr = pattern.toCharArray();

		int firstInstance = patternMatch( sentenceArr, patternArr  );
		System.out.println( firstInstance );
	}

	//Rabin Karp
	private static int patternMatch(char[] sentenceArr, char[] patternArr) {
		int firstInstance = -1;
		
		if( sentenceArr.length < patternArr.length ) {
			return firstInstance;
		}
		long patternHash = calculateHash( patternArr, 0, patternArr.length - 1, 0 );
		long oldHashValue = 0;
		
		for( int i = 0, j = patternArr.length - 1; j < sentenceArr.length; i++, j++ ) {
			long sentenceHash = calculateHash( sentenceArr, i, j, oldHashValue );
			
			if( sentenceHash == patternHash ) {
				if( checkForEquality( patternArr, sentenceArr, i , j ) ) {
					firstInstance = i;
					break;
				}
			}
			oldHashValue = sentenceHash;
		}
			
		return firstInstance;	
	}

	private static boolean checkForEquality(char[] patternArr, char[] sentenceArr, 
			int start, int end) {
		
		for( int i = 0, j = start; i < patternArr.length && j <= end; i++, j++ ) {
			
			if( patternArr[ i ] != sentenceArr[ j ] ) {
				return false;
			}
		}
		return true;
	}

	private static long calculateHash(char[] arr, int  startIndex, int endIndex, 
			long oldHashValue ) {
		long returnValue = 0;
		int primeNum = 101;
		
		if( oldHashValue == 0 ) {
			
			for( int i = startIndex; i <= endIndex; i++ ) {
				returnValue += (long) (arr[ i ] * Math.pow( primeNum, i));
			}
		} else {
			returnValue = oldHashValue - arr[ startIndex -  1 ];
			returnValue /= primeNum;
			returnValue += arr[ endIndex ] * Math.pow(primeNum, endIndex - startIndex ); 
		}
		return returnValue;
	}
}
