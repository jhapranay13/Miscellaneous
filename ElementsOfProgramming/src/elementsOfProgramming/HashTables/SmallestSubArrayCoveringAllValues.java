package elementsOfProgramming.HashTables;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SmallestSubArrayCoveringAllValues {

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
				keyWords.remove(str.toUpperCase());
				keyWords.put(str.toUpperCase(), index);
				//just by updating linkedHashMap does not change entry order
				//for that you have to remove and put it back again
			}
			
			if( numBerOfKeywords >= 2 ) {
				Set< Entry<String, Integer>> keyWordEntry = keyWords.entrySet();
				int value = -1;
				
				for( Entry<String, Integer> entry : keyWordEntry ) {
					value = entry.getValue();
					break;
				}
				minimumSubArrayForBothKeyWords = minimumSubArrayForBothKeyWords < index - value ?
						minimumSubArrayForBothKeyWords : index - value;
			}
			index++;
		}
		System.out.println( minimumSubArrayForBothKeyWords );
	}

}
