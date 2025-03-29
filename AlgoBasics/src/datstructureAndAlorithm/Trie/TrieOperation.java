package datstructureAndAlorithm.Trie;

import java.util.HashMap;
import java.util.Map;

class Trie {

	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		// Constructor
		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}

		@Override
		public String toString() {
			return "TrieNode [children=" + children + ", endOfWord=" + endOfWord + "]";
		}


	}
	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert( String str ) {

		if( str == null ) {
			System.out.println( "Null Word!!" );
		}
		TrieNode current = root;

		for( int i= 0; i < str.length(); i++ ) {
			char strChar = str.charAt( i );
			TrieNode temp = current.children.get( strChar );

			if( temp == null ) {
				temp = new TrieNode();
				current.children.put( strChar , temp );
			}
			current = temp;
		}
		current.endOfWord = true;
		System.out.println("Successfully inserted " + str + " in Trie !");
	}

	public boolean search(String word) {
		TrieNode current = root;

		for( int i = 0; i < word.length(); i++ ) {
			char ch = word.charAt( i );
			TrieNode node = current.children.get( ch );

			if( node == null ) {
				System.out.println("Word: " + word + " does not exists in Trie !");
				return false;
			}
			current = node;
		}

		if(current.endOfWord == true) {
			System.out.println("Word: " + word + " exists in Trie !"); //CASE#2 -- Word exists in Trie
		}else {//CASE#3 -- Current word is a prefix of another word. But this word does not exists
			System.out.println("Word: " + word + " does not exists in Trie ! But this is a Prefix of another Word !");
		}
		return current.endOfWord;
	}

	public void delete(String word) {

		if (search(word) == true) {
			delete(root, word, 0);
		}
	}

	private void delete( TrieNode parentNode, String word, int index ) {

		if( index == word.length() ) {
			return;
		}
		char ch = word.charAt( index );
		TrieNode currentNode = parentNode.children.get( ch );
		delete( currentNode, word, index + 1 );


		if( index == word.length() - 1 ) { // CASE#2
			System.out.println("Entering Case#2");

			if (currentNode.children.size() > 0 ) {
				currentNode.endOfWord = false;
				//updating endOfWord will signify that this word is not there in Trie
			} else {
				System.out.println("Character " + ch + " has no dependency, hence deleting it from last");
				parentNode.children.remove(ch);
				// If this word is not a prefix of some other word, and since this is last
				// character, we should
				// return true, indicating we are ok to delete this node
			}
		} else {

			if ( currentNode.children.size() == 0 ) {
				System.out.println("Character " + ch + " has no dependency, hence deleting it from last");
				parentNode.children.remove(ch);
				// If this word is not a prefix of some other word, and since this is last
				// character, we should
				// return true, indicating we are ok to delete this node
			}
		}
	}

	/*private boolean delete(TrieNode parentNode, String word, int index) {
		// CASE#1 -- Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
		// CASE#2 -- We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
		// CASE#3 -- Some other word is a Prefix of this word (BCDE, BC)
		// CASE#4 -- No one is dependent on this Word (BCDE, BCDE)
		char ch = word.charAt(index);
		TrieNode currentNode = parentNode.children.get(ch);
		boolean canThisNodeBeDeleted;

		if (currentNode.children.size() > 1) {
			System.out.println("Entering Case#1");
			delete(currentNode, word, index + 1); // CASE#1
			return false;
		}

		if (index == word.length() - 1) { // CASE#2
			System.out.println("Entering Case#2");

			if (currentNode.children.size() >= 1) {
				currentNode.endOfWord = false;//updating endOfWord will signify that this word is not there in Trie
				return false;
			} else {
				System.out.println("Character " + ch + " has no dependency, hence deleting it from last");
				parentNode.children.remove(ch);
				return true;// If this word is not a prefix of some other word, and since this is last
				// character, we should
				// return true, indicating we are ok to delete this node
			}
		}

		if (currentNode.endOfWord == true) { // CASE#3
			System.out.println("Entering Case#3");
			delete(currentNode, word, index + 1); 
			return false;
		}
		System.out.println("Entering Case#4");
		canThisNodeBeDeleted = delete(currentNode, word, index + 1); // CASE#4

		if (canThisNodeBeDeleted == true) {
			System.out.println("Character " + ch + " has no dependency, hence deleting it");
			parentNode.children.remove(ch);
			return true; // Current node can also be deleted
		} else {
			return false; // Someone is dependent on this node, hence dont delete it
		}

	}*/
}
public class TrieOperation {

	public static void main(String[] args) {
		Trie t  = new Trie();

		//CASE#1
		t.insert("bcde");
		t.insert("bckg");
		t.delete("bcde");
		t.search("bcde");
		t.search("bckg");


		//CASE#2
		t.insert("bcde");
		t.insert("bcdefg");
		t.delete("bcde");
		t.search("bcde");
		t.search("bcdefg");


		//CASE#3
		t.insert("bcde");
		t.insert("bc");
		t.delete("bcde");
		t.search("bcde");
		t.search("bcde");
		t.search("bc");
		t.search("b");


		//CASE#4
		t.insert("bcde");

	}

}
