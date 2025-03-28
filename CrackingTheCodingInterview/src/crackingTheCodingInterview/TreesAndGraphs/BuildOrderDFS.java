package crackingTheCodingInterview.TreesAndGraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class BuilOrderDFSNode {
	private String value;
	private List< BuilOrderDFSNode > parent = new LinkedList<>();
	private List< BuilOrderDFSNode > children = new LinkedList<>();

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<BuilOrderDFSNode> getParent() {
		return parent;
	}

	public void setParent(List<BuilOrderDFSNode> parent) {
		this.parent = parent;
	}

	public List<BuilOrderDFSNode> getChildren() {
		return children;
	}

	public void setChildren(LinkedList<BuilOrderDFSNode> children) {
		this.children = children;
	}
}

public class BuildOrderDFS {
	//derivation Of Toplogical Sort
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
		Map< String, BuilOrderDFSNode > valueNodeMap = new HashMap<>();
		List< BuilOrderDFSNode > nodes = createNodes( projects, valueNodeMap );

		List< BuilOrderDFSNode > nodesWithNoDependency = new LinkedList<>();
		List< BuilOrderDFSNode > nodesWithDependency = new LinkedList<>();

		if( nodes != null ) {
			assignChildrenUsingDependency( nodes, projectDependencies, nodesWithDependency
					, nodesWithNoDependency, valueNodeMap );
		}

		List< BuilOrderDFSNode > executionOrder = executionOrderDFS( nodesWithDependency, nodesWithNoDependency );

		for( BuilOrderDFSNode project : executionOrder ) {
			System.out.println( project.getValue() );
		}
	}

	private static List<BuilOrderDFSNode> executionOrderDFS(List<BuilOrderDFSNode> nodesWithDependency,
			List<BuilOrderDFSNode> nodesWithNoDependency) {
		List< BuilOrderDFSNode > executionOrder = new LinkedList<>();

		for( int i = 0; i < nodesWithNoDependency.size(); i++ ) {
			int level = 0;
			BuilOrderDFSNode node = nodesWithNoDependency.get( i );
			buildExecutionOrderDFS( node, level, executionOrder );
			executionOrder.add( 0, node );
		}
		return executionOrder;
	}

	private static void buildExecutionOrderDFS(BuilOrderDFSNode node, int level, 
			List<BuilOrderDFSNode> executionOrder) {

		if( node.getChildren().isEmpty() && level > 0 ) {

			if( !executionOrder.contains( node ) ) {
				executionOrder.add( level , node);
			}
			return;
		} else {

			for( BuilOrderDFSNode child : node.getChildren() ) {
				if( !executionOrder.contains( node ) && level > 0 ) {
					executionOrder.add( level , node);
				}
				buildExecutionOrderDFS(child, level + 1, executionOrder);
			}
		}
	}

	private static void assignChildrenUsingDependency(List< BuilOrderDFSNode > nodes, String[][] projectDependencies, 
			List<BuilOrderDFSNode> nodesWithDependency, List<BuilOrderDFSNode> nodesWithNoDependency,
			Map<String, BuilOrderDFSNode> valueNodeMap) {

		for( int i = 0; i < projectDependencies.length; i++ ) {
			String[] dependency = projectDependencies[ i ];
			BuilOrderDFSNode parent = valueNodeMap.get( dependency[ 0 ] );
			BuilOrderDFSNode child = valueNodeMap.get( dependency[ 1 ] );
			parent.getChildren().add( child );
			child.getParent().add( parent );
		}

		for( int i = 0; i < nodes.size(); i++ ) {
			BuilOrderDFSNode temp = nodes.get( i );

			if( temp.getParent().isEmpty() ) {
				nodesWithNoDependency.add( temp );
			} else {
				nodesWithDependency.add( temp );
			}
		}
	}

	private static List< BuilOrderDFSNode > createNodes(String[] projects, Map<String, BuilOrderDFSNode> valueNodeMap) {
		List< BuilOrderDFSNode > returnNodes = null;

		if( projects.length > 0 ) {
			returnNodes = new LinkedList<>();

			for( int i = 0; i < projects.length; i++ ) {
				BuilOrderDFSNode temp = new BuilOrderDFSNode();
				temp.setValue( projects[ i ] );
				returnNodes.add( temp );
				valueNodeMap.put( projects[ i ] , temp );
			}
		}
		return returnNodes;
	}
}
