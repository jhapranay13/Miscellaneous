package dynamicProgramming;

public class FibonacciNumber {

	public static void main(String[] args) {
		int num = 7;
		int fibNum = fibRecur( num );
		System.out.println( fibNum );
		
		int[] memo = new int[ num + 1 ];
		fibNum = fibMemo( num, memo ); // Also known as top down approach
		System.out.println( fibNum );
		
		memo = new int[ num + 1 ];
		fibNum = fibDP( num, memo ); // Also known as bottom up approach
		System.out.println( fibNum );
	}

	private static int fibRecur(int num) {
		
		if( num == 0 ) {
			return 0;
		}
		
		if( num == 1 ) {
			return 1;
		}
		return fibRecur( num - 1 ) + fibRecur( num - 2 );
	}

	private static int fibMemo(int num, int[] memo) {
		
		if( num <= 0 ) {
			return 0;
		}
		
		if( num == 1 ) {
			return 1;
		}
		
		if( memo[ num ] != 0 ) {
			return memo[ num ];
		}
		memo[ num ] = fibMemo( num - 1, memo ) + 
				fibMemo( num - 2, memo );
		return memo[ num ];
	}
	
	private static int fibDP(int num, int[] memo) {
		
		memo[ 0 ] = 0;
		memo[ 1 ] = 1;
		
		for( int i = 2; i <= num; i++ ) {
			memo[ i ] = memo[ i - 1 ] + memo[ i - 2 ];
		}
		return memo[ num ];
	}
}
