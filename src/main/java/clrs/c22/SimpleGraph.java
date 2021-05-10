package clrs.c22;

import java.util.*;
import java.util.stream.Collectors;

public class SimpleGraph {

    public static class Edge {
        int from;
        int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    List<List<Integer>> graph = new LinkedList<>();

    public SimpleGraph(Integer nodes, List<Edge> edges, boolean unidirectional) {
        for (int i = 0; i < nodes; i++) {
            graph.add(new LinkedList<>());
        }

        for (Edge edge : edges) {
            int from = edge.from;
            Integer to = edge.to;
            if (from >= nodes || to >= nodes) {
                throw new IllegalArgumentException(String.format("Invalid edges. Graph has %d nodes, but edge is " +
                        "between: %d-%d", nodes, from, to));
            }
            this.graph.get(from).add(to);
            if (unidirectional) {
                this.graph.get(to).add(from);
            }
        }
    }

    public static SimpleGraph from(int count, boolean uni, int... edgeEnds) {
        if (edgeEnds.length % 2 != 0) {
            throw new IllegalArgumentException("Invalid edgeEnds, dangling");
        }

        List<Edge> edges = new ArrayList<>(edgeEnds.length / 2);
        for (int i = 0; i < edgeEnds.length; i += 2) {
            // check the value if it's less than node count.
            // optional although as it's already done in the constructor
            edges.add(new Edge(edgeEnds[i], edgeEnds[i + 1]));
        }
        return new SimpleGraph(count, edges, uni);
    }


    List<Integer> breadthFirstSearch(int source) {
        // TODO check if source is in graph
        Queue<Integer> remaining = new LinkedList<>();
        List<Integer> order = new ArrayList<>(graph.size());
        BitSet visited = new BitSet();

        remaining.offer(source);
        visited.set(source);

        while (!remaining.isEmpty()) {
            int current = remaining.poll();
            order.add(current);

            for (Integer neighbor : graph.get(current)) {
                if (!visited.get(neighbor)) {
                    remaining.offer(neighbor);
                    visited.set(neighbor);
                }
            }
        }

        return order;
    }

    List<Integer> depthFirstSearch(int source) {
        Stack<Integer> remaining = new Stack<>();
        List<Integer> order = new ArrayList<>(graph.size());
        BitSet visited = new BitSet();

        remaining.push(source);
        visited.set(source);

        while (!remaining.isEmpty()) {
            int current = remaining.pop();
            order.add(current);

            for (Integer neighbor : graph.get(current)) {
                if (!visited.get(neighbor)) {
                    remaining.push(neighbor);
                    visited.set(neighbor);
                }
            }
        }

        return order;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph:\n");

        for (int i = 0; i < graph.size(); i++) {
            sb.append(graph.get(i).stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("-", i + "->", "\n")));
        }

        return sb.toString();
    }
}
