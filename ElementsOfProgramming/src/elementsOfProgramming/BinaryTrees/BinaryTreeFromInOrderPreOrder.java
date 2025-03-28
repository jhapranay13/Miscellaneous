package elementsOfProgramming.BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeFromInOrderPreOrder {

	/*
	 * 
	 * 
	 * 					 1
	 * 				   /  \
	 * 			      /    \
	 * 				2       3 	
	 * 			   / 	   / \	
	 *            /       /   \
	 *           4       5     6
	 * 					/  \	
	 *     			   /	\
	 * 				  7       8
	 * 
	 */
	public static void main(String[] args) {
		int[] inOrderData = { 4, 2, 1, 7 ,5 ,8 ,3, 6 };
		int[] preOrderData = { 1, 2, 4, 3, 5, 7, 8, 6 };
		BinaryTreeNode root = reConstructBinaryTree( inOrderData, preOrderData );
		printTree( root );
	}

	private static BinaryTreeNode reConstructBinaryTree(int[] inOrderData, int[] preOrderData) {
		Map< Integer, Integer > inOrderMap = createInOrderMap( inOrderData );
		BinaryTreeNode root = null;
		AtomicInteger currentIndexPreOrder = new AtomicInteger();
		root =  constructTree( 0, preOrderData.length - 1, inOrderMap, preOrderData, 
				currentIndexPreOrder );
		return root;
	}

	

	private static BinaryTreeNode constructTree( int startIndex, int endIndex,
			Map<Integer, Integer> inOrderMap, int[] preOrderData, 
			AtomicInteger currentIndexPreOrder) {
		BinaryTreeNode node = new BinaryTreeNode();
		
		if( currentIndexPreOrder.get() < preOrderData.length && startIndex <= endIndex ) {
			int nodeValue = preOrderData[ currentIndexPreOrder.getAndIncrement() ];
			node.data = nodeValue;
			int pivotInOrder = inOrderMap.get( nodeValue );
			node.left = constructTree(startIndex, pivotInOrder - 1, inOrderMap, 
					preOrderData, currentIndexPreOrder);
			
			node.right = constructTree(pivotInOrder + 1, endIndex, inOrderMap, preOrderData, 
					currentIndexPreOrder );
		} else {
			return null;
		}
		return node;
	}

	private static Map<Integer, Integer> createInOrderMap(int[] inOrderData) {
		Map< Integer, Integer > inOrderMap = new HashMap<Integer, Integer>();
		
		for( int i = 0; i < inOrderData.length; i++ ) {
			inOrderMap.put( inOrderData[ i ] , i );
		}
		return inOrderMap;
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
