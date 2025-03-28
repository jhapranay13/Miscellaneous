package elementsOfProgramming.BinarySearchTrees;

import java.util.Deque;
import java.util.LinkedList;

public class DeleteFromBSTIteration {

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
		//deleteFromBSTInOrderPredecessor( root, 5 );
		deleteFromBSTInOrderSuccessor( root, 5 );
		printTree( root );
	}
	
	private static void deleteFromBSTInOrderSuccessor(BinarySearchNode root,
			int nodeToBeDeleted ) {
		BinarySearchNode parent = null;
		BinarySearchNode current = root;
		
		while( current != null ) {
			
			if( nodeToBeDeleted > current.data ) {
				parent = current;
				current = current.right;
			} else if( nodeToBeDeleted < current.data ) {
				parent = current;
				current = current.left;
			} else {
				break;
			}
		}
		
		if( current != null ) {
			BinarySearchNode dataNode = null;
			
			if( current.right != null  ) {
				dataNode = getDataAndDeleteRightMinimum( current );
			} else {

				if( parent.left.data == current.data ) {
					parent.left = current.left;
					current.left = null;
				} else {
					parent.right = current.left;
					current.left = null;
				}
			}
			
			if( dataNode == null ) {
				
				if( parent.left.data == current.data ) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else {
				current.data = dataNode.data;
			}
		}
	}

	private static BinarySearchNode getDataAndDeleteRightMinimum(BinarySearchNode current) {
		BinarySearchNode curr = current.right;
		BinarySearchNode parent = current;
		int counter = 0;
		
		while( curr != null ) {
			
			if( curr.left == null ) {
				break;
			}
			parent = curr;
			curr = curr.left;
			counter++;
		}
		if( counter > 0 ) { 
			parent.left = null;
		} else {
			parent.right = null;
		}
		return curr;
	}

	private static void deleteFromBSTInOrderPredecessor(BinarySearchNode root,
			int nodeToBeDeleted) {
		BinarySearchNode parent = null;
		BinarySearchNode current = root;
		
		while( current != null ) {
			
			if( nodeToBeDeleted > current.data ) {
				parent = current;
				current = current.right;
			} else if( nodeToBeDeleted < current.data ) {
				parent = current;
				current = current.left;
			} else {
				break;
			}
		}
		
		if( current != null ) {
			BinarySearchNode dataNode = null;
			
			if( current.left != null  ) {
				dataNode = getDataAndDeleteLeftMaximum( current );
			} else {

				if( parent.right.data == current.data ) {
					parent.right = current.right;
					current.right = null;
				} else {
					parent.left = current.right;
					current.right = null;
				}
			}
			
			if( dataNode == null ) {
				
				if( parent.left.data == current.data ) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else {
				current.data = dataNode.data;
			}
		}
	}

	private static BinarySearchNode getDataAndDeleteLeftMaximum(BinarySearchNode left) {
		BinarySearchNode current = left.left;
		BinarySearchNode parent = left;
		int counter = 0;
		
		while( current != null ) {
			
			if( current.right == null ) {
				break;
			}
			parent = current;
			current = current.right;
			counter++;
		}
		if( counter > 0 ) { 
			parent.right = null;
		} else {
			parent.left = null;
		}
		return current;
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
