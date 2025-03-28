package elementsOfProgramming.Strings;

import java.util.ArrayList;
import java.util.Stack;

public class PhoneMnemonicIteration {

	public static void main(String[] args) {
		String number = "2267834";
		int indexPosition = 0;

		ArrayList< String > mnemonicCombinations = new ArrayList<>();
		phoneMnemonic( number, mnemonicCombinations, indexPosition );
		
		for( String combination : mnemonicCombinations ) {
			System.out.println( combination );
		}
	}

	private static void phoneMnemonic(String number, ArrayList<String> mnemonicCombinations, 
			int indexPosition) {
		Stack< String > numberToLetterContainter = new Stack<>();

		for( int i = number.length() - 1; i >= 0; i-- ) {
			int position = number.charAt( i ) - '0';
			numberToLetterContainter.push( numberMapping[ position ] );
		}

		while( !numberToLetterContainter.isEmpty() ) {
			String letters = numberToLetterContainter.pop();

			if( mnemonicCombinations.isEmpty() ) {

				for( int i = 0; i < letters.length(); i++ ) {
					mnemonicCombinations.add( "" + letters.charAt( i ) );
				}
			} else {
				ArrayList<String> temp = (ArrayList<String>) mnemonicCombinations.clone();
				int switchIndex = temp.size() - 1;
				int fixedSwitchIndex = switchIndex;
				mnemonicCombinations.clear();

				for( int i = 0; i < letters.length(); i++ ) {
					mnemonicCombinations.addAll( temp );
				}
				int i = 0;
				
				for( int j = 0 ; j < letters.length(); j++ ) {
					String letterToAdd = "" + letters.charAt( j );
					
					for( ; i < mnemonicCombinations.size(); i++ ) {
						String partialString = mnemonicCombinations.get( i );
						partialString += letterToAdd;
						mnemonicCombinations.set( i , partialString );
						
						if( i == fixedSwitchIndex ) {
							fixedSwitchIndex += ( switchIndex + 1 );
							i++;
							break;
						}
					}
				}
			}
		}
	}

	private static final String[] numberMapping = { "0", "1", "ABC", "DEF", "GHI", "JKL", 
			"MNO", "PQRS", "TUV", "WXYZ" };
}
