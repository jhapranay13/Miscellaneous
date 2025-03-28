package crackingTheCodingInterview.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

class MinimalTreeNode {
	private int value;
	private MinimalTreeNode leftNode;
	private MinimalTreeNode rightNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public MinimalTreeNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(MinimalTreeNode leftNode) {
		this.leftNode = leftNode;
	}

	public MinimalTreeNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(MinimalTreeNode rightNode) {
		this.rightNode = rightNode;
	}
}

public class MinimalBSTOfSortedArray {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 6, 7, 9, 11, 12, 14, 17, 19, 20 };
		int lo = 0;
		int hi = arr.length - 1;
		MinimalTreeNode root = createMinimalBST( arr, lo, hi );
		printMinimalBST( root );
	}

	private static void printMinimalBST(MinimalTreeNode root) {
		Queue< MinimalTreeNode > queue = new LinkedList<>();
		queue.add( root );
		int counter = 0;

		while( !queue.isEmpty() ) {
			int noOfInnerLoops = (int) Math.pow( 2 , counter);
			counter++;

			while( noOfInnerLoops != 0 ) {
				MinimalTreeNode temp = queue.poll();
				
				if( temp != null ) {
					System.out.print( " " + temp.getValue() );
					queue.add( temp.getLeftNode() );
					queue.add( temp.getRightNode() );
				}
				noOfInnerLoops-- ;
			}
			System.out.println(  );
		}
	}

	private static MinimalTreeNode createMinimalBST(int[] arr, int lo, int hi) {

		if( lo > hi ) {
			return null;
		}
		int pivot = lo + ( hi - lo ) / 2;
		MinimalTreeNode root = new MinimalTreeNode();
		root.setValue( arr[ pivot ] );
		root.setLeftNode( createMinimalBST(arr, lo, pivot - 1 ) );
		root.setRightNode( createMinimalBST(arr, pivot + 1, hi ) );
		return root;
	}
}
