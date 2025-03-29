package dynamicProgramming.twoDimensionDP;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		//String word = "ABBBBDC";
		String word = "ABBBBAC";
		String regExp = ".*A*";
		
		boolean match = regExpRecur( word, regExp, word.length() - 1, regExp.length() - 1 );
		System.out.println( match );
		
		match = regExpMemo( word, regExp );
		System.out.println( match );
		
		match = regExpDP( word, regExp );
		System.out.println( match );
	}

	private static boolean regExpRecur(String word, String regExp, int i, int j) {
		
		if( ( i < 0 && j < 0 ) || regExp.substring(0, j + 1 ).equals( "*" ) ) {
			return true;
		} else if( i < 0 || j < 0 ) {
			return false;
		}
		boolean result = false;
		
		if( word.charAt(i) == regExp.charAt(j) ) {
			result = regExpRecur( word, regExp, i - 1, j - 1 );
		} else if( regExp.charAt( j ) == '.' ) {
			result = regExpRecur( word, regExp, i - 1, j - 1 );
		} else if( regExp.charAt( j ) == '*' ) {
			result = regExpRecur( word, regExp, i - 1, j ) || 
					regExpRecur( word, regExp, i, j - 1 ); 
		}
		return result;
	}

	private static boolean regExpMemo(String word, String regExp) {
		Boolean[][] memo = new Boolean[ word.length() ][ regExp.length() ];
		return regExpMemo( word, regExp, word.length() - 1, regExp.length() - 1, memo );
	}

	private static boolean regExpMemo(String word, String regExp, int i, int j, Boolean[][] memo) {
		
		if( ( i < 0 && j < 0 ) || regExp.substring(0, j + 1 ).equals( "*" ) ) {
			return true;
		} else if( i < 0 || j < 0 ) {
			return false;
		}
		
		if( memo[ i ][ j ] != null ) {
			return memo[ i ][ j ];
		}
		boolean result = false;
		
		if( word.charAt(i) == regExp.charAt(j) ) {
			result = regExpMemo( word, regExp, i - 1, j - 1, memo );
		} else if( regExp.charAt( j ) == '.' ) {
			result = regExpMemo( word, regExp, i - 1, j - 1, memo );
		} else if( regExp.charAt( j ) == '*' ) {
			result = regExpMemo( word, regExp, i - 1, j, memo ) || 
					regExpMemo( word, regExp, i, j - 1, memo ); 
		}
		return memo[ i ][ j ] = result;
	}

	private static boolean regExpDP(String word, String regExp) {
		boolean[][] memo = new boolean[ word.length() + 1 ][ regExp.length() + 1 ];
		memo[ 0 ][ 0 ] = true;
		
		for( int i = 1; i < word.length() + 1; i++ ) {
			
			for( int j = 1; j < regExp.length() + 1; j++ ) {
				
				if( word.charAt(i - 1) == regExp.charAt(j - 1) ) {
					memo[ i ][ j ] = true;
				} else if( regExp.charAt( j - 1 ) == '.' ) {
					memo[ i ][ j ] = true;
				} else if( regExp.charAt( j - 1 ) == '*' ) {
					memo[ i ][ j ] = memo[ i - 1][ j ] || memo[ i ][ j - 1 ]; 
				}
			}
		}
		return memo[ word.length()][ regExp.length() ];
	}
}
