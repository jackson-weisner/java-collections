package weisner.collections;


public class HashMap<K,V> extends Map<K,V> {
    // default constructor, initializes the map to 15
    public HashMap() {
        this(HashMap.defaultSize);
    }

    public HashMap(int arraySize) {
        this.arraySize = arraySize;
        this.array = new HashMapNode[arraySize];
        this.size = 0;
    }

    // inserts the key value pair into the hash map
    // chains to the previous node if there was one already there
    public void put(K key, V value) {
        int index = this.hash(key);
        HashMapNode<K,V> prev = this.array[index];
        HashMapNode<K,V> newNode = new HashMapNode<K,V>(key, value, key.hashCode(), prev);
        this.array[index] = newNode;
        this.size++;
    }

    // hashes the key and checks the hash table for an entry
    // checks all keys in the chained list
    public V get(K key) {
        int index = this.hash(key);
        int hash = key.hashCode();

        HashMapNode<K,V> cur = this.array[index];

        if (cur == null) return null;
        while (cur.next != null) {
            if (cur.hash == hash) return cur.value;
            cur = cur.next;
        }
        return cur.value;
    }

    // remove a item from the hash map
    public V remove(K key) {
        int index = this.hash(key);
        HashMapNode<K,V> cur = this.array[index];
        HashMapNode<K,V> prev = null;
        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        this.size--;
        return cur.value;
    }

    // helper function to hash a key
    private int hash(K key) {
        return key.hashCode() % this.arraySize;
    }

    public void print() {
        for (int i = 0; i < this.arraySize; i++) {
            if (this.array[i] != null) {
                System.out.println(this.array[i].key);
            }
        }
    }

    // node for the HashMap class
    // used for chaining
    class HashMapNode<K,V> {
        public HashMapNode(K key, V value, int hash, HashMapNode<K,V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
        }

        public int hash;
        public K key;
        public V value;
        public HashMapNode<K,V> next;
    }

    public static final int defaultSize = 15;
    private int arraySize;
    private int size;
    private HashMapNode[] array;
}

