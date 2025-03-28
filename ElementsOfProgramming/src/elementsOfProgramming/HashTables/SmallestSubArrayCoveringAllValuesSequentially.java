package elementsOfProgramming.HashTables;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SmallestSubArrayCoveringAllValuesSequentially {

	public static void main(String[] args) {
		String str = "My paramount object in this struggle is to save the Union and is not either to " + 
				"save or to destroy slavery If I could save the Union without freeing any slave I " + 
				"would do it and if I could save it by freeing all the slaves I would do it and if I " + 
				"could save it by freeing some and leaving others alone I would also do that";

		String[] paragraph = str.split("\\s");
		System.out.println( Arrays.toString(paragraph) );
		Map< String, Integer > keyWords = new LinkedHashMap<>();
		keyWords.put( "UNION", -1 );
		keyWords.put( "SAVE", -1 );
		printSmallestSubArrayWithKeyWords( paragraph, keyWords );
	}

	private static void printSmallestSubArrayWithKeyWords(String[] paragraph,
			Map<String, Integer> keyWords) {
		int minimumSubArrayForBothKeyWords = Integer.MAX_VALUE;
		int index = 0;
		int numBerOfKeywords = 0;

		for( String str : paragraph ) {

			if( keyWords.containsKey( str.toUpperCase() ) ) {
				numBerOfKeywords ++;
				keyWords.put(str.toUpperCase(), index);
			}

			if( numBerOfKeywords >= 2 ) {
				Set< Entry<String, Integer>> keyWordEntry = keyWords.entrySet();
				int firstValue = -1;
				int secondValue = -1;
				int counter = 0;
				for( Entry<String, Integer> entry : keyWordEntry ) {

					if( counter == 0 ) {
						firstValue = entry.getValue();
						counter++;
						continue;
					}	
					secondValue = entry.getValue();
				}

				if( secondValue > firstValue ) {
					minimumSubArrayForBothKeyWords = 
							minimumSubArrayForBothKeyWords < secondValue - firstValue ?
									minimumSubArrayForBothKeyWords : secondValue - firstValue;
				}
				index++;
			}
		}
		System.out.println( minimumSubArrayForBothKeyWords );
	}
}
