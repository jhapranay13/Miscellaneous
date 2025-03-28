package crackingTheCodingInterview.moderate;

public class WordFrequencies {

	public static void main(String[] args) {
		String[] words = { "ant", "giraffe", "ant" };
		int frequency = calculateFrequency( words, "ant" );
		System.out.println( frequency );
	}

	private static int calculateFrequency(String[] words, String word) {
		int frequencyCounter = 0;
		
		for( int i = 0; i < words.length; i++ ) {
			
			if( words[ i ].trim().toLowerCase().equals( word.toLowerCase() ) ) {
				frequencyCounter++;
			}
		}
		return frequencyCounter;
	}

}
