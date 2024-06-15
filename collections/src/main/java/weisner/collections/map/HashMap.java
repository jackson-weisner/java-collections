package weisner.collections.map;


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

    public boolean contains(K key) {
        return this.get(key) != null;
    }

    // change the value in the HashMapNode
    public void replace(K key, V value) {
        HashMapNode<K,V> node = this.getNode(key);
        if (node != null) {
            this.getNode(key).value = value;
        }
    }

    // inserts the key value pair into the hash map
    // chains to the previous node if there was one already there
    public void put(K key, V value) {
        if (this.get(key) != null) return;
        int index = this.hash(key);
        HashMapNode<K,V> prev = this.array[index];
        HashMapNode<K,V> newNode = new HashMapNode<K,V>(key, value, key.hashCode(), prev);
        this.array[index] = newNode;
        this.size++;
    }

    // hashes the key and checks the hash table for an entry
    // checks all keys in the chained list
    // returns a node, for easy use in the get() method and replace() method
    private HashMapNode<K,V> getNode(K key) {
        int index = this.hash(key);

        HashMapNode<K,V> cur = this.array[index];

        if (cur == null) return null;
        while (cur.next != null) {
            if (cur.equal(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return (cur.equal(key)) ? cur : null;
    }

    public V get(K key) {
        HashMapNode<K,V> node = this.getNode(key);
        return (node == null) ? null : node.value;
    }

    // remove a item from the hash map
    public V remove(K key) {
        if (this.get(key) == null) return null;
        int index = this.hash(key);
        HashMapNode<K,V> prev = null, cur = this.array[index];

        // checks if the hash node is at the index (not part of the chain)
        if (cur.equal(key)) {
            V v = (V)this.array[index].value;
            this.array[index] = this.array[index].next;
            this.size--;
            return v;
        }

        // loops over the chained nodes until the key is found
        while (cur.next != null) {
            if (cur.equal(key)) break;
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
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

        // tests if a key is equal to this hash node's hash value
        public boolean equal(K key) {return this.hash == key.hashCode();}

        public int hash;
        public K key;
        public V value;
        public HashMapNode<K,V> next;
    }

    public static final int defaultSize = 25;
    private int arraySize;
    private HashMapNode[] array;
}

