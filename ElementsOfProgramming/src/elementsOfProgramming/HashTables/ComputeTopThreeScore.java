package elementsOfProgramming.HashTables;

public class ComputeTopThreeScore {

	/*
	 * Storing the entire set of scores for a student is wasteful, since we use only the top
three scores. We can use a dynamic data structure to track just the top three scores
seen so far. If three scores already have been seen for a student, and then a score is
read for that student which is better than the lowest score of these three scores, we
evict the lowest score, and add the new score. A min-heap is a natural candidate for
holding the top three scores for each student. Note that scores can be repeated, so we
need to use a data structure that supports duplicate entries.
For example,suppose the first three scoresseen for Adamare 97, 91, and 96, in that
order. The min-heap for Adam contains 97 after the first of his scores is read, 91,97
after the second of his scores is read, and 91, 96,97 after the third of his scores is read.
Suppose the next score for Adam in the file is 88. Since 88 is less than 91 we do not
update his top three scores. Then if the next score for Adam is 97, which is greater
than 91, we remove the 91 and add 97, updating his top three scores to 96, 97, 97.



public static String findStudentWithHighestBestOfThreeScores (
			Iterator <Object> nameScoreData) {
		Map<String , Priori tyQueue <Integer >> s tudentScores = new HashMap<>() ;
		while (nameScoreData . hasNext () ) {
			String name = (String)nameScoreData.next();
			Integer score =(Integer)nameScoreData.next();
			PriorityQueue <Integer> scores = studentScores.get(name);
			if (scores == null) {
				scores = new PriorityQueue <>();
				studentScores.put(name , scores);
			}
			scores.add(score);
			if (scores.size() > 3){
				scores.poll(); // Only keep the top 3 scores.
			}
		}
		String topStudent = "no such student";
		int currentTopThreeScoresSum = 0;
		for (Map.Entry<String , PriorityQueue <Integer> scores :
			studentScores.entrySet()){
			if (scores.getValue().size() == 3){
				int currentScoresSum = getTopThreeScoresSum(scores.getValue());
				if (currentScoresSum > currentTopThreeScoresSum) {
					currentTopThreeScoresSum = currentScoresSum;
					topStudent = scores.getKey();
				}
			}
		}
		return topStudent ;
	}
	// Returns the sum of top three scores.
	private static int getTopThreeScoresSum(PriorityQueue <Integer> scores) {
		Iterator<Integer> it = scores.iterator();
		int result = ®;
		while (it.hasNext()){
			result += it.next();
		}
		return result;
	}
	 */

	
}
