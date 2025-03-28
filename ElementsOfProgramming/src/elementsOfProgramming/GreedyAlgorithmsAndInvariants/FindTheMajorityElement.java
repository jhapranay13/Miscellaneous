package elementsOfProgramming.GreedyAlgorithmsAndInvariants;

public class FindTheMajorityElement {

	public static void main(String[] args) {
		String[] arr = { "b", "a", "c", "a", "a", "b", "a", "a", "c", "a" };
		String majorityCandidate = findMajorityCandidate( arr );
		System.out.println( majorityCandidate );
	}

	private static String findMajorityCandidate(String[] arr) {
		String candidate = null;
		int counter = 0;
		
		for( int i = 0; i < arr.length; i++ ) {
			
			if( candidate == null ) {
				candidate = arr[ i ];
			}
			
			if( candidate.equals( arr[ i ] ) ) {
				counter++;
			} else {
				
				if( counter > 1 ) {
					counter--;
				} else {
					candidate = null;
					counter = 0;
				}	
			}
		}
		return counter > 0 ? candidate : null;
	}

}
