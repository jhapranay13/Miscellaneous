package crackingTheCodingInterview.TreesAndGraphs;

import java.util.HashMap;

class NodeSum {
	private int value;
	private NodeSum leftNode;
	private NodeSum rightNode;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public NodeSum getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(NodeSum leftNode) {
		this.leftNode = leftNode;
	}

	public NodeSum getRightNode() {
		return rightNode;
	}

	public void setRightNode(NodeSum rightNode) {
		this.rightNode = rightNode;
	}
}

public class PathSumProblemUsingMap {

	public static void main(String[] args) {
		NodeSum zero = new NodeSum();
		NodeSum one = new NodeSum();
		NodeSum two = new NodeSum();
		NodeSum three = new NodeSum();
		NodeSum four = new NodeSum();
		NodeSum five = new NodeSum();
		NodeSum six = new NodeSum();
		NodeSum seven = new NodeSum();
		NodeSum eight = new NodeSum();
		NodeSum nine = new NodeSum();
		NodeSum ten = new NodeSum();
		
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

	private static int countPathWithSum(NodeSum node, int targetSum) {
		return countPathWithSum(node, targetSum, 0, new HashMap< Integer, Integer >());
	}

	private static int countPathWithSum(NodeSum node, int targetSum, int runningSum,
			HashMap<Integer, Integer> pathCountHolder) {
		
		if( node == null ) {
			return 0;
		}
		runningSum += node.getValue();
		int sum = runningSum - targetSum;
		int totalPaths = pathCountHolder.getOrDefault( sum, 0 );
		
		if( targetSum == runningSum ) {
			totalPaths++;
		}
		pathCountHolder.put( runningSum, totalPaths );

		totalPaths += countPathWithSum(node.getLeftNode(), targetSum, runningSum, pathCountHolder);
		totalPaths += countPathWithSum(node.getRightNode(), targetSum, runningSum, pathCountHolder);
		//decremented so that other nodes don't use the same value;
		int tempHolder = pathCountHolder.get( runningSum );
		pathCountHolder.put( runningSum, --tempHolder );
		
		return totalPaths;
	}

}
