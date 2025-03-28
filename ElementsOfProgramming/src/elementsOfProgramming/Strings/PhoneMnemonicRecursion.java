package elementsOfProgramming.Strings;

public class PhoneMnemonicRecursion {

	public static void main(String[] args) {
		String number = "2267834";
		StringBuilder partialMnemonic = new StringBuilder();
		int indexPosition = 0;
		phoneMnemonic( number, partialMnemonic, indexPosition );
	}
	
	private static void phoneMnemonic(String number, StringBuilder partialMnemonic, 
			int indexPosition) {
		
		if( indexPosition >= number.length() ) {
			System.out.println( partialMnemonic.toString() );
			return;
		}
		int numberInConsideration = number.charAt( indexPosition ) - '0';
		String possibleMnemonicValue = numberMapping[ numberInConsideration ];
		
		for( int i = 0; i < possibleMnemonicValue.length(); i++ ) {
			String temp = "" + possibleMnemonicValue.charAt(i);
			partialMnemonic.append( temp );
			phoneMnemonic(number, partialMnemonic, indexPosition + 1 );
			partialMnemonic.delete( indexPosition, partialMnemonic.length() );
		}
	}

	private static final String[] numberMapping = { "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", 
			"PQRS", "TUV", "WXYZ" };
}
