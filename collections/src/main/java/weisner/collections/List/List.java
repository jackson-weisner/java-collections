package weisner.collections;

// abstract class for a generic List
public abstract class List<E> {
    public abstract boolean add(E e);
    public abstract void add(int index, E e);
    public abstract E remove(int index);
    public abstract boolean remove(E e);
    public abstract E get(int index);
    public abstract boolean contains(E e);
    public abstract int indexOf(E e);

    public boolean isEmpty() {return this.size == 0;}
    public int size() {return this.size;}
    protected boolean validIndex(int index) {return index >= 0 && index < this.size;};

    protected int size;
    // void clear();
    // Iterator<E> iterator();
};