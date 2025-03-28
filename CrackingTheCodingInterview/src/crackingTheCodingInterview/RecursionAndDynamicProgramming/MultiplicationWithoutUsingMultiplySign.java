package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class MultiplicationWithoutUsingMultiplySign {

	public static void main(String[] args) {
		int firstNum = 7;
		int secondNum = 4;
		int level = 0;
		int sum = 0;
		int multiplicationResult = multiply( firstNum, secondNum, level, sum );
		System.out.println( multiplicationResult );
	}

	private static int multiply(int firstNum, int secondNum, int level, int sum) {
		int biggerNum = firstNum < secondNum ? secondNum : firstNum;
		int smallerNum = firstNum > secondNum ? secondNum : firstNum;
		
		if( level == smallerNum / 2 ) {
			
			if( smallerNum % 2 != 0 ) {
				return ( sum ) * 2 + biggerNum;
			} else {
				return ( sum ) * 2;
			}
		}
		sum += biggerNum;
		int returnVal = 0;
		returnVal += multiply(firstNum, secondNum, level + 1, sum );
		return returnVal;
	}
}
