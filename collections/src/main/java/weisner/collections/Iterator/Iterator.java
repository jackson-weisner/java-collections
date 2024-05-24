// package weisner.collections;

interface Iterator<E> {
    public boolean hasNext();
    public E next();
    // public void remove();
}

interface Iterable<E> {
    public Iterator<E> iterator();
}