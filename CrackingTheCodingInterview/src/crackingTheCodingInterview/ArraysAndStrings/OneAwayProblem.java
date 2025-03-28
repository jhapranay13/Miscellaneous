package crackingTheCodingInterview.ArraysAndStrings;

public class OneAwayProblem {

	public static void main(String[] args) {
		String stringOne = "pale";
		String stringTwo = "pabe";
		/*String stringOne = "pales";
		String stringTwo = "pale";*/
		/*String stringOne = "pale";
		String stringTwo = "bale";*/
		/*String stringOne = "pale";
		String stringTwo = "bal";*/
		boolean oneAwayFlag = isOneAwayFlag( stringOne, stringTwo );
		System.out.println( oneAwayFlag );
	}

	private static boolean isOneAwayFlag(String stringOne, String stringTwo) {
		boolean returnFlag = checkInsertOrRemovalOrEdit( stringOne, stringTwo );
		System.out.println( ">>> " + returnFlag );
		return returnFlag;
	}

	private static boolean checkInsertOrRemovalOrEdit(String stringOne, String stringTwo) {
		
		if ( Math.abs( stringOne.length() - stringTwo.length() ) > 1 ) {
			return false;
		}
		
		int differentIndex = -1;
		int indexOne = 0;
		int indexTwo = 0;
		String s1 = stringOne.length() < stringTwo.length() ? stringTwo : stringOne;
		String s2 = stringOne.length() < stringTwo.length() ? stringOne : stringTwo;

		while( indexOne < s1.length() && indexTwo < s2.length() ) {
			
			if( s1.charAt( indexOne ) != s2.charAt( indexTwo ) ) {
				
				if( differentIndex > -1 ) {
					return false;
				}
				differentIndex = indexTwo;
				
				if( s1.length() != s2.length() ) {
					indexOne++;
					continue;
				}	
			}
			indexTwo++;
			indexOne++;
		}
		return ( differentIndex > -1 );
	}

}
