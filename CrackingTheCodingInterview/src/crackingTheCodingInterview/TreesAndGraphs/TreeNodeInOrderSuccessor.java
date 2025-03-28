package crackingTheCodingInterview.TreesAndGraphs;

class TreeNodeInOrderSucc {
	private int val;
	private TreeNodeInOrderSucc parent;
	private TreeNodeInOrderSucc leftNode;
	private TreeNodeInOrderSucc rightNode;

	public TreeNodeInOrderSucc getParent() {
		return parent;
	}

	public void setParent(TreeNodeInOrderSucc parent) {
		this.parent = parent;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNodeInOrderSucc getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNodeInOrderSucc leftNode) {
		this.leftNode = leftNode;
	}

	public TreeNodeInOrderSucc getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNodeInOrderSucc rightNode) {
		this.rightNode = rightNode;
	}
}

public class TreeNodeInOrderSuccessor {

	public static void main(String[] args) {
		TreeNodeInOrderSucc one = new TreeNodeInOrderSucc();
		TreeNodeInOrderSucc two = new TreeNodeInOrderSucc();
		TreeNodeInOrderSucc three = new TreeNodeInOrderSucc();
		TreeNodeInOrderSucc four = new TreeNodeInOrderSucc();
		TreeNodeInOrderSucc five = new TreeNodeInOrderSucc();
		TreeNodeInOrderSucc six = new TreeNodeInOrderSucc();
		TreeNodeInOrderSucc seven = new TreeNodeInOrderSucc();

		one.setVal(7);
		two.setVal(4);
		three.setVal(10);
		four.setVal(3);
		five.setVal(5);
		six.setVal(9);
		seven.setVal(11);

		two.setParent(one);
		three.setParent(one);
		four.setParent(two);
		five.setParent(two);
		six.setParent(three);
		seven.setParent(three);

		one.setLeftNode( two );
		one.setRightNode( three );
		two.setLeftNode( four );
		two.setRightNode( five );
		three.setLeftNode( six );
		three.setRightNode( seven );
		int level = 0;
		TreeNodeInOrderSucc inOrderSuccesorNode = getInOrderSuccessorNode( one, level );
		System.out.println( inOrderSuccesorNode.getVal() );
	}

	private static TreeNodeInOrderSucc getInOrderSuccessorNode(TreeNodeInOrderSucc node, int level) {
		TreeNodeInOrderSucc returnNode = null;


		if( level == 0) {
			TreeNodeInOrderSucc rightNode = node.getRightNode();

			if( rightNode == null ) {

				if( node.getParent() != null ) {
					returnNode = node.getParent();
				}
			} else {
				returnNode = getInOrderSuccessorNode( rightNode, level + 1 );  
			}
		} else {
			TreeNodeInOrderSucc leftNode = node.getLeftNode();
			
			if( leftNode == null ) {
				returnNode = node;
			} else {
				returnNode = getInOrderSuccessorNode( leftNode, level );
			}
		}
		return returnNode;
	}
}
