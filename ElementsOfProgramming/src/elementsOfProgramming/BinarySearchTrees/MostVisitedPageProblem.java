package elementsOfProgramming.BinarySearchTrees;

public class MostVisitedPageProblem {

	/*
	 * 
	 * 
	 * A brute-force approach is to have the read function add the page on the
line to the end of a dynamic array. For the find function, the number of times each
page has been visited can be obtained by sorting the array, and iterating through it.
The space complexity is0(n),where n is the number of lines.
Alternatively, we can store the page-to-visit-count data in a hash table. The k most
visited pages are the k pages with the highest counts, and can be computed using the
algorithm for computing the kth smallest entry in an array given in Solution 12.8 on
Page 200. (We would need to reverse the comparator to get the k pages with highest
counts.) Reading a log file entry takes0(1) time, regardless of whether we keep pages
in an array or store (page,visit-count) pairs in a hash table. The time to compute the
k most visited pages is 0(m), where m is the number of distinct pages processed up
to that point.
Intuitively, the brute-force algorithm performs poorly when there are many calls
to computing the k most visited pages. The reason is that it does not take advantage of
incrementality—processing a few more linesdoes not change the page-to-visit-counts
drastically.
Height-balanced BSTs are a good choice when performing many incremental up¬
dates while preserving sortedness. Adding and removing an entry in a heightbalanced
BST on N nodes takes time <9(logN). Therefore it makes sense to store the
page-to-visit-counts in a balanced BST. The BST nodes store (page,visit-count) pairs.
These pairs are ordered by visit-count, with ties broken on page.
Updating the tree after reading a line from the log file is slightly challenging
because we cannot easily update the corresponding (page,visit-count). The reason is
that the BST is ordered by visit-counts, not pages. The solution is to use an additional
data structure, namely a hash table, which maps pages to (page,visit-count) pairs
in the BST. If the pair is present, the visit-count in the pair in the BST is updated.
Note that directly changing the pair does not automatically update the BST it lies in.
The simplest way to update the BST is to delete the pair from the BST, update the
pair, and then insert the updated pair back into the BST. (Library implementations of
height-balanced BSTs ensure that inserts and deletes preserve balance.)
To find the k most visited pages we find the maximum element in the BST and
make k— 1 calls to the predecessor function. If the tree is height-balanced, the time
complexity of k -1calls to predecessor is0(k + log m). For k « m this compares very
favorably with having to iterate through the entire collection lines or pages as we did
in the brute-force approaches.
270
The time complexity of adding a log file entry is dominated by the BST update,
which is0(log m). This is higher than in the brute-force approach, and is the price we
pay for fast queries.
For the given example, after the first four entries have been read, the BST contains
the following (visit-count, page) pairs (1,a),(1, g),(2, f) in this order, and the hash table
mapsa,g,t to (1, a),(1, g),(2, f), respectively. After we read the fifth entry, a,we use the
hash table to find the corresponding entry (1,a) and update it to (2,a),yielding the tree
(1, g),(2,a),(2, t). After the first ten entries, the tree consists of (1, c), (2, g),(3, f), (4,a).
The most visited page at this point is a, with a visit count of 4.
	 * 
	 * 
	 * 
	 * 
	 */
}
