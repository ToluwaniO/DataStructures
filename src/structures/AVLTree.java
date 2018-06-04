package structures;

public class AVLTree {

    private class Node {
        int value, height;
        Node left, right;

        Node(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    AVLTree() {
        root = null;
    }

    public void add(int value) {
        root = add(root, value);
    }

    private Node add(Node root, int value) {
        if(root == null) {
            root = new Node(value);
        } else if (value < root.value) {
            root.left = add(root.left, value);
        } else if (value > root.value) {
            root.right = add(root.right, value);
        } else {
            return root;
        }

        computeHeight(root);

        if(getBalance(root) > 1 && value < root.left.value) {
            return rightRotate(root);
        }
        if(getBalance(root) > 1 && value > root.left.value) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if(getBalance(root) < -1 && value > root.left.value) {
            return leftRotate(root);
        }
        if(getBalance(root) < -1 && value < root.left.value) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private void computeHeight(Node node) {
        if (node == null) return;
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int height(Node node) {
        if(node == null) return 0;
        return node.height;
    }

    private int getBalance(Node node) {
        if(node == null) return 0;
        return height(node.left) - height(node.right);
    }

    private Node leftRotate(Node x) {
        Node xRight = x.right;
        Node xRightLeft = xRight.left;

        xRight.left = x;
        x.right = xRightLeft;

        computeHeight(xRight);
        computeHeight(x);
        return xRight;
    }

    private Node rightRotate(Node x) {
        Node xLeft = x.left;
        Node xLeftRight = xLeft.right;

        xLeft.right = x;
        x.left = xLeftRight;

        computeHeight(xLeft);
        computeHeight(x);
        return xLeft;
    }

}
