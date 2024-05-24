import weisner.collections.*;

public class Main {
    public static void main(String[] args) {
        // LinkedList<Integer> ll = new LinkedList<Integer>();
        // ll.add(123);
        // ll.add(1234);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}