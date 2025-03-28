package elementsOfProgramming.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateAllSubsetOfSizek {

	public static void main(String[] args) {
		List< Integer > input = new ArrayList<>();
		input.add( 3 );
		input.add( 4 );
		input.add( 5 );
		input.add( 6 );
		input.add( 7 );
		input.add( 8 );
		int size = 2;
		List<List<Integer>> result = generatePowerSetOfSizeK(input, size );
		
		for( List<Integer> set : result  ) {
			System.out.println( Arrays.toString( set.toArray() ) );
		}
	}

	private static List<List<Integer>> generatePowerSetOfSizeK(List<Integer> input, int size) {
		List< List<Integer> > result = new ArrayList<>();
		int startIndex = 0;
		generateSetOfSizeK( input, size, startIndex, result, new ArrayList<Integer>() );
		return result;
	}

	private static void generateSetOfSizeK(List<Integer> input, int size, int startIndex,
			List<List<Integer>> result, ArrayList<Integer> partial) {
		
		if( size == 0 ) {
			result.add( new ArrayList<>( partial ) );
			return;
		}
		
		for( int i = startIndex; i < input.size(); i++ ) {
			partial.add( input.get( i ) );
			generateSetOfSizeK(input, size - 1, i + 1, result, partial);
			partial.remove( partial.size() - 1 );
		}
	}

}
