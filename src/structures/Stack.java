package structures;

import java.util.EmptyStackException;

public class Stack<T> {

    private static class Node<T>{
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> top = null;
    private int size = 0;

    public void push(T t){
        Node<T> temp = new Node<>(t);
        temp.next = top;
        top = temp;
        size++;
    }

    public T pop(){
        if(top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public T peek(){
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return top == null;
    }

}
