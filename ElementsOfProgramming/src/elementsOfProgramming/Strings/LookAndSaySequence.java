package elementsOfProgramming.Strings;

public class LookAndSaySequence {

	public static void main(String[] args) {
		int number = 6;// 13112221
		String sequence = generateSequence( number );
		System.out.println( sequence );
	}

	private static String generateSequence(int number) {
		String returnValue = "1";
		
		for( int i = 0; i < number; i++ ) {
			returnValue = nextSequence( returnValue );
 		}
		return returnValue;
	}

	private static String nextSequence(String returnValue) {
		StringBuilder sequence = new StringBuilder();

		for( int i = 0; i < returnValue.length(); i++ ) {
			int counter = 1;

			while( i + 1 < returnValue.length() && 
					returnValue.charAt(i) == returnValue.charAt( i + 1) ) {
				counter++;
				i++;
			}
			sequence.append( counter );
			sequence.append( returnValue.charAt( i ) );
		}
		return sequence.toString();
	}

}
