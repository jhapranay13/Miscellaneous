package elementsOfProgramming.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

class LCAResult {
	public BinaryTreeNode nodeOne;
	public BinaryTreeNode nodeTwo;
	public BinaryTreeNode result;
}

public class LowestCommonAncestorOfTwoNodes {

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
		LCAResult lowestCommonAncestor = getLowestCommonAncestor( root, eight, nine );
		System.out.println( lowestCommonAncestor.result.data );
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

	private static LCAResult getLowestCommonAncestor(BinaryTreeNode root,
			BinaryTreeNode nodeOne, BinaryTreeNode nodeTwo ) {
		if( root == null ) {
			return null;
		}
		LCAResult returnResult = new LCAResult();
		LCAResult leftResult;
		LCAResult rightResult;
		
		if( root.data == nodeOne.data ) {
			returnResult.nodeOne = root;
			return returnResult;
		} else {
			leftResult = getLowestCommonAncestor(root.left, nodeOne, nodeTwo);
		}
		
		if( leftResult != null && leftResult.nodeOne != null && leftResult.nodeTwo != null ) {
			leftResult.result = leftResult.result == null ? root : leftResult.result;
			return leftResult;
		}
		
		if( root.data == nodeTwo.data ) {
			returnResult.nodeTwo = root;
			return returnResult;
		} else {
			rightResult = getLowestCommonAncestor(root.right, nodeOne, nodeTwo);
		}
		
		if( rightResult != null && rightResult.nodeOne != null && rightResult.nodeTwo != null ) {
			rightResult.result = rightResult.result == null ? root : rightResult.result;
			return leftResult;
		}
		
		if( leftResult!= null && rightResult!= null ) {
			returnResult.result = root;
			returnResult.nodeOne = leftResult.nodeOne == null ? leftResult.nodeTwo : 
				leftResult.nodeOne;
			returnResult.nodeTwo = rightResult.nodeOne == null ? rightResult.nodeTwo : 
				rightResult.nodeOne;
		}
		
		return returnResult;
	}

}
