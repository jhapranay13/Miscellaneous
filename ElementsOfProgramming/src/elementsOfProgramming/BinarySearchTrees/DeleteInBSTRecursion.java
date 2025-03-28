package elementsOfProgramming.BinarySearchTrees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DeleteInBSTRecursion {

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
		
		printTree( root );
		root = deleteFromBSTInOrderPredecessor( root, 5 );
		//root = deleteFromBSTInOrderSuccessor( root, 5 );
		printTree( root );
	}

	private static BinarySearchNode deleteFromBSTInOrderSuccessor(BinarySearchNode root, 
			int nodeToBeDeleted  ) {
		if( root == null ) {
			return null;
		}
		
		if( root.data < nodeToBeDeleted ) {
			root.right = deleteFromBSTInOrderSuccessor(root.right, nodeToBeDeleted);
		} else if( root.data > nodeToBeDeleted ){
			root.left = deleteFromBSTInOrderSuccessor(root.left, nodeToBeDeleted);
		} else {
			
			if( root.left == null ) {
				return root.right;
			} else if( root.right == null ) {
				return root.left;
			}
			root.data = getRightMinimum( root.right );
			root.right = deleteFromBSTInOrderSuccessor(root.right, root.data);
		}
		return root;
	}

	private static int getRightMinimum(BinarySearchNode node) {
		
		while( node.left != null ) {
			
			if( node.left == null ) {
				break;
			}
			node = node.left;
		}
		return node.data;
	}

	private static BinarySearchNode deleteFromBSTInOrderPredecessor(BinarySearchNode root, 
			int nodeToBeDeleted ) {
		
		if( root == null ) {
			return null;
		}
		
		if( root.data < nodeToBeDeleted ) {
			root.right = deleteFromBSTInOrderPredecessor(root.right, nodeToBeDeleted);
		} else if( root.data > nodeToBeDeleted ){
			root.left = deleteFromBSTInOrderPredecessor(root.left, nodeToBeDeleted);
		} else {
			
			if( root.left == null ) {
				return root.right;
			} else if( root.right == null ) {
				return root.left;
			}
			root.data = getLeftMaximum( root.left );
			root.left = deleteFromBSTInOrderPredecessor(root.left, root.data);
			
		}
		return root;
	}
	
	private static int getLeftMaximum(BinarySearchNode left) {
		
		while( left != null ) {
			
			if( left.right == null ) {
				break;
			}
			left = left.right;
		}
		return left.data;
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
