package crackingTheCodingInterview.TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNodeDepthBFS {
	private int val;
	private TreeNodeDepthBFS leftNode;
	private TreeNodeDepthBFS rightNode;
	
	public int getVal() {
		return val;
	}
	
	public void setVal(int val) {
		this.val = val;
	}
	
	public TreeNodeDepthBFS getLeftNode() {
		return leftNode;
	}
	
	public void setLeftNode(TreeNodeDepthBFS leftNode) {
		this.leftNode = leftNode;
	}
	
	public TreeNodeDepthBFS getRightNode() {
		return rightNode;
	}
	
	public void setRightNode(TreeNodeDepthBFS rightNode) {
		this.rightNode = rightNode;
	}
}

public class ListOfDepthBFS {

	public static void main(String[] args) {
		TreeNodeDepthBFS one = new TreeNodeDepthBFS();
		TreeNodeDepthBFS two = new TreeNodeDepthBFS();
		TreeNodeDepthBFS three = new TreeNodeDepthBFS();
		TreeNodeDepthBFS four = new TreeNodeDepthBFS();
		TreeNodeDepthBFS five = new TreeNodeDepthBFS();
		TreeNodeDepthBFS six = new TreeNodeDepthBFS();
		TreeNodeDepthBFS seven = new TreeNodeDepthBFS();
		
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
		
		List< LinkedList< TreeNodeDepthBFS > > layerList = new ArrayList<>();
		getDepthListBFS( one, layerList );
		
		for( LinkedList< TreeNodeDepthBFS > list : layerList ) {
			
			for( TreeNodeDepthBFS node : list ) {
				System.out.print( " " + node.getVal() );
			}
			System.out.println();
		}
	}

	private static void getDepthListBFS( TreeNodeDepthBFS root, List<LinkedList<TreeNodeDepthBFS>> layerList ) {
		Queue< TreeNodeDepthBFS > queue = new LinkedList<>();
		queue.add( root );
		int currentCounter = 1;
		int nextLevelCounter = 0;
		int level = 0;
		
		while( !queue.isEmpty() ) {
			
			if( currentCounter == 0 ) {
				currentCounter = nextLevelCounter;
				nextLevelCounter = 0;
				level++;
			}
			
			List< TreeNodeDepthBFS > layer = null;
			
			if( !layerList.isEmpty() ) {
				
				if( layerList.size() > level ) {
					layer = layerList.get( level );
				}	
			}
			
			if( layer == null ) {
				layer = new LinkedList<>();
				layerList.add( ( LinkedList< TreeNodeDepthBFS > ) layer );
			}
			TreeNodeDepthBFS node = queue.poll();
			layer.add( node );
			currentCounter--;
			
			if( node.getLeftNode() != null ) {
				queue.add( node.getLeftNode() );
				nextLevelCounter++;
			}
			
			if( node.getRightNode() != null ) {
				queue.add( node.getRightNode() );
				nextLevelCounter++;
			}
		}
	}
}
