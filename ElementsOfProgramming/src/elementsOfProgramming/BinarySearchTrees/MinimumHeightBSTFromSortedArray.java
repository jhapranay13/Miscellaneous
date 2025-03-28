package elementsOfProgramming.BinarySearchTrees;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumHeightBSTFromSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 4, 5, 7, 9, 12, 13, 14, 17, 21, 22, 23 };
		BinarySearchNode root = getTreeFromSortedArray( arr );
		printTree( root );
	}
	
	private static BinarySearchNode getTreeFromSortedArray(int[] arr) {
		int hi = arr.length - 1;
		int lo = 0;
		BinarySearchNode root = getBinarySearchNode( arr, lo, hi );
		return root;
	}

	private static BinarySearchNode getBinarySearchNode(int[] arr, int lo, int hi) {
		
		if( lo > hi ) {
			return null;
		}
		int pivot = lo + ( hi - lo ) / 2;
		BinarySearchNode node = new BinarySearchNode( arr[ pivot ] );
		node.left = getBinarySearchNode(arr, lo, pivot - 1 );
		node.right = getBinarySearchNode(arr, pivot + 1, hi );
		return node;
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
