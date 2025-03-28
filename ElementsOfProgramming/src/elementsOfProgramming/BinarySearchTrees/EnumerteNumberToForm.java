package elementsOfProgramming.BinarySearchTrees;

public class EnumerteNumberToForm {

	/*
	 * 
	 * A key fact about V2 is that it is irrational, i.e., it cannot equal to|for any
integers a,b. This implies that if x + y V2 = x' + y' V2, where x and y are integers, then
x = x' and y = y' (since otherwise V2 =
Here is a brute-force solution. Generate all numbers of the form a + byl where a
and b are integers, 0 < a,b < k - 1. This yields exactly k2 numbers and the k smallest
numbers must lie in this collection. We can sort these numbers and return the k
smallest ones. The time complexity is0(k2 log(fc2)) = 0(k2 log k).
Intuitively, it is wasteful to generate k2 numbers, since we only care about a small
fraction of them.
We know the smallest number is 0+0 V2. The candidates for next smallest number
are 1 + 0 V2 and 0 + 1V2. From this, we can deduce the following algorithm. We
want to maintain a collection of real numbers, initialized to 0 + 0 yl. We perform k
extractions of the smallest element, call it a+ b V2, followed by insertion of (a+l)+b yfl
and a + (b + 1) V2 to the collection.
The operations on this collection are extract the minimum and insert. Since it is
possible that the same number may be inserted more than once, we need to ensure
the collection does not create duplicates when the same item is inserted twice. A
267
BST satisfies these operations efficiently, and is used in the implementation below.
It is initialized to contain 0 + 0 v2. We extract the minimum from the BST, which is
0 + 0 V2, and insert 1 + 0 V2 and 0 + 1V2 to the BST. We extract the minimum from
the BST, which is1 + 0 yfl, and insert 2 + 0 V2 and 1 + 1V2 to the BST, which now
consists of 0 + 1V2 = 1.414, 2 + 0 V2 = 2,1 + 1V2 = 2.414. We extract the minimum
from the BST, which is 0 + 1 V2, and insert 1 + 1V2 and 0 + 2 V2. The first value is
already present, so the BST updates to2 + 0V2 = 2, l + lV2 = 2.414, 0 + 2 V2 = 2.828.
(Although it's not apparent from this small example, the values we add back to the
BST may be smaller than values already present in it, so we really need the BST to
hold values.)
	 * 
	 */
}
