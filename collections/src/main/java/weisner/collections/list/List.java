package weisner.collections.list;
import java.util.Iterator;

// abstract class for a generic List
public abstract class List<E> implements Iterable<E> {
    public abstract void addBack(E e);
    public abstract void addFront(E e);
    public abstract void add(E e);
    public abstract void insert(E e, int index);
    public abstract E remove(int index);
    // public abstract boolean remove(E e);
    public abstract E get(int index);
    public abstract boolean contains(E e);
    public abstract int indexOf(E e);
    public abstract Iterator<E> iterator();

    public boolean isEmpty() {return this.size == 0;}
    public int size() {return this.size;}
    protected boolean validIndex(int index) {
        return (index >= 0 && index < this.size);
    };

    protected int size;
    // void clear();
};