package datstructureAndAlorithm.Hashing;

import java.util.ArrayList;

class DoubleHashing {
	String[] hashTable;
	int noOfCellsUsedInHashTable;

	//Constructor
	DoubleHashing() {
		hashTable = new String[13];
		noOfCellsUsedInHashTable = 0;
	}

	// HashFunction to be used on Keys
	public int simpleASCIIHashFunction(String x, int M) {
		char ch[];
		ch = x.toCharArray();
		int i, sum;

		for (sum = 0, i = 0; i < x.length(); i++) {
			sum = sum + ch[i];
		}
		// System.out.println("Index from hashfunction: " + sum % M);
		return sum % M;
	}

	//2nd HashFunction. 
	int secondHashFunction(String x, int M) {
		char ch[];
		ch = x.toCharArray();
		int xlength = x.length();
		int i, sum;

		for (sum = 0, i = 0; i < xlength; i++)
			sum += ch[i];

		while (sum > 13)
			sum = addAllTheDigitsTogether(sum);
		return sum % M;
	}

	private int addAllTheDigitsTogether(int sum) {
		int value = 0;

		while (sum > 0) {
			value = sum % 10;
			sum = sum / 10;
		}
		return value;
	}

	public double getLoadFactor() {
		return noOfCellsUsedInHashTable * 1.0 / hashTable.length;
	}

	public void insertKeyInHashTable(String value) {
		double loadFactor = getLoadFactor();

		if (loadFactor >= 0.75) {
			System.out.println("Load factor of this HashTable has exceeded 0.75, hence we need to Rehash !\n");
			rehashKeys(value);
		} else {
			System.out.println("Inserting \"" + value + "\" in HashTable...");
			int x = simpleASCIIHashFunction(value, hashTable.length);
			int y = secondHashFunction(value, hashTable.length);

			for (int i = 0; i < hashTable.length; i++) {
				int newIndex = (x + i * y) % hashTable.length;
				// If there is a collision then we go to the next index
				// and keep going till we reach starting index.
				if (hashTable[newIndex] == null) {
					hashTable[newIndex] = value;
					System.out.println("Index: " + newIndex + " is blank. Inserting there...");
					System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
					System.out.println("-------------------------------------------\n");
					break;
				}else {
					System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
				}
			}
		}
		noOfCellsUsedInHashTable++;
	}

	public void rehashKeys(String newStringToBeInserted) {
		noOfCellsUsedInHashTable = 0; //need to reset it as we are now dealing with fresh HashTable
		ArrayList<String> data = new ArrayList<String>();

		for (String s : hashTable) { //loop through the HashTable and save all the keys in ArrayList

			if (s != null)
				data.add(s);
		}
		data.add(newStringToBeInserted);
		hashTable = new String[hashTable.length * 2]; // make new table with double size

		for (String s : data) { // push all old data into new table
			insertKeyInHashTable(s);
		}
	}

	public boolean searchKeyInHashTable(String stringToBeSearched) {
		int index = simpleASCIIHashFunction(stringToBeSearched, hashTable.length);

		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;

			if (hashTable[newIndex]!=null && hashTable[newIndex].equals(stringToBeSearched)) {
				System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " found in HashTable at location: "+newIndex);
				return true;
			}
		}
		System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
		return false;
	}

	public void deleteKeyFromHashTable(String stringToBeDeleted) {
		int index = simpleASCIIHashFunction(stringToBeDeleted, hashTable.length);

		for (int i = index; i < index + hashTable.length; i++) {
			int newIndex = i % hashTable.length;

			if (hashTable[newIndex]!=null && hashTable[newIndex].equals(stringToBeDeleted)) {
				hashTable[newIndex] = null;
				System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable." );
				System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !" );
				return;
			}
		}
		System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
	}

	public void displayHashTable() {
		if(hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		}else {
			System.out.println("\n---------- HashTable ---------");
			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("Index:" + i + ".   Key:" + hashTable[i]);
			}
		}
		System.out.println("\n");
	}// end of method


	// deletes entire HashTable
	public void deleteHashTable() {
		System.out.println("Successfully deleted HashTable !");
		hashTable = null;
	}
}

public class DoubleHashingImpl {

	public static void main(String[] args) {
		DoubleHashing doubleHashing = new DoubleHashing();

		doubleHashing.insertKeyInHashTable("The");
		doubleHashing.insertKeyInHashTable("quick");
		doubleHashing.insertKeyInHashTable("brown");
		doubleHashing.insertKeyInHashTable("fox");
		doubleHashing.insertKeyInHashTable("over");
		doubleHashing.insertKeyInHashTable("lazy");
		doubleHashing.displayHashTable();

		doubleHashing.insertKeyInHashTable("fox"); // use for showing collision
		doubleHashing.displayHashTable();

		doubleHashing.insertKeyInHashTable("fox"); 
		doubleHashing.displayHashTable();
		
		doubleHashing.insertKeyInHashTable("fox"); 
		doubleHashing.displayHashTable();
		
		doubleHashing.insertKeyInHashTable("fox"); 
		doubleHashing.displayHashTable();
		
		doubleHashing.insertKeyInHashTable("fox"); 
		doubleHashing.displayHashTable();
		 
		doubleHashing.searchKeyInHashTable("jump");
		doubleHashing.searchKeyInHashTable("brown");

		doubleHashing.deleteKeyFromHashTable("jump");
		doubleHashing.deleteKeyFromHashTable("quick");
		doubleHashing.displayHashTable();
		
		doubleHashing.deleteHashTable(); 
		doubleHashing.displayHashTable();
	}

}
