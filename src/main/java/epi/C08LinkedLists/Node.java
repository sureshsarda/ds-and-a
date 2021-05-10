package epi.C08LinkedLists;

import java.util.stream.IntStream;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public static Node sequentialList(int size) {
        return from(IntStream.rangeClosed(0, size).toArray());
    }

    public static Node from(int... numbers) {
        if (numbers.length < 1) {
            throw new IllegalArgumentException("At least one argument is required");
        }

        Node head = new Node(numbers[0]);
        Node current = head;
        for (int i = 1; i < numbers.length; i++) {
            current.next = new Node(numbers[i]);
            current = current.next;
        }
        return head;
    }

    public Node last() {
        Node node = this;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    /**
     * Returns nth list after the current not. 0, 1, 2, 3
     *
     * @param n the index of node to return
     * @return
     */
    public Node nth(int n) {
        Node current = this;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }
        return current;
    }

    public int length() {
        Node current = this;
        int length = 0;
        while (current != null) {
            length += 1;
            current = current.next;
        }
        return length;
    }

    @Override
    public String toString() {
        return "Node{" + data + "}->" + (next == null ? "null" : next.toString());
    }

}
