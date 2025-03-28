package elementsOfProgramming.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneratePowerSet {

	public static void main(String[] args) {
		List< Integer > input = new ArrayList<>();
		input.add( 3 );
		input.add( 4 );
		input.add( 5 );
		input.add( 6 );
		input.add( 7 );
		input.add( 8 );
		List<List<Integer>> result = generatePowerSet(input);
		
		for( List<Integer> set : result  ) {
			System.out.println( Arrays.toString( set.toArray() ) );
		}
	}

	public static List<List<Integer>> generatePowerSet(List<Integer> inputSet) {
		List<List<Integer>> powerSet = new ArrayList <>();
		directedPowerSet(inputSet , 0, new ArrayList<Integer>(), powerSet);
		return powerSet ;
	}
	
	// Generate all subsets whose intersection with inputSet[<9] , ...,
	// inputSet[toBeSelected - 1] is exactly selectedSoFar .
	private static void directedPowerSet(List<Integer> inputSet, int toBeSelected,
			List<Integer> selectedSoFar ,
			List<List<Integer>> powerSet) {
		if (toBeSelected == inputSet.size()){
			powerSet.add(new ArrayList <>(selectedSoFar));
			return ;
		}
		// Generate all subsets that contain inputSet[toBeSelected].
		selectedSoFar.add(inputSet.get(toBeSelected));
		directedPowerSet(inputSet , toBeSelected + 1, selectedSoFar, powerSet);
		// Generate all subsets that do not contain inputSet[toBeSelected].
		selectedSoFar.remove(selectedSoFar.size() - 1);
		directedPowerSet(inputSet , toBeSelected + 1, selectedSoFar, powerSet);
	}
}
