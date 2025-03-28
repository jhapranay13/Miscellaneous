package elementsOfProgramming.BinarySearchTrees;

import java.util.Deque;
import java.util.LinkedList;

public class TestIf3BSTNodesAreOrdered {

	public static void main( String args[] ) {
		BinarySearchNode root = new BinarySearchNode( 8 );
		BinarySearchNode node1 = new BinarySearchNode( 5 );
		BinarySearchNode node2 = new BinarySearchNode( 12 );
		BinarySearchNode node3 = new BinarySearchNode( 6 );
		BinarySearchNode node4 = new BinarySearchNode( 11 );
		BinarySearchNode node5 = new BinarySearchNode( 4 );
		BinarySearchNode node6 = new BinarySearchNode( 15 );
		BinarySearchNode node7 = new BinarySearchNode( 7 );
		BinarySearchNode node8 = new BinarySearchNode( 10 );
		BinarySearchNode node9 = new BinarySearchNode( 9 );

		root.left = node1;
		root.right = node2;
		node1.left = node5;
		node1.right = node3;
		node2.left = node4;
		node2.right = node6;
		node3.right = node7;
		node4.left = node8;
		node8.left = node9;

		BinarySearchNode search1 = root;
		BinarySearchNode search2 = node6;
		BinarySearchNode middle = node2;
		printTree( root );

		boolean isInOrderFlag = testIfInOrder( search1, search2, middle );
		System.out.println( isInOrderFlag );

	}

	//Search Both The Nodes. If any Node Is found then continue Search From that Node
	private static boolean testIfInOrder(BinarySearchNode search1, BinarySearchNode search2, 
			BinarySearchNode middle) {
		BinarySearchNode srch1 = search1;
		BinarySearchNode srch2 = search2;
		
		while(  srch1 != null || srch2 != null ) {
			
			if( srch1.data != middle.data && srch1.data != search2.data ) {
				srch1 = srch1.data > middle.data ? srch1.left : srch1.right;
			} else {
				break;
			}
			
			if( srch2.data != middle.data && srch2.data != search1.data  ) {
				srch2 = srch2.data > middle.data ? srch2.left : srch2.right;
			} else {
				break;
			}
		}
		
		if( ( srch1 != null && srch1.data != middle.data ) || 
				(srch2 != null && srch2.data != middle.data ) ) {
			return false;
		}
		return srch1.data == middle.data ? searchTarget( middle, search2) :
				searchTarget( middle, search1);
	}

	private static boolean searchTarget(BinarySearchNode middle, BinarySearchNode search) {
		
		while( middle != null ) {
			
			if( middle.data == search.data ) {
				return true;
			}
			middle = middle.data > search.data ? middle.left : middle.right;
		}
		
		return false;
	}

	private static void printTree(BinarySearchNode root) {
		Deque< BinarySearchNode > queue = new LinkedList<BinarySearchNode>();
		Deque< BinarySearchNode > childQueue = new LinkedList<BinarySearchNode>();
		queue.add( root );

		while( !queue.isEmpty() ) {
			BinarySearchNode temp = queue.poll();
			System.out.print( temp.data + " " );

			if( temp.left != null ) {
				childQueue.add( temp.left );
			}

			if( temp.right != null ) {
				childQueue.add( temp.right );
			}	

			if( queue.isEmpty() ) {
				System.out.println();
				queue = childQueue;
				childQueue = new LinkedList<BinarySearchNode>();
			}
		}
		System.out.println( "=================" );
	}
}
