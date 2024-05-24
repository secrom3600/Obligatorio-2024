package uy.edu.um.tad.linkedlist;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node<T> {

    private T value;

    private Node<T> next;

    private int priority;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

}
