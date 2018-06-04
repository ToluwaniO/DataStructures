package structures;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void add(int e){
        root = add(root, e);
    }

    public boolean search(int value) {
        return search(root, value);
    }

    public void delete(int value) {
        delete(root, value);
    }

    private Node delete(Node root, int value) {
        if(root == null) return null;

        if (value < root.value) {
            root.left = delete(root.left, value);
        } else if(value > root.value) {
            root.right = delete(root.right, value);
        } else  {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                root.value = maxFromLeft(root.left);
                root.left = delete(root.left, value);
            }
        }
        return root;
    }

    private int maxFromLeft(Node root){
        while (root != null) root = root.right;
        return root.value;
    }

    private boolean search(Node root, int value) {
        if(root == null) return false;

        if(root.value == value) {
            return true;
        } else if(value < root.value) {
            return search(root.left, value);
        } else {
            return search(root.right, value);
        }
    }

    private Node add(Node n, int e){
        if(n == null){
            n = new Node(e);
        } else if(e < n.value) {
            n.left = add(n.left, e);
        } else {
            n.right = add(n.right, e);
        }
        return n;
    }

    private class Node {
        int value;
        Node left;
        Node right;

        private Node() {
        }

        Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

}
