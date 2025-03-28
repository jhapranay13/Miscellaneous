package elementsOfProgramming.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class InOrderSuccessor {

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
		BinaryTreeNodeParentPointer inOrderSuccesor = getInorderSuccesor( ten );
		System.out.println( inOrderSuccesor.data );
	}

	private static BinaryTreeNodeParentPointer getInorderSuccesor(BinaryTreeNodeParentPointer root) {
		BinaryTreeNodeParentPointer inOrderSuccessor = null;
		
		if( root.right != null ) {
			BinaryTreeNodeParentPointer current = root.right;
			BinaryTreeNodeParentPointer previous = null;
			
			while( current != null ) {
				previous = current;
				current = current.left;
			}
			inOrderSuccessor = previous;
		} else {
			BinaryTreeNodeParentPointer current = root;
			BinaryTreeNodeParentPointer parent = root.parent;
			
			while( current != null ) {
				
				if( parent.left.data == current.data ) {
					inOrderSuccessor = parent;
					break;
				}
				current = current.parent;
				parent = current.parent;
			}		
		}
		return inOrderSuccessor != null && inOrderSuccessor.data == root.data ? 
				null : inOrderSuccessor;
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
