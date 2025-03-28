package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class ValidParenthesis {

	//Like weaving
	public static void main(String[] args) {
		int numberOfParenthesis = 3;
		List< String > paranthesisCombination = getCombination( numberOfParenthesis );

		for( String combination : paranthesisCombination ) {
			System.out.println( combination );
		}
	}

	private static List<String> getCombination(int numberOfParenthesis) {
		int numOfLeftParenthesis = numberOfParenthesis;
		int numOfRightParenthesis = numberOfParenthesis;
		List< String > paranthesisCombination = new ArrayList<String>();
		StringBuilder prefix = new StringBuilder();

		parenthesisCombination( numOfLeftParenthesis, numOfRightParenthesis, prefix
				, paranthesisCombination );
		return paranthesisCombination;
	}

	private static void parenthesisCombination(int numOfLeftParenthesis, int numOfRightParenthesis, 
			StringBuilder prefix, List< String > paranthesisCombination ) {

		//check coz number of right parenthesis can never be less than number of left paranthesis.
		if( numOfRightParenthesis < numOfLeftParenthesis ) {
			return;
		}
		if( numOfLeftParenthesis == 0 && numOfRightParenthesis == 0 ) {
			paranthesisCombination.add( prefix.toString() );
			return;
		}
		int rightIndex = 0;
		int leftIndex = 0;

		if( numOfLeftParenthesis != 0 ) {
			prefix.append( "(" );
			leftIndex = prefix.length() - 1;
			parenthesisCombination( numOfLeftParenthesis - 1, numOfRightParenthesis, 
					prefix, paranthesisCombination );

			prefix.delete(leftIndex, leftIndex + 1 );
		}
		prefix .append( ")" );
		rightIndex = prefix.length() - 1;
		parenthesisCombination( numOfLeftParenthesis , numOfRightParenthesis - 1, 
				prefix, paranthesisCombination );
		prefix.delete(rightIndex, rightIndex + 1 );
	}

}
