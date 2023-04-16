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
    public void add(T item, int index) {
        if (index >= length + 1) throw new IndexOutOfBoundsException();

        length++;
        for (int i = length - 1; i > index; i--) {
            hiddenArr[i] = hiddenArr[i - 1];
        }
        hiddenArr[index] = item;

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
    public boolean contains(Object o) {
        for (var elem: hiddenArr) {
            if (elem == o) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < length; i++) {
            if (hiddenArr[i] == o) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = length - 1; i >= 0; i--) {
            if (hiddenArr[i] == o) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < length; i++) {
            if (hiddenArr[i] == o) {
                for (int j = i; j < length - 1; j++) {
                    hiddenArr[j] = hiddenArr[j + 1];
                }
                length--;
                return true;
            }
        }

        return false;
    }

    @Override
    public T remove(int index) {
        if (index >= length) throw new IndexOutOfBoundsException();

        Object object = hiddenArr[index];
        remove(hiddenArr[index]);
        return (T)object;
    }

    @Override
    public void clear() {
        length = 0;
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