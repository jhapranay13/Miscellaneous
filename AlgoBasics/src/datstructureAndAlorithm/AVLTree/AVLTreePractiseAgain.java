package datstructureAndAlorithm.AVLTree;

import java.util.LinkedList;
import java.util.Queue;

class AVLTreeNode1 {
	int value;
	AVLTreeNode1 left;
	AVLTreeNode1 right;
	int height;

	@Override
	public String toString() {
		return "AVLTreeNode1 [value=" + value + ", height=" + height + "]";
	}	
}

class AVLTreeImpl1 {
	AVLTreeNode1 root;

	public void insertNode( int value ) {
		root = insertNode( root, value );
	}

	private AVLTreeNode1 insertNode(AVLTreeNode1 node, int value) {

		if( node == null ) {
			node = new AVLTreeNode1();
			node.value = value;
			node.height = 0;
			return node;
		} else if( node.value > value ) {
			node.left = insertNode( node.left, value );
		} else if( node.value < value ) {
			node.right = insertNode( node.right, value );
		}
		node.height = getHeight( node );
		int balance = getBalance( node );

		if( balance > 1 ) {

			if( getBalance( node.left ) > 0 ) {
				node = rightRotate( node );
			} else {
				node.left = leftRotate( node.left );
				node = rightRotate(node);
			}
		} else if( balance < -1 ) {

			if( getBalance( node.right ) < 0 ) {
				node = leftRotate( node );
			} else {
				node.right = rightRotate( node.right );
				node = leftRotate( node );
			}
		}
		return node;
	}

	private AVLTreeNode1 leftRotate(AVLTreeNode1 node) {
		AVLTreeNode1 newRoot = node.right;
		node.right = newRoot.left;
		newRoot.left = node;
		node.height = getHeight( node );
		newRoot.height = getHeight( newRoot );
		return newRoot;
	}

	private AVLTreeNode1 rightRotate(AVLTreeNode1 node) {
		AVLTreeNode1 newRoot = node.left;
		node.left = newRoot.right;
		newRoot.right = node;
		node.height = getHeight( node );
		newRoot.height = getHeight( newRoot );
		return newRoot;
	}

	private int getHeight(AVLTreeNode1 node) {

		if( node == null ) {
			return 0;
		}

		return 1 + Math.max( node.left != null ? node.left.height : - 1, 
				node.right != null ? node.right.height : -1 );
	}

	private int getBalance(AVLTreeNode1 node) {
		AVLTreeNode1 leftNode = node.left;
		AVLTreeNode1 rightNode = node.right;

		if( leftNode != null && rightNode != null ) {
			return leftNode.height - rightNode.height;
		} else if( rightNode == null ) {
			return 1 + leftNode.height;
		} else if( leftNode == null ) {
			return -1 * ( rightNode.height + 1 );
		}
		return 0;
	}

	public void deleteNode( int value ) {
		root = deleteNode( root, value );
	}

	private AVLTreeNode1 deleteNode(AVLTreeNode1 node, int value) {

		if( node == null ) {
			return null;
		}

		if( node.value > value ) {
			node.left = deleteNode( node.left, value );
		} else if( node.value < value ) {
			node.right = deleteNode(node.right, value);
		} else {

			if( node.left != null && node.right != null ) {
				AVLTreeNode1 minimumNode = inOrderSuccesor( node.right );
				node.value = minimumNode.value;
				deleteNode( minimumNode, minimumNode.value );
			} else if( node.left == null ) {
				node = node.right;
			} else if( node.right == null ) {
				node = node.left;
			} else {
				node = null;
			}
			return node;
		}
		int balance  = getBalance(node);

		if( balance > 1 ) {

			if( getBalance( node.left ) > 0 ) {
				node = rightRotate( node );
			} else {
				node.left = leftRotate( node.left );
				node = rightRotate(node);
			}
		} else if( balance < -1 ) {

			if( getBalance( node.right ) < 0 ) {
				node = leftRotate( node );
			} else {
				node.right = rightRotate( node.right );
				node = leftRotate( node );
			}
		}
		node.height = getHeight(node);
		return node;
	}

	private AVLTreeNode1 inOrderSuccesor(AVLTreeNode1 node) {

		if( node.left == null ) {
			return node;
		}
		return inOrderSuccesor( node.left );
	}

	void printTreeGraphically() {
		Queue<AVLTreeNode1> queue = new LinkedList<AVLTreeNode1>();
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
public class AVLTreePractiseAgain {

	public static void main(String[] args) {
		AVLTreeImpl1 tree = new AVLTreeImpl1();
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
