package elementsOfProgramming.Graphs;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class DjkstraUtil {
	
	public static GraphImpl1 caluclateShortestPath( GraphImpl1 graph, NodeDj source ) {
		source.setDistance(0);
		Set<NodeDj> settled = new HashSet<>();
		Set<NodeDj> unSettled = new HashSet<>();
		unSettled.add(source);
		
		while( unSettled.size() != 0 ) {
			NodeDj currentNode = getLowestDistanceNode( unSettled );
			unSettled.remove(currentNode);
			
			for( Entry<NodeDj, Integer> entry: currentNode.getAdjacentNode().entrySet() ) {
				NodeDj adjacentNode = entry.getKey();
				Integer edgeDistance = entry.getValue();
				
				if( !settled.contains(adjacentNode) ) {
					calculateMinimumDistance( adjacentNode, currentNode, edgeDistance );
					unSettled.add(adjacentNode);
				}
			}
		}
		return graph;
	}

	private static void calculateMinimumDistance(NodeDj adjacentNode, NodeDj currentNode, Integer edgeDistance) {
		int distance = currentNode.getDistance();
		
		if( distance + edgeDistance < adjacentNode.getDistance() ) {
			adjacentNode.setDistance(distance + edgeDistance );
			LinkedList< NodeDj > shortestPath = new LinkedList<>( currentNode.getShortestPath() );
			shortestPath.add(currentNode);
			adjacentNode.setShortestPath(shortestPath);
		}
	}

	private static NodeDj getLowestDistanceNode(Set<NodeDj> unSettled) {
		NodeDj lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		
		for( NodeDj node: unSettled ) {
			int nodeDistance = node.getDistance();
			
			if( nodeDistance < lowestDistance ) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}
}
