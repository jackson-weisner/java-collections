package weisner.collections;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import weisner.collections.map.HashMap;

public class TestHashMap {
    protected HashMap<Integer, Integer> map;

    @BeforeEach
    public void init() {this.map = new HashMap<>();}
}


class TestPut extends TestHashMap {
    // put elements and check if the size is correct
    @Test
    public void basicTest() {
        assertEquals(0, map.size());
        map.put(0, 0);
        assertEquals(1, map.size());
    }

    // put elements then get their value
    @Test
    public void putThenGet() {
        map.put(0,0);
        assertEquals(0, map.get(0));
        map.put(1,1);
        assertEquals(1, map.get(1));
    }

    // see if the hash map will not add duplicate key's
    @Test
    public void addDuplicate() {
        map.put(0,0);
        map.put(0,1);
        assertEquals(1, map.size());
        assertEquals(0, map.get(0));
    }
}

class TestContains extends TestHashMap {
    // check if something that is not in the
    // HashMap is not contained
    @Test
    public void basicTest() {
        assertFalse(map.contains(0));
    }

    // add key value pairs and see if contains() returns true
    @Test
    public void addPairs() {
        for (int i = 0; i < 3; i++) {
            map.put(i, 0);
            assertTrue(map.contains(i));
        }
    }
}


class TestMapRemove extends TestHashMap {
    @Test
    public void basicTest() {

    }
}