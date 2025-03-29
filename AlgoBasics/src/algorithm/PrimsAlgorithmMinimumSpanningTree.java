package algorithm;

/*
 * 						A-------B------C  
 * 						| \  	|     /| \
 * 						|  \	|    / |  \
 * 						|	\   |   /  |   \
 * 						|    \  |  /   |    \ 
 * 						|     \ | /    |     \ 
 * 						D-------E-------F-----G
 * 						|      /|\      |     /
 * 						|     / | \     |    /
 * 						|    /  |  \    |   /
 * 						|   /   |   \   |  /
 * 						|  /    |    \  | /
 *						H-------I-------J  
 * 
 * 
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class NodePR {
	private String name;
	private Integer distance = Integer.MAX_VALUE;
	private Map<NodePR, Integer> adjacentNodes = new HashMap<>();
	private String parent;
	private String status = "TEMPORARY";

	public NodePR( String name ) {
		this.name = name;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Map<NodePR, Integer> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(Map<NodePR, Integer> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Map<NodePR, Integer> getAdjacentNode() {
		return adjacentNodes;
	}

	public void setAdjacentNode(Map<NodePR, Integer> adjacentNode) {
		this.adjacentNodes = adjacentNode;
	}

	public void addAdjacentNode( NodePR adjacentNode, Integer distance ) {
		adjacentNodes.put(adjacentNode, distance);
	}

	@Override
	public String toString() {
		return "NodePR [name=" + name + ", distance=" + distance + ", parent=" + parent + 
				", status=" + status + "]";
	}
}

public class PrimsAlgorithmMinimumSpanningTree {

	public static void main(String[] args) {
		NodePR nodeA = new NodePR("A");
		NodePR nodeB = new NodePR("B");
		NodePR nodeC = new NodePR("C");
		NodePR nodeD = new NodePR("D"); 
		NodePR nodeE = new NodePR("E");
		NodePR nodeF = new NodePR("F");
		NodePR nodeG = new NodePR("G");
		NodePR nodeH = new NodePR("H");
		NodePR nodeI = new NodePR("I"); 
		NodePR nodeJ = new NodePR("J");
		
		nodeA.setDistance(0);
		nodeA.addAdjacentNode(nodeB, 19);
		nodeA.addAdjacentNode(nodeD, 14);
		nodeA.addAdjacentNode(nodeE, 12);
		
		nodeB.addAdjacentNode(nodeA, 19);
		nodeB.addAdjacentNode(nodeC, 20);
		nodeB.addAdjacentNode(nodeE, 18);
		
		nodeC.addAdjacentNode(nodeB, 20);
		nodeC.addAdjacentNode(nodeG, 29);
		nodeC.addAdjacentNode(nodeE, 17);
		nodeC.addAdjacentNode(nodeF, 15);

		nodeD.addAdjacentNode(nodeA, 14);
		nodeD.addAdjacentNode(nodeE, 13);
		nodeD.addAdjacentNode(nodeH, 28);
		
		nodeE.addAdjacentNode(nodeA, 12);
		nodeE.addAdjacentNode(nodeB, 18);
		nodeE.addAdjacentNode(nodeC, 17);
		nodeE.addAdjacentNode(nodeD, 13);
		nodeE.addAdjacentNode(nodeF, 16);
		nodeE.addAdjacentNode(nodeH, 21);
		nodeE.addAdjacentNode(nodeI, 22);
		nodeE.addAdjacentNode(nodeJ, 24);

		nodeF.addAdjacentNode(nodeE, 16);
		nodeF.addAdjacentNode(nodeC, 15);
		nodeF.addAdjacentNode(nodeG, 27);
		nodeF.addAdjacentNode(nodeI, 26);

		nodeG.addAdjacentNode(nodeC, 29);
		nodeG.addAdjacentNode(nodeF, 27);
		nodeG.addAdjacentNode(nodeJ, 35);

		nodeH.addAdjacentNode(nodeD, 28);
		nodeH.addAdjacentNode(nodeE, 21);
		nodeH.addAdjacentNode(nodeI, 23);

		nodeI.addAdjacentNode(nodeH, 23);
		nodeI.addAdjacentNode(nodeE, 22);
		nodeI.addAdjacentNode(nodeJ, 30);

		nodeJ.addAdjacentNode(nodeI, 30);
		nodeJ.addAdjacentNode(nodeE, 24);
		nodeJ.addAdjacentNode(nodeF, 26);
		nodeJ.addAdjacentNode(nodeG, 35);
		
		List< NodePR > nodeList = new LinkedList<>();
		List< NodePR > minimumSpanningTree = new LinkedList<>();
		
		nodeList.add(nodeA);
		nodeList.add(nodeB);
		nodeList.add(nodeC);
		nodeList.add(nodeD);
		nodeList.add(nodeE);
		nodeList.add(nodeF);
		nodeList.add(nodeG);
		nodeList.add(nodeH);
		nodeList.add(nodeI);
		nodeList.add(nodeJ);
		calculateMinimumSpanningTree( nodeList, minimumSpanningTree );
		int treeWeight = 0;
		
		for( NodePR minimumNode : minimumSpanningTree ) {
			System.out.println( minimumNode.getParent() + " : "+  minimumNode.getName() +
					" -> " + minimumNode.getDistance() );
			treeWeight += minimumNode.getDistance();
		}
		System.out.println( treeWeight );
	}

	private static void calculateMinimumSpanningTree( List<NodePR> nodeList, 
			List<NodePR> minimumSpanningTree ) {
		int numOfEdges = 0;
		int size = nodeList.size();
		NodePR currentNode = null;
		
		while( true ) {
			
			if( numOfEdges < size ) {
				numOfEdges++;
			} else {
				break;
			}
			
			if( currentNode == null ) {
				currentNode = findMinimumTemporaryNode( nodeList );
			}	
			Map< NodePR, Integer > adjacentList = currentNode.getAdjacentNodes();
			Set< Entry< NodePR, Integer > > entrySet = adjacentList.entrySet();
			List< NodePR > adjacentNodeTempList = new LinkedList<>();
			
			for( Entry<NodePR, Integer> entry : entrySet ) {
				int distance = entry.getValue();
				NodePR adjacentNode = entry.getKey();
				
				if( !adjacentNode.getStatus().equals("PERMANENT") && adjacentNode.getDistance() > distance ) {
					adjacentNode.setDistance( distance );
					adjacentNodeTempList.add( adjacentNode );
					adjacentNode.setParent( currentNode.getName() );
				}
			}
			currentNode.setStatus( "PERMANENT" );
			minimumSpanningTree.add( currentNode );
			currentNode = findMinimumTemporaryNode( adjacentNodeTempList );
			
			if( currentNode == null ) {
				currentNode = findMinimumTemporaryNode(nodeList);
			}
		}
	}

	private static NodePR findMinimumTemporaryNode(List<NodePR> nodeList) {
		NodePR nodewithMinimumDistance = null;
		
		for( NodePR node : nodeList ) {
			
			if( nodewithMinimumDistance == null && !node.getStatus().equals( "PERMANENT" )) {
				nodewithMinimumDistance = node;
			} else if( node.getStatus().equals( "PERMANENT" )  ) {
				continue;
			}else if( nodewithMinimumDistance.getDistance() > node.getDistance() ) {
				nodewithMinimumDistance = node;
			}
		}
		return nodewithMinimumDistance;
	}
}