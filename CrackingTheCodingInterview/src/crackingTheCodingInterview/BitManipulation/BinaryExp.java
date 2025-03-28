package crackingTheCodingInterview.BitManipulation;

public class BinaryExp {

	public static void main(String[] args) {
		/*//used in clear bits through 0
		int negative = -1;
		System.out.println( Integer.toBinaryString( negative ) );
		int shiftingNegative = negative << 2;
		System.out.println( Integer.toBinaryString( shiftingNegative ) );
		System.out.println( Integer.toBinaryString( negative & shiftingNegative ) );

		
		//used in clear bits from start to a position
		int num = -1;
		System.out.println( Integer.toBinaryString( num ) );
		int pos = 9;
		System.out.println( Integer.toBinaryString( pos ) );
		int mask = ( 1 << pos ) - 1;
		System.out.println( Integer.toBinaryString( mask ) );
		System.out.println( Integer.toBinaryString( num & mask ) );
		
		//used to clear one particular bit
		num = -1;
		pos = 23;
		mask = ~( 1 << 23 );
		System.out.println( Integer.toBinaryString( num & mask ) );*/
		
		//used to update a value of a particular bit
		int num = 0;
		int pos = 7;
		int valToBeUsed = 1; //can also be one or zero;
		int mask = ~( valToBeUsed  << pos);  
		System.out.println( Integer.toBinaryString( mask ) );
		int changedVal = num & mask;
		System.out.println( changedVal );
		changedVal = changedVal | (valToBeUsed << pos);
		System.out.println( Integer.toBinaryString( changedVal ) );
	}

}
