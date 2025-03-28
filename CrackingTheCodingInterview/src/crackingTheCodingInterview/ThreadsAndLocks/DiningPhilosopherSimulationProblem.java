package crackingTheCodingInterview.ThreadsAndLocks;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosopher extends Thread {
	String name;
	private Chopstick left;
	private Chopstick right;
	boolean isFull = false;

	public Philosopher(String name) {
		super();
		this.name = name;
	}

	public Philosopher(String name, Chopstick left, Chopstick right) {
		super();
		this.name = name;
		this.left = left;
		this.right = right;
	}

	public void run() {
		Random rand  = new Random();

		while( !isFull ) {
			
			try {
				System.out.println( "Philosopher " + name + " is Digesting." );
				Thread.sleep( rand.nextInt(600) );
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			boolean leftPickupFlag = left.pickUp();

			if( leftPickupFlag ) {
				System.out.println( "Philosopher " + name + " Picking up chopstick " + left.getName() );
				boolean rightPickUpFLag = right.pickUp();

				if( rightPickUpFLag  ) {
					System.out.println( "Philosopher " + name + " Picking up chopstick " + right.getName() );
					System.out.println( "Philosopher " + name + " is eating." );
					
					try {
						Thread.sleep( rand.nextInt(2000) );
						System.out.println( "Philosopher " + name + 
								" Putting Down chopstick " + right.getName() );
						right.putDown();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					try {
						Thread.sleep( rand.nextInt(200) );
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				left.putDown();
				System.out.println( "Philosopher " + name + " Putting Down chopstick " + left.getName() );
			}
			
		}
	}
}

class Chopstick {
	private String name;
	private Lock lock;

	public Chopstick(String name) {
		super();
		this.name = name;
		lock = new ReentrantLock();
	}

	public synchronized void putDown() {
		try {
		}  finally {
			lock.unlock();
		}
	}

	public synchronized boolean pickUp() {
		
		try {
			if( lock.tryLock( 10 , TimeUnit.MILLISECONDS) ) {
				return true;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class DiningPhilosopherSimulationProblem {

	public static void main(String[] args) {
		Chopstick chopstick1 = new Chopstick( "1" );
		Chopstick chopstick2 = new Chopstick( "2" );
		Chopstick chopstick3 = new Chopstick( "3" );
		Chopstick chopstick4 = new Chopstick( "4" );
		Chopstick chopstick5 = new Chopstick( "5" );
		Chopstick chopstick6 = new Chopstick( "6" );
		
		Philosopher philosopher1 = new Philosopher("1", chopstick1, chopstick2);
		Philosopher philosopher2 = new Philosopher("2", chopstick2, chopstick3);
		Philosopher philosopher3 = new Philosopher("3", chopstick3, chopstick4);
		Philosopher philosopher4 = new Philosopher("4", chopstick4, chopstick5);
		Philosopher philosopher5 = new Philosopher("5", chopstick5, chopstick6);
		Philosopher philosopher6 = new Philosopher("6", chopstick6, chopstick1);
		
		philosopher1.start();
		philosopher2.start();
		philosopher3.start();
		philosopher4.start();
		philosopher5.start();
		philosopher6.start();
		
		try {
			Thread.sleep( 15000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		philosopher1.isFull = true;
		philosopher2.isFull = true;
		philosopher3.isFull = true;
		philosopher4.isFull = true;
		philosopher5.isFull = true;
		philosopher6.isFull = true;
	}

}
