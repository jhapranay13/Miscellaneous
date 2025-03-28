package elementsOfProgramming.BinaryTrees;

class ResultObject {
	public int maximumDepth;
	public boolean leftPresent;
	public boolean rightPresent;
	public BinaryTreeNode rootNode;
	public int size;
}

public class LargestCompleteSubtree {

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
		
		int size = getMaximumSizeOfCompleteSubtree( root );
		System.out.println( size );
	}

	private static int getMaximumSizeOfCompleteSubtree(BinaryTreeNode root) {
		int level = 0;
		ResultObject result = getMaximumSize(root, level );
		return result.size;
	}

	private static ResultObject getMaximumSize(BinaryTreeNode root, int level) {
		
		if( root == null ) {
			ResultObject result = new ResultObject();
			result.maximumDepth = level - 1;
			result.leftPresent = true;
			result.rightPresent = true;
			result.size = 0;
			return result;
		}
		ResultObject left = getMaximumSize(root.left, level + 1);
		ResultObject right = getMaximumSize( root.right, level + 1);
		ResultObject returnValue = new ResultObject();
		
		if( left.leftPresent && left.rightPresent && right.rightPresent && right.leftPresent &&
				left.maximumDepth == right.maximumDepth ) {
			returnValue.leftPresent = true;
			returnValue.rightPresent = true;
			returnValue.maximumDepth = left.maximumDepth;
			returnValue.size = left.size + right.size + 1;
			returnValue.rootNode = root;
		} else if( left.leftPresent && left.rightPresent && !right.rightPresent && right.leftPresent && 
				left.maximumDepth == right.maximumDepth ) {
			returnValue.leftPresent = true;
			returnValue.rightPresent = false;
			returnValue.maximumDepth = left.maximumDepth;
			returnValue.size = left.size + right.size + 1;
			returnValue.rootNode = root;
		} else if( left.leftPresent && !left.rightPresent && right.rightPresent && right.leftPresent && 
				left.maximumDepth == right.maximumDepth + 1 ) {
			returnValue.leftPresent = true;
			returnValue.rightPresent = false;
			returnValue.maximumDepth = left.maximumDepth;
			returnValue.size = left.size + right.size + 1;
			returnValue.rootNode = root;
		} else {
			returnValue.leftPresent = true;
			returnValue.rightPresent = false;
			returnValue.maximumDepth = left.size > right.size ? left.maximumDepth : right.maximumDepth;
			returnValue.size = left.size > right.size ? left.size : right.size;
			returnValue.rootNode = left.size > right.size ? left.rootNode : right.rootNode;
		}
		return returnValue;
	}
}
