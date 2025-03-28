package elementsOfProgramming.Searching;

public class ComputeIntegerSquareRootLessThanOrEqual {

	public static void main(String[] args) {
		int number = 45;
		int lessThanOrEqualSquareRoot = getLessThanOrEqualSquareRoot( number );
		System.out.println( lessThanOrEqualSquareRoot );
	}

	private static int getLessThanOrEqualSquareRoot(int number) {
		int lo = 0;
		int hi = number;
		
		while( lo <= hi ) {
			int pivot = lo + ( hi - lo ) / 2;
			int square = pivot * pivot;
			
			if( square < number ) {
				lo = pivot + 1;
			} else {
				hi = pivot - 1;
			}
		}
		return hi;
	}

}
