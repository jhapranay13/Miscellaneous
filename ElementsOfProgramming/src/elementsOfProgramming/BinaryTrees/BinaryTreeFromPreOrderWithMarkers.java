package elementsOfProgramming.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeFromPreOrderWithMarkers {
	//Zero Can be considered as null
	public static void main(String[] args) {
		int[] preOrderData = { 6, 5, 4, 0, 0, 23, 1, 0, 0, 0, 9, 0, 10 , 0, 11, 12, 0, 0, 0 };
		AtomicInteger index = new AtomicInteger();
		BinaryTreeNode root = constructTree( index, preOrderData );
		printTree(root);
	}

	private static BinaryTreeNode constructTree(AtomicInteger index, int[] preOrderData ) {
		BinaryTreeNode node = new BinaryTreeNode();
		int nodeValue = 0;
		
		if( index.get() >= preOrderData.length ) {
			return null;
		}
		nodeValue = preOrderData[ index.getAndIncrement() ];
		
		if( nodeValue == 0 ) {
			return null;
		}
		node.data = nodeValue;
		node.left = constructTree(index, preOrderData);
		node.right = constructTree(index, preOrderData);
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
