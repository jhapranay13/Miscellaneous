package datstructureAndAlorithm.Hashing;

import java.util.LinkedList;

class directChaining {
	LinkedList<String>[] hashTable;
	int maximumChainSize = 5;

	directChaining() {
		hashTable = new LinkedList[13];
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

	public void insertKeyInHashTable(String value) {
		int newIndex = simpleASCIIHashFunction(value, hashTable.length); //returns in which index we need to store this string

		if(hashTable[newIndex] == null) {
			System.out.println("Index: " + newIndex + " is empty. Creating a new LinkedList there...");
			hashTable[newIndex] = new LinkedList<String>(); 
			hashTable[newIndex].add(value);
			System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
			System.out.println("-------------------------------------------\n");
		}else {
			System.out.println("\nIndex: " + newIndex + " is having sufficient space. Inserting there...");
			hashTable[newIndex].add(value);
			System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
			System.out.println("-------------------------------------------\n");
		}
	}

	public boolean searchKeyInHashTable(String stringToBeSearched) {
		int newIndex = simpleASCIIHashFunction(stringToBeSearched, hashTable.length);

		if (hashTable[newIndex] != null && hashTable[newIndex].contains(stringToBeSearched)) {
			System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " found in HashTable at location: "+newIndex);
			return true;
		}else {
			System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
			return false;
		}
	}

	public void deleteKeyFromHashTable(String stringToBeDeleted) {
		int newIndex = simpleASCIIHashFunction(stringToBeDeleted, hashTable.length);

		if (hashTable[newIndex] != null && hashTable[newIndex].contains(stringToBeDeleted)) {
			System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable." );
			hashTable[newIndex].remove(stringToBeDeleted);
			System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !" );
		}else {
			System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
		}
	}

	public void displayHashTable() {

		if(hashTable == null) {
			System.out.println("\nHashTable does not exits !");
			return;
		}else {
			System.out.println("\n---------- HashTable ---------");

			for (int i = 0; i < hashTable.length; i++) {
				System.out.println("Index: " + i + ", key: " + hashTable[i]);

			}
		}
	} 

	public void deleteHashTable() {
		hashTable = null;
		System.out.println("Successfully deleted HashTable !");
	}
}

public class DirectChaningImpl {

	public static void main(String[] args) {
		directChaining directChaining = new directChaining();

		directChaining.insertKeyInHashTable("The");
		directChaining.insertKeyInHashTable("quick");
		directChaining.insertKeyInHashTable("brown");
		directChaining.insertKeyInHashTable("fox");
		directChaining.insertKeyInHashTable("over");
		directChaining.insertKeyInHashTable("lazy");
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); // use for showing collision
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();

		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();
		
		directChaining.insertKeyInHashTable("fox"); 
		directChaining.displayHashTable();

		directChaining.searchKeyInHashTable("jump");
		directChaining.searchKeyInHashTable("brown");

		directChaining.deleteKeyFromHashTable("jump");
		directChaining.deleteKeyFromHashTable("quick");
		directChaining.displayHashTable();

		directChaining.deleteHashTable(); 
		directChaining.displayHashTable();
	}

}
