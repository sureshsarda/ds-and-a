package clrs.c22;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleGraphTest {

    @Test
    public void testBFS() {

        SimpleGraph graph = SimpleGraph.from(6, true, 0, 1, 0, 4, 1, 4, 1, 5, 1, 2, 5, 2);
        final List<Integer> integers = graph.breadthFirstSearch(0);

        assertEquals(Arrays.asList(0, 1, 4, 5, 2), integers);

        SimpleGraph graph1 = new SimpleGraph(6, Arrays.asList(
                new SimpleGraph.Edge(0, 1),
                new SimpleGraph.Edge(0, 3),
                new SimpleGraph.Edge(1, 4),
                new SimpleGraph.Edge(3, 1),
                new SimpleGraph.Edge(4, 3),
                new SimpleGraph.Edge(2, 4),
                new SimpleGraph.Edge(2, 5),
                new SimpleGraph.Edge(5, 5)
        ), true);

        assertEquals(Arrays.asList(0, 1, 3, 4, 2, 5), graph1.breadthFirstSearch(0));
    }
}
