public interface MyList<T> extends Iterable<T> {
    void add(T item);
    void add(T item, int index);
    T get(int index);
    int size();
    boolean contains(Object o);
    int indexOf(Object o);
    boolean remove(Object o);
    T remove(int index);
}