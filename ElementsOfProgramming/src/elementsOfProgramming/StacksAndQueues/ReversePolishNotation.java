package elementsOfProgramming.StacksAndQueues;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation {

	public static void main(String[] args) {
		String rpnString= "3,4,+,2,*,1,+";
		int rpnResult = evaluateRPN( rpnString );
		System.out.println( rpnResult );
	}

	private static int evaluateRPN(String rpnString) {
		Deque< String > intermediateResult = new LinkedList<String>();
		
		if( rpnString.length() > 1 ) {
			String[] rpnSplit = rpnString.split( "," );

			for( String token : rpnSplit ) {
				int first;
				int second;
				
				switch( token.trim() ) {
					case "+" : 
						first = Integer.parseInt( intermediateResult.pop() );
						second = Integer.parseInt( intermediateResult.pop() );
						intermediateResult.push( ( first + second ) + "" );
						break;
					case "*" : 
						first = Integer.parseInt( intermediateResult.pop() );
						second = Integer.parseInt( intermediateResult.pop() );
						intermediateResult.push( ( first * second ) + "" );
						break;
					case "-" : 
						first = Integer.parseInt( intermediateResult.pop() );
						second = Integer.parseInt( intermediateResult.pop() );
						intermediateResult.push( ( first + second ) + "" );
						break;
					case "/" : 
						first = Integer.parseInt( intermediateResult.pop() );
						second = Integer.parseInt( intermediateResult.pop() );
						intermediateResult.push( ( first + second ) + "" );
						break;
					default :
						intermediateResult.push( token );
				}
			}
		}
		return Integer.parseInt( intermediateResult.pop() );
	}
}
