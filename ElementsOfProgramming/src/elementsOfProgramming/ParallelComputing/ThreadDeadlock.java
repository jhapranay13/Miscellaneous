package elementsOfProgramming.ParallelComputing;

public class ThreadDeadlock {

	/*
	 *
	 * 	public static class Account {
		private int balance;
		private int id;
		private static int globalId;

		Account(int balance) {
			this.balance = balance;
			this.id = ++globalId ;
		}
		private boolean move(Account to, int amount) {
			synchronized (this) {
				synchronized (to) {
					if (amount > balance) {
						return false;
					}
					to.balance += amount;
					this.balance -= amount;
					System.out.println("returning true");
					return true ;
				}
			}
		}
		public static void transfer(final Account from, final Account to,
				final int amount) {
			Thread transfer = new Thread(new Runnable(){
				public void run() { from.move(to, amount); )
				});
				transfer.start();
			}
		}
	}
	 * 
	 */
	
	/*
	 * 
	 * 
	 * Suppose 111 initiates a transfer to 1/2, and immediately afterwards, U2
initiates a transfer to 111. Since each transfer takes place in a separate thread, it's
possible for the first thread to lock U1 and then the second thread to be scheduled in
and take the lock U2. The program is now deadlocked—each of the two threads is
waiting for the lock held by the other thread.
One solution is to have a global lock which is acquired by the transfer method.
The drawback is that it blocks transfers that are unrelated, e.g., 1/3 cannot transfer to
1/4 if there is a pending transfer from 1/5 to LZ6.
The canonical way to avoid deadlock is to have a global ordering on locks and
acquire them in that order. Since accounts have a unique integer id, the update below
is all that is needed to solve the deadlock.


Account lockl = (id < to. id) ? this : to;
Account lock2 = (id < to. id) ? to : this;
synchronized (lockl) {
// Does not matter if lockl equals lock2: since Java locks are
// reentrant , we will re-acquire lock2.
synchronized (lock2) {
	 */
}