package elementsOfProgramming.Sorting;

public class TeamPhoto {

	/*
	 * 
	 * 
	 * 
	 * A brute-force approach is to consider every permutation of one array, and
compare it against the other array, element by element. Suppose there are n players
in each team. It takes0(n\) time to enumerate every possible permutation of a team,
and testing if a permutation leads to a satisfactory arrangement takes 0(n) time.
Therefore, the time complexity is 0(n\ X «), clearly unacceptable.
Intuitively, we should narrow the search by focusing on the hardest to place
players. Suppose we want to place Team A behind Team B. If A's tallest player is
not taller than the tallest player in B, then it's not possible to place Team A behind
Team B and satisfy the placement constraint. Conversely, if Team A's tallest player
is taller than the tallest player in B, we should place him in front of the tallest player
in B, since the tallest player in B is the hardest to place. Applying the same logic to
the remaining players, the second tallest player in A should be taller than the second
tallest player in B, and so on.
We can efficiently check whether A's tallest, second tallest, etc. players are each
taller than B's tallest, second tallest, etc. players by first sorting the arrays of player
heights. Figure 14.4 shows the teams in Figure 14.3 sorted by their heights.
	 * 
	 * 
	 * 
	 */
}
