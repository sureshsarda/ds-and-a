package clrs.c22;


import java.util.*;
import java.util.stream.Collectors;

public class AdjacencyListGraph<T> implements Graph<T> {

    private static class AdjacencyListVertex<K> implements Vertex<K> {

        private final int id;
        private final Set<Vertex<K>> neighbors;
        private K data;

        public AdjacencyListVertex(int id) {
            this.id = id;
            this.neighbors = new TreeSet<>();
        }

        @Override
        public K getData() {
            return data;
        }

        @Override
        public void setData(K t) {
            this.data = t;
        }

        @Override
        public int id() {
            return id;
        }

        private void addNeighbor(AdjacencyListVertex<K> v) {
            this.neighbors.add(v);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AdjacencyListVertex<?> that = (AdjacencyListVertex<?>) o;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    List<AdjacencyListVertex<T>> vertices = new LinkedList<>();

    public AdjacencyListGraph(List<Vertex<T>> nodes, Map<Integer, Integer> edges) {
        for (Vertex<T> v : nodes) {
            vertices.add(new AdjacencyListVertex<>(v.id()));
        }

        for (Map.Entry<Integer, Integer> edge : edges.entrySet()) {
            int from = edge.getKey();
            Integer to = edge.getValue();
            if (from >= nodes.size() || to >= nodes.size()) {
                throw new IllegalArgumentException(String.format("Invalid edges. Graph has %d nodes, but edge is " +
                        "between: %d-%d", nodes.size(), from, to));
            }
            this.vertices.get(from).addNeighbor(this.vertices.get(to));
        }
    }


    public Set<Vertex<T>> neighborsOf(Vertex<T> vertex) {
        assertSizeIsValid(vertex.id());
        return vertices.get(vertex.id()).neighbors;
    }

    private void assertSizeIsValid(int i) {
        if (i >= vertices.size()) {
            throw new IllegalArgumentException("Size should not be greater than: " + vertices.size());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Graph:");

        for (int i = 0; i < vertices.size(); i++) {
            sb.append(vertices.get(i).neighbors.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("-", i + "->", "")));
        }

        return sb.toString();
    }
}
