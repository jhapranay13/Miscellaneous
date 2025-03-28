package crackingTheCodingInterview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class BuilOrderBFSNode {
	private String value;
	private List< BuilOrderBFSNode > parent = new LinkedList<>();
	private List< BuilOrderBFSNode > children = new LinkedList<>();

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<BuilOrderBFSNode> getParent() {
		return parent;
	}

	public void setParent(List<BuilOrderBFSNode> parent) {
		this.parent = parent;
	}

	public List<BuilOrderBFSNode> getChildren() {
		return children;
	}

	public void setChildren(LinkedList<BuilOrderBFSNode> children) {
		this.children = children;
	}
}

public class BuildOrderBFS {

	//Derived Form of Topological Sort
	public static void main( String args[] ) {
		String[] projects = { "a", "b", "c", "d", "e", "f" };
		//Second Depends On First.
		String[][] projectDependencies = {
				{ "a", "d" },
				{ "f", "b" },
				{ "b", "d" },
				{ "f", "a" },
				{ "d", "c" }
		};
		Map< String, BuilOrderBFSNode > valueNodeMap = new HashMap<>();
		List< BuilOrderBFSNode > nodes = createNodes( projects, valueNodeMap );

		List< BuilOrderBFSNode > nodesWithNoDependency = new LinkedList<>();
		List< BuilOrderBFSNode > nodesWithDependency = new LinkedList<>();

		if( nodes != null ) {
			assignChildrenUsingDependency( nodes, projectDependencies, nodesWithDependency
					, nodesWithNoDependency, valueNodeMap );
		}

		List< BuilOrderBFSNode > executionOrder = executionOrderBFS( nodesWithDependency, nodesWithNoDependency );

		for( BuilOrderBFSNode project : executionOrder ) {
			System.out.println( project.getValue() );
		}
	}

	private static List<BuilOrderBFSNode> executionOrderBFS(List<BuilOrderBFSNode> nodesWithDependency,
			List<BuilOrderBFSNode> nodesWithNoDependency) {
		List<BuilOrderBFSNode> setteledList = new ArrayList<>();
		Queue< BuilOrderBFSNode > unsetteledQueue = new LinkedList<>();

		for( int i = 0; i < nodesWithNoDependency.size(); i++ ) {
			unsetteledQueue.add( nodesWithNoDependency.get( i ) );
		}

		while( !unsetteledQueue.isEmpty() ) {
			Set< BuilOrderBFSNode > tempSetForDupRemoval = new LinkedHashSet<>();
			tempSetForDupRemoval.addAll( unsetteledQueue );
			unsetteledQueue.clear();
			unsetteledQueue.addAll( tempSetForDupRemoval );
			
			BuilOrderBFSNode currentNode = unsetteledQueue.poll();
			List< BuilOrderBFSNode > children = currentNode.getChildren();

			if( !children.isEmpty() ) {
				unsetteledQueue.addAll( children );
			}
			setteledList.add( currentNode );
		}

		return setteledList;
	}

	private static void assignChildrenUsingDependency(List< BuilOrderBFSNode > nodes, String[][] projectDependencies, 
			List<BuilOrderBFSNode> nodesWithDependency, List<BuilOrderBFSNode> nodesWithNoDependency,
			Map<String, BuilOrderBFSNode> valueNodeMap) {

		for( int i = 0; i < projectDependencies.length; i++ ) {
			String[] dependency = projectDependencies[ i ];
			BuilOrderBFSNode parent = valueNodeMap.get( dependency[ 0 ] );
			BuilOrderBFSNode child = valueNodeMap.get( dependency[ 1 ] );
			parent.getChildren().add( child );
			child.getParent().add( parent );
		}

		for( int i = 0; i < nodes.size(); i++ ) {
			BuilOrderBFSNode temp = nodes.get( i );

			if( temp.getParent().isEmpty() ) {
				nodesWithNoDependency.add( temp );
			} else {
				nodesWithDependency.add( temp );
			}
		}
	}

	private static List< BuilOrderBFSNode > createNodes(String[] projects, Map<String, BuilOrderBFSNode> valueNodeMap) {
		List< BuilOrderBFSNode > returnNodes = null;

		if( projects.length > 0 ) {
			returnNodes = new LinkedList<>();

			for( int i = 0; i < projects.length; i++ ) {
				BuilOrderBFSNode temp = new BuilOrderBFSNode();
				temp.setValue( projects[ i ] );
				returnNodes.add( temp );
				valueNodeMap.put( projects[ i ] , temp );
			}
		}
		return returnNodes;
	}
}
