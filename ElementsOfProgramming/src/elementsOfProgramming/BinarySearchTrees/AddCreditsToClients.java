package elementsOfProgramming.BinarySearchTrees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

class ClentCredit {
	private int offset = 0;
	private Map< String , Integer > clientToCreditMap = new HashMap<>() ;
	private NavigableMap< Integer , Set< String > > creditToClientsTree = new TreeMap<>() ;

	public void insert(String clientID, int c){
		remove(clientID);
		clientToCreditMap.put(clientID , c - offset);
		Set<String> set = creditToClientsTree.get(c - offset);

		if (set == null) {
			set = new HashSet<>();
			creditToClientsTree.put(c - offset, set);
			set.add(clientID);
		}	
	}

	public boolean remove(String clientID) {
		Integer clientCredit = clientToCreditMap.get(clientID);
		
		if (clientCredit != null) {
			creditToClientsTree.get(clientCredit).remove(clientID);
			
			if (creditToClientsTree.get(clientCredit).isEmpty()) {
				creditToClientsTree.remove(clientCredit);
			}
			clientToCreditMap.remove(clientID);
			return true;
		}
		return false;
	}
}

public class AddCreditsToClients {

	public static void main(String[] args) {

	}

}
