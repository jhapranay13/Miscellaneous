package elementsOfProgramming.Graphs;

public class DjkstraTest {

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
		 
		graph = DjkstraUtil.caluclateShortestPath(graph, nodeA);
	}

}
