package elementsOfProgramming.BinarySearchTrees;

public class LCABST {

	/*
	 * 
	 * In Solution 10.3 on Page 156 we presented an algorithm for this problem in
the context of binary trees. The idea underlying that algorithm was to do a postorder
traversal—the LCA is the first node visited after the two nodes whose LCA we are to
compute have been visited. The time complexity was0(n), where n is the number of
nodes in the tree.
This approach can be improved upon when operating on BSTs with distinct keys.
Consider the BST in Figure 15.1 on Page 255 and nodes C and G. Since both C and
G holds keys that are smaller than A's key, their LCA must lie in A's left subtree.
Examining B, since C's key is less than B's key, and B's key is less than G's key. B
must be the LCA of C and G.
Let s and b be the two nodes whose LCA we are to compute, and without loss
of generality assume the key at s is smaller. (Since the problem specified keys are
distinct, it cannot be that s and b hold equal keys.) Consider the key stored at the root
of the BST. There are four possibilities:
• If the root's key is the same as that stored at s or at b, we are done—the root is
the LCA.
• If the key at s is smaller than the key at the root, and the key at b is greater than
the key at the root, the root is the LCA.
261
• If the keys at s and b are both smaller than that at the root, the LCA must he in
the left subtree of the root.
• If both keys are larger than that at the root, then the LCA must he in the right
subtree of the root.
	 * 
	 * 
	 */
}
