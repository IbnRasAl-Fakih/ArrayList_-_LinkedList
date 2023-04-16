import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {

    private class Node {
        private final T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node head; // entry point
    private Node tail; // last point
    private int size;

    @Override
    public void add(T item) {
        Node newNode = new Node(item);
        size++;
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.previous = temp;
        tail = newNode;
    }

    @Override
    public void add(T item, int index) {
        size++;
        if (index >= size) throw new IndexOutOfBoundsException();
        Node newNode = new Node(item);
        if (index == 0) {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            return;
        }
        Node temp = head;
        int counter = 1;
        while (counter != index) {
            temp = temp.next;
            counter++;
        }
        Node nextNode = temp.next;

        temp.next = newNode;
        newNode.previous = temp;
        newNode.next = nextNode;
        if (nextNode != null) {
            nextNode.previous = newNode;
        }
    }

    @Override
    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == o) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    @Override
    public int indexOf(Object o) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data == o) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node temp = tail;
        int index = size - 1;
        while (temp != null) {
            if (temp.data == o) {
                return index;
            }
            temp = temp.previous;
            index--;
        }
        return -1;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        Node cursor = head;

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
