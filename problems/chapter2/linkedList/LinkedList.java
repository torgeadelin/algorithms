package linkedList;

public class LinkedList<T> {
    class Node<T> {
        public Node<T> next = null;
        public T value = null;

        public Node(T value) {
            this.next = null;
            this.value = value;
        }
    }

    // Node Class
    public Node<T> head;
    public Node<T> tail;
    public int size = 0;

    // Constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<T>(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public T deleteTail() {
        T deletedNode = this.tail.value;

        // If there is only one node
        if (this.tail == this.head) {
            this.head = null;
            this.tail = null;
            return deletedNode;
        }

        // 2 or more nodes
        if (this.tail != null) {
            Node<T> current = this.head;
            while (current.next != this.tail) {
                current = current.next;
            }
            current.next = null;
            this.tail = current;
        }
        this.size--;
        return deletedNode;
    }

    public T deleteHead() {
        if (this.head.next != null) {
            this.head = this.head.next;
        } else {
            this.head = null;
            this.tail = null;
        }
        return null;
    }

    public void printToScreen() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
        System.out.println();
    }
}
