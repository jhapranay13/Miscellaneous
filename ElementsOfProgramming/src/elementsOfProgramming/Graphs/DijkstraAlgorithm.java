package elementsOfProgramming.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//If multiple paths caluclate the number of edges by pairing an extra parameter for number of edges
//return with fewest edges.
class Node {

	private String name;
	private List<Node> shortestPath = new LinkedList<>();
	private Integer distance = -1;
	private Map<Node, Integer> adjacentNodes = new HashMap<>();

	public Node( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Map<Node, Integer> getAdjacentNode() {
		return adjacentNodes;
	}

	public void setAdjacentNode(Map<Node, Integer> adjacentNode) {
		this.adjacentNodes = adjacentNode;
	}

	public void addAdjacentNode( Node adjacentNode, Integer distance ) {
		adjacentNodes.put(adjacentNode, distance);
	}
}


class GraphImpl {

	private Set<Node> nodes = new HashSet<>();

	public Set<Node> getNodes() {
		return nodes;
	}

	public void setNodes(Set<Node> nodes) {
		this.nodes = nodes;
	}

	public void addNode( Node node ) {
		nodes.add(node);
	}
}

public class DijkstraAlgorithm {

	public static void main(String[] args) {
		System.out.println( "Statrt" );
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D"); 
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		nodeA.addAdjacentNode(nodeB, 10);
		nodeA.addAdjacentNode(nodeC, 15);

		nodeB.addAdjacentNode(nodeD, 12);
		nodeB.addAdjacentNode(nodeF, 15);

		nodeC.addAdjacentNode(nodeE, 10);

		nodeD.addAdjacentNode(nodeE, 2);
		nodeD.addAdjacentNode(nodeF, 1);

		nodeF.addAdjacentNode(nodeE, 5);

		GraphImpl graph = new GraphImpl();

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);

		Node lastNode = calculateShortestPath( graph, nodeA, nodeE );
		
		LinkedList< Node > shortestPath = (LinkedList<Node>) lastNode.getShortestPath();
		System.out.println( lastNode.getName() + "  " + lastNode.getDistance() );

		while( shortestPath != null && !shortestPath.isEmpty() ) {
			System.out.println( shortestPath.get(0).getName() + "  " + shortestPath.get(0).getDistance() );
			shortestPath = (LinkedList<Node>) shortestPath.get(0).getShortestPath();
		}
	}

	private static Node calculateShortestPath(GraphImpl graph, Node nodeOfOrigin, Node nodeExit ) {
		Set< Node > setteledNode = new HashSet<>();
		Set< Node > unSetteledNode = new HashSet<>();
		Node exitNode = nodeExit;
		nodeOfOrigin.setDistance( 0 );
		
		unSetteledNode.add( nodeOfOrigin );
		
		while( !unSetteledNode.isEmpty() ) {
			Node nodeUnderConsideration = calculateNodeWithMinimuDistance( unSetteledNode );
			
			if( nodeUnderConsideration.equals(exitNode) ) {
				exitNode = nodeExit;
			}
			unSetteledNode.remove( nodeUnderConsideration );
			Map<Node, Integer> adjacentNodes = nodeUnderConsideration.getAdjacentNode();
			
			if( !adjacentNodes.isEmpty() ) {
				
				Set< Entry< Node, Integer > > entrySet = adjacentNodes.entrySet();
				
				for( Entry< Node, Integer > entry : entrySet ) {
					Node adjacentNode = entry.getKey();
					int edgeWeight = entry.getValue();
					calculateAndAddEdgeWeightFromPointOfOrigin( adjacentNode, edgeWeight, 
							nodeUnderConsideration );
					unSetteledNode.add( adjacentNode );
				}
			}
		}
		return exitNode;
	}

	private static void calculateAndAddEdgeWeightFromPointOfOrigin(Node adjacentNode, int edgeWeight,
			Node nodeUnderConsideration) {
		int distanceFromOrigin = nodeUnderConsideration.getDistance();
		int distance = distanceFromOrigin + edgeWeight;
		LinkedList< Node > shortestPath = new LinkedList<>();
		
		if( adjacentNode.getDistance() == -1 ) {
			adjacentNode.setDistance(distance);
			shortestPath.add(nodeUnderConsideration);
			adjacentNode.setShortestPath( shortestPath );
		} else if( distance < adjacentNode.getDistance() ) {
			adjacentNode.setDistance(distance);
			shortestPath.add(nodeUnderConsideration);
			adjacentNode.setShortestPath( shortestPath );
		}
	}

	private static Node calculateNodeWithMinimuDistance(Set<Node> unSetteledNode) {
		Node minimumDistanceNode = null;
		int minimumDistance = -1;
		
		for( Node node : unSetteledNode ) {
		
			if( minimumDistance == -1 ) {
				minimumDistance = node.getDistance();
				minimumDistanceNode = node;
			} else if( node.getDistance() < minimumDistance ) {
				minimumDistance = node.getDistance();
				minimumDistanceNode = node;
			}
		}
		return minimumDistanceNode;
	}
}