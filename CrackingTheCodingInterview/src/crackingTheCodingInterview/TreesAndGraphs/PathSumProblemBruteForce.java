package crackingTheCodingInterview.TreesAndGraphs;

class NodeSumBF {
	private int value;
	private NodeSumBF leftNode;
	private NodeSumBF rightNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public NodeSumBF getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(NodeSumBF leftNode) {
		this.leftNode = leftNode;
	}

	public NodeSumBF getRightNode() {
		return rightNode;
	}

	public void setRightNode(NodeSumBF rightNode) {
		this.rightNode = rightNode;
	}
}

public class PathSumProblemBruteForce {

	public static void main(String[] args) {
		NodeSumBF zero = new NodeSumBF();
		NodeSumBF one = new NodeSumBF();
		NodeSumBF two = new NodeSumBF();
		NodeSumBF three = new NodeSumBF();
		NodeSumBF four = new NodeSumBF();
		NodeSumBF five = new NodeSumBF();
		NodeSumBF six = new NodeSumBF();
		NodeSumBF seven = new NodeSumBF();
		NodeSumBF eight = new NodeSumBF();
		NodeSumBF nine = new NodeSumBF();
		NodeSumBF ten = new NodeSumBF();
		
		zero.setValue( 7 );
		one.setValue( 1 );
		two.setValue( 5 );
		three.setValue( 3 );
		four.setValue( 4 );
		five.setValue( 2 );
		six.setValue( 6 );
		seven.setValue( -2 );
		eight.setValue( -1 );
		nine.setValue( 8 );
		ten.setValue( 11 );

		zero.setLeftNode( one );
		zero.setRightNode( two );
		one.setLeftNode( three );
		one.setRightNode( four );
		two.setLeftNode( five );
		two.setRightNode( six );
		three.setRightNode( seven );
		three.setLeftNode( eight );
		five.setLeftNode( nine );
		six.setRightNode( ten );
		
		int targetSum = 9;
		int paths = countPathWithSum( zero, targetSum );
		System.out.println( paths );
	}

	private static int countPathWithSum(NodeSumBF node, int targetSum) {
		
		if( node == null ) {
			return 0;
		}
		int pathFromRoot = countPathFromNode( node, targetSum, 0 );
		int leftPath = countPathWithSum( node.getLeftNode() , targetSum);
		int rightPath = countPathWithSum( node.getRightNode() , targetSum);
		return pathFromRoot + leftPath + rightPath;
	}

	private static int countPathFromNode(NodeSumBF node, int targetSum, int currentSum ) {
		
		if( node == null ) {
			return 0;
		}
		currentSum += node.getValue();
		int totalPaths = 0;
		
		if( currentSum == targetSum ) {
			totalPaths++;
		}
		
		int leftPath = countPathFromNode( node.getLeftNode() , targetSum, currentSum);
		int rightPath = countPathFromNode( node.getRightNode() , targetSum, currentSum);
		return totalPaths + leftPath + rightPath;
	}
}
