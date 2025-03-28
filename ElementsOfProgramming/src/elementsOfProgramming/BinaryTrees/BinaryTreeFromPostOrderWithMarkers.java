package elementsOfProgramming.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeFromPostOrderWithMarkers {

	public static void main(String[] args) {
		int[] postOrderData = { 0, 0, 0 , 12, 11, 0, 10, 0, 9, 0, 0, 0, 1, 23, 0, 0, 4, 5, 6 };
		AtomicInteger index = new AtomicInteger( postOrderData.length - 1 );
		BinaryTreeNode root = constructTree( index, postOrderData );
		printTree(root);
	}

	private static BinaryTreeNode constructTree(AtomicInteger index, int[] preOrderData ) {
		BinaryTreeNode node = new BinaryTreeNode();
		int nodeValue = 0;
		
		if( index.get() >= preOrderData.length ) {
			return null;
		}
		nodeValue = preOrderData[ index.getAndDecrement() ];
		
		if( nodeValue == 0 ) {
			return null;
		}
		node.data = nodeValue;
		node.right = constructTree(index, preOrderData);
		node.left = constructTree(index, preOrderData);
		return node;
	}

	private static void printTree(BinaryTreeNode root) {
		Queue< BinaryTreeNode > queue = new LinkedList<>();
		Queue< BinaryTreeNode > nextQueue = new LinkedList<>();
		queue.add( root );

		while( !queue.isEmpty() ) {

			BinaryTreeNode temp = queue.remove();

			if( temp.left != null ) {
				nextQueue.add( temp.left );
			}

			if( temp.right != null ) {
				nextQueue.add( temp.right );
			}	
			System.out.print( temp.data + " " );

			if( queue.isEmpty() ) {
				System.out.println(  );
				queue = nextQueue;
				nextQueue = new LinkedList<>();
			}
		}
		System.out.println("==================================");
	}

}
