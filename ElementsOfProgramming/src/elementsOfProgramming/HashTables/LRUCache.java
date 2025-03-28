package elementsOfProgramming.HashTables;

import java.util.LinkedHashMap;

/*
 * An alternative is to maintain a separate queue of keys. In the hash table we store
for each key a reference to its location in the queue. Each time an ISBN is looked up
and is found in the hash table, it is moved to the front of the queue. (This requires
us to use a linked list implementation of the queue, so that items in the middle of the
queue can be moved to the head.) When the length of the queue exceeds n, when a
new element is added to the cache, the item at the tail of the queue is deleted from
the cache, i.e., from the queue and the hash table.
The Java language provides the class LinkedHashMap, which is a subclass of
HashMap that preserves the insertion order—an iteration through a LinkedHashMap
visits keys in the order they were inserted. By calling the appropriate constructor, we
can ensure that any time an entry is read, it automatically moves to the front. We can
take advantage of this class to avoid having to implement the linked list.
public class
 */
public class LRUCache {
	LinkedHashMap<Integer, Integer> isbnToPrice;

	public LRUCache(int initialCapacity) {
		super();
		isbnToPrice = new LinkedHashMap<Integer, Integer>(initialCapacity, 1.0f, true) {

			@Override
			protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
				return initialCapacity < isbnToPrice.size();
			}
		};
	}

	public Integer lookup(Integer key) {
		if (!isbnToPrice.containsKey(key)){
			return null ;
		}
		return isbnToPrice.get(key);
	}
	
	public Integer insert(Integer key, Integer value) {
		// We add the value for key only if key is not present - we don’t update
		// existing values.
		Integer currentValue = isbnToPrice.get(key);
		if (!isbnToPrice.containsKey(key)){
			isbnToPrice.put(key , value);
			return currentValue;
		} else {
			return null ;
		}
	}
	public Integer erase(Object key) { 
		return isbnToPrice.remove(key); 
	}


	public static void main(String[] args) {

	}

}
