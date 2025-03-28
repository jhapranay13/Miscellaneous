package crackingTheCodingInterview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNodeDepthDFS {
	private int val;
	private TreeNodeDepthDFS leftNode;
	private TreeNodeDepthDFS rightNode;
	
	public int getVal() {
		return val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
	public TreeNodeDepthDFS getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(TreeNodeDepthDFS leftNode) {
		this.leftNode = leftNode;
	}
	
	public TreeNodeDepthDFS getRightNode() {
		return rightNode;
	}
	
	public void setRightNode(TreeNodeDepthDFS rightNode) {
		this.rightNode = rightNode;
	}
}

public class ListOfDepthDFS {

	public static void main(String[] args) {
		TreeNodeDepthDFS one = new TreeNodeDepthDFS();
		TreeNodeDepthDFS two = new TreeNodeDepthDFS();
		TreeNodeDepthDFS three = new TreeNodeDepthDFS();
		TreeNodeDepthDFS four = new TreeNodeDepthDFS();
		TreeNodeDepthDFS five = new TreeNodeDepthDFS();
		TreeNodeDepthDFS six = new TreeNodeDepthDFS();
		TreeNodeDepthDFS seven = new TreeNodeDepthDFS();
		
		one.setVal(1);
		two.setVal(2);
		three.setVal(3);
		four.setVal(4);
		five.setVal(5);
		six.setVal(6);
		seven.setVal(7);
		
		one.setLeftNode( two );
		one.setRightNode( three );
		two.setLeftNode( four );
		two.setRightNode( five );
		three.setLeftNode( six );
		three.setRightNode( seven );
		
		List< LinkedList< TreeNodeDepthDFS > > layerList = new ArrayList<>();
		int level = 0;
		getDepthListDFS( one, layerList, level );
		
		for( LinkedList< TreeNodeDepthDFS > list : layerList ) {
			
			for( TreeNodeDepthDFS node : list ) {
				System.out.print( " " + node.getVal() );
			}
			System.out.println();
		}
	}

	private static void getDepthListDFS(TreeNodeDepthDFS root, List<LinkedList<TreeNodeDepthDFS>> layerList, 
			int level) {
		
		if( root == null ) {
			return;
		}
		List< TreeNodeDepthDFS > layer = null;
		
		if( !layerList.isEmpty() ) {
			
			if( layerList.size() > level ) {
				layer = layerList.get(level);
			}	
		}
		
		if( layer == null ) {
			layer = new LinkedList<>();
			layerList.add( (LinkedList<TreeNodeDepthDFS>) layer );
		}
		layer.add( root );
		
		for( int i = 0; i < 2; i++ ) {
			
			if( i == 0 ) {
				getDepthListDFS(root.getLeftNode(), layerList, level + 1 );
			} else {
				getDepthListDFS(root.getRightNode(), layerList, level + 1 );
			}
		}
	}

}
