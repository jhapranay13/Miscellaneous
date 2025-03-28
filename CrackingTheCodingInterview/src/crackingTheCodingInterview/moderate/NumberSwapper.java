package crackingTheCodingInterview.moderate;

public class NumberSwapper {

	public static void main(String[] args) {
		int a = 12;
		int b = 15;
		
		System.out.println( "Before Swapping A >> " + a );
		System.out.println( "Before Swapping B >> " + b );
		
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println( "After Swapping A >> " + a );
		System.out.println( "After Swapping B >> " + b );
	}

}
