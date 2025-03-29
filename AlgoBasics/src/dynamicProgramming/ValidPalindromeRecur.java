package dynamicProgramming;

public class ValidPalindromeRecur {

	public static void main(String[] args) {
		String str = "abc";
		boolean isValidFlag = validPalRecur( str, 0, str.length() - 1 );
		System.out.println( isValidFlag );
	}

	private static boolean validPalRecur(String str, int start, int end) {
		
		if( start >= end ) {
			return true;
		}
		
		return str.charAt( start ) == str.charAt( end ) && 
				validPalRecur(str, start + 1, end - 1 );
	}

}
