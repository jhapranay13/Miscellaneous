package elementsOfProgramming.HashTables;

public class MostFrequentlyUsedQueey {
	
	/*
	 * The brute-force approach is to first find the distinct strings and how often
each one of them occurs using a hash table—keys are strings and values are frequen¬
cies. After building the hash table, we create a new array on the unique strings and
sort the new array, using a custom comparator in which strings are ordered by their
frequency (which we get via a lookup in the hash table). The k top entries in the new
array after sorting are the result. The time complexity is0(n + mlog m), where n is the
number of strings the original array, and m is the number of distinct strings. The first
term comes from building the hash table, and the second comes from the complexity
to sort the array. The space complexity is0(m).
Since all that is required is the k most frequent strings, the sort phase in above
algorithm is overkill because it tells us about the relative frequencies of strings that
are infrequent too. We can achieve a time complexity of 0(n+ mlogk). This approach
is superior when m is large, i.e., comparable to n, and k is small. We do this by
maintaining a min-heap of the k most frequent strings. We add the first k strings
to the hash table. We compare the frequency of each subsequent string with the
frequency of the string at the root of the min-heap. If the new string's frequency is
greater than the root's frequency, we delete the root and add the new string to the
min-heap. The k stringsin the min-heap at the end of the iteration are the result. In the
worst-case, each iterative step entails a heap delete and insert, so the time complexity
is0(n + m log k). The space complexity is dominated by the hash table, i.e., 0(m).
We can improve the time complexity to almost certain 0(n + m) = 0(n) by using
the algorithm in Solution 12.8 on Page 200 to compute the k largest elements in the
array of unique strings, again comparing strings on their frequencies. The space
complexity is0(m).
	 */
}
