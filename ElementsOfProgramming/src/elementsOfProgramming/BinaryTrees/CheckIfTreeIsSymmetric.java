package elementsOfProgramming.BinaryTrees;

public class CheckIfTreeIsSymmetric {

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
		two.data = 2;
		three.data = 3;
		four.data = 3;
		five.data = 6;
		six.data = 6;
		seven.data = 7;
		eight.data = 7;
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
		one.right = five;
		two.left = six;
		two.right = four;
		five.right = seven;
		six.left = eight; //ten will lead to assymetry
		
		boolean isSymmetricalFlag = isSymmetrical( root.left, root.right );
		System.out.println( isSymmetricalFlag );
	}

	private static boolean isSymmetrical(BinaryTreeNode left, BinaryTreeNode right) {
		
		if( left == null && right == null ) {
			return true;
		}
		boolean firstFlag = isSymmetrical(left.right, right.left);
		boolean secondFlag = isSymmetrical( left.left , right.right);
		
		if( firstFlag && secondFlag ) {
			return left.data == right.data;
		}
		return false;
	}

}
