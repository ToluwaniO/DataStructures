import structures.BinarySearchTree;
import structures.MyLinkedList;
import structures.SearchSort;
import structures.Stack;


import java.util.Arrays;
import java.util.Random;

public class main {

    public static void main(String[] args){
//        System.out.println("//////////////// LINKEDLIST \\\\\\\\\\\\\\\\\\\\\\\\");
//        printLinkedList();
//
//        System.out.println("\n\n//////////////// LINKEDLIST \\\\\\\\\\\\\\\\\\\\\\\\");
//        printStack();
//
//        createTree();
//        testMergeSort();
//        testQuickSort();
        boolean[] v = new boolean[5];
        for (boolean b : v) {
            System.out.println(b);
        }
    }

    private static void createTree() {
        BinarySearchTree tree = new BinarySearchTree();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            tree.add(random.nextInt(100));
        }
    }

    public static void printLinkedList(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(0);
        print(list.toString());

        for (int i = 0; i < 100; i++){
            list.add(i+1);
        }
        print(list.toString());

        list.remove(10);

        print(list.toString());
        list.addFirst(-1);
        print(list.toString());
    }

    public static void printStack(){
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i++){
            stack.push(i);
        }
        int size = stack.size();
        for (int i = 0; i < size; i++){
            print(stack.pop());
        }

    }

    public static void testMergeSort() {
        int[] data = new int[20];
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            data[i] = rand.nextInt(20);
        }
        print(Arrays.toString(data));
        SearchSort.mergeSort(data);
        print(Arrays.toString(data));
    }

    public static void testQuickSort() {
        int[] data = new int[20];
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            data[i] = rand.nextInt(20);
        }
        print(Arrays.toString(data));
        SearchSort.quickSort(data);
        print(Arrays.toString(data));
    }

    public static void print(Integer i){
        System.out.println(i);
    }

    public static void print(String i){
        System.out.println(i);
    }
}