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
class NodeDj {

	private String name;
	private List<NodeDj> shortestPath = new LinkedList<>();
	private Integer distance = -1;
	private Map<NodeDj, Integer> adjacentNodes = new HashMap<>();

	public NodeDj( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<NodeDj> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<NodeDj> shortestPath) {
		this.shortestPath = shortestPath;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Map<NodeDj, Integer> getAdjacentNode() {
		return adjacentNodes;
	}

	public void setAdjacentNode(Map<NodeDj, Integer> adjacentNode) {
		this.adjacentNodes = adjacentNode;
	}

	public void addAdjacentNode( NodeDj adjacentNode, Integer distance ) {
		adjacentNodes.put(adjacentNode, distance);
	}
}


class GraphImpl1 {

	private Set<NodeDj> nodes = new HashSet<>();

	public Set<NodeDj> getNodes() {
		return nodes;
	}

	public void setNodes(Set<NodeDj> nodes) {
		this.nodes = nodes;
	}

	public void addNode( NodeDj node ) {
		nodes.add(node);
	}
}

public class DijkstraAlgorithm_1 {

	public static void main(String[] args) {
		System.out.println( "Statrt" );
		NodeDj nodeA = new NodeDj("A");
		NodeDj nodeB = new NodeDj("B");
		NodeDj nodeC = new NodeDj("C");
		NodeDj nodeD = new NodeDj("D"); 
		NodeDj nodeE = new NodeDj("E");
		NodeDj nodeF = new NodeDj("F");

		nodeA.addAdjacentNode(nodeB, 10);
		nodeA.addAdjacentNode(nodeC, 15);

		nodeB.addAdjacentNode(nodeD, 12);
		nodeB.addAdjacentNode(nodeF, 15);

		nodeC.addAdjacentNode(nodeE, 10);

		nodeD.addAdjacentNode(nodeE, 2);
		nodeD.addAdjacentNode(nodeF, 1);

		nodeF.addAdjacentNode(nodeE, 5);

		GraphImpl1 graph = new GraphImpl1();

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);

		NodeDj lastNode = calculateShortestPath( graph, nodeA, nodeE );
		
		LinkedList< NodeDj > shortestPath = (LinkedList<NodeDj>) lastNode.getShortestPath();
		System.out.println( lastNode.getName() + "  " + lastNode.getDistance() );

		while( shortestPath != null && !shortestPath.isEmpty() ) {
			System.out.println( shortestPath.get(0).getName() + "  " + shortestPath.get(0).getDistance() );
			shortestPath = (LinkedList<NodeDj>) shortestPath.get(0).getShortestPath();
		}
	}

	private static NodeDj calculateShortestPath(GraphImpl1 graph, NodeDj nodeOfOrigin, NodeDj nodeExit ) {
		Set< NodeDj > setteledNode = new HashSet<>();
		Set< NodeDj > unSetteledNode = new HashSet<>();
		NodeDj exitNode = nodeExit;
		nodeOfOrigin.setDistance( 0 );
		
		unSetteledNode.add( nodeOfOrigin );
		
		while( !unSetteledNode.isEmpty() ) {
			NodeDj nodeUnderConsideration = calculateNodeWithMinimuDistance( unSetteledNode );
			
			if( nodeUnderConsideration.equals(exitNode) ) {
				exitNode = nodeExit;
			}
			unSetteledNode.remove( nodeUnderConsideration );
			Map<NodeDj, Integer> adjacentNodes = nodeUnderConsideration.getAdjacentNode();
			
			if( !adjacentNodes.isEmpty() ) {
				
				Set< Entry< NodeDj, Integer > > entrySet = adjacentNodes.entrySet();
				
				for( Entry< NodeDj, Integer > entry : entrySet ) {
					NodeDj adjacentNode = entry.getKey();
					int edgeWeight = entry.getValue();
					calculateAndAddEdgeWeightFromPointOfOrigin( adjacentNode, edgeWeight, 
							nodeUnderConsideration );
					unSetteledNode.add( adjacentNode );
				}
			}
		}
		return exitNode;
	}

	private static void calculateAndAddEdgeWeightFromPointOfOrigin(NodeDj adjacentNode, int edgeWeight,
			NodeDj nodeUnderConsideration) {
		int distanceFromOrigin = nodeUnderConsideration.getDistance();
		int distance = distanceFromOrigin + edgeWeight;
		LinkedList< NodeDj > shortestPath = new LinkedList<>();
		
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

	private static NodeDj calculateNodeWithMinimuDistance(Set<NodeDj> unSetteledNode) {
		NodeDj minimumDistanceNode = null;
		int minimumDistance = -1;
		
		for( NodeDj node : unSetteledNode ) {
		
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