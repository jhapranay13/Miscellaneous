package elementsOfProgramming.BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeFromInOrderPostOrder {

	
	/*
	
	 * 				   1
       				/     \
      			   2        3
   				/    \   /   \
  				4     5   6    7
    			 \
      			  8
	 
	 * 
	 */
	public static void main(String[] args) {
		int inOrderData[]   = {4, 8, 2, 5, 1, 6, 3, 7};
		int postOrderData[] = {8, 4, 5, 2, 6, 7, 3, 1};
		int start = 0;
		int end = inOrderData.length - 1;
		AtomicInteger postOrderIndex = new AtomicInteger( end );
		Map<Integer, Integer> inOrderMap = createInOrderMap( inOrderData );
		BinaryTreeNode root = constructTree( postOrderData, inOrderMap, postOrderIndex, start, end );
		printTree(root);
	}

	private static BinaryTreeNode constructTree(int[] postOrderData, Map<Integer, Integer> inOrderMap,
			AtomicInteger postOrderIndex, int start, int end) {
		BinaryTreeNode node = new BinaryTreeNode();
		
		if( postOrderIndex.get() >= 0 && start <= end ) {
			int postOrderIndexVal = postOrderIndex.getAndDecrement(); 
			int nodeData = postOrderData[ postOrderIndexVal ];
			node.data = nodeData;
			int pivotIndex = inOrderMap.get( nodeData );
			node.right = constructTree(postOrderData, inOrderMap, postOrderIndex, pivotIndex + 1, 
					end);
			node.left = constructTree(postOrderData, inOrderMap, postOrderIndex, start, 
					pivotIndex - 1);
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
