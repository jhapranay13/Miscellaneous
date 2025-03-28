package crackingTheCodingInterview.hard;

public class AddingTwoNumbersWithoutUsingPlusRecursive {

	public static void main(String[] args) {
		int a = 12;
		int b = 15;
		int sum = add( a, b );
		System.out.println( sum );
	}

	private static int add(int a, int b) {
		
		if( a == 0 ) {
			return b;
		}
		int sum = a ^ b;
		int carry = ( a & b ) << 1;
		return add( carry, sum );
	}
}
