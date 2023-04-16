import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] hiddenArr;
    private int length;

    public MyArrayList() {
        this(5);
    }

    public MyArrayList(int initialCapacity) {
        hiddenArr = new Object[initialCapacity];
    }

    private void increaseArray() {
        int biggerSize = (int)(hiddenArr.length * 1.5);
        Object[] newArr = new Object[biggerSize];

        for (int i = 0; i < hiddenArr.length; i++) {
            newArr[i] = hiddenArr[i];
        }

        hiddenArr = newArr;
    }


    @Override
    public void add(T item) {
        if (length == hiddenArr.length) {
            increaseArray();
        }

        hiddenArr[length++] = item;
    }

    @Override
    public T get(int index) {
        if (index >= length) throw new IndexOutOfBoundsException();

        return (T)hiddenArr[index];
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public T next() {
            return get(cursor++);
        }
    }
}