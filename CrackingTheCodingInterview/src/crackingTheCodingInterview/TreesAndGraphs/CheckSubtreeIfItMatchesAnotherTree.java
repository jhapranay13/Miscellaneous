package crackingTheCodingInterview.TreesAndGraphs;

class BSTNodeSubtree {
	private int value = Integer.MIN_VALUE;
	private BSTNodeSubtree leftNode;
	private BSTNodeSubtree rightNode;
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public BSTNodeSubtree getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(BSTNodeSubtree leftNode) {
		this.leftNode = leftNode;
	}
	
	public BSTNodeSubtree getRightNode() {
		return rightNode;
	}
	
	public void setRightNode(BSTNodeSubtree rightNode) {
		this.rightNode = rightNode;
	}
	
	public void insertNode( int nodeVal ) {
		
		if( this.getValue() == Integer.MIN_VALUE ) {
			this.setValue( nodeVal ); 
		} else if( this.getValue() < nodeVal ) {
			BSTNodeSubtree rightTemp = this.getRightNode();
			
			if( rightTemp != null ) {
				rightTemp.insertNode(nodeVal);
			} else {
				rightTemp = new BSTNodeSubtree();
				rightTemp.setValue( nodeVal );
				this.setRightNode( rightTemp );
			}
		} else if( this.getValue() > nodeVal ) {
			BSTNodeSubtree leftTemp = this.getLeftNode();
			
			if( leftTemp != null ) {
				leftTemp.insertNode(nodeVal);
			} else {
				leftTemp = new BSTNodeSubtree();
				leftTemp.setValue( nodeVal );
				this.setLeftNode( leftTemp );
			}
		}
	}
}


public class CheckSubtreeIfItMatchesAnotherTree {
	//InOrder Travversal Won't work as it gives the sorted order but does not account for
	//Structure Of the tree.
	//Pre Order Or post Order traversal would work.
	public static void main(String[] args) {
		int arr1[] = { 6 , 4, 12, 3, 5, 11, 17 };
		int arr2[] = { 12, 11, 17 };
		BSTNodeSubtree treeOneRoot = new BSTNodeSubtree();
		BSTNodeSubtree treeTwoRoot = new BSTNodeSubtree();
		
		for( int i = 0; i < arr1.length; i++ ) {
			treeOneRoot.insertNode( arr1[ i ] );
		}
		
		for( int i = 0; i < arr2.length; i++ ) {
			treeTwoRoot.insertNode( arr2[ i ] );
		}
		
		StringBuilder treeOnePreOrder = new StringBuilder();
		StringBuilder treeTwoPreOrder = new StringBuilder();
		int level = 0;
		getTreePreOrder( treeOneRoot, treeOnePreOrder, level );
		getTreePreOrder( treeTwoRoot, treeTwoPreOrder, level );
		int index = treeOnePreOrder.indexOf( treeTwoPreOrder.toString() );
		System.out.println( index );
		
		if( index > -1 ) {
			System.out.println( "TRUE" );
		} else {
			System.out.println( "FALSE" );
		}
	}

	private static void getTreePreOrder(BSTNodeSubtree treeRoot, StringBuilder treePreOrder, 
			int level) {
		
		if( treeRoot == null ) {
			return;
		}
		
		if( level > 0 ) {
			treePreOrder.append( ", " );
		}
		treePreOrder.append( treeRoot.getValue() );
		getTreePreOrder( treeRoot.getLeftNode(), treePreOrder, level + 1 );
		getTreePreOrder( treeRoot.getRightNode(), treePreOrder, level + 1 );
	}

}
