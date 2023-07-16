package Util;

import lombok.Data;

@Data
public
class Node<T> {
    public T data;
    public Node<T> next;

    private Node() {
    }

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public String toString() {
        return this.data+"\t"+this.next;
    }
}
