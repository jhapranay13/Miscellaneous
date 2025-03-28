package elementsOfProgramming.Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class StringWithDistance {
	public String candidatestring ;
	public Integer distance;

	public StringWithDistance(String candidatestring, Integer distance) {
		this.candidatestring = candidatestring;
		this.distance = distance;
	}
}

public class TransformOneStringToAnotherV1 {

	public static int transformString( Set<String> words, String from, String to) {
		Queue<StringWithDistance> q = new LinkedList<>();
		words.remove(from); // Marks s as visited by erasing it in words.
		q.add(new StringWithDistance(from, 0));
		StringWithDistance processInfo;

		while ( ( processInfo = q.poll() )!= null) {
			// Returns if we find a match.
			if (processInfo.candidatestring.equals(to)){
				return processInfo.distance; // Number of steps reaches t.
			}
			// Tries all possible transformations of f.first.
			String str = processInfo.candidatestring ;
			
			for (int i = 0; i < str.length(); i++) {
				String strStart = i == 0 ? "" : str.substring(0 , i);
				String strEnd = i + 1 < str.length() ? str.substring( i + 1 ): "";
				
				for (int j = 0; j < 26; j++) { // Iterates through ’a’ ~ ’z’.
					String modStr = strStart + (char)('a' + j) + strEnd;
					
					if (words.remove(modStr)){
						q.add(new StringWithDistance(modStr , processInfo.distance + 1));
					}
				}
			}
		}
		return -1; // Cannot find a possible transformations.
	}
	
	public static void main( String args[] ) {
		String[] words = { "bat", "cot", "dog", "dag", "dot", "cat" };
		String from = "Rat";
		String to = "cat";
		int numberOfSteps = transformString( new HashSet<String>( 
				Arrays.asList(words) ), from, to );
		System.out.println( numberOfSteps );
	}
}
