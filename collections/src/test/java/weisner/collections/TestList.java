import weisner.collections.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.stream.Stream;

abstract class ListFactory {
    // @ParameterizedTest
    // @MethodSource("listFactory")
    // public void testInit(List<Integer> list) {
    //     assertEquals(list.size(), 0);
    //     // assertEquals(list.capacity(), 8);
    // }



    // @ParameterizedTest
    // @MethodSource("listFactory")
    // public void insert(List<Integer> list) {
    //     // assertEquals(list.size(), 0);
    //     // list.insert(999, -1);
    //     // list.insert(999, 2);
    //     // assertEquals(list.size(), 0);

    //     // list.insert(999, 0);
    //     // assertEquals(list.get(0), 999);
    // }

    // @ParameterizedTest
    // @MethodSource("listFactory")
    // public void remove(List<Integer> list) {

    // }


    // @ParameterizedTest
    // @MethodSource("listFactory")
    // public void contains(List<Integer> list) {

    // }

    // @ParameterizedTest
    // @MethodSource("listFactory")
    // public void indexOf(List<Integer> list) {
    //     assertEquals(list.indexOf(999), -1);

    // }


    private static Stream<List<Integer>> listFactory() {
        return Stream.of(
            new ArrayList<Integer>(),
            new LinkedList<Integer>()
        );
    }
}

class TestGet extends ListFactory {}

class TestIsEmpty extends ListFactory {
    // check that the list is empty after the constructor 
    @ParameterizedTest
    @MethodSource("listFactory")
    public void basicTest(List<Integer> list) {
        assertTrue(list.isEmpty());
    }
    
    @ParameterizedTest
    @MethodSource("listFactory")
    public void addingElements(List<Integer> list) {
        assertTrue(list.isEmpty());
        for (int i = 0; i < 9; i++) {
            list.add(999);
        }
        assertFalse(list.isEmpty());
    }


    // add and then remove elements from the list
    @ParameterizedTest
    @MethodSource("listFactory")
    public void removingElements(List<Integer> list) {
        assertTrue(list.isEmpty());
        list.add(999);
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }
}

class TestSize extends ListFactory {
    // basic test after constructor
    @ParameterizedTest
    @MethodSource("listFactory")
    public void basicTest(List<Integer> list) {
        assertEquals(list.size(), 0);
    }

    // add elements and see if the size is correct
    @ParameterizedTest
    @MethodSource("listFactory")
    public void addingElements(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
            assertEquals(list.size(), i+1);
        }
    }

    // remove items from the list and ensure the size is never < 0
    @ParameterizedTest
    @MethodSource("listFactory")
    public void removingElements(List<Integer> list) {
        list.add(999);
        assertEquals(list.size(), 1);
        for (int i = 0; i < 3; i++) {
            list.remove(0);
        }
        assertEquals(list.size(), 0);
    }
}


class TestAdd extends ListFactory {
    @ParameterizedTest
    @MethodSource("listFactory")
    public void add(List<Integer> list) {
        for (int i = 0; i < 12; i++) {
            list.add(i);
            assertEquals(list.get(i), (Integer)i);
        }
        assertEquals(list.size(), 12);
    }

    @ParameterizedTest
    @MethodSource("listFactory")
    public void removeAndAdd(List<Integer> list) {
        assertEquals(list.size(), 0);
        list.remove(0);
        assertEquals(list.size(), 0);
        list.add(1);
        list.add(2);
        assertEquals(list.get(0), 1);
        assertEquals(list.get(1), 2);
        list.remove(1);
        assertEquals(list.get(0), 1);
    }
}

class TestInsert extends ListFactory {}


class TestRemove extends ListFactory {}