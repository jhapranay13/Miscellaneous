package crackingTheCodingInterview.ThreadsAndLocks;

import java.util.function.Function;
import java.util.function.Predicate;

class FizzBuzzThread extends Thread {
	Predicate< Integer > condition;
	Function< Integer, String > integerToString;
	static Object lock = new Object();
	int max;
	int current = 1;
	
	public FizzBuzzThread(Predicate<Integer> condition,
			Function<Integer, String> integerToString, int max) {
		super();
		this.condition = condition;
		this.integerToString = integerToString;
		this.max = max;
	}
	
	public void run() {
		
		while( true ) {
			
			synchronized (lock) {
				
				if( current == max ) {
					return;
				}
				
				if( condition.test( current ) ) {
					System.out.println( integerToString.apply( current ) );
				}
				current++;
			}
		}
	}
} 

public class FizzBuzzUsingMultiThreadingAndJava8 {

	public static void main(String[] args) {
		int max = 100;
		FizzBuzzThread t1 = new FizzBuzzThread( i -> i % 3 == 0 && i % 5 == 0, i -> "FizzBuzz", max);
		FizzBuzzThread t2 = new FizzBuzzThread( i -> i % 3 != 0 && i % 5 == 0, i -> "Buzz", max);
		FizzBuzzThread t3 = new FizzBuzzThread( i -> i % 3 == 0 && i % 5 != 0, i -> "Fizz", max);
		FizzBuzzThread t4 = new FizzBuzzThread( i -> i % 3 != 0 && i % 5 != 0, i -> "" + i, max);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
