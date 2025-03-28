package elementsOfProgramming.Arrays;

import java.util.Arrays;

public class MultiplyTwoArbitaryPrecisionIntegers {

	public static void main(String[] args) {
		int[] num1 = { 1, 2, 3 };
		int[] num2 = { -2, 4 };
		int[] multiplyResult = multiply( num1, num2 );
		System.out.println( Arrays.toString( multiplyResult ) );
	}

	private static int[] multiply(int[] num1, int[] num2) {
		int[] result = new int[ num1.length + num2.length ];
		int signVal = num1[ 0 ] < 0 || num2[ 0 ] < 0 ? -1 : 1;
		int num1EndPointer = num1.length - 1;
		int num2EndPointer = num2.length - 1;
		int resultEndPointer = result.length - 1;
		
		for( int i = num2EndPointer; i >= 0; i-- ) {
			
			for( int j = num1EndPointer; j >= 0; j-- ) {
				result[ resultEndPointer ] = result[ resultEndPointer ] + Math.abs( num1[ j ] ) 
						* Math.abs( num2[ i ] ) ;
				result[ resultEndPointer - 1 ] = result[ resultEndPointer - 1 ] + 
						( result[ resultEndPointer ] / 10 );
				result[ resultEndPointer ] =  result[ resultEndPointer-- ] % 10;
			}
			resultEndPointer = resultEndPointer + num1EndPointer;
		}
		int counter = 0;
		
		while( result[ counter ] == 0 ) {
			counter++;
		}
		result[ counter ] *= signVal;
		
		return result;
	}

}
