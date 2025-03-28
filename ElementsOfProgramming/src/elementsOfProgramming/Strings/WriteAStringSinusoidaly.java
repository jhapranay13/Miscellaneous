package elementsOfProgramming.Strings;

public class WriteAStringSinusoidaly {

	public static void main(String[] args) {
		String str = "Hello World!";
		String sinusoidalString = getSinusoidal( str );
		System.out.println( sinusoidalString );
	}

	private static String getSinusoidal(String str) {
		StringBuilder returnValue = new StringBuilder();
		
		for( int i = 1; i < str.length(); i += 4 ) {
			returnValue.append( str.charAt( i ) );
		}
		
		for( int i = 0; i < str.length(); i += 2 ) {
			returnValue.append( str.charAt( i ) );
		}
		
		for( int i = 3; i < str.length(); i += 4 ) {
			returnValue.append( str.charAt( i ) );
		}
		return returnValue.toString();
	}
}
