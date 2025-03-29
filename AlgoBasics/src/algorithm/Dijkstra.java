package algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class NodeDS {
	private String value;
	private LinkedList<NodeDS> shortestPath;
	private int distanceFromSource = -1;
	private Map< NodeDS, Integer > adjacetNodeList = new HashMap<>();
	
	public NodeDS( String value ) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public LinkedList<NodeDS> getShortestPath() {
		return shortestPath;
	}
	
	public void setShortestPath(LinkedList<NodeDS> shortestPath) {
		this.shortestPath = shortestPath;
	}
	
	public int getDistanceFromSource() {
		return distanceFromSource;
	}
	
	public void setDistanceFromSource(int distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}
	
	public void addAdjacentNode( NodeDS node, int distance) {
		this.adjacetNodeList.put( node, distance );
	}

	public Map<NodeDS, Integer> getAdjacetNodeList() {
		return adjacetNodeList;
	}
}

class GraphDij {
	private HashSet< NodeDS > nodes = new HashSet<>();
	
	public void addNode( NodeDS node ) {
		nodes.add( node );
	}
}

public class Dijkstra {

	public static void main(String[] args) {
		NodeDS nodeA = new NodeDS("A");
		NodeDS nodeB = new NodeDS("B");
		NodeDS nodeC = new NodeDS("C");
		NodeDS nodeD = new NodeDS("D"); 
		NodeDS nodeE = new NodeDS("E");
		NodeDS nodeF = new NodeDS("F");
		
		nodeA.addAdjacentNode(nodeB, 10);
		nodeA.addAdjacentNode(nodeC, 15);
		nodeB.addAdjacentNode(nodeD, 12);
		nodeB.addAdjacentNode(nodeF, 15);
		nodeC.addAdjacentNode(nodeE, 10);
		nodeD.addAdjacentNode(nodeE, 2);
		nodeD.addAdjacentNode(nodeF, 1);
		nodeF.addAdjacentNode(nodeE, 5);
		
		GraphDij graph = new GraphDij();
		 
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);
		
		NodeDS exitNode = nodeE;
		NodeDS startNode = nodeA;
		
		exitNode = calculateShortestPath( graph, startNode, exitNode );
		LinkedList< NodeDS > shortestPath = exitNode.getShortestPath();
		System.out.println( exitNode.getValue() + " " + exitNode.getDistanceFromSource() );
		
		while( shortestPath != null ) {
			System.out.println( shortestPath.get( 0 ).getValue() + " " + 
					shortestPath.get( 0 ).getDistanceFromSource() );
			shortestPath = shortestPath.get( 0 ).getShortestPath();
		}
	}

	private static NodeDS calculateShortestPath(GraphDij graph, NodeDS startNode, NodeDS exitNode) {
		startNode.setDistanceFromSource(0);
		Set< NodeDS > setteledNodes = new HashSet<>();
		Set< NodeDS > unSetteledNodes = new HashSet<>();
		unSetteledNodes.add( startNode );
		
		while( !unSetteledNodes.isEmpty() ) {
			NodeDS currentNode = getLowestDistanceNode( unSetteledNodes );
			unSetteledNodes.remove( currentNode );
			Map< NodeDS, Integer > adjacentNodes = currentNode.getAdjacetNodeList();
			Set< Entry< NodeDS, Integer > > entrySet = (Set< Entry<NodeDS, Integer> >) adjacentNodes.entrySet();
			
			for( Entry< NodeDS, Integer > entry : entrySet ) {
				NodeDS adjacentNode = (NodeDS) entry.getKey();
				int distanceFromCurrentNode = (int) entry.getValue();
				calculateAndAddDistanceFromSourceAndShortestPath( adjacentNode, distanceFromCurrentNode, 
						currentNode );
				unSetteledNodes.add( adjacentNode );
			}
			setteledNodes.add( currentNode );
		}
		return exitNode;
	}

	private static void calculateAndAddDistanceFromSourceAndShortestPath(NodeDS adjacentNode, 
			int distanceFromCurrentNode,
			NodeDS currentNode) {
		int distanceFromSourceForCurrentNode = currentNode.getDistanceFromSource();
		int distanceFromSourceForAdjacentNode = distanceFromSourceForCurrentNode + distanceFromCurrentNode;
		
		if( adjacentNode.getDistanceFromSource() == -1 || 
				adjacentNode.getDistanceFromSource() > distanceFromSourceForAdjacentNode ) {
			adjacentNode.setDistanceFromSource( distanceFromSourceForAdjacentNode );
			LinkedList< NodeDS > shortestPath = new LinkedList<>();
			shortestPath.add( currentNode );
			adjacentNode.setShortestPath(shortestPath);
		}
	}

	private static NodeDS getLowestDistanceNode(Set<NodeDS> unSetteledNodes) {
		NodeDS returnNode = null;
		
		for( NodeDS node : unSetteledNodes ) {
			
			if( returnNode == null || 
					returnNode.getDistanceFromSource() > node.getDistanceFromSource() ) {
				returnNode = node;
			}
		}
		return returnNode;
	}
}
