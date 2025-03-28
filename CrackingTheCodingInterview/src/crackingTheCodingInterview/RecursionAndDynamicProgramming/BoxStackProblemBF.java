package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.Stack;

class BoxBF {
	private String name;
	private int width;
	private int height;
	private int length;
	
	public BoxBF(String name, int width, int height, int length) {
		super();
		this.name = name;
		this.width = width;
		this.height = height;
		this.length = length;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
}

public class BoxStackProblemBF {

	public static void main(String[] args) {
		BoxBF[] boxes = new BoxBF[ 6 ];
		
		//Usually have to sort it descending on height but skipping it.
		boxes[ 0 ] = new BoxBF("First", 5, 6, 7);
		boxes[ 1 ] = new BoxBF("First", 6, 5, 8);
		boxes[ 2 ] = new BoxBF("First", 4, 5, 6);
		boxes[ 3 ] = new BoxBF("First", 3, 4, 3);
		boxes[ 4 ] = new BoxBF("First", 2, 2, 2);
		boxes[ 5 ] = new BoxBF("First", 1, 2, 1);
		Stack< BoxBF > stack = new Stack<>();
		int index = -1;
		
		int maximumHeight = findMaximumHeightInStack(  boxes, index  );
		System.out.println( maximumHeight );
	}

	private static int findMaximumHeightInStack(BoxBF[] boxes, int index) {
		
		if( index == boxes.length ) {
			return 0;
		}
		int maxHeight = 0;
		index++;
		int height = 0;
		
		for( int i = index; i < boxes.length; i++ ) {
			BoxBF box = boxes[ i ];
			height = findMaximumHeightInStack( boxes, index );
			maxHeight = Math.max(maxHeight, height);
			
			if( index != 0 && box.getWidth() < boxes[ index - 1 ].getWidth() &&
					box.getLength() < boxes[ index - 1 ].getLength() ) {
				maxHeight += box.getHeight();
			} else {
				maxHeight += box.getHeight();
			}
		}
		return maxHeight;
	}
}
