import weisner.collections.*;

public class Main {
    public static void main(String[] args) {
        // LinkedList<Integer> ll = new LinkedList<Integer>();
        // ll.add(123);
        // ll.add(1234);
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.insert(999, 10);
        list.addFront(-111);
        list.addBack(888);
        list.addBack(777);
        list.addFront(111);
        for (Integer i : list) {
            System.out.println(i);
        }

    }
}