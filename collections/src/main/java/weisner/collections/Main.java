import weisner.collections.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<Integer>(8);
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }
        l.add(3, 10);
        System.out.print("ttttest\n\n\n");
        System.out.println(l.indexOf(10));
        l.print();
    }
};