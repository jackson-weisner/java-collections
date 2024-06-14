package weisner.collections;
import weisner.collections.list.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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

class TestGet extends ListFactory {
    @ParameterizedTest
    @MethodSource("listFactory")
    public void afterInit(List<Integer> list) {
        assertNull(list.get(0));
        assertNull(list.get(-1));
    }

    @ParameterizedTest
    @MethodSource("listFactory")
    public void addingAndGetting(List<Integer> list) {
        list.add(999);
        assertEquals(999, list.get(0));
        list.add(123);
        assertEquals(123, list.get(1));
    }

    @ParameterizedTest
    @MethodSource("listFactory")
    public void removeAndGet(List<Integer> list) {
        list.add(999);
        assertEquals(999, list.get(0));
        list.remove(0);
        assertNull(list.get(0));
    }
}

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
        assertEquals(0, list.size());
    }

    // add elements and see if the size is correct
    @ParameterizedTest
    @MethodSource("listFactory")
    public void addingElements(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
            assertEquals(i+1, list.size());
        }
    }

    // remove items from the list and ensure the size is never < 0
    @ParameterizedTest
    @MethodSource("listFactory")
    public void removingElements(List<Integer> list) {
        list.add(999);
        assertEquals(1, list.size());
        for (int i = 0; i < 3; i++) {
            list.remove(0);
        }
        assertEquals(0, list.size());
    }
}


class TestAdd extends ListFactory {
    @ParameterizedTest
    @MethodSource("listFactory")
    public void add(List<Integer> list) {
        for (int i = 0; i < 12; i++) {
            list.add(i);
            assertEquals((Integer)i, list.get(i));
        }
        assertEquals(12, list.size());
    }

    @ParameterizedTest
    @MethodSource("listFactory")
    public void removeAndAdd(List<Integer> list) {
        assertEquals(0, list.size());
        list.remove(0);
        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        list.remove(1);
        assertEquals(1, list.get(0));
    }
}

class TestInsert extends ListFactory {}


class TestRemove extends ListFactory {
    @ParameterizedTest
    @MethodSource("listFactory")
    public void basicTest(List<Integer> list) {
        assertNull(list.remove(0));
        assertEquals(0, list.size());
    }
}