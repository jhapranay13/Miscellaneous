package crackingTheCodingInterview.TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;

class BSTSequencesNodeV2 {
	private int value = Integer.MIN_VALUE;
	private BSTSequencesNodeV2 leftNode;
	private BSTSequencesNodeV2 rightNode;
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public BSTSequencesNodeV2 getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(BSTSequencesNodeV2 leftNode) {
		this.leftNode = leftNode;
	}
	
	public BSTSequencesNodeV2 getRightNode() {
		return rightNode;
	}
	
	public void setRightNode(BSTSequencesNodeV2 rightNode) {
		this.rightNode = rightNode;
	}
	
	public void insertNode( int nodeVal ) {
		
		if( this.getValue() == Integer.MIN_VALUE ) {
			this.setValue( nodeVal ); 
		} else if( this.getValue() < nodeVal ) {
			BSTSequencesNodeV2 rightTemp = this.getRightNode();
			
			if( rightTemp != null ) {
				rightTemp.insertNode(nodeVal);
			} else {
				rightTemp = new BSTSequencesNodeV2();
				rightTemp.setValue( nodeVal );
				this.setRightNode( rightTemp );
			}
		} else if( this.getValue() > nodeVal ) {
			BSTSequencesNodeV2 leftTemp = this.getLeftNode();
			
			if( leftTemp != null ) {
				leftTemp.insertNode(nodeVal);
			} else {
				leftTemp = new BSTSequencesNodeV2();
				leftTemp.setValue( nodeVal );
				this.setLeftNode( leftTemp );
			}
		}
	}

	@Override
	public String toString() {
		return  value + "";
	}
}

public class BSTSequencesProblemVersionTwo {

	public static void main(String[] args) {
		int[] arr = { 6 , 4, 12, 3, 5, 11, 17 };
		BSTSequencesNodeV2 root = new BSTSequencesNodeV2();
		
		for( int i = 0; i < arr.length; i++ ) {
			root.insertNode( arr[ i ] );
		}
		List<LinkedList<BSTSequencesNodeV2>> allSequence = getAllSequence( root );
		
		for( List< BSTSequencesNodeV2 > sequence : allSequence ) {
			System.out.println( sequence );
		}
		System.out.println( "Size >> " + allSequence.size() );
	}

	private static List< LinkedList<BSTSequencesNodeV2> > getAllSequence(BSTSequencesNodeV2 root) {
		LinkedList< BSTSequencesNodeV2 > pre = new LinkedList<>();
		LinkedList< BSTSequencesNodeV2 > post = new LinkedList<>();
		List< LinkedList< BSTSequencesNodeV2 > > result = new LinkedList<>();
		
		buildSequence( pre, post, root, result );
		return result;
	}

	private static void buildSequence(LinkedList<BSTSequencesNodeV2> pre, LinkedList<BSTSequencesNodeV2> post, 
			BSTSequencesNodeV2 root, List<LinkedList<BSTSequencesNodeV2>> result) {
		pre.add( root );
		
		if( root.getLeftNode() != null ) {
			post.add( root.getLeftNode() );
		}
		
		if( root.getRightNode() != null ) {
			post.add( root.getRightNode() );
		}
		
		if( post.isEmpty() ) {
			result.add( pre );
		}
		
		for( int i = 0; i < post.size(); i++ ) {
			LinkedList< BSTSequencesNodeV2 > tempPre = (LinkedList<BSTSequencesNodeV2>) pre.clone();
			LinkedList< BSTSequencesNodeV2 > tempPost = (LinkedList<BSTSequencesNodeV2>) post.clone();
			BSTSequencesNodeV2 temp = tempPost.remove( i );

			buildSequence(tempPre, tempPost, temp, result);
		}
		
	
	}
}
