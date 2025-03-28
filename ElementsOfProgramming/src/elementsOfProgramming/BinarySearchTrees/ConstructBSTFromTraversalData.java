package elementsOfProgramming.BinarySearchTrees;

public class ConstructBSTFromTraversalData {
	/*
	 * 
	 * First, with some experimentation, we see the sequence of keys generated
by an inorder traversal is not enough to reconstruct the tree.
	 * 
	 * However, the story for a preorder sequence is different. As an example, con¬
sider the preorder key sequence <43,23,37, 29,31,41,47,53). The root must hold 43,
since it's the first visited node. The left subtree contains keys less than 43, i.e.,
23,37,29,31,41, and the right subtree contains keys greater than 43, i.e., 47,53. Fur¬
thermore, <23,37,29,31,41) is exactly the preorder sequence for the left subtree and
<47,53) is exactly the preorder sequence for the right subtree. We can recursively
reason that 23 and 47 are the roots of the left and right subtree, and continue to build
the entire tree, which is exactly the subtree rooted at Node I in Figure 15.1 on Page 255.
Generalizing, in any preorder traversal sequence, the first key corresponds to the
root. The subsequence which begins at the second element and ends at the last key
less than the root, corresponds to the preorder traversal of the root's left subtree.
The final subsequence, consisting of keys greater than the root corresponds to the
preorder traversal of the root's right subtree. We recursively reconstruct the BST by
recursively reconstructing the left and right subtrees from the two subsequences then
adding them to the root.
	 * 
	 * The implementation above potentially iterates over nodes multiple times, which
is wasteful. A better approach is to reconstruct the left subtree in the same iteration as
identifying the nodes which lie in it. The code shown below takes this approach. The
intuition is that we do not want to iterate from first entry after the root to the last entry
smaller than the root, only to go back and partially repeat this process for the root's
left subtree. We can avoid repeated passes over nodes by including the range of keys
we want to reconstruct the subtrees over. For example, looking at the preorder key
sequence (43, 23,37, 29, 31, 41, 47,53), instead of recursing on (23, 37, 29, 31, 41) (which
would involve an iteration to get the last element in this sequence). We can directly
recur on (23,37, 29, 31, 41, 47,53), with the constraint that we are building the subtree
on nodes whose keys are less than 43.
	 * 
	 */
}
