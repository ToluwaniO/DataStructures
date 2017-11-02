
import java.util.Comparator;
import java.util.Random;

public class main {

    public static void main(String[] args){

    }
}

class Comp implements Comparator<Integer>
{
    public int compare(Integer x, Integer y)
    {
        return y-x;
    }
}
