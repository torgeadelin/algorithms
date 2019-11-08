class Node<T> {
    public Node<T> next = null;
    public T value = null;

    public Node(T value) {
        this.next = null;
        this.value = value;
    }
}

public class LinkedList {
    // Node Class
    public Node<Integer> head;
    public Node<Integer> tail;
    public int size = 0;

    // Constructor
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        Node<Integer> newNode = new Node<>(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public int deleteTail() {
        int deletedNode = this.tail.value;

        // If there is only one node
        if (this.tail == this.head) {
            this.head = null;
            this.tail = null;
            return deletedNode;
        }

        // 2 or more nodes
        if (this.tail != null) {
            Node<Integer> current = this.head;
            while (current.next != this.tail) {
                current = current.next;
            }
            current.next = null;
            this.tail = current;
        }
        this.size--;
        return deletedNode;
    }

    public int deleteHead() {
        if (this.head.next != null) {
            this.head = this.head.next;
        } else {
            this.head = null;
            this.tail = null;
        }
        return 0;
    }

    public void printToScreen() {
        Node<Integer> current = this.head;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.printToScreen();
        list.deleteHead();
        list.printToScreen();
        list.deleteTail();
        list.printToScreen();

    }
}
