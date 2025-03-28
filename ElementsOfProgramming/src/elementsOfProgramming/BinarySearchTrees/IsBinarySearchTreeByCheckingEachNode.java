package elementsOfProgramming.BinarySearchTrees;

import java.util.Deque;
import java.util.LinkedList;
//Can also Be Done in BST and inOrderTrversal. BST might reduce time complexity if
//the node that violates the principle is at upper level.
public class IsBinarySearchTreeByCheckingEachNode {
	
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
		// Change it to 19 to violate BST principle which will return false

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
		boolean binaryTreeFlag = isBinaryTree( root );
		System.out.println( binaryTreeFlag );
	}

	private static boolean isBinaryTree(BinarySearchNode root) {
		
		if( root == null ) {
			return true;
		}
		boolean leftFlag = true;
		boolean rightFlag = true;
		
		if( root.left != null ) {
			leftFlag = isBinaryTree( root.left );
			
			if( leftFlag ) {
				leftFlag =  root.data > root.left.data;
			}
		}
		
		if( root.right != null ) {
			rightFlag = isBinaryTree( root.right );
			
			if( rightFlag ) {
				rightFlag = root.data < root.right.data;
			}
		}
		
		return rightFlag && leftFlag;
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
	}
}
