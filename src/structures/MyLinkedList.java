package structures;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class MyLinkedList<E> {

    private class Node<E> {
        E data = null;
        Node next = null;

        Node(E data) {
            this.data = data;
        }

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    
    public void add(E e) {
        head = add(head, e);
        size++;
    }

    
    public void addFirst(E e) {
        Node<E> temp = head;
        if(head == null) {
            head = new Node<>(e);
        } else {
            head = new Node<E>(e, temp);
        }
        size++;
    }

    private Node<E> add(Node<E> list, E e) {
        if(list == null) {
            return new Node<>(e);
        } else {
            list.next = add(list.next, e);
            return list;
        }
    }

    
    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node<E> list, E e) {
        if(list == null) {
            return false;
        } else if (list.data == e) {
            return true;
        }
        return contains(list.next, e);
    }

    
    public E get(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("List size = " + size + " index = " + index);
        } else if(size == 1) {
            return head.data;
        }
        Node<E> temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    
    public int indexOf(E e) {
        return 0;
    }

    
    public void remove(E e) {
        head = remove(head, e);
    }

    private Node<E> remove(Node<E> temp, E e) {
        if(temp == null) {
            return temp;
        } else if(temp.data == e) {
            size--;
            return temp.next;
        } else {
            temp.next = remove(temp.next, e);
            return temp;
        }
    }

    
    public int size() {
        return size;
    }

    
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        Node<E> temp = head;
        while (temp != null) {
            builder.append(temp.data).append(", ");
            temp = temp.next;
        }
        builder.append("]");
        return builder.toString();
    }
}