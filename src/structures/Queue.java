package structures;

public class Queue<T> {

    private Node<T> head;
    private int size = 0;

    Queue(){
        head = null;
    }

    public void enqueue(T value){
        if(head == null)
            head = new Node<T>(value, head);
        add(head.next, value);
        size++;
    }

    private void add(Node<T> node, T value){
        if(node == null){
            node = new Node<T>(value, node);
        } else {
            add(node.next, value);
        }
    }

    public T dequeue() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public T peek(){
        return head.value;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value){
            this.value = value;
            this.next = null;
        }

        Node(T value, Node<T> next){
            this.value = value;
            this.next = next;
        }
    }
}
