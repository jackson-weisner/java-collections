package weisner.collections.map;

public abstract class Map<K,V> {
    protected int size;
    public abstract V get(K key);
    public abstract void put(K key, V value);
    public abstract V remove(K key);
    public abstract void replace(K key, V value);
    public abstract boolean contains(K key);

    public boolean isEmpty() {return this.size == 0;}
    public int size() {return this.size;}
}