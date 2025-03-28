package elementsOfProgramming.Strings;

public class SpreadSheetEncoding {

	public static void main(String[] args) {
		String encoding = "ZZ";
		int decodedValue = decodeSpreadSheet( encoding );
		System.out.println( "Decoded Value >> " + decodedValue );
	}

	private static int decodeSpreadSheet(String encoding) {
		int decodedValue = 0;
		
		for( int i = 0; i < encoding.length(); i++ ) {
			decodedValue = decodedValue * 26 + encoding.charAt( i ) - 'A' + 1;
		}
		return decodedValue;
	}
}
