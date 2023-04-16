import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class MyNode {
        private final T data;
        private MyNode next;

        public MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head; // entry point
    private int length;

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        length++;
        if (head == null) {
            head = newNode;
            return;
        }

        MyNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // O(N)
    @Override
    public T get(int index) {
        if (index >= length) throw new IndexOutOfBoundsException();
        MyNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
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
        MyNode cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }

        @Override
        public T next() {
            T data = cursor.data;
            cursor = cursor.next;
            return data;
        }
    }
}
