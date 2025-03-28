package crackingTheCodingInterview.ThreadsAndLocks;

import java.util.concurrent.Semaphore;

class MethodResource {
	Semaphore semLock1 = new Semaphore( 1 );
	Semaphore semLock2 = new Semaphore( 1 );
	
	public MethodResource() {
		try {
			semLock1.acquire();
			semLock2.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void methodA() {
		//semLock1.acquire();
		System.out.println( "Method A" );
		semLock1.release();
	}
	
	public void methodB() {
		try {
			semLock1.acquire();
			semLock1.release();
			//semLock2.acquire();
			System.out.println( "Method B" );
			semLock2.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void methodC() {
		try {
			semLock2.acquire();
			System.out.println( "Method C" );
			semLock2.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ExcutionThread extends Thread {
	MethodResource resource;
	String name;
	
	public void run() {
		
		if( name.trim().equals("A") ) {
			resource.methodA();
		} else if( name.trim().equals("B") ) {
			resource.methodB();
		} else {
			resource.methodC();
		}
	}
}
public class MethodExecutionOrder {

	public static void main(String[] args) {
		MethodResource res = new MethodResource();
		ExcutionThread t1 = new ExcutionThread();
		ExcutionThread t2 = new ExcutionThread();
		ExcutionThread t3 = new ExcutionThread();
		
		t1.resource = res;
		t2.resource = res;
		t3.resource = res;
		
		t1.name = "A";
		t2.name = "B";
		t3.name = "C";
		
		t1.start();
		t2.start();
		t3.start();
	}

}
