package elementsOfProgramming.BinaryTrees;

public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	
	public BinaryTreeNode(int i, BinaryTreeNode left2, BinaryTreeNode right2) {
		data = i;
		left = left2;
		right = right2;
	}

	public BinaryTreeNode() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BinaryTreeNode [data=" + data + "]";
	}
}
