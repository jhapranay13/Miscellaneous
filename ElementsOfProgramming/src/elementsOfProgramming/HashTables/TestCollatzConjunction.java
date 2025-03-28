package elementsOfProgramming.HashTables;

import java.util.HashSet;
import java.util.Set;

public class TestCollatzConjunction {

	public static void main(String[] args) {
		int number = 10;
		System.out.println( testCollatz( number ) );
	}

	private static boolean testCollatz(int number) {
		Set< Long > verifiedNumbers = new HashSet<>();

		for( int i = 3; i <= number; i += 2 ) {
			Set<Long> sequence = new HashSet<>();
			long testl = i;
			while (testl >= i) {
				if (!sequence.add(testl)) {
					// We previously encountered testl, so the Collatz sequence
					// has fallen into a loop. This disproves the hypothesis , so
					// we short-circuit, returning false.
					return false;
				}
				if ((testl % 2) != 0) { // Odd number
					if(!verifiedNumbers.add(testl)) {
						break; // testl has already been verified to converge to 1.
					}
					long nextTestl = 3 * testl + 1; // Multiply by 3 and add 1.
					if (nextTestl <= testl) {
						throw new ArithmeticException("Collatz sequence overflow for " + i);
					}
					testl = nextTestl ;
				} else {
					testl /= 2; // Even number, halve it.
				}
			}
		}
		return true;
	}

}
