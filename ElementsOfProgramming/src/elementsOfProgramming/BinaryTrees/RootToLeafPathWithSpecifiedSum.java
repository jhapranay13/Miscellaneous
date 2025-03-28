package elementsOfProgramming.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class RootToLeafPathWithSpecifiedSum {

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
		seven.left = fifteen;
		
		printTree( root );
		boolean hasPathSum = hasPathWithSum( root, 18, 0 );
		System.out.println( hasPathSum );
	}

	private static boolean hasPathWithSum(BinaryTreeNode root, int sumToFind, int partialSum) {
		
		if( root == null ) {
			return false;
		}
		partialSum += root.data;
		
		if( sumToFind == partialSum ) {
			return true;
		}
		
		if( root.left == null && root.right == null ) {
			return false;
		}
		boolean leftFlag = false;
		boolean rightFlag = false;
		
		if( root.left != null ) {
			leftFlag = hasPathWithSum( root.left, sumToFind, partialSum );
			
			if( leftFlag ) {
				return leftFlag;
			}
		}
		
		if( root.right != null ) {
			rightFlag = hasPathWithSum( root.right, sumToFind, partialSum);
		}
		
		return leftFlag ? leftFlag : rightFlag;
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
