package elementsOfProgramming.Sorting;

//Can use MergeSort With LinkedList. Which unlike merge sort on arrays can be done inplace
//with time complexity O( n log n )
public class FastSortingAlgorithmForLists {

	/*
	 * 
	 * 
	 * Unlike arrays, lists can be merged in-place—conceptually, this is because insertion
into the middle of a list is an 0(1) operation. The following program implements a
mergesort on lists. We decompose the list into two equal-sized sublists around the
node in the middle of the list. We find this node by advancing two iterators through
the list, one twice as fast as the other. When the fast iterator reaches the end of the
list, the slow iterator is at the middle of the list. We recurse on the sublists, and use
Solution 8.1 on Page 115 (merge two sorted lists) to combine the sorted sublists.
	 * 
	 * 
	 */
}
