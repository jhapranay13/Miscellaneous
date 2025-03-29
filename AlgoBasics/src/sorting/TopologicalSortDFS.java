package sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class NodeTopoSortDFS {
	int value;
	boolean visited;
	List< NodeTopoSortDFS > adjacencyList = new LinkedList<NodeTopoSortDFS>();
	
	@Override
	public String toString() {
		return "NodeTopoSortDFS [value=" + value + "]";
	}	
}

public class TopologicalSortDFS {

	public static void main(String[] args) {
		NodeTopoSortDFS node1 = new NodeTopoSortDFS();
		NodeTopoSortDFS node2 = new NodeTopoSortDFS();
		NodeTopoSortDFS node3 = new NodeTopoSortDFS();
		NodeTopoSortDFS node4 = new NodeTopoSortDFS();
		NodeTopoSortDFS node5 = new NodeTopoSortDFS();
		NodeTopoSortDFS node6 = new NodeTopoSortDFS();
		NodeTopoSortDFS node7 = new NodeTopoSortDFS();
		NodeTopoSortDFS node8 = new NodeTopoSortDFS();
		
		node1.value = 5;
		node2.value = 7;
		node3.value = 8;
		node4.value = 3;
		node5.value = 9;
		node6.value = 2;
		node7.value = 4;
		node8.value = 1;
		
		node1.adjacencyList.add( node2 );
		node1.adjacencyList.add( node3 );
		node2.adjacencyList.add( node4 );
		node2.adjacencyList.add( node5 );
		node5.adjacencyList.add( node6 );
		node6.adjacencyList.add( node8 );
		node6.adjacencyList.add( node7 );
		Stack< NodeTopoSortDFS > result = new Stack<>();
		topologicalSortDFS( node1, result );
		
		while( !result.isEmpty() ) {
			System.out.println( result.pop().value );
		}
	}

	private static void topologicalSortDFS(NodeTopoSortDFS node,
			Stack<NodeTopoSortDFS> result) {
		
		if( node == null ) {
			return;
		}
		node.visited = true;
		
		for( int i = 0; i < node.adjacencyList.size(); i++ ) {
			
			if( node.adjacencyList.get(i).visited != true ) {
				topologicalSortDFS( node.adjacencyList.get( i ) , result);

			}
		}
		result.push(node);
	}

}
