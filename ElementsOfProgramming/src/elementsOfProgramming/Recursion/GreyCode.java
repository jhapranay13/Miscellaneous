package elementsOfProgramming.Recursion;


/*
 * 
 * 
 * 
 * case analysis. The sequence ((00)2, (01)2, (11)2, (10)2) is a 2-bit Gray code. To get
to n = 3, we cannot just prepend 0 to each elements of ((00)2,(01)2,(11)2,(10)2),
1 to ((00)2, (01)2, (11)2/(10)2) and concatenate the two sequences—that leads to the
Gray code property being violated from (010)2 to (100)2. However, it is preserved
everywhere else.
Since Gray codes differ in one place on wrapping around, prepending 1
to the reverse of ((00)2, (01)2,(11)2, (10)2) solves the problem when transition¬
ing from a leading 0 to a leading 1. For n = 3 this leads to the sequence
((000)2, (001)2, (011)2, (010)2, (110)2, (111)2, (101)2, (100)2). The general solution uses re¬
cursion in conjunction with this reversing, and is presented below.
public static List<Integer> grayCode(int numBits) {
if (numBits == 0) {
return new ArrayList<>(Arrays.asList(0));
}
// These implicitly begin with 0 at bit-index (numBits - 1).
Listdnteger> grayCodeNumBitsMinus1 = grayCode(numBits - 1);
// Now, add a 1 at bit-index (numBits - 1) to all entries in
// grayCodeNumBitsMinus1.
int leadingBitOne = 1 << (numBits - 1);
// Process in reverse order to achieve reflection of grayCodeNumBitsMinusl.
299
for (int i = grayCodeNumBitsMinus1. size () - 1; i >= 0; --i) {
grayCodeNumBitsMinus1. add(leadingBitOne | grayCodeNumBit sMinus1. get (i)) ;
}
return grayCodeNumBitsMinus1 ;
}
Assuming we operate on integers that fit within the size of the integer word, the time
complexity T(n) satisfies T(n) = T(n-1) + 0( 2"-1). the time complexity is0(2").
 * 
 * 
 * 
 * 
 */
public class GreyCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
