package crackingTheCodingInterview.TreesAndGraphs;

class CommonAncestorNodeWithParentLink {
	private CommonAncestorNodeWithParentLink parent;
	private int value;
	private CommonAncestorNodeWithParentLink leftNode;
	private CommonAncestorNodeWithParentLink rightNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public CommonAncestorNodeWithParentLink getParent() {
		return parent;
	}

	public void setParent(CommonAncestorNodeWithParentLink parent) {
		this.parent = parent;
	}

	public CommonAncestorNodeWithParentLink getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(CommonAncestorNodeWithParentLink leftNode) {
		this.leftNode = leftNode;
	}

	public CommonAncestorNodeWithParentLink getRightNode() {
		return rightNode;
	}

	public void setRightNode(CommonAncestorNodeWithParentLink rightNode) {
		this.rightNode = rightNode;
	}
}

public class FirstCommonAncestorWithLinksToParent {

	public static void main(String[] args) {
		CommonAncestorNodeWithParentLink zero = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink one = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink two = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink three = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink four = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink five = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink six = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink seven = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink eight = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink nine = new CommonAncestorNodeWithParentLink();
		CommonAncestorNodeWithParentLink ten = new CommonAncestorNodeWithParentLink();

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
		one.setParent( zero );
		zero.setRightNode( two );
		two.setParent( zero );
		one.setLeftNode( three );
		three.setParent( one );
		one.setRightNode( four );
		four.setParent( one );
		two.setLeftNode( five );
		five.setParent( two );
		two.setRightNode( six );
		six.setParent( two );
		three.setRightNode( seven );
		seven.setParent( three );
		three.setLeftNode( eight );
		eight.setParent( three );
		five.setLeftNode( nine );
		nine.setParent( five );
		six.setRightNode( ten );
		ten.setParent( six );

		CommonAncestorNodeWithParentLink commonAncestor = findCommonAncestor( three, ten );
		System.out.println( commonAncestor.getValue() );
	}

	private static CommonAncestorNodeWithParentLink findCommonAncestor(
			CommonAncestorNodeWithParentLink firstNode,
			CommonAncestorNodeWithParentLink secondNode) {
		CommonAncestorNodeWithParentLink commonAncestor = null;
		int depthOfFirstNode = 0;
		CommonAncestorNodeWithParentLink tempFirst = firstNode;

		while( tempFirst != null ) {
			tempFirst = tempFirst.getParent();
			depthOfFirstNode++;
		}
		int depthOfSecondNode = 0;
		CommonAncestorNodeWithParentLink tempSecond = secondNode;

		while( tempSecond != null ) {
			tempSecond = tempSecond.getParent();
			depthOfSecondNode++;
		}
		tempFirst = firstNode;
		tempSecond = secondNode;

		while( tempFirst != null && tempSecond != null ) {

			if( depthOfFirstNode > depthOfSecondNode ) {
				tempFirst = tempFirst.getParent();
				depthOfFirstNode--;
				continue;
			} else if( depthOfFirstNode < depthOfSecondNode ) {
				tempSecond = tempSecond.getParent();
				depthOfSecondNode--;
				continue;
			} 
			
			if( tempFirst.getValue() == tempSecond.getValue() ) {
				commonAncestor = tempFirst;
				break;
			}
			tempFirst = tempFirst.getParent();
			depthOfFirstNode--;
			tempSecond = tempSecond.getParent();
			depthOfSecondNode--;
		}
		return commonAncestor;
	}
}
