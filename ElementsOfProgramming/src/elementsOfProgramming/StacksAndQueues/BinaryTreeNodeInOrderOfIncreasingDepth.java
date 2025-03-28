package elementsOfProgramming.StacksAndQueues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNodeForQueue {
	int data;
	TreeNodeForQueue left;
	TreeNodeForQueue right;
}

public class BinaryTreeNodeInOrderOfIncreasingDepth {

	public static void main(String[] args) {
		TreeNodeForQueue root = new TreeNodeForQueue();
		root.data = 1;
		TreeNodeForQueue one = new TreeNodeForQueue();
		one.data = 2;
		TreeNodeForQueue two = new TreeNodeForQueue();
		two.data = 3;
		TreeNodeForQueue three = new TreeNodeForQueue();
		three.data = 4;
		TreeNodeForQueue four = new TreeNodeForQueue();
		four.data = 5;
		TreeNodeForQueue five = new TreeNodeForQueue();
		five.data = 6;
		TreeNodeForQueue six = new TreeNodeForQueue();
		six.data = 7;
		TreeNodeForQueue seven = new TreeNodeForQueue();
		seven.data = 8;
		
		root.left = one;
		root.right = two;
		one.left = three;
		one.right = four;
		two.left = five;
		two.right = six;
		five.left = seven;
		List< List<TreeNodeForQueue> > result = new ArrayList<>();
		levelWiseNodes( result, root );
		
		for( List<TreeNodeForQueue> queue : result ) {
			
			for( TreeNodeForQueue element : queue ) {
				System.out.print( element.data + " " );
			}
			System.out.println();
		}
	}

	private static void levelWiseNodes(List<List<TreeNodeForQueue>> result, TreeNodeForQueue root) {
		List< TreeNodeForQueue > level = new ArrayList<TreeNodeForQueue>();
		Deque< TreeNodeForQueue > queue = new LinkedList<TreeNodeForQueue>();
		queue.add( root );
		Deque< TreeNodeForQueue > queueNext = new LinkedList<TreeNodeForQueue>();
		
		while( !queue.isEmpty() ) {
			TreeNodeForQueue temp = queue.removeFirst();
			level.add( temp );
			
			if( temp.left != null ) {
				queueNext.addLast( temp.left );
			}
			
			if( temp.right != null ) {
				queueNext.addLast( temp.right );
			}	
			
			if( queue.isEmpty() ) {
				queue = queueNext;
				queueNext = new LinkedList<TreeNodeForQueue>();
				result.add( level );	
				level = new ArrayList<TreeNodeForQueue>();
			}
		}
	}

}
