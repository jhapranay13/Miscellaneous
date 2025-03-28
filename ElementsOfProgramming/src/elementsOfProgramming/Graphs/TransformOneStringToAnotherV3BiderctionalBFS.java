package elementsOfProgramming.Graphs;

import javafx.util.Pair;

import java.util.*;

public class TransformOneStringToAnotherV3BiderctionalBFS {
	  private static int L = 0;
	  private static HashMap<String, ArrayList<String>> allComboDict = 
			  new HashMap<String, ArrayList<String>>();

	  private static int visitWordNode(
	      Queue<Pair<String, Integer>> Q,
	      HashMap<String, Integer> visited,
	      HashMap<String, Integer> othersVisited) {
	    Pair<String, Integer> node = Q.remove();
	    String word = node.getKey();
	    int level = node.getValue();

	    for (int i = 0; i < L; i++) {

	      // Intermediate words for current word
	      String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

	      // Next states are all the words which share the same intermediate state.
	      for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
	        // If at any point if we find what we are looking for
	        // i.e. the end word - we can return with the answer.
	        if (othersVisited.containsKey(adjacentWord)) {
	          return level + othersVisited.get(adjacentWord);
	        }

	        if (!visited.containsKey(adjacentWord)) {

	          // Save the level as the value of the dictionary, to save number of hops.
	          visited.put(adjacentWord, level + 1);
	          Q.add(new Pair(adjacentWord, level + 1));
	        }
	      }
	    }
	    return -1;
	  }

	  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

	    if (!wordList.contains(endWord)) {
	      return 0;
	    }

	    // Since all words are of same length.
	    L = beginWord.length();

	    wordList.forEach(
	        word -> {
	          for (int i = 0; i < L; i++) {
	            // Key is the generic word
	            // Value is a list of words which have the same intermediate generic word.
	            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
	            ArrayList<String> transformations =
	                allComboDict.getOrDefault(newWord, new ArrayList<String>());
	            transformations.add(word);
	            allComboDict.put(newWord, transformations);
	          }
	        });

	    // Queues for birdirectional BFS
	    // BFS starting from beginWord
	    Queue<Pair<String, Integer>> Q_begin = new LinkedList<Pair<String, Integer>>();
	    // BFS starting from endWord
	    Queue<Pair<String, Integer>> Q_end = new LinkedList<Pair<String, Integer>>();
	    Q_begin.add(new Pair(beginWord, 1));
	    Q_end.add(new Pair(endWord, 1));

	    // Visited to make sure we don't repeat processing same word.
	    HashMap<String, Integer> visitedBegin = new HashMap<String, Integer>();
	    HashMap<String, Integer> visitedEnd = new HashMap<String, Integer>();
	    visitedBegin.put(beginWord, 1);
	    visitedEnd.put(endWord, 1);

	    while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

	      // One hop from begin word
	      int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
	      if (ans > -1) {
	        return ans;
	      }

	      // One hop from end word
	      ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
	      if (ans > -1) {
	        return ans;
	      }
	    }

	    return 0;
	  }
	
	public static void main(String[] args) {
		String[] words = { "bat", "cot", "dog", "dag", "dot", "cat" };
		String from = "Rat";
		String to = "cat";
		int numberOfSteps = ladderLength(  from, to,  
				new ArrayList<String>( Arrays.asList(words) ) );
		System.out.println( numberOfSteps );
	}

}
