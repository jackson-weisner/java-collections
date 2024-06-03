import weisner.collections.*;

public class Main {
    public static void main(String[] args) {
        // LinkedList<Integer> ll = new LinkedList<Integer>();
        // ll.add(123);
        // ll.add(1234);
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Integer i : list) {
            System.out.println(i);
        }

    }
}