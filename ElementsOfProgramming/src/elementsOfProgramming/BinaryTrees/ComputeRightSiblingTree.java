package elementsOfProgramming.BinaryTrees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ComputeRightSiblingTree {

	public static void main( String args[] ) {
		BinaryTreeNodeRightSibling root = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling one = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling two = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling three = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling four = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling five = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling six = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling seven = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling eight = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling nine = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling ten = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling eleven = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling twelve = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling thirteen = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling fourteen = new BinaryTreeNodeRightSibling();
		BinaryTreeNodeRightSibling fifteen = new BinaryTreeNodeRightSibling();

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
		fourteen.data = 15;
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
		
		printTree( root );
		rightSiblingLink( root );
	}

	private static void rightSiblingLink(BinaryTreeNodeRightSibling root) {
		BinaryTreeNodeRightSibling start = root;
		
		while( start != null && start.left != null) {
			linkSiblingsAtLevel( start );
			start = start.left;
		}
	}

	private static void linkSiblingsAtLevel(BinaryTreeNodeRightSibling start) {
		BinaryTreeNodeRightSibling current = start;
		
		while( current != null ) {
			current.left.siblingRight = current.right;
			
			if( current.siblingRight != null ) {
				current.right.siblingRight = current.siblingRight.left;
			}
			current = current.siblingRight;
		}
	}

	private static void printTree(BinaryTreeNodeRightSibling root) {
		Queue< BinaryTreeNodeRightSibling > queue = new LinkedList<>();
		Queue< BinaryTreeNodeRightSibling > nextQueue = new LinkedList<>();
		queue.add( root );

		while( !queue.isEmpty() ) {

			BinaryTreeNodeRightSibling temp = queue.remove();

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
