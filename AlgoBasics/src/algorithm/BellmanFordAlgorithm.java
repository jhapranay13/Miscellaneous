package algorithm;

/*
 * 					  __S___
 *					 / 	   	\
 * 					E  ______A
 * 					| /	     /|	
 * 					|/	    / |	
 * 					D      /  B
 * 					\	  /	 /
 * 					 \__ / _/
     					 C
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

class NodeBF {
	private String value;
	private int distanceFromSource = Integer.MAX_VALUE;
	private String parent;
	private Map< NodeBF, Integer > adjacetNodeList = new HashMap<>();
	
	public NodeBF( String value ) {
		this.value = value;
	}
	
	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public void setAdjacetNodeList(Map<NodeBF, Integer> adjacetNodeList) {
		this.adjacetNodeList = adjacetNodeList;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public int getDistanceFromSource() {
		return distanceFromSource;
	}
	
	public void setDistanceFromSource(int distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}
	
	public void addAdjacentNode( NodeBF node, int distance) {
		this.adjacetNodeList.put( node, distance );
	}

	public Map<NodeBF, Integer> getAdjacetNodeList() {
		return adjacetNodeList;
	}

	@Override
	public String toString() {
		return "NodeBF [value=" + value + ", distanceFromSource=" + distanceFromSource + ", parent=" + parent + "]";
	}
	
	
}

class GraphBF {
	private ArrayList< NodeBF > nodes = new ArrayList<>();
	
	public void addNode( NodeBF node ) {
		nodes.add( node );
	}

	public ArrayList<NodeBF> getNodes() {
		return nodes;
	}

	public void setNodes(ArrayList<NodeBF> nodes) {
		this.nodes = nodes;
	}
}

public class BellmanFordAlgorithm {

	public static void main(String[] args) {
		NodeBF nodeS = new NodeBF("S");
		NodeBF nodeA = new NodeBF("A");
		NodeBF nodeB = new NodeBF("B");
		NodeBF nodeC = new NodeBF("C");
		NodeBF nodeD = new NodeBF("D");
		NodeBF nodeE = new NodeBF("E");
		nodeS.addAdjacentNode(nodeA, 10);
		nodeS.addAdjacentNode(nodeE, 8);
		nodeA.addAdjacentNode(nodeC, 2);
		nodeB.addAdjacentNode(nodeA, 1);
		nodeC.addAdjacentNode(nodeB, -2);
		nodeD.addAdjacentNode(nodeC, -1);
		nodeD.addAdjacentNode(nodeA, -4);
		nodeE.addAdjacentNode(nodeD, 1);
		nodeS.setDistanceFromSource(0);

		GraphBF graph = new GraphBF();
		graph.addNode(nodeS); 
		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		calculateShortestPath( graph, nodeS );
		ArrayList< NodeBF > nodes = graph.getNodes();
		
		for( NodeBF node : nodes ) {
			System.out.println( node.getParent() + " : " + node.getValue() + "->" + node.getDistanceFromSource() );
		}
	}

	private static void calculateShortestPath(GraphBF graph, NodeBF nodeS) {
		Queue< NodeBF > unsetteled = new LinkedList<>();
		Queue< NodeBF > visited = new LinkedList<>();
		unsetteled.add( nodeS );
		int numOfIteration = graph.getNodes().size();
		
		for( int i = 0; i <= numOfIteration; i++ ) {
			
			while( !unsetteled.isEmpty() ) {
				NodeBF currentNode = unsetteled.poll();
				Map< NodeBF, Integer > adjacentNodes = currentNode.getAdjacetNodeList();
				Set< Entry< NodeBF, Integer > > entrySet = adjacentNodes.entrySet();
				
				for( Entry< NodeBF, Integer > entry : entrySet ) {
					NodeBF adjacentNode = entry.getKey();
					int edgeWeight = entry.getValue();
					int distanceFromSource = currentNode.getDistanceFromSource() + edgeWeight;
					
					if( distanceFromSource < adjacentNode.getDistanceFromSource() ) {
						
						if( i == numOfIteration ) {
							System.out.println( "-ve Cylcle" );
							throw new IllegalArgumentException( "-ve cycle encountered" );
						}
						adjacentNode.setDistanceFromSource( distanceFromSource );
						adjacentNode.setParent( currentNode.getValue() );
					}
					
					if( !visited.contains( adjacentNode ) ) {
						unsetteled.add( adjacentNode );
					}	
				}
				visited.add( currentNode );
			}
			unsetteled = visited;
			visited = new LinkedList<>();
		}
	}
}
