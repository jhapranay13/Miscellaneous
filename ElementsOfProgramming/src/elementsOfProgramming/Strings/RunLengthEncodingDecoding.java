package elementsOfProgramming.Strings;

public class RunLengthEncodingDecoding {

	public static void main(String[] args) {
		String str = "aaaabcccaa";
		String encodedString = encode( str );
		System.out.println( "Encoded String >> " + encodedString );
		String decodedString = decode( encodedString );
		System.out.println( decodedString );
	}

	private static String decode(String str) {
		StringBuilder returnVal = new StringBuilder();
		int counter = 0;
		
		for( int i = 0; i < str.length(); i += 2 ) {
			counter += str.charAt( i ) - '0';
		}
		int count = str.charAt(0) - '0';
		char charToConsider = str.charAt(1);
		int indexCounter = 0;
		
		for( int i = 0; i < counter; i++ ) {
			
			if( i == count ) {
				indexCounter += 2;
				count = i + str.charAt( indexCounter ) - '0';
				charToConsider = str.charAt( indexCounter + 1 );
			}
			returnVal.append( charToConsider );
			
		}
		return returnVal.toString();
	}

	private static String encode(String str) {
		StringBuilder returnVal = new StringBuilder();
		int counter = 1;

		for( int i = 0; i <= str.length() - 1; i++ ) {

			if( i + 1 < str.length() && str.charAt( i ) == str.charAt( i + 1 ) ) {
				counter++;
				continue;
			}
			returnVal.append( counter );
			returnVal.append( str.charAt( i ) );
			counter = 1;
		}
		return returnVal.toString();
	}

}
