import weisner.collections.*;

public class Main {
    public static void main(String[] args) {
        // LinkedList<Integer> ll = new LinkedList<Integer>();
        // ll.add(123);
        // ll.add(1234);
        // LinkedList<Integer> list = new LinkedList<Integer>();
        // for (int i = 0; i < 10; i++) {
        //     list.add(i);
        // }

        // for (Integer i : list) {
        //     System.out.println(i);
        // }
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < 20; i++) {
            m.put(i, i);
        }
            System.out.println(m.contains(10));
            System.out.println(m.get(10));
        // System.out.println(m.remove(10));
        m.put(88, 999);
        // for (int i = 0; i < 21; i++) {
        // }

        // m.print();
    }
}