package elementsOfProgramming.BinaryTrees;

public class HeightBalancedTree {

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
		
		/*
		 * root.left = one; root.right = two; one.left = four; one.right = five;
		 * five.left = six; five.right = seven; two.left = three; two.right = eight;
		 * eight.right = nine; eight.left = ten;
		 */
		
		root.left = one;
		one.left = two;
		two.left = three;
		three.left = four;
		one.right = five;
		
		int depth = checkTreeIfBalance( root, 0 );
		
		if( depth >= 1 ) {
			System.out.println( "Balacend" );
		} else {
			System.out.println( "Not balanced" ); 
		}
	}

	private static int checkTreeIfBalance(BinaryTreeNode root, int level) {
		
		if( root == null ) {
			return level - 1;
		}
		int leftDepth = checkTreeIfBalance(root.left, level + 1 );
		int rightDepth = checkTreeIfBalance(root.right, level + 1 );
		
		int difference = Math.abs( leftDepth -  rightDepth );
		
		if( difference > 1 ) {
			return -1;
		}
		return Math.max( leftDepth , rightDepth);
	}
}
