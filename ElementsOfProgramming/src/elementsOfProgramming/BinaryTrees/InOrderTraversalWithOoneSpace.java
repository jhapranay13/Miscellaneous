package elementsOfProgramming.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class InOrderTraversalWithOoneSpace {

	public static void main(String[] args) {
		BinaryTreeNodeParentPointer root = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer one = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer two = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer three = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer four = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer five = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer six = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer seven = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer eight = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer nine = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer ten = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer eleven = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer twelve = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer thirteen = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer fourteen = new BinaryTreeNodeParentPointer();
		BinaryTreeNodeParentPointer fifteen = new BinaryTreeNodeParentPointer();

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
		one.parent = root;
		root.right = two;
		two.parent = root;
		one.left = three;
		three.parent = one;
		one.right = four;
		four.parent = one;
		two.left = five;
		five.parent = two;
		two.right = six;
		six.parent = two;
		three.left = seven;
		seven.parent = three;
		three.right = eight;
		eight.parent = three;
		four.left = nine;
		nine.parent = four;
		four.right = ten;
		ten.parent = four;
		five.left = eleven;
		eleven.parent = five;
		five.right = twelve;
		twelve.parent = five;
		six.left = thirteen;
		thirteen.parent = six;
		six.right = fourteen;
		fourteen.parent = six;
		seven.left = fifteen;
		fifteen.parent = seven;
		printTree(root);
		inorderTraversal( root );
	}

	private static void inorderTraversal(BinaryTreeNodeParentPointer root) {
		BinaryTreeNodeParentPointer current = root;

		if( root == null ) {
			System.out.println( " NULL TREE " );
		}
		current = root.left != null ? root.left : root.right;

		while( current != null ) {

			if( current.left != null ) {
				current = current.left;
			} else {
				break;
			}
		}

		while( current != null ) {
			System.out.print( current.data + " " );
			current = getInOrderSuccesssor( current );
		}
	}

	private static BinaryTreeNodeParentPointer getInOrderSuccesssor(
			BinaryTreeNodeParentPointer node) {
		BinaryTreeNodeParentPointer returnVal = null;
		
		if( node.right == null ) {
			BinaryTreeNodeParentPointer parent = node.parent;

			if( parent.left.data == node.data  ) {
				returnVal = node.parent;
			} else {
				
				while( parent != null && parent.right.data == node.data ) {
					node = parent;
					parent = parent.parent;
				}
				returnVal = parent;
			}
		} else {
			BinaryTreeNodeParentPointer temp = node.right;
			
			while( temp.left != null ) {
				temp = temp.left;
			}
			returnVal = temp;
		}
		return returnVal;
	}

	private static void printTree(BinaryTreeNodeParentPointer root) {
		Queue< BinaryTreeNodeParentPointer > queue = new LinkedList<>();
		Queue< BinaryTreeNodeParentPointer > nextQueue = new LinkedList<>();
		queue.add( root );

		while( !queue.isEmpty() ) {

			BinaryTreeNodeParentPointer temp = queue.remove();

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
