package weisner.collections;

public class ArrayList<E> implements List<E> {

    public ArrayList() {
        this(ArrayList.defaultSize);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int size) {
        this.data = (E[]) new Object[ArrayList.defaultSize];
        this.size = 0;
        this.capacity = size;
    }

    public boolean add(E e) {
        this.checkSpace();
        this.data[this.size] = e;
        this.size++;
        return true;
    }

    public void add(int index, E e) {
        this.checkSpace(); 
        if (!this.validIndex(index)) return;
        this.shift(index, Direction.RIGHT);
        this.data[index] = e;
        this.size++;
    }

    public E remove(int index) {
        if (!this.validIndex(index)) return null;
        E e = this.data[index];
        this.shift(index, Direction.LEFT);
        this.size--;
        return e;
    }

    public boolean remove(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e) {
                System.out.printf("\t%d", i);
                this.shift(i, Direction.LEFT);
                this.size--;
                return true;
            }
        }
        return false;
    }

    public boolean contains(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e) return true;
        }
        return false;
    }

    public int indexOf(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e) return i;
        }
        return -1;
    }

    public E get(int index) {
        E value = null;
        if (this.validIndex(index)) value = this.data[index];
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.data[i]);
        }
    }

    @SuppressWarnings("unchecked")
    private void expand() {
        E[] old = this.data;
        this.data = (E[]) new Object[this.capacity * 2];
        for (int i = 0; i < this.capacity; i++) {
            this.data[i] = old[i];
        }
        this.capacity = this.capacity * 2;
    }

    public void shift(int index, Direction d) {
        switch (d) {
            case RIGHT:
                for(int i = this.size+1; i > index; i--) {
                    this.data[i] = this.data[i-1];
                }
                break;
            case LEFT:
                for(int i = index; i < this.size-1; i++) {
                    this.data[i] = this.data[i+1];
                }
                break;
        }
    }

    private void checkSpace() {
        if (this.size == this.capacity) this.expand();
    }

    private boolean validIndex(int index) {
        return index >= 0 && index < this.size;
    }

    private static final int defaultSize = 8;

    private enum Direction {LEFT, RIGHT};

    private E[] data;
    private int capacity;
    private int size;
};