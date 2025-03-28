package elementsOfProgramming.Recursion;

import java.util.ArrayList;
import java.util.List;

import elementsOfProgramming.BinaryTrees.BinaryTreeNode;

public class GenerateAllBinaryTreeForGivenNumberOfNode {

	public static void main(String[] args) {
		int numberOfNode = 3;
		List< elementsOfProgramming.BinaryTrees.BinaryTreeNode > result = generateAllBinaryTrees( numberOfNode );
	}

	public static List <BinaryTreeNode> generateAllBinaryTrees (
			int numNodes) {
		List <BinaryTreeNode> result = new ArrayList <>() ;
		
		if (numNodes == 0) { // Empty tree, add as an null.
			result.add(null) ;
		}
		for (int numLeftTreeNodes = 0; numLeftTreeNodes < numNodes;
				++numLeftTreeNodes) {
			int numRightTreeNodes = numNodes - 1 - numLeftTreeNodes ;
			List <BinaryTreeNode> leftSubtrees = generateAllBinaryTrees (numLeftTreeNodes) ;
			List <BinaryTreeNode> rightSubtrees = generateAllBinaryTrees (numRightTreeNodes ) ;
			
			// Generates all combinations of leftSubtrees and rightSubtrees.
			for (BinaryTreeNode left : leftSubtrees) {
				for (BinaryTreeNode right : rightSubtrees) {
					result . add(new BinaryTreeNode(0 , left, right));
				}
			}
		}
		return result;
	}	
}
