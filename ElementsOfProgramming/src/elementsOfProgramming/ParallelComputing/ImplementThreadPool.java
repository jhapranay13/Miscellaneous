package elementsOfProgramming.ParallelComputing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ImplementThreadPool {


	/*
	 * 
	 * 
	 * 
	 * 
	 * The following program, implements part of a simple HTTP server:

	public static class SingleThreadWebServer {
		public static final int PORT = 8888;
		public static void main(String[] args) throws IOException {
		ServerSocket serversock = new ServerSocket(PORT);

		for (;;){
			Socket sock = serversock.accept();
			processReq(sock);
		}
	}
Suppose you find that the program haspoor performance because it frequently blocks
on I/O. What steps could you take to improve the program's performance? Feel free
to use any utilities from the standard library, including concurrency classes.
	 * 
	 * 
	 * 
	 * 
	 */

	/*
	 * 
	 * public static class ConcurrentWebServer {

		private static final int SERVERPORT = 8888;

		public static void main(String[] args) throws IOException {
			final ServerSocket serversocket = new ServerSocket(SERVERPORT);

			while (true){
				final Socket connection = serversocket.accept();
				Runnable task = new Runnable(){
					public void run() { Worker.handleRequest(connection); >
					};
					new Thread(task).start();
				}
			}
		}
	}
	 *
	 *
	 *
	 *The problem with this approach is that we do not control the number of threads
launched. A thread consumesa nontrivial amount of resources,such as the time taken
to start and end the thread and the memory used by the thread. For a lightly-loaded
server, this may not be an issue but under load, it can result in exceptions that are
challenging, if not impossible, to handle.
The right trade-off is to use a thread pool. As the name implies, this is a collection of
threads, the size of which is bounded. A thread pool can be implemented relatively
easily using a blocking queue, i.e., a queue which blocks the writing thread on a put
until the queue is empty. However, since the problem statement explicitly allows us
to use library routines, we can use the thread pool implementation provided in the
Executor framework, which is the approach used below.
	 */
	
	/*
	 * 
	 * public static class ThreadPoolWebServer {
		private static final int NTHREADS = 180;
		private static final int SERVERPORT = 8880;
		private static final Executor exec = Executors.newFixedThreadPool(NTHREADS);
		
		public static void main(String[] args) throws IOException {
			ServerSocket serversocket = new ServerSocket(SERVERPORT);
			
			while (true) {
				final Socket connection = serversocket.accept();
				Runnable task = new Runnable() {
					public void run() { Worker.handleRequest(connection); }
				};
				exec.execute(task);
			}
		}
	}
	 * 
	 * 
	 * 
	 * 
	 */
}