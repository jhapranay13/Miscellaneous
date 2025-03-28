package elementsOfProgramming.StacksAndQueues;

import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class NormalizePath {

	public static void main(String[] args) {
		String path = "/exp/sub/../../damn.html";
		System.out.println( normalizePath( path ) );
	}

	private static String normalizePath(String path) {
		
		if (path.equals("")) {
			throw new IllegalArgumentException("Empty string is not a legal path.");
		}
		Deque<String> pathNames = new LinkedList<>();
		String[] splitPath = path.split( "/" );
		System.out.println( Arrays.toString( splitPath ) );
		
		for( int i = 0; i < splitPath.length; i++ ) {
			pathNames.push( splitPath[ i ] );
		}
		StringBuilder result = new StringBuilder();
		int skipCounter = 0;
		
		while( !pathNames.isEmpty() ) {
			
			if( skipCounter > 0 && ( !pathNames.peek().equals("..") ) ) {
				pathNames.pop();
				skipCounter--;
				continue;
			}
			
			if( pathNames.peek().equals( "..") ) {
				skipCounter++;
				pathNames.pop();
				continue;
			} 
			
			if( pathNames.peek().equals(".") || pathNames.peek().equals("")  ) {
				pathNames.pop();
				continue;
			}
			result.insert( 0 , pathNames.pop());
		}
		
		if( path.startsWith("/") ) {
			result.insert( 0 , "/");
		}
		return result.toString();
	}

	
}
