package crackingTheCodingInterview.ArraysAndStrings;

public class URLifying {

	public static void main(String[] args) {
		String string = "Mr John Smith    ";
		int trueLength = 13;
		System.out.println( urlIfy( string, trueLength ) );
	}

	private static char[] urlIfy(String string, int trueLength) {
		char[] stringCharArr = string.toCharArray();
		int spaceCount = 0;
		
		for( int i = 0; i < trueLength; i++ ) {
			
			if( stringCharArr[ i ] == ' ' ) {
				spaceCount++;
			}
		}
		int index = trueLength + spaceCount * 2;
		
		if( trueLength < string.length() ) {
			stringCharArr[ trueLength ] = '\0';
		}
		
		for( int i = trueLength - 1; i >= 0; i-- ) {
			
			if( stringCharArr[ i ] == ' ' ) {
				stringCharArr[ index - 1 ] = '0';
				stringCharArr[ index - 2 ] = '2';
				stringCharArr[ index - 3 ] = '%';
				index -= 3;
			} else {
				stringCharArr[ index - 1 ] = stringCharArr[ i ];
				index--;
			}
		}
		return stringCharArr;
	}

}
