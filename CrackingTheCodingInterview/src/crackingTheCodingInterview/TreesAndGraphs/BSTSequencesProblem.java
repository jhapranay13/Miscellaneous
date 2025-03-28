package crackingTheCodingInterview.TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;

class BSTSequencesNode {
	private int value = Integer.MIN_VALUE;
	private BSTSequencesNode leftNode;
	private BSTSequencesNode rightNode;
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public BSTSequencesNode getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(BSTSequencesNode leftNode) {
		this.leftNode = leftNode;
	}
	
	public BSTSequencesNode getRightNode() {
		return rightNode;
	}
	
	public void setRightNode(BSTSequencesNode rightNode) {
		this.rightNode = rightNode;
	}
	
	public void insertNode( int nodeVal ) {
		
		if( this.getValue() == Integer.MIN_VALUE ) {
			this.setValue( nodeVal ); 
		} else if( this.getValue() < nodeVal ) {
			BSTSequencesNode rightTemp = this.getRightNode();
			
			if( rightTemp != null ) {
				rightTemp.insertNode(nodeVal);
			} else {
				rightTemp = new BSTSequencesNode();
				rightTemp.setValue( nodeVal );
				this.setRightNode( rightTemp );
			}
		} else if( this.getValue() > nodeVal ) {
			BSTSequencesNode leftTemp = this.getLeftNode();
			
			if( leftTemp != null ) {
				leftTemp.insertNode(nodeVal);
			} else {
				leftTemp = new BSTSequencesNode();
				leftTemp.setValue( nodeVal );
				this.setLeftNode( leftTemp );
			}
		}
	}
}


public class BSTSequencesProblem {

	public static void main(String[] args) {
		int[] arr = { 6 , 4, 12, 3, 5, 11, 17 };
		BSTSequencesNode root = new BSTSequencesNode();
		
		for( int i = 0; i < arr.length; i++ ) {
			root.insertNode( arr[ i ] );
		}
		List< List< Integer > > allSequence = getAllSequence( root );
		
		for( List< Integer > sequence : allSequence ) {
			System.out.println( sequence );
		}
		System.out.println( "Size >> " + allSequence.size() );
	}

	private static List< List< Integer > > getAllSequence(BSTSequencesNode root) {
		
		if( root == null ) {
			return new LinkedList<>( );
		}
		int prefix = root.getValue();
		List<List<Integer>> left = getAllSequence( root.getLeftNode() );
		List<List<Integer>> right = getAllSequence( root.getRightNode() );
		List< List<Integer> > result = new LinkedList<>();
		
		if( left.isEmpty() && right.isEmpty() ) {
			List< Integer > holder = new LinkedList<>();
			holder.add( root.getValue() );
			result.add( holder );
			return result;
		}
		
		for( List< Integer > leftTemp : left ) {
			
			for( List< Integer > rightTemp: right ) {
				weaveLeftAndRight(leftTemp, rightTemp, new LinkedList< Integer >(), result);
			}
		}
		
		for( List< Integer > resHolder : result ) {
			resHolder.add( 0, prefix );
		}
		return result;
	}

	private static void weaveLeftAndRight(List< Integer > left, List< Integer > right, 
			LinkedList< Integer > prefix, List<List<Integer>> result) {
		
		if( left.isEmpty() || right.isEmpty() ) {
			List< Integer > temp = new LinkedList<>();
			temp.addAll( prefix );
			temp.addAll( (List<Integer>) ( ( LinkedList<Integer> )left ).clone() );
			temp.addAll( (List<Integer>) ( ( LinkedList<Integer> )right ).clone() );
			result.add( temp );
			return;
		}
		
		int leftTempVal = left.remove( 0 );
		prefix.add( leftTempVal );
		weaveLeftAndRight(left, right, prefix, result);
		prefix.removeLast();
		left.add(0, leftTempVal );
		
		int rightTempVal = right.remove( 0 );
		prefix.add( rightTempVal );
		weaveLeftAndRight(left, right, prefix, result);
		prefix.removeLast();
		right.add(0, rightTempVal );
	}
}
