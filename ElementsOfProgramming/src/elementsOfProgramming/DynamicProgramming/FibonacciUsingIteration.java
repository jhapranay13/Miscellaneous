package elementsOfProgramming.DynamicProgramming;

public class FibonacciUsingIteration {

	public static void main(String[] args) {
		int numberOfFibonacci = 6;
		int result = calculateFibonacci( numberOfFibonacci );
		System.out.println( result );
	}

	private static int calculateFibonacci(int numberOfFibonacci) {
		int secondNum = 1;
		int firstNum = 1;
		
		for( int  i = 2; i <= numberOfFibonacci; i++ ) {
			int temp = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = temp;
			
		}
		return secondNum;
	}

}
