package elementsOfProgramming.Sorting;

import java.util.Arrays;

public class CalculateSalaryCap {

	public static void main(String[] args) {
		int[] salary = { 90, 30, 100, 20, 40 };
		int budget = 210;
		System.out.println( calculateSalaryCap( salary, budget ) );
	}

	private static int calculateSalaryCap(int[] salary, int budget) {
		Arrays.sort( salary );
		int salaryCap = 0;
		//int[] auxillary = new int[ salary.length ];
		//keeping each salary as a cap and then calculating what will be the salary
		//for all having heigher salary and what will be the budget for it.
		//as we cannot decrease the salary of a person having salary below the cap
		//As soon as it is exceeded we can check the cap with budget by subtracting 
		//the total salary previous to the CAP and dividing it among people of heigher salary.
		//Can also be done using an auxillary array to store these values. and figuring out
		//where your budget lies. for axample this will give auxillary array as
		// { 100, 140, 180, 270, 280 } if we take cap as 20 30 40 and so on so forth.
		//so budget lies between 180 and 270. So we can take that cap will effect 90 and 100
		//salary people
		int auxillary = 0;
		for( int i = 0; i < salary.length; i++ ) {
			int temp = (salary[ i ] * ( salary.length - i ));
			
			if( auxillary + temp >= budget ) {
				salaryCap = ( budget - auxillary ) / ( salary.length  - i);
				break;
			} else {
				auxillary += salary[ i ];
			}
		}
		
		return salaryCap;
	}

}
