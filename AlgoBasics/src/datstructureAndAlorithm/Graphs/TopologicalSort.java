package datstructureAndAlorithm.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

	//Constructor
	public TopologicalSort(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	void topologicalSort() {
		Stack<GraphNode>stack = new Stack<>();
		
		for (GraphNode node : nodeList) { // if a node is unvisited then run topologicalSort on it
			
			if (!node.isVisited())
				topologicalVisit(node,stack);
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop().getName()+" ");
		}
	}

	void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
		
		for (GraphNode neighbor : node.getNeighbors()){	//if neighbor is not visited then recursive call to it
			
			if(!neighbor.isVisited()){
				topologicalVisit(neighbor,stack);
			}
		}
		node.setVisited(true);
		stack.push(node);
	}
	
	public void addDirectedEdge(int i, int j) {
		GraphNode first = nodeList.get(i - 1);
		GraphNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
	}
}
