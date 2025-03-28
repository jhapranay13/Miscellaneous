package crackingTheCodingInterview.TreesAndGraphs;

class TreeNodeValidBSTArr {
	private int val;
	private TreeNodeValidBSTArr leftNode;
	private TreeNodeValidBSTArr rightNode;

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNodeValidBSTArr getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNodeValidBSTArr leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNodeValidBSTArr getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNodeValidBSTArr rightNode) {
		this.rightNode = rightNode;
	}
}


public class BinarySearchTreeValidationUsingArray {

	public static void main(String[] args) {
		TreeNodeValidBSTArr one = new TreeNodeValidBSTArr();
		TreeNodeValidBSTArr two = new TreeNodeValidBSTArr();
		TreeNodeValidBSTArr three = new TreeNodeValidBSTArr();
		TreeNodeValidBSTArr four = new TreeNodeValidBSTArr();
		TreeNodeValidBSTArr five = new TreeNodeValidBSTArr();
		TreeNodeValidBSTArr six = new TreeNodeValidBSTArr();
		TreeNodeValidBSTArr seven = new TreeNodeValidBSTArr();
		
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
		
		int treeSize = 7;
		boolean validBSTFlag = isValidBST( one, treeSize );
		System.out.println( validBSTFlag );
	}

	private static boolean isValidBST(TreeNodeValidBSTArr root, int treeSize) {
		int treeHolder[] = new int[ treeSize ];
		int counter = 0;
		populateTreeHolderInOrderTraversal( root, treeHolder, counter );
		boolean validBSTFlag = true;
		
		for( int i = 1; i < treeHolder.length; i++ ) {
			
			if( treeHolder[ i ] < treeHolder[ i - 1 ] ) {
				validBSTFlag = false;
				break;
			}
		}
		
		return validBSTFlag;
	}

	private static int populateTreeHolderInOrderTraversal(TreeNodeValidBSTArr root, int[] treeHolder, 
			int counter) {
		
		if( root == null ) {
			return counter;
		}
		TreeNodeValidBSTArr leftNode =  root.getLeftNode();
		int cntr = populateTreeHolderInOrderTraversal( leftNode , treeHolder, counter);	
		treeHolder[ cntr++ ] = root.getVal();
		TreeNodeValidBSTArr rightNode =  root.getRightNode();
		cntr = populateTreeHolderInOrderTraversal( rightNode , treeHolder, cntr);
		return cntr;
	}
}
