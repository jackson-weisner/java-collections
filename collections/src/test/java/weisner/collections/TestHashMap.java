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
    public void basicTest() {
        assertEquals(0, map.size());
    }
}