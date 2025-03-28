package elementsOfProgramming.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateStringOfMatchedParenthesis {

	public static void main(String[] args) {
		int numberOfParenthesis = 3;
		List< String > result = new ArrayList<>();
		StringBuilder partial = new StringBuilder();
		generateAllParenthesis( numberOfParenthesis, numberOfParenthesis, result, partial );
		
		for( String parens : result ) {
			System.out.println( parens );
		}
	}

	private static void generateAllParenthesis(int numberOfLeftParen, int numberOfRightParen, 
			List<String> result, StringBuilder partial) {
		
		if( numberOfLeftParen > numberOfRightParen ) {
			return;
		}
		
		if( numberOfLeftParen == 0 && numberOfRightParen == 0 ) {
			result.add( partial.toString() );
			return;
		}
		
		if( numberOfLeftParen > 0 ) {
			partial.append( "(" );
			generateAllParenthesis(numberOfLeftParen - 1, numberOfRightParen, result, partial);
			partial.deleteCharAt( partial.length() - 1 );
		}
		
		if( numberOfRightParen > 0 ) {
			partial.append( ")" );
			generateAllParenthesis(numberOfLeftParen, numberOfRightParen - 1, result, partial);
			partial.deleteCharAt( partial.length() - 1 );
		}
	}
}
