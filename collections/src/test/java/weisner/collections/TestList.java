import weisner.collections.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.stream.Stream;

public class TestList {
    @ParameterizedTest
    @MethodSource("listFactory")
    public void testInit(List<Integer> list) {
        assertEquals(list.size(), 0);
        // assertEquals(list.capacity(), 8);
    }

    @ParameterizedTest
    @MethodSource("listFactory")
    public void add(List<Integer> list) {
        for (int i = 0; i < 12; i++) {
            list.add(i);
            assertEquals(list.get(i), (Integer)i);
        }
        for (Integer i : list) {System.out.println(i);}
        System.out.println();
        assertEquals(list.size(), 12);
    }

    private static Stream<List<Integer>> listFactory() {
        return Stream.of(
            new ArrayList<Integer>(),
            new LinkedList<Integer>()
        );
    }

    @Test
    public void remove() {

    }
}