package weisner.collections;

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
        this.size = 0;
    }

    // adds the element to the head of the linked list
    public boolean add(E e) {
        LinkedListNode<E> node = new LinkedListNode<E>(e, this.head);
        this.head = node;
        this.size++;
        return false;
    }

    public void print() {
        LinkedListNode<E> cur = this.head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public void add(int index, E e) {}
    public E remove(int index) {return this.test;}
    public boolean remove(E e) {return true;}

    public E get(int index) {return this.test;}
    public boolean contains(E e) {return true;}
    public int indexOf(E e) {return 0;}

    public boolean isEmpty() {return size == 0;}
    public int size() {return this.size;}

    private boolean checkIndex(int index) {
        return index >= 0 && index < this.size;
    }

    private int size;
    private E test;
    private LinkedListNode<E> head;
}