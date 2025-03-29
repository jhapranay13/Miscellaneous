package dynamicProgramming;

public class SumOfAllDigitsOfAInteger {

	public static void main(String[] args) {
		int num = 123456;
		int sumOfDigits = sumOfDigitsRecur( num );
		System.out.println( sumOfDigits );
	}

	private static int sumOfDigitsRecur(int num) {
		
		if( num % 10 == 0 ) {
			return 0;
		}
		return num % 10 + sumOfDigitsRecur( num / 10 );
	}

}
