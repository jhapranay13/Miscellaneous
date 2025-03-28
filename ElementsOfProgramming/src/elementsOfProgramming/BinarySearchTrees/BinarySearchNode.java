package elementsOfProgramming.BinarySearchTrees;

public class BinarySearchNode {
	int data;
	BinarySearchNode left;
	BinarySearchNode right;

	public BinarySearchNode() {
		super();
	}

	public BinarySearchNode(int data, BinarySearchNode left, BinarySearchNode right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public BinarySearchNode(int data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "BinarySearchNode [data=" + data + "]";
	}
}
