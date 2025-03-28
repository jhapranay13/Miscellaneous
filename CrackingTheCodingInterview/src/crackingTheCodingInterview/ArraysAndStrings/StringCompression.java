package crackingTheCodingInterview.ArraysAndStrings;

public class StringCompression {

	public static void main(String[] args) {
		String string = "aabcccccaab";
		string = compressString( string );
		System.out.println( string );
	}

	private static String compressString(String string) {
		StringBuilder builder = new StringBuilder();
		int counter = 0;

		for( int i = 0; i < string.length(); i++ ) {

			if( i == string.length() - 1 ) {
				counter++;
				builder.append( "" + string.charAt( i ) + "" + counter );
				continue;
			}

			if( string.charAt( i ) == string.charAt( i + 1 ) ) {
				counter++;
			} else {
				counter++;
				builder.append( "" + string.charAt( i ) + "" + counter );
				counter = 0;
			}
		}
		return builder.toString();
	}
}
