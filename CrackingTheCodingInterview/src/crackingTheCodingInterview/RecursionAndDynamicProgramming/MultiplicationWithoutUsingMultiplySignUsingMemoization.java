package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class MultiplicationWithoutUsingMultiplySignUsingMemoization {

	public static void main(String[] args) {
		int firstNum = 7;
		int secondNum = 5;
		int multiplicationResult = multiply( firstNum, secondNum );
		System.out.println( multiplicationResult );
	}

	private static int multiply(int firstNum, int secondNum) {
		int biggerNum = firstNum < secondNum ? secondNum : firstNum;
		int smallerNum = firstNum > secondNum ? secondNum : firstNum;
		int [] memo = new int[ smallerNum + 1 ];
		
		int sum = multiply(biggerNum, smallerNum, memo);
		return sum;
	}

	private static int multiply(int biggerNum, int smallerNum, int[] memo) {
		
		if( smallerNum == 0 ) {
			return 0;
		} else if( smallerNum == 1 ) {
			return biggerNum;
		} else if( memo[ smallerNum ] > 0 ){
			return memo[ smallerNum ];
		}
		int side = smallerNum >> 1;
		int side1 = multiply( biggerNum, side, memo );
		int side2 = side1;
		
		if( smallerNum % 2 == 1 ) {
			side2 = multiply(biggerNum, smallerNum - side, memo);
		}
		memo[ smallerNum ] = side1 + side2;
		return memo[ smallerNum ];
	}

}
