package elementsOfProgramming.Sorting;

//Can also be done using counting Sort.
public class PartitioningAndSortingAnArrayWithRepeatedEntitites {

	/*
	 * 
	 * 
	 * 
	 * The brute-force approach is to sort the array, comparing on age. If the
array length is n, the time complexity is0(n log n) and space complexity is 0(1). The
inefficiency in thisapproachstemsfrom the fact that itdoes more than is required—the
specification simply asks for students of equal age to be adjacent.
We use the approach described in the introduction to the problem. However, we
cannot apply it directly, since we need to write objects, not integers—two students
may have the same age but still be different.
For example, consider the array ((Greg,14), (John,12), (Andy,11), (Jim,13),
(Phil,12), (Bob,13), (Chip,13), (Tim,14)). We can iterate through the array and record
the number of students of each age in a hash. Specifically, keys are ages, and values
are the corresponding counts. For the given example, on completion of the iteration,
the hash is (14, 2), (12, 2), (11,1), (13,3). This tells us that we need to write two students
of age 14, two students of age 12, one student of age 11 and three students of age 13.
We can write these students in any order, as long as we keep students of equal age
adjacent.
If we had a new array to write to, we can write the two students of age 14 starting
at index 0, the two students of age 12 starting at index 0 + 2 = 2, the one student of
age 11 at index 2+2 = 4, and the three students of age 13 starting at index 4 + 1 = 5.
We would iterate through the original array, and write each entry into the new array
according to these offsets. For example, after the first four iterations, the new array
would be ((Greg,14), (John,12), (Andy,11), (Jim,13), -).
The time complexity of this approach is 0(n), but it entails 0(n) additional space
for the result array. We can avoid having to allocate a new array by performing the
updates in-place. The idea is to maintain a subarray for each of the different types
of elements. Each subarray marks out entries which have not yet been assigned
elements of that type. We swap elements across these subarrays to move them to
their correct position.
In the program below, we use two hash tables to track the subarrays. One is the
starting offset of the subarray, the other its size. As soon as the subarray becomes
empty, we remove it.
	 * 
	 * 
	 * 
	 */
}
