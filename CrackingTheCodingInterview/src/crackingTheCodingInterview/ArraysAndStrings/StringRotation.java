package crackingTheCodingInterview.ArraysAndStrings;

public class StringRotation {

	public static void main(String[] args) {
		String originalString = "waterbottle";
		String rotatedString = "tlewaterbot";
		boolean rotatedFlag = isRotated( originalString, rotatedString );
		System.out.println( rotatedFlag );
	}

	private static boolean isRotated(String originalString, String rotatedString) {
		boolean rotatedFlag = false;
		
		if( originalString.length() != rotatedString.length() ) {
			return false;
		}
		String holder = originalString + originalString;
		int size = holder.length();
		int counter = 0;
		
		for( int i = 0; i < size; i++ ) {
			
			if( counter == rotatedString.length() - 1 ) {
				rotatedFlag = true;
				break;
			}
			char holderChar = holder.charAt( i );
			char rotatedChar = rotatedString.charAt( counter ); 
			if( holderChar == rotatedChar ) {
				counter++;
			} else {
				
				if( counter > 0 ) {
					i--;
				}
				counter = 0;
			}
		}
		return rotatedFlag;
	}
}
