import weisner.collections.list.LinkedList;
import weisner.collections.map.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < 20; i++) {
            m.put(i, i);
        }
        System.out.println(m.contains(10));
        System.out.println(m.get(10));
    }
}