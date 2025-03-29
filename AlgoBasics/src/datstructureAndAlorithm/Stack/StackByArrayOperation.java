package datstructureAndAlorithm.Stack;

class StackByArray {
	int[] arr;
	int topOfStack;
	
	public StackByArray(int size) {
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("Successfully created an empty Stack of Size: "+size);
	}
	
	public void push(int value) {
		//if array is full, show stack overflow error
		if (isFullStack()) {
			System.out.println("Stack overflow error!!");
		} else {
			arr[topOfStack+1] = value;
			topOfStack++;
			System.out.println("Successfully inserted " + value + " in the stack");
		}
	}
	
	public boolean isEmptyStack() {
		//if top pointer is zero, the stack is empty
		if (topOfStack == -1)
			return true;
		else
			return false;
	}
	
	public boolean isFullStack() {
		
		if (topOfStack == arr.length-1) {
			System.out.println("Stack is full !");
			return true;
		}else {
			return false;
		}
	}
	
	public void pop() {
		
		if (isEmptyStack()) {
			System.out.println("Stack underflow error!!");
		} else {
			System.out.println("Poping value from Stack: " + arr[topOfStack] + "...");
			topOfStack--;
		}
	}
	
	public void peekOperation() {
		if (!isEmptyStack())
			System.out.println("Top of Stack: " + arr[topOfStack]);
		else {
			System.out.println("The stack is empty!!");
		}
		System.out.println();System.out.println();
	}
	
	public void deleteStack() {
		arr = null;
		System.out.println("Stack is successfully deleted");
	}
}
public class StackByArrayOperation {

	public static void main(String[] args) {
		System.out.println("Creating a stack of size 5...");
		StackByArray stack = new StackByArray(5);
		System.out.println("Pushing 6 values in the Stack...");
		
		for(int i=0; i<=5; i++) {
			stack.push(i*10);
		}
		System.out.println("Peeking value from stack");
		stack.peekOperation();
		System.out.println("Poping 6 values from the Stack...");
		
		for(int i=0; i<=5; i++) {
			stack.pop();
		}
		System.out.println("Deleting the Stack...");
		stack.deleteStack();
	}

}
