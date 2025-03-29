package datstructureAndAlorithm.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

class AVLNode {
	int value;
	int height;
	AVLNode left;
	AVLNode right;

	@Override
	public String toString() {
		return value + " ";
	}
}

class AVLTreeImpl {
	AVLNode root;

	public void insertNode( int value ) {

		root = insertNode( root, value );
	}

	private AVLNode insertNode(AVLNode node, int value) {

		if( node == null ) {
			node = new AVLNode();
			node.value = value;
			System.out.println( "Node Added To the AVL tree with Value >> " + value );
		} else if( value < node.value ){
			node.left = insertNode( node.left, value );
			node.height = 1 + Math.max( heightOfNode( node.left ), heightOfNode( node.right ) );
		} else {
			node.right = insertNode( node.right, value );
			node.height = 1 + Math.max( heightOfNode( node.left ), heightOfNode( node.right ) );
		}
		int balance = getBalance( node );

		if( balance > 1 ) {

			if ( getBalance( node.left ) > 0) {
				node = rightRotate( node );// LL Condition
			} else {
				node.left = leftRotate( node.left ); // LR Condition
				node = rightRotate( node );
			}
		} else if( balance < -1 ) {
			
			if ( getBalance( node.right ) < 0) {
				node = leftRotate( node );// RR Condition
			} else {
				node.right = rightRotate( node.right);// RL Condition
				node = leftRotate( node );
			}
		}
		return node;
	}

	private AVLNode leftRotate(AVLNode node) {
		AVLNode newNode = node.right;
		node.right = node.right.left; 
		newNode.left = node;
		node.height = heightOfNode(node);
		newNode.height = heightOfNode(newNode);
		return newNode;
	}

	private AVLNode rightRotate(AVLNode node) {
		AVLNode newNode = node.left;
		node.left = node.left.right; 
		newNode.right = node;
		node.height = heightOfNode(node);
		newNode.height = heightOfNode(newNode);
		return newNode;
	}

	private int getBalance(AVLNode node) {
		AVLNode nodeLeft = node.left;
		AVLNode nodeRight = node.right;

		if((nodeLeft == null) && (nodeRight == null)) { 
			return 0;
		}else if (nodeLeft == null) {
			return -1 * (nodeRight.height + 1); 
		} else if (nodeRight == null) {
			return nodeLeft.height + 1;
		} else {
			return nodeLeft.height - nodeRight.height;
		}
	}

	private int heightOfNode( AVLNode node ) {

		if (node == null) {
			return 0;
		}
		return 1 + Math.max((node.left != null ? node.left.height : -1),
				(node.right != null ? node.right.height : -1));

	}
	
	void deleteNode( int value ) {
		System.out.println("Deleting " + value + " from AVL Tree ...");
		root = deleteNode( root, value );
	}
	
	private AVLNode deleteNode(AVLNode node, int value) {
		
		if( node == null ) {
			return null;
		}
		
		if ( value < node.value ) {
			node.left = deleteNode(node.left, value);
		} else if ( value > node.value ) {
			node.right = deleteNode( node.right, value );
		} else {
			
			if( node.left != null && node.right != null ) {
				AVLNode minimumElement = minimumElement(node.right);
				node.value = minimumElement.value;
				deleteNode(node.right, minimumElement.value );
			} else if ( node.left != null ) {
				node = node.left;
			} else if( node.right != null ) {
				node = node.right;
			} else {
				node = null;
			}
			return node;
		}
		int balance = getBalance( node );
		
		if( balance > 1 ) {
			
			if( getBalance( node.left ) > 0 ) {
				node = rightRotate(node);
			} else {
				node.left = leftRotate( node.left );
				node = rightRotate( node );
			}
		} else if ( balance < -1 ) {
			
			if( getBalance( node.right ) < 0 ) {
				node = leftRotate( node );
			} else {
				node.right = rightRotate( node.right );
				node = leftRotate( node );
			}
		}
		return node;
	}
	
	public static AVLNode minimumElement(AVLNode root) {

		if (root.left == null)
			return root;
		else {
			return minimumElement(root.left);
		}
	}

	void printTreeGraphically() {
		Queue<AVLNode> queue = new LinkedList<AVLNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);

		System.out.println("\nPrinting Level order traversal of Tree...");

		if(root == null) {
			System.out.println("Tree does not exists !");
			return;
		}

		while (!queue.isEmpty()) {

			if(CurrentLevel == level.peek()) { //if we are in the same level

				if(queue.peek()==null) {
					queue.add(null);level.add(CurrentLevel+1);
				}else {
					queue.add(queue.peek().left);level.add(CurrentLevel+1);
					queue.add(queue.peek().right);level.add(CurrentLevel+1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");level.remove();
			}else { //level has changed
				System.out.println("\n");
				CurrentLevel++;

				if(previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}
	}
}

public class AVLTreePractise {

	public static void main(String[] args) {
		AVLTreeImpl tree = new AVLTreeImpl();
		tree.insertNode(30);
		tree.insertNode(10);
		tree.insertNode(5);
		tree.insertNode(3);
		tree.insertNode(4);
		tree.insertNode(50);
		tree.insertNode(65);
		tree.insertNode(1);

		tree.printTreeGraphically();

		tree.deleteNode(5);//LL Condition
		tree.printTreeGraphically();

		tree.insertNode(2);
		tree.printTreeGraphically();

		tree.deleteNode(4);//LR Condition
		tree.printTreeGraphically();

		tree.insertNode(20);
		tree.deleteNode(65);//RR Condition
		tree.printTreeGraphically();

		tree.insertNode(40);
		tree.deleteNode(20);//RL Condition
		 		
		tree.printTreeGraphically();

		 		
	}

}
