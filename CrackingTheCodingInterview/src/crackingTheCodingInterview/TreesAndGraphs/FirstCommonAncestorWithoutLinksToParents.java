package crackingTheCodingInterview.TreesAndGraphs;

class CommonAncestorNode {
	private int value;
	private CommonAncestorNode leftNode;
	private CommonAncestorNode rightNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CommonAncestorNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(CommonAncestorNode leftNode) {
		this.leftNode = leftNode;
	}

	public CommonAncestorNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(CommonAncestorNode rightNode) {
		this.rightNode = rightNode;
	}
}

public class FirstCommonAncestorWithoutLinksToParents {

	public static void main(String[] args) {
		CommonAncestorNode zero = new CommonAncestorNode();
		CommonAncestorNode one = new CommonAncestorNode();
		CommonAncestorNode two = new CommonAncestorNode();
		CommonAncestorNode three = new CommonAncestorNode();
		CommonAncestorNode four = new CommonAncestorNode();
		CommonAncestorNode five = new CommonAncestorNode();
		CommonAncestorNode six = new CommonAncestorNode();
		CommonAncestorNode seven = new CommonAncestorNode();
		CommonAncestorNode eight = new CommonAncestorNode();
		CommonAncestorNode nine = new CommonAncestorNode();
		CommonAncestorNode ten = new CommonAncestorNode();

		zero.setValue( 0 );
		one.setValue( 1 );
		two.setValue( 2 );
		three.setValue( 3 );
		four.setValue( 4 );
		five.setValue( 5 );
		six.setValue( 6 );
		seven.setValue( 7 );
		eight.setValue( 8 );
		nine.setValue( 9 );
		ten.setValue( 10 );

		zero.setLeftNode( one );
		zero.setRightNode( two );
		one.setLeftNode( three );
		one.setRightNode( four );
		two.setLeftNode( five );
		two.setRightNode( six );
		three.setRightNode( seven );
		three.setLeftNode( eight );
		five.setLeftNode( nine );
		six.setRightNode( ten );
		
		CommonAncestorNode commonAncestor = findCommonAncestor( seven, four, zero );
		System.out.println( commonAncestor.getValue() );
	}

	private static CommonAncestorNode findCommonAncestor(
			CommonAncestorNode firstNode, CommonAncestorNode secondNode, 
			CommonAncestorNode root ) {
		CommonAncestorNode returnNode = null;
		
		if( root == null ) {
			return returnNode;
		}
		
		if( root.getValue() == firstNode.getValue() ) {
			returnNode = firstNode;
		}
		
		if( root.getValue() == secondNode.getValue() ) {
			returnNode = secondNode;
		}
		
		if( returnNode == null ) {
			CommonAncestorNode nodeLeft = 
					findCommonAncestor(firstNode, secondNode, root.getLeftNode() );
			CommonAncestorNode nodeRight = 
					findCommonAncestor(firstNode, secondNode, root.getRightNode() );
			
			if( nodeLeft != null && nodeRight != null ) {
				returnNode = root;
			} else {
				returnNode = nodeLeft != null ? nodeLeft : nodeRight;
			}
		}
		return returnNode;
	}
}
