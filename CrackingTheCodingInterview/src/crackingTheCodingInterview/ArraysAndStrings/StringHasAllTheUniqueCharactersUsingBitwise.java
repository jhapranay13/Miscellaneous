package crackingTheCodingInterview.ArraysAndStrings;

public class StringHasAllTheUniqueCharactersUsingBitwise {

	/*
	 * 
		A	B	A & B	A | B	A ^ B
		1	0	  0	      1	      1
		0	1	  0	      1	      1
        1	1	  1	      1	      0
        0	0	  0	      0	      0


        Signed Left Shift takes two operands. It takes the bit pattern of the first operand and shifts 
        it to the left by the number of places given by the second operand. For example 5 << 3: 
        What happens in this case - Every bit in the binary representation of the integer 5 is shifted 
        by 3 positions to the left. All the places on the left are padded by zeros. That is:

		00000000 00000000 00000000 00000101
		becomes

		00000000 00000000 00000000 00101000
		You can note that the integer result of 5 << 3 is 40. That shows that shifting a number by one 
		is equivalent to multiplying it by 2, or more generally left shifting a number by n positions is
		 equivalent to multiplication by 2^n.

		There are several additional interesting aspects to this:

		Even though you can use shifting of byte, short or char, they are promoted to 32-bit integer
		 before the shifting
		Bit-shift operators never throw an exception
		The right operand (the number of positions to shift) is reduced to modulo 32. 
		That is 5 <<35 is equivalent to 5 << 3.

		Negative Integers in Java
		There are actually two types of right shift. Signed and unsigned. The difference is how they treat 
		negative numbers. To understand the difference, it is necessary to know how negative numbers are 
		represented in Java. Binary representation on its own does not provide information whether the number 
		is negative. There needs to be a special rule to define how to represent negative numbers in binary. 
		There are several approaches to this problem.

		One solution is that the leftmost (Most Significant) bit is a sign bit. 
		That means that its value indicates whether the number is positive or negative. This has, however,
		 some disadvantages such as that there are two ways of representing zero.

		Java uses another approach, which is called two's complement. 
		Negative numbers are representing by negating (flipping) all the bits and then adding 1. 
		Still, if the leftmost bit is 0, the number is positive. Otherwise, it is negative.

		Signed Right Shift [>>]
		Signed right shift moves all the bits by given number of positions to the right. However,
		 it preserves the sign. Positive numbers remain positive and negative ones remain negative. 
		 Similar to left shift, the right shift of n positions is equivalent to division by 2^n. 
		 Or division by 2^n -1 in case of odd numbers.
	 */
	public static boolean uniqueCharacters(String str) 
	{ 
		// Assuming string can have characters a-z 
		// this has 32 bits set to 0

		int checker = 0; 
		// 90 to 97 is Special Characters
		// 65 t 90 A - Z
		// 97 to 122 a - z
		//int bit size = 32
		char exp = 122;
		System.out.println( exp );

		for (int i = 0; i < str.length(); i++) { 
			int bitAtIndex = str.charAt(i) - 'a'; 
			//int checkNit = str.charAt( i );

			/*System.out.println( Integer.toBinaryString(checkNit) );
            System.out.println( Integer.toBinaryString( checker ) );
            System.out.println( bitAtIndex );
            System.out.println( Integer.toBinaryString(bitAtIndex) );
            System.out.println( Integer.toBinaryString((1 << bitAtIndex)) );
            System.out.println(  1 << bitAtIndex );
            System.out.println( Integer.toBinaryString((checker & (1 << bitAtIndex))) );
            System.out.println( Integer.toBinaryString( ( checker | (1 << bitAtIndex) ) ) );*/


			// if that bit is already set in checker, 
			// return false  
			if ((checker & (1 << bitAtIndex)) > 0) {
				return false; 
			} 
			// otherwise update and continue by 
			// setting that bit in the checker 
			checker = checker | (1 << bitAtIndex); 
		}
		// no duplicates encountered, return true 
		return true; 
	}

	// Driver Code 
	public static void main(String args[]) 
	{ 
		String input = "GeekforGeeks"; 

		if ( uniqueCharacters(input)) 
			System.out.println("The String " + input 
					+ " has all unique characters"); 
		else
			System.out.println("The String " + input 
					+ " has duplicate characters"); 
	} 

}
