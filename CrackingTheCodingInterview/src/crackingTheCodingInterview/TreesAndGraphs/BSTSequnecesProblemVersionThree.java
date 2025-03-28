package crackingTheCodingInterview.TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;

class BSTSequencesNodeV3 {
	private int value = Integer.MIN_VALUE;
	private BSTSequencesNodeV3 leftNode;
	private BSTSequencesNodeV3 rightNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BSTSequencesNodeV3 getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BSTSequencesNodeV3 leftNode) {
		this.leftNode = leftNode;
	}

	public BSTSequencesNodeV3 getRightNode() {
		return rightNode;
	}

	public void setRightNode(BSTSequencesNodeV3 rightNode) {
		this.rightNode = rightNode;
	}

	public void insertNode( int nodeVal ) {

		if( this.getValue() == Integer.MIN_VALUE ) {
			this.setValue( nodeVal ); 
		} else if( this.getValue() < nodeVal ) {
			BSTSequencesNodeV3 rightTemp = this.getRightNode();

			if( rightTemp != null ) {
				rightTemp.insertNode(nodeVal);
			} else {
				rightTemp = new BSTSequencesNodeV3();
				rightTemp.setValue( nodeVal );
				this.setRightNode( rightTemp );
			}
		} else if( this.getValue() > nodeVal ) {
			BSTSequencesNodeV3 leftTemp = this.getLeftNode();

			if( leftTemp != null ) {
				leftTemp.insertNode(nodeVal);
			} else {
				leftTemp = new BSTSequencesNodeV3();
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

public class BSTSequnecesProblemVersionThree {

	public static void main(String[] args) {
		int[] arr = { 6 , 4, 12, 3, 5, 11, 17 };
		BSTSequencesNodeV3 root = new BSTSequencesNodeV3();

		for( int i = 0; i < arr.length; i++ ) {
			root.insertNode( arr[ i ] );
		}
		List<LinkedList<Integer>> allSequence = getAllSequence( root );

		for( List< Integer > sequence : allSequence ) {
			System.out.println( sequence );
		}
		System.out.println( "Size >> " + allSequence.size() );

	}

	private static List< LinkedList< Integer > > getAllSequence(BSTSequencesNodeV3 root) {
		LinkedList< BSTSequencesNodeV3 > preFixNodes = new LinkedList<>();
		LinkedList< Integer > preFixValue = new LinkedList<>();
		LinkedList< LinkedList< Integer > > result = new LinkedList<>();

		if( root.getLeftNode() != null ) {
			preFixNodes.add( root.getLeftNode() );
			preFixValue.add( root.getLeftNode().getValue() );
		}
		
		if( root.getRightNode() != null ) {
			preFixNodes.add( root.getRightNode() );
			preFixValue.add( root.getRightNode().getValue() );
		}
		result.add( (LinkedList<Integer>) preFixValue.clone() );
		permute( preFixValue, result, 0 );
		
		for( LinkedList< Integer > tempList : result ) {
			tempList.addFirst( root.getValue() );
		}
		result = buildSequences( preFixNodes, result ); 

		return result;
	}

	private static LinkedList<LinkedList<Integer>> buildSequences(LinkedList<BSTSequencesNodeV3> preFixNodes,
			LinkedList<LinkedList<Integer>> result) {
		
		if( preFixNodes.size() == 0  ) {
			return result;
		}
		LinkedList<LinkedList<Integer>> resultTemp = new LinkedList<>();
		LinkedList<LinkedList<Integer>> mergedResult = new LinkedList<>();
		LinkedList<BSTSequencesNodeV3> nextPreFixNodes = new LinkedList<>();
		LinkedList<Integer> nextPreFixValues = new LinkedList<>();

		for( BSTSequencesNodeV3 tempNode : preFixNodes ) {
			
			if( tempNode.getLeftNode() != null ) {
				nextPreFixNodes.add( tempNode.getLeftNode() );
				nextPreFixValues.add( tempNode.getLeftNode().getValue() );
			}
			
			if( tempNode.getRightNode() != null ) {
				nextPreFixNodes.add( tempNode.getRightNode() );
				nextPreFixValues.add( tempNode.getRightNode().getValue() );
			}
		}
		permute( nextPreFixValues , resultTemp, 0);
		
		for( List< Integer > pre : result  ) {
			
			for( List< Integer > post : resultTemp ) {
				LinkedList<Integer> tempMerge = new LinkedList<>();
				tempMerge.addAll( pre );
				tempMerge.addAll( post );
				mergedResult.add( tempMerge );
			}
		}
		return buildSequences(nextPreFixNodes, mergedResult);
	}

	private static void permute(LinkedList<Integer> list, LinkedList<LinkedList<Integer>> permuteResult,
			int fromIndex) {
		int endIndex = list.size() - 1;
		
		if( fromIndex == endIndex ) {
			return;
		}
		
		for( int i = fromIndex; i <= endIndex; i++ ) {
			permute(list, permuteResult, fromIndex + 1);
			
			if( i == endIndex ) {
				permuteResult.add( (LinkedList<Integer>) list.clone() );
				swap(i, endIndex, list);
			} else {
				swap( i, endIndex, list );
			}
		}
	}

	private static void swap(int fromIndex, int lastIndex, LinkedList<Integer> list) {
		int temp = list.get( lastIndex );
		list.set( lastIndex , list.get( fromIndex ) );
		list.set( fromIndex , temp );
	}
}
