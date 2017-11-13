package structures;

public interface List<E> {

    void add(E e);

    E remove(int i) throws IndexOutOfBoundsException;

    E get(int i) throws IndexOutOfBoundsException;

    int size();

    boolean isEmpty();


}
