package crackingTheCodingInterview.RecursionAndDynamicProgramming;

public class TowersOfHanoi {

	/*//Pseudo Code
	 * moveDisks(int n, Tower origin, Tower destination, Tower buffer) { 
	 * Base case 
		if (n <= 0) return;

	 	//move top n - 1 disks from origin to buffer, using destination as a buffer.
		moveDisks(n - 1, origin, buffer, destination);
 		//move top from origin to destination
		moveTop(origin, destination);
		//move top n - 1 disks from buffer to destination, using origin as a buffer.
		moveDisks(n - 1, buffer, destination, origin);
	}
	 */
	public static void main(String[] args) {
		int numberOfDisks = 4;
		String originTower = "Origin Tower";
		String bufferTower = "Buffer Tower";
		String destinationTower = "Destination Tower";
		moveDisks( numberOfDisks, originTower, destinationTower, bufferTower );
	}

	private static void moveDisks(int numberOfDisks, String originTower, String destinationTower, 
			String bufferTower) {
		
		if( numberOfDisks == 0 ) {
			return;
		} 
		moveDisks(numberOfDisks - 1, originTower, bufferTower, destinationTower);
		System.out.println( "MOving " + numberOfDisks + " from " + originTower +
				" to " + destinationTower );
		moveDisks(numberOfDisks - 1, bufferTower, destinationTower, originTower);
	}

}
