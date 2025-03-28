package elementsOfProgramming.ParallelComputing;

/*
 * 
 * First, note that the increment code is unguarded, which opens up the
possibility of its value being determined by the order in which threads that write to
it are scheduled by the thread scheduler.
The maximum value is 2N. This occurs when the thread scheduler runs one thread
to completion, followed by the other thread.
When N = 1, the minimum value for the count variable is 1: tl reads, tl reads, tl
increments and writes, then tl increments and writes. When N > 1, the final value
of the count variable must be at least 2. The reasoning is as follows. There are two
possibilities. A thread, call it T, performs a read-increment-write-read-incrementwrite
without the other thread writing between reads, in which case the written value
is at least 2. If the other thread now writes a 1, it has not yet completed, so it will
increment at least once more. Otherwise, T's second read returns a value of 1or more
(since the other thread has performed at least one write).

The lower bound of 2 is achieved according to the following thread schedule:
• f1loads the value of the counter, which is 0.
• f2 executes the loop N-1times.
• fl doesn't know that the value of the counter changed and writes1 to it.
• t2 loads the value of the counter, which is 1.
• fl executes the loop for the remaining N-1iterations.
• t2 doesn't know that the value of the counter has changed, and writes 2 to the
counter.
 * 
 * 
 * 
 */

class IncrementThread implements Runnable {

	public void run() {
		for (int i = 0; i < AnalyzeTwoInterLeavedThread.N ; i++) {
			AnalyzeTwoInterLeavedThread.counter++;
		}
	}
}

public class AnalyzeTwoInterLeavedThread {

	public static int counter;
	public static int N;
	
	public static void main(String[] args) throws Exception {
		N = (args.length > 0) ? new Integer(args[0]): 1000000;
		
		Thread t1 = new Thread(new IncrementThread());
		
		Thread t2 = new Thread(new IncrementThread());
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println(counter);
	}
}
