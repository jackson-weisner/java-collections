// This file implements an array based dynamic list

package weisner.collections;

public class ArrayList<E> implements List<E> {

    // default constructor that calls the param constructor with a default size
    public ArrayList() {
        this(ArrayList.defaultSize);
    }

    // this constructor creates a generic array of the size passed in
    // and inits fields
    @SuppressWarnings("unchecked")
    public ArrayList(int size) {
        this.data = (E[]) new Object[ArrayList.defaultSize];
        this.size = 0;
        this.capacity = size;
    }

    // adds an element to the list
    public boolean add(E e) {
        this.checkSpace();
        this.data[this.size] = e;
        this.size++;
        return true;
    }

    // shifts the array RIGHT around the index
    // inserts the element at the new spot
    public void add(int index, E e) {
        this.checkSpace(); 
        if (!this.validIndex(index)) return;
        this.shift(index, Direction.RIGHT);
        this.data[index] = e;
        this.size++;
    }

    // shifts the array LEFT at index
    public E remove(int index) {
        if (!this.validIndex(index)) return null;
        E e = this.data[index];
        this.shift(index, Direction.LEFT);
        this.size--;
        return e;
    }

    // remove elements that are equal to e
    // shifts the array LEFT around elements that are == e
    public boolean remove(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e) {
                this.shift(i, Direction.LEFT);
                this.size--;
                return true;
            }
        }
        return false;
    }

    // linear search over the array
    public boolean contains(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e) return true;
        }
        return false;
    }

    // linear search
    public int indexOf(E e) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == e) return i;
        }
        return -1;
    }

    // returns the element at the index if it is valid
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

    // debug method to display this list
    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.data[i]);
        }
    }

    // allocates a new array of double the current size
    // then copies over all the elements to the new array
    @SuppressWarnings("unchecked")
    private void expand() {
        E[] old = this.data;
        this.data = (E[]) new Object[this.capacity * 2];
        for (int i = 0; i < this.capacity; i++) {
            this.data[i] = old[i];
        }
        this.capacity = this.capacity * 2;
    }

    // shift the contents of the array around an index in a direction
    // direction = LEFT, is for shrinking the array
    // direction = RIGHT, is for making room at the index
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

    // helper method to check if there is still room in the array
    private void checkSpace() {
        if (this.size == this.capacity) this.expand();
    }

    // helper method to verify if the index passed in is within the arrays bounds
    private boolean validIndex(int index) {
        return index >= 0 && index < this.size;
    }

    private static final int defaultSize = 8;
    private enum Direction {LEFT, RIGHT};
    private E[] data;
    private int capacity;
    private int size;
};