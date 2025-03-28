package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class StairCaseProblemBF {

	public static void main(String[] args) {
		int numberOfStairs = 36;
		int ways = countWays( numberOfStairs );
		System.out.println( ways );
	}

	private static int countWays(int numberOfStairs) {

		if( numberOfStairs < 0 ) {
			return 0;
		} else if( numberOfStairs == 0 ) {
			return 1;
		}
		return countWays( numberOfStairs - 1 ) + countWays( numberOfStairs - 2 ) + 
				countWays( numberOfStairs - 3 );
	}
}
