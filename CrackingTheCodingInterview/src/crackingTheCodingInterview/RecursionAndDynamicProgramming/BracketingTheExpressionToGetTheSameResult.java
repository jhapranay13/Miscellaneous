package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class BracketingTheExpressionToGetTheSameResult {

	public static void main(String[] args) {
		String expression = "0^0&0^1^1|1" ;
		boolean returnValue = true;
		int level = 0;
		int numberOfWays = getNumberOfWays( expression, ( returnValue ? 1 : 0 ), level );
		System.out.println( numberOfWays );
	}

	private static int getNumberOfWays(String expression, int value, int level) {
		
		if( expression.trim().length() == 0 ) {
			return 0;
		}
		
		if( expression.trim().length() == 1 ) {
			return Integer.parseInt( expression.trim() );
		}
		String left = "";
		int ways = 0;
		int result = -1;

		for( int i = 1; i < expression.length(); i += 2 ) {
			String charAt = expression.charAt( i ) + "";
			left = expression.substring( 0, i );
			int resultLeft = getNumberOfWays(left, value, level + 1);
			int resultRight = getNumberOfWays( expression.substring( i + 1) , value, level + 1);
			
			if( charAt.equals("^") ) {
				result = resultLeft + resultRight;
				
				if( result != 1 ) {
					result = 0;
				}
			}
			
			if( charAt.equals("|") ) {
				result = resultLeft + resultRight;
				
				if( !(result >= 1) & !( result == 0 ) ) {
					result = 0;
				} else {
					result = 1;
				}
			}
			
			if( charAt.equals("&") ) {
				result = resultLeft * resultRight;
				
				if( result != 1 ) {
					result = 0;
				} else {
					result = 1;
				}
			}
			
			if( level == 0 ) {
				
				if( result == value ) {
					ways++;
				}
			}
		}
		
		if( level == 0 ) {
			return ways;
		}
		return result;
	}
}
