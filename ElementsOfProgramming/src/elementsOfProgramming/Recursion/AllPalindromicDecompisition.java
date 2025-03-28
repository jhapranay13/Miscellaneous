package elementsOfProgramming.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPalindromicDecompisition {

	public static void main(String[] args) {
		String input = "2024451881";
		List<String> result = palindromePartitioning(input);
		
		for( String partition : result ) {
			System.out.println( partition );
		}
	}

	public static List<String> palindromePartitioning(String input) {
		List<String> result = new ArrayList<>();
		List<String> partial = new ArrayList<>();
		directedPalindromePartitioning(input , 0, partial, result);
		return result;
	}
	
	private static void directedPalindromePartitioning( String input, int startIndex, 
			List<String> partial , List<String> result) {
		
		if (startIndex == input.length()){
			result.add( Arrays.toString( partial.toArray() ) );
			return ;
		}
		
		for (int i = startIndex; i <= input.length() - 1; i++) {
			String prefix = input.substring( startIndex  , i + 1);
			
			if (isPalindrome(prefix)) {
				partial.add(prefix);
				directedPalindromePartitioning(input , i + 1, partial, result);
				partial.remove( partial.size() - 1 );
			}
		}
	}

	private static boolean isPalindrome (String prefix) {
		
		for (int i = 0, j = prefix.length() - 1; i < j; ++i , --j) {
			
			if (prefix . charAt (i) != prefix .charAt (j)) {
				return false ;
			}
		}
		return true ;
	}
}
