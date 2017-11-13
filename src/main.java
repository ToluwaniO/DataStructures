import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class main {

    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 100; i++){
            list.add(i*2);
        }

        print(list.remove(10));

        for (Integer i:list) {
            print(i);
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
