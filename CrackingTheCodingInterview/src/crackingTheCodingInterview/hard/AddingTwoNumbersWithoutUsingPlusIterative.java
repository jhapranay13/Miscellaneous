package crackingTheCodingInterview.hard;

public class AddingTwoNumbersWithoutUsingPlusIterative {

	public static void main(String[] args) {
		int a = 12;
		int b = 15;
		int sum = add( a, b );
		System.out.println( sum );
	}

	private static int add(int a, int b) {
		
		while( b != 0 ) {
			int sum = a ^ b;
			int carry = ( a & b ) << 1;
			a = sum;
			b = carry;
		}	
		return a;
	}
}
