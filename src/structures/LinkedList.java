package structures;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

class LinkedList<E> implements List<E>, Iterable<E>{

    private Node<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(E e) {
        add(head, e);
    }

    private void add(Node<E> n, E e){
        if(head == null){
            head = new Node<E>(null, e);
        }
        else if(head.next == null){
            head.next = new Node<E>(null, e);
        }
        else {
            add(head.next, e);
        }
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if(i >= size){
            throw new IndexOutOfBoundsException();
        }
        return remove(head, 0, 1);
    }

    private E remove(Node<E> n, int loc, int i) {
        E val;
        if(loc == i){
            val = n.value;
            head = head.next;
            return val;
        }
        return remove(head.next,loc+1, i);
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        return get(head, 0, i);
    }

    private E get(Node<E> n, int loc, int i) {
        E val;
        if(loc == i){
            val = n.value;
            return val;
        }
        return get(head.next,loc+1, i);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator(head);
    }

    private class Node<E>{
        Node<E> next;
        E value;

        public Node(Node<E> next, E value) {
            this.next = next;
            this.value = value;
        }

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    private class LinkedListIterator implements Iterator<E>{

        Node<E> node;

        public LinkedListIterator(Node<E> node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public E next() {
            return node.value;
        }
    }
}