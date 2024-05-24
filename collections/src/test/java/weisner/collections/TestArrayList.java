import weisner.collections.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayList {
    @Test
    public void testInit() {
        ArrayList<Integer> test = new ArrayList<Integer>();
        assertEquals(test.size(), 0);
        assertEquals(test.capacity(), 8);
    }
};