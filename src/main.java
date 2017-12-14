import structures.Stack;

import java.util.Comparator;
import java.util.LinkedList;

public class main {

    public static void main(String[] args){
        System.out.println("//////////////// LINKEDLIST \\\\\\\\\\\\\\\\\\\\\\\\");
        printLinkedList();

        System.out.println("\n\n//////////////// LINKEDLIST \\\\\\\\\\\\\\\\\\\\\\\\");
        printStack();
    }

    public static void printLinkedList(){
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++){
            list.add(i*2);
        }

        print(list.remove(10));

        for (Integer i:list) {
            print(i);
        }
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

    public static void print(Integer i){
        System.out.println(i);
    }
}

class Comp implements Comparator<Integer>
{
    public int compare(Integer x, Integer y)
    {
        return y-x;
    }
}
