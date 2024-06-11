package weisner.collections;

public abstract class Map<K,V> {
    public abstract V get(K key);
    public abstract void put(K key, V value);
    public abstract V remove(K key);
    public abstract void replace(K key, V value);
    public abstract boolean contains(K key);
    // public abstract boolean containsValue(V value);

    // public boolean isEmpty() {return this.size == 0;}
    // public int size() {return this.size;}
}