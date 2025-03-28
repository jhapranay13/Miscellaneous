package elementsOfProgramming.GreedyAlgorithmsAndInvariants;

public class LargestRectangleUnderSkyline {

	public static void main(String[] args) {
		int[] buildingHeight = { 1, 4, 2, 5, 6, 3, 2, 6, 6, 5, 2, 1, 3 };
		int maximumRectangle = calculateMaximumRectangle( buildingHeight );
		System.out.println( maximumRectangle );
	}

	private static int calculateMaximumRectangle(int[] buildingHeight) {
		int maximumRect = 0;
		int lo = 0;
		int hi = buildingHeight.length - 1;
		int pivot = lo + ( hi - lo ) / 2;
		int pivotToLo = -1;
		int pivotToHi = -1;
		int minimumPillar = Integer.MAX_VALUE;
		
		if( buildingHeight.length % 2 == 0 ) {
			pivotToLo = pivot;
			pivotToHi = pivot + 1;
		} else {
			pivotToLo = pivot;
			pivotToHi = pivot + 1;
			pivotToLo = pivot - 1;

			maximumRect = Math.min( buildingHeight[ pivot ] , 
					Math.min( buildingHeight[ pivotToHi ], buildingHeight[ pivotToLo ] ) );
			minimumPillar = maximumRect;
		}
		
		while( pivotToHi <= hi && pivotToLo >= lo ) {
			 int minimumPillarTemp = Math.min( minimumPillar, Math.min( buildingHeight[ pivotToLo ] , 
					buildingHeight[ pivotToHi ] ) );
			 
			 if( minimumPillarTemp != minimumPillar ) {
				 
				 if( minimumPillar < buildingHeight[ pivotToHi ] || 
						 minimumPillar < buildingHeight[ pivotToLo ] ) {
					 maximumRect += minimumPillar;
				 }
			 }
			 minimumPillar = minimumPillarTemp;
			 int range = pivotToHi - pivotToLo + 1;
			 maximumRect = Math.max( maximumRect ,  minimumPillar * range );
			 pivotToHi++;
			 pivotToLo--;
		}
		return maximumRect;
	}

}
