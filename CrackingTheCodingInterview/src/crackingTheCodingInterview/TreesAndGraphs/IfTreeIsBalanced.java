package crackingTheCodingInterview.TreesAndGraphs;

class TreeNodeBalanced {
	private int val;
	private TreeNodeBalanced leftNode;
	private TreeNodeBalanced rightNode;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNodeBalanced getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNodeBalanced leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNodeBalanced getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNodeBalanced rightNode) {
		this.rightNode = rightNode;
	}
}

public class IfTreeIsBalanced {

	public static void main(String[] args) {
		TreeNodeBalanced one = new TreeNodeBalanced();
		TreeNodeBalanced two = new TreeNodeBalanced();
		TreeNodeBalanced three = new TreeNodeBalanced();
		TreeNodeBalanced four = new TreeNodeBalanced();
		TreeNodeBalanced five = new TreeNodeBalanced();
		TreeNodeBalanced six = new TreeNodeBalanced();
		TreeNodeBalanced seven = new TreeNodeBalanced();

		one.setVal(1);
		two.setVal(2);
		three.setVal(3);
		four.setVal(4);
		five.setVal(5);
		six.setVal(6);
		seven.setVal(7);

		one.setLeftNode( two );
		one.setRightNode( three );
		two.setLeftNode( four );
		two.setRightNode( five );
		three.setLeftNode( six );
		three.setRightNode( seven );

		int intialHeight = 0;
		int checkBalanced = isBalanced( one, intialHeight );
		System.out.println( checkBalanced );
	}

	private static int isBalanced(TreeNodeBalanced root, int initalHeight ) {
		int leftHeight = 0;
		int rightHeight = 0;

		if( root == null ) {
			return initalHeight - 1;
		}
		leftHeight = isBalanced( root.getLeftNode(), initalHeight + 1 );
		rightHeight = isBalanced( root.getRightNode(), initalHeight + 1 );
		
		if( leftHeight == Integer.MIN_VALUE || rightHeight == Integer.MIN_VALUE ) {
			return Integer.MIN_VALUE;
		}
		
		int difference = Math.abs( leftHeight - rightHeight );
		
		if( difference > 1 ) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max( leftHeight , rightHeight);
		}
	}
}
