package structures;

public class BinaryTree<E> {

    private Node<E> root;

    public BinaryTree() {
        this.root = new Node<E>();
    }

    public void add(E e){

    }

    private void add(Node<E> n, E e){
        if(root == null){
            root = new Node<>(e);
        }
    }

    private class Node<E>{
        E value;
        Node<E> left;
        Node<E> right;

        private Node() {
        }

        public Node(E value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

}
