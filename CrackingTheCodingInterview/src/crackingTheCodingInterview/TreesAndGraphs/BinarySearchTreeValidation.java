package crackingTheCodingInterview.TreesAndGraphs;

class TreeNodeValidBST {
	private int val;
	private TreeNodeValidBST leftNode;
	private TreeNodeValidBST rightNode;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNodeValidBST getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNodeValidBST leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNodeValidBST getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNodeValidBST rightNode) {
		this.rightNode = rightNode;
	}
}

class MaxVal {
	int max;
}

public class BinarySearchTreeValidation {

	//Cannot be used in a tree with duplicate values as it might give wrong result
	//since we cannot predict if the duplicate value is on the left or right side
	public static void main(String[] args) {
		TreeNodeValidBST one = new TreeNodeValidBST();
		TreeNodeValidBST two = new TreeNodeValidBST();
		TreeNodeValidBST three = new TreeNodeValidBST();
		TreeNodeValidBST four = new TreeNodeValidBST();
		TreeNodeValidBST five = new TreeNodeValidBST();
		TreeNodeValidBST six = new TreeNodeValidBST();
		TreeNodeValidBST seven = new TreeNodeValidBST();
		
		one.setVal(7);
		two.setVal(4);
		three.setVal(10);
		four.setVal(3);
		five.setVal(5);
		six.setVal(9);
		seven.setVal(11);
		
		one.setLeftNode( two );
		one.setRightNode( three );
		two.setLeftNode( four );
		two.setRightNode( five );
		three.setLeftNode( six );
		three.setRightNode( seven );
		
		boolean validBSTFlag = isValidBST( one );
		System.out.println( validBSTFlag );
	}

	private static boolean isValidBST(TreeNodeValidBST root) {
		MaxVal maxVal = new MaxVal();
		maxVal.max = Integer.MIN_VALUE;
		boolean isValidBSTFlag = inOrderValidChecker( root, maxVal );
		return isValidBSTFlag;
	}

	private static boolean inOrderValidChecker(TreeNodeValidBST root, MaxVal maxVal) {
		
		if( root == null ) {
			return true;
		}
		boolean returnFlag = true;
		TreeNodeValidBST leftNode = root.getLeftNode();
		TreeNodeValidBST rightNode = root.getRightNode();
		
		boolean leftValidFlag = inOrderValidChecker( leftNode, maxVal );
		int currentVal = root.getVal();
		
		if( leftNode == null  ) {
			maxVal.max = currentVal; 
		} else if( maxVal.max < currentVal ) {
			returnFlag = true;
			maxVal.max = currentVal;
		} else {
			returnFlag = false;
		}
		
		if( !returnFlag ) {
			return returnFlag;
		}
		boolean rightValidFlag = inOrderValidChecker( rightNode, maxVal );
		
		if( rightNode == null ) {
			maxVal.max = currentVal;
		} else if( currentVal < maxVal.max ) {
			maxVal.max = rightNode.getVal();
		} else {
			returnFlag = false;
		}
		
		if( !leftValidFlag || !rightValidFlag ) {
			returnFlag = false;
		}
		return returnFlag;
	}
}
