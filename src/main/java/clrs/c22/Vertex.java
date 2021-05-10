package clrs.c22;

public interface Vertex<T> {

    /**
     * Arbitary data that can be stored in the vertex
     *
     * @return the stored data
     */
    T getData();

    /**
     * Arbitarary data that can be stored in the vertex
     *
     * @param t data to store
     */
    void setData(T t);

    /**
     * An index of the vertex
     *
     * @return index
     */
    int id();
}
