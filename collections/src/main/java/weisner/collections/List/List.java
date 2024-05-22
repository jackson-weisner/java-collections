package weisner.collections;

public interface List<E> {
    boolean add(E e);
    void add(int index, E e);
    E remove(int index);
    boolean remove(E e);

    E get(int index);
    boolean contains(E e);
    int indexOf(E e);

    boolean isEmpty();
    int size();

    // void clear();
    // Iterator<E> iterator();
};