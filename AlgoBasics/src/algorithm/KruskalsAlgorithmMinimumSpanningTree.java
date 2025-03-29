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

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class NodeKR {
	private String name;
	private Integer distance = Integer.MAX_VALUE;
	private String parent;
	private NodeKR root;

	public NodeKR( String name ) {
		this.name = name;
	}

	public NodeKR getRoot() {
		return root;
	}

	public void setRoot(NodeKR root) {
		this.root = root;
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

	@Override
	public String toString() {
		return "NodeKR [name=" + name + ", parent=" + parent + ", root=" + root + "]";
	}	
}

class EdgeKR implements Comparable<EdgeKR>{
	private NodeKR firstNode;
	private NodeKR secondNode;
	private int distance;

	public EdgeKR(NodeKR firstNode, NodeKR secondNode, int distance) {
		super();
		this.firstNode = firstNode;
		this.secondNode = secondNode;
		this.distance = distance;
	}

	public NodeKR getFirstNode() {
		return firstNode;
	}

	public void setFirstNode(NodeKR firstNode) {
		this.firstNode = firstNode;
	}

	public NodeKR getSecondNode() {
		return secondNode;
	}

	public void setSecondNode(NodeKR secondNode) {
		this.secondNode = secondNode;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(EdgeKR o) {
		int returnValue;

		if( this.distance == o.distance ) {
			returnValue = 0;
		} else if( this.distance > o.distance ){
			returnValue = 1;
		} else {
			returnValue = -1;
		}
		return returnValue ;
	}

	@Override
	public String toString() {
		return "EdgeKR [firstNode=" + firstNode + ", secondNode=" + secondNode + ", distance=" + distance + "]";
	}	
}

public class KruskalsAlgorithmMinimumSpanningTree {

	public static void main(String[] args) {
		NodeKR nodeA = new NodeKR("A");
		NodeKR nodeB = new NodeKR("B");
		NodeKR nodeC = new NodeKR("C");
		NodeKR nodeD = new NodeKR("D"); 
		NodeKR nodeE = new NodeKR("E");
		NodeKR nodeF = new NodeKR("F");
		NodeKR nodeG = new NodeKR("G");
		NodeKR nodeH = new NodeKR("H");
		NodeKR nodeI = new NodeKR("I"); 
		NodeKR nodeJ = new NodeKR("J");
		nodeA.setDistance(0);
		
		List< NodeKR > nodeList = new LinkedList<>();		
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

		EdgeKR edgeAB = new EdgeKR( nodeA, nodeB, 19 );
		EdgeKR edgeAD = new EdgeKR( nodeA, nodeD, 14 );
		EdgeKR edgeAE = new EdgeKR( nodeA, nodeE, 12 );

		EdgeKR edgeBC = new EdgeKR( nodeB, nodeC, 20 );
		EdgeKR edgeBE = new EdgeKR( nodeB, nodeE, 18 );

		EdgeKR edgeCG = new EdgeKR( nodeC, nodeG, 29 );
		EdgeKR edgeCE = new EdgeKR( nodeC, nodeE, 17 );
		EdgeKR edgeCF = new EdgeKR( nodeC, nodeF, 15 );

		EdgeKR edgeDE = new EdgeKR( nodeD, nodeE, 13 );
		EdgeKR edgeDH = new EdgeKR( nodeD, nodeH, 28 );

		EdgeKR edgeEF = new EdgeKR( nodeE, nodeF, 16 );
		EdgeKR edgeEH = new EdgeKR( nodeE, nodeH, 21 );
		EdgeKR edgeEI = new EdgeKR( nodeE, nodeI, 22 );
		EdgeKR edgeEJ = new EdgeKR( nodeE, nodeJ, 24 );

		EdgeKR edgeFG = new EdgeKR( nodeF, nodeG, 27 );
		EdgeKR edgeFI = new EdgeKR( nodeF, nodeI, 26 );

		EdgeKR edgeGJ = new EdgeKR( nodeG, nodeJ, 35 );

		EdgeKR edgeHI = new EdgeKR( nodeH, nodeI, 23 );

		EdgeKR edgeIJ = new EdgeKR( nodeI, nodeJ, 30 );

		List< EdgeKR > edgeList = new LinkedList<>();
		edgeList.add(edgeAB);
		edgeList.add(edgeAD);
		edgeList.add(edgeAE);
		edgeList.add(edgeBC);
		edgeList.add(edgeBE);
		edgeList.add(edgeCG);
		edgeList.add(edgeCE);
		edgeList.add(edgeCF);
		edgeList.add(edgeDE);
		edgeList.add(edgeDH);
		edgeList.add(edgeEF);
		edgeList.add(edgeEH);
		edgeList.add(edgeEI);
		edgeList.add(edgeEJ);
		edgeList.add(edgeFG);
		edgeList.add(edgeFI);
		edgeList.add(edgeGJ);
		edgeList.add(edgeHI);
		edgeList.add(edgeIJ);
		List< EdgeKR > minimumSpanningTree = new LinkedList<>();
		int treeWeight = calculateMinimumSpanningTree( edgeList, minimumSpanningTree, nodeList );

		for( EdgeKR minimumNode : minimumSpanningTree ) {
			System.out.println( minimumNode.getFirstNode().getName() + " : "+  
					minimumNode.getSecondNode().getName() +
					" -> " + minimumNode.getDistance() );
		}
		System.out.println( treeWeight ); 
	}

	private static int calculateMinimumSpanningTree(List<EdgeKR> edgeList, List<EdgeKR> minimumSpanningTree, 
			List<NodeKR> nodeList) {
		Collections.sort(edgeList);
		int treeWeight = 0;
		int NoOfEdges = nodeList.size() - 1;
		
		for( int i = 0; i < NoOfEdges || edgeList.isEmpty();  ) {
			EdgeKR currentEdge = edgeList.remove(0); 
			NodeKR firstNode = currentEdge.getFirstNode();
			NodeKR secondNode = currentEdge.getSecondNode();
			
			NodeKR tempFirstRoot = firstNode;
			NodeKR tempSecondRoot = secondNode;
			
			while( tempFirstRoot.getRoot() != null ) {
				tempFirstRoot = tempFirstRoot.getRoot();
			}
			
			while( tempSecondRoot.getRoot() != null ) {
				tempSecondRoot = tempSecondRoot.getRoot();
			}
		
			if( !tempSecondRoot.equals(tempFirstRoot) ) {
				
				if( tempSecondRoot.getRoot() == null && tempFirstRoot.getRoot() == null ) {
					tempSecondRoot.setRoot( tempFirstRoot );
					secondNode.setRoot( firstNode );
				} else if( tempFirstRoot.getRoot() == null && tempSecondRoot.getRoot() != null ) {
					tempFirstRoot.setRoot( tempSecondRoot.getRoot() );
					firstNode.setRoot( secondNode );
				} else {
					tempSecondRoot.setRoot( tempFirstRoot );
					secondNode.setRoot( firstNode );
				}	
				secondNode.setParent( firstNode.getName() );
				treeWeight += currentEdge.getDistance();
				minimumSpanningTree.add( new EdgeKR( firstNode, secondNode, currentEdge.getDistance() ) );
				i++;
			}
		}		
		return treeWeight;
	}
}
