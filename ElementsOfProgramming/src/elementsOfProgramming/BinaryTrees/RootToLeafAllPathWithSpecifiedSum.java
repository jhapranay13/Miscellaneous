package elementsOfProgramming.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class RootToLeafAllPathWithSpecifiedSum {

	public static void main(String[] args) {
		BinaryTreeNode root = new BinaryTreeNode();
		BinaryTreeNode one = new BinaryTreeNode();
		BinaryTreeNode two = new BinaryTreeNode();
		BinaryTreeNode three = new BinaryTreeNode();
		BinaryTreeNode four = new BinaryTreeNode();
		BinaryTreeNode five = new BinaryTreeNode();
		BinaryTreeNode six = new BinaryTreeNode();
		BinaryTreeNode seven = new BinaryTreeNode();
		BinaryTreeNode eight = new BinaryTreeNode();
		BinaryTreeNode nine = new BinaryTreeNode();
		BinaryTreeNode ten = new BinaryTreeNode();
		BinaryTreeNode eleven = new BinaryTreeNode();
		BinaryTreeNode twelve = new BinaryTreeNode();
		BinaryTreeNode thirteen = new BinaryTreeNode();
		BinaryTreeNode fourteen = new BinaryTreeNode();
		BinaryTreeNode fifteen = new BinaryTreeNode();

		root.data = 1;
		one.data = 2;
		two.data = 3;
		three.data = 4;
		four.data = 5;
		five.data = 6;
		six.data = 7;
		seven.data = 8;
		eight.data = 9;
		nine.data = 10;
		ten.data = 11;
		eleven.data = 12;
		twelve.data = 13;
		thirteen.data = 14;
		fourteen.data = 7;
		fifteen.data = 16;

		root.left = one;
		root.right = two;
		one.left = three;
		one.right = four;
		two.left = five;
		two.right = six;
		three.left = seven;
		three.right = eight;
		four.left = nine;
		four.right = ten;
		five.left = eleven;
		five.right = twelve;
		six.left = thirteen;
		six.right = fourteen;
		seven.left = fifteen;

		printTree( root );
		StringBuilder result = new StringBuilder();
		hasPathWithSum( root, 18, 0, result );
	}

	private static void hasPathWithSum(BinaryTreeNode root, int sumToFind, int partialSum, 
			StringBuilder result) {

		if( root == null ) {
			return;
		}
		partialSum += root.data;
		StringBuilder partialResult = new StringBuilder( result.toString() );
		partialResult.append( root.data + " " );

		if( sumToFind == partialSum ) {
			System.out.println( partialResult.toString() );
		}

		if( root.left == null && root.right == null ) {
			return;
		}

		if( root.left != null ) {
			hasPathWithSum( root.left, sumToFind, partialSum, partialResult );
		}

		if( root.right != null ) {
			hasPathWithSum( root.right, sumToFind, partialSum, partialResult );
		}
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
