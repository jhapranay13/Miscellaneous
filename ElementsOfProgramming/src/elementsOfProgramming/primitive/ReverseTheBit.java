package elementsOfProgramming.primitive;

//Not Complete
public class ReverseTheBit {

	public static void main(String[] args) {
		long word = 999999999999999997L;
		System.out.println( word );
		System.out.println( Long.toBinaryString(word) );
		long reversedWord = reverse( word );
		System.out.println( reversedWord );
		System.out.println( Long.toBinaryString(reversedWord) );
	}

	private static long reverse(long word) {
		long resultWord = word;
		
		for( long i = 0, j = 62; i <= 62 / 2 && i <= j; i++, j-- ) {
			long maskHead = 1L << i;
			//System.out.println( Long.toBinaryString( maskHead ) );
			long maskTail = 1L << j;
			//System.out.println( Long.toBinaryString( maskTail ) );
			
			long bitAtHead = word & maskHead;
			//System.out.println( "HEAD >> " + Long.toBinaryString( bitAtHead ) );
			long bitAtTail = word & maskTail;
			//System.out.println( "TAIL >> " + Long.toBinaryString( bitAtTail ) );
			
			if( ( bitAtHead >= 1 && bitAtTail >= 1 ) || 
					( bitAtHead == 0 && bitAtTail >= 0 ) ) {
				continue;
			} else {
				resultWord ^= maskHead;
				resultWord ^= maskTail;
			}
		}
		return resultWord;
	}
}
