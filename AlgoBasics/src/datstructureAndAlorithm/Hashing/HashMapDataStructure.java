package datstructureAndAlorithm.Hashing;

class Entry< K, V > {
	private K key;
	private V value;
	private Entry<K, V> next;

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public Entry< K, V > getNext() {
		return next;
	}

	public void setNext(Entry< K, V > next) {
		this.next = next;
	}
}

class HashmapDS<K, V> {
	int bucketSize = 10;
	Entry< K, V >[] data = new Entry[ bucketSize ];
	int length = 0;

	public int getHash( K key ) {
		return key.hashCode();
	}

	public void put( K key, V value) {
		int keyHashCode = getHash( key );
		int bucket = keyHashCode % bucketSize;
		Entry<K, V> entry = data[ bucket ];

		while( true ) {

			if( entry == null ) {
				entry = new Entry<K, V>();
				entry.setKey( key );
				entry.setValue( value );
				entry.setNext( data[ bucket ] );
				data[ bucket ] = entry;
				length++;
				break;
			} else if( entry.getKey().equals( key ) ) {
				entry.setValue( value );
				break;
			} else {
				entry = entry.getNext();
			}
		}	
	}
	
	public V get( K key ) {
		int keyHashCode = getHash( key );
		int bucket = keyHashCode % bucketSize;
		Entry<K, V> entry = data[ bucket ];
		
		while( true ) {

			if( entry == null ) {
				return null;
			} else if( entry.getKey().equals( key ) ) {
				return ( V ) entry.getValue();
			} else {
				entry = entry.getNext();
			}
		}
	}
	
	public V remove( K key ) {
		int keyHashCode = getHash( key );
		int bucket = keyHashCode % bucketSize;
		Entry<K, V> entry = data[ bucket ];
		V removedEntry = null;
		
		if( entry == null ) {
			return null;
		} else if( entry.getKey().equals( key ) ) {
			data[ bucket ] = entry.getNext();
			removedEntry = (V) entry.getValue();
		} else {
			entry.setNext( removeNode( entry.getNext(), key ) );
		}
		return removedEntry;	
	}

	private Entry< K, V > removeNode( Entry< K, V > next, K key ) {
		
		if( next == null ) {
			return null;
		}
		
		if( next.getKey().equals( key ) ) {
			return next.getNext();
		} else if( next.getNext() != null ) {
			return removeNode(next.getNext(), key);
		} else {
			return null;
		}
	}
}

public class HashMapDataStructure {

	public static void main(String[] args) {
		HashmapDS< Integer, String > map = new HashmapDS();
		map.put(1, "Hi");
		map.put(2, "Hello");
		map.put(3, "Olla");
		map.put(11, "What");
		map.put(12, "When");
		map.put(13, "How");
		System.out.println( map.get( 1 ) );
		map.remove(12);
		System.out.println( map.get( 12 ) );
		System.out.println( map.get( 13 ) );

	}

}
