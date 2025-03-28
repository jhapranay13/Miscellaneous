package crackingTheCodingInterview.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class AllSetOfASet {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		List< List< Integer > > allSubSets = new ArrayList<>();
		List< Integer > subSet = new ArrayList<>();
		allSubSets.add( subSet );
		int startIndex = 0;
		getAllSubSets( allSubSets, arr, startIndex );

		for( List< Integer > subSt : allSubSets ) {
			System.out.println( subSt );
		}
	}

	private static void getAllSubSets(List<List<Integer>> allSubSets, int[] arr, int startIndex) {
		
		if( startIndex == arr.length ) {
			return;
		}
		ArrayList< Integer > subSt = (ArrayList<Integer>) ( ( ArrayList< Integer > )allSubSets.get( allSubSets.size() - 1 ) ).clone();

		for( int i = startIndex; i < arr.length; i++ ) {
			int val = arr[ i ];
			subSt.add( val );
			allSubSets.add( (List<Integer>) subSt.clone() );
			getAllSubSets( allSubSets, arr, i + 1 );
			subSt.remove( subSt.size() - 1 );
		}
	}
}
