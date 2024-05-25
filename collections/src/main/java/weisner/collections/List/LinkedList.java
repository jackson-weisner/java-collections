package weisner.collections;
import java.util.Iterator;

// node class for the linked list
class LinkedListNode<E> {
    public LinkedListNode(E e, LinkedListNode next) {
        this.next = next;
        this.data = e;
    }

    public LinkedListNode next;
    public E data;
}

public class LinkedList<E> extends List<E> {
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // adds the element to the front
    public void addFront(E e) {
        LinkedListNode<E> node = new LinkedListNode<E>(e, this.head);
        if (this.size == 0) this.tail = node;
        this.head = node;
        this.size++;
    }

    public void addBack(E e) {
        // checks if head == tail
        if (this.size == 0) {
            this.addFront(e);
            return;
        }
        // normal case where size > 0
        LinkedListNode<E> node = new LinkedListNode<E>(e, null);
        this.tail.next = node;
        this.tail = node;
        size++;
    }

    // a default add method that adds to the front of the list
    public void add(E e) {
        this.addFront(e);
    }

    // traverses the linked list and inserts the element at the specified index
    public void insert(E e, int index) {
        if (!this.validIndex(index)) return;

        // checks if element should be inserted at the front
        if (index == 0) {
            this.addFront(e);
            return;
        }

        // traverse the linked list
        LinkedListNode<E> cur = this.head;
        for (int i = 0; i < index-1; i++) {
            cur = cur.next;
        }
        cur.next = new LinkedListNode<E>(e, cur.next);
    }

    public void print() {
        LinkedListNode<E> cur = this.head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public E remove(int index) {return this.test;}
    public boolean remove(E e) {return true;}

    // traverses the linked list and returns value at the index passed in
    public E get(int index) {
        if (!this.validIndex(index)) return null;

        // traverse the list
        LinkedListNode<E> cur = this.head;
        for (int i = 0; i != index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }
    public boolean contains(E e) {return true;}
    public int indexOf(E e) {return 0;}

    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }

    public LinkedListNode<E> getHead() {
        return this.head;
    }

    private E test;
    private LinkedListNode<E> head;
    private LinkedListNode<E> tail;
}

// linked list iterator implementation
class LinkedListIterator<E> implements Iterator<E> {
    public LinkedListIterator(LinkedList<E> list) {
        this.cur = list.getHead();
    }

    // checks if the current node has a next
    public boolean hasNext() {
        return this.cur.next != null;
    }

    // gets the element at the index
    // increments index
    public E next() {
        E data = this.cur.data;
        this.cur = this.cur.next;
        return data;
    }

    private LinkedListNode<E> cur;
}