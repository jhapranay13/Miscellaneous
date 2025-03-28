package crackingTheCodingInterview.moderate;

public class NumberToEnglishNumber {

	public static void main(String[] args) {
		long number = 1134569;
		String[] smallNum = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
				"Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
				"Sixteen", "Seventeen", "Eighteen", "Nineteen" };
		String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
				"Eighty", "Ninety" };
		String[] big = { "Thousand", "Million", "Billion" };
		StringBuilder result = new StringBuilder();
		int counter = 0;
		convertNumber( number, smallNum, tens, big, result,
				counter );
		System.out.println( result );
	}

	private static void convertNumber(long number, String[] smallNum, String[] tens, 
			String[] big, StringBuilder result, int counter) {

		if( number == 0 ) {
			result.append( smallNum[ 0 ] );
		} else if( number < 0 ) {
			result.append( "Negative " );
			convertNumber(-1 * number, smallNum, tens, big, result, counter);
		}
		
		while( number % 1000 > 0 ) {
			StringBuilder temp = new StringBuilder();
			long lowerTemp = number % 1000;
			convertLowerTemp( lowerTemp, smallNum, tens, temp );
			number = number / 1000;
			result.insert(0, temp);
			
			if( number > 0 ) {
				result.insert(0, " " + big[ counter ] + " ");
			}
			counter++;
		}
	}

	private static void convertLowerTemp(long number, String[] smallNum, String[] tens, 
			StringBuilder result) {
		
		if( number > 99 && number < 999 ) {
			result.append( smallNum[(int) (number / 100)] + " Hundred " );
			number %= 100;
		}
		
		if( number < 100 && number > 19 ) {
			result.append( tens[ (int) (number / 10) ] );
			number %= 10;
		}
		
		if( number > 0 && number < 20 ) {
			result.append(" " + smallNum[ (int) number ]);
		}
	}

}
