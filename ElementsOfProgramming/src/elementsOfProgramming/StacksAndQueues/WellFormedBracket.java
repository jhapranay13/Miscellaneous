package elementsOfProgramming.StacksAndQueues;

import java.util.Stack;

public class WellFormedBracket {
	
	public static void main( String args[] ) {
		String brackets = "{[(())]})";
		boolean wellFormedFlag = isWellFormed( brackets );
		System.out.println( wellFormedFlag );
	}

	private static boolean isWellFormed(String brackets) {
		Stack<String> holder = new Stack<>();
		
		if( brackets.trim().equals( "") ) {
			return false;
		}
		
		for( int i = 0; i < brackets.length(); i++ ) {
			String brace = "" + brackets.charAt( i );
			
			if( brace.trim().equals("{") || brace.trim().equals("[") || 
					brace.trim().equals("(") ) {
				holder.push( brace.trim() );
			}
			
			if( brace.trim().equals("}") || brace.trim().equals("]") || 
					brace.trim().equals(")") ) {
				
				switch ( brace.trim() ) {
					case "}": 
						if( !holder.isEmpty() && holder.peek().trim().equals( "{" ) ) {
							holder.pop();
						} else {
							return false;
						}
						break;
					case "]": 
						if( !holder.isEmpty() && holder.peek().trim().equals( "[" ) ) {
							holder.pop();
						} else {
							return false;
						}
						break;
					case ")": 
						if( !holder.isEmpty() && holder.peek().trim().equals( "(" ) ) {
							holder.pop();
						} else {
							return false;
						}
						break;	
				}
			}
		}	
		return holder.isEmpty() ? true : false;
	}
}
