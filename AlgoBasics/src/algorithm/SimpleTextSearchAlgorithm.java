package algorithm;

public class SimpleTextSearchAlgorithm {

	public static void main(String[] args) {
		String textStr = "This a test text and text for test.";
		String pattern = "text";
		
		int index = simpleTextSearch( textStr.toCharArray(), pattern.toCharArray() );
		System.out.println( textStr.substring( index, index + pattern.length() ));
	}

	private static int simpleTextSearch(char[] text, char[] pattern) {
		int patternLength = pattern.length;
		int textLength = text.length;
		
		int textCounter = 0;
		
		while( ( textCounter + patternLength ) <= textLength ) {
			int patternCounter = 0;
			
			while( text[ textCounter + patternCounter ]  == pattern[ patternCounter ] ) {
				patternCounter += 1;
				
				if( patternCounter >= patternLength ) {
					return textCounter;
				}
			}
			textCounter++;
		}
		return textCounter;
	}
}
