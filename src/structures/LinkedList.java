package structures;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int size = 0;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(T e){
        if(e == null){
            return;
        }
        if(size == 0){
            head = new Node(e, tail, tail);
            tail.previous = head;
            tail.next = head;
        }
        else {
            tail.next = new Node(e, head, tail);
            tail = tail.next;
        }
        size++;
    }

    public void addFirst(T e){
        if(e == null) return;
        if(size == 0){
            add(e);
        }
        else {
            head = new Node(e, head, tail);
            tail.next = head;
            size++;
        }
    }

//    public boolean addAll(Collection<T> c){
//        if(c == null){
//            throw new NullPointerException("Collection for addAll argument is null");
//        }
//        return addAll(0, c);
//    }

//    public boolean addAll(int index, Collection<T> c){
//        if(c == null){
//            throw new NullPointerException("Collection for addAll argument is null");
//        }
//        Node temp = head;
//        Iterator<T> iterator = c.iterator();
//        for (int i = 0; i < index; i ++){
//            temp = temp.next;
//        }
//
//        while (iterator.hasNext()){
//            temp.next = temp;
//            temp.value = iterator.next();
//            temp.next.previous = temp;
//        }
//        size += c.size();
//        return true;
//    }

    public T removeFirst(){
        head = head.next;
        tail = head;
        head.previous = tail;
        size--;
        return head.value;
    }

    public T remove(){
        tail = tail.previous;
        tail.next = head;
        head.previous = tail;
        size--;
        return tail.value;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    @NotNull
    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class Node{
        T value;
        Node next;
        Node previous;

        Node(T data) {
            this.value = data;
            next = previous = null;
        }

        public Node(T data, Node next, Node previous) {
            this.value = data;
            this.next = next;
            this.previous = previous;
        }
    }

    private class LinkedListIterator implements Iterator<T>{
        Node temp;
        public LinkedListIterator() {
            temp = head;
        }

        @Override
        public boolean hasNext() {
            return temp.next != null;
        }

        @Override
        public T next() {
            T val = temp.value;
            temp = temp.next;
            return val;
        }
    }


}
