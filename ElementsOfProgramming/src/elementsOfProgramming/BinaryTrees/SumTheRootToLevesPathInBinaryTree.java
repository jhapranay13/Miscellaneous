package elementsOfProgramming.BinaryTrees;

public class SumTheRootToLevesPathInBinaryTree {

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
		one.data = 0;
		two.data = 1;
		three.data = 1;
		four.data = 0;
		five.data = 1;
		six.data = 0;
		seven.data = 0;
		eight.data = 1;
		nine.data = 1;
		ten.data = 0;
		eleven.data = 0;
		twelve.data = 1;
		thirteen.data = 1;
		fourteen.data = 0;
		fifteen.data = 1;
		
		root.left = one;
		root.right = two;
		one.left = three;
		one.right = four;
		two.left = five;
		two.right = six;
		/*three.left = seven;
		three.right = eight;
		four.left = nine;
		four.right = ten;
		five.left = eleven;
		five.right = twelve;
		six.left = thirteen;
		six.right = fourteen;
		seven.left = fifteen;*/
		
		int sum = getSumFromRootToLeave( root, 0 );
		System.out.println( sum );
	}

	private static int getSumFromRootToLeave(BinaryTreeNode root, int partialSum) {
		 
		if( root == null ) {
			return 0;
		}
		partialSum = 2 * partialSum + root.data;
		int partialSumLeft = getSumFromRootToLeave( root.left, partialSum );
		int partialSumRight = getSumFromRootToLeave( root.right, partialSum );
		return partialSumLeft != 0 && partialSumRight != 0 ? partialSumLeft + partialSumRight :
			partialSum;
	}

}
