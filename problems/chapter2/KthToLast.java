class Node {
    Node next = null;
    int value;

    public Node(int d) {
        this.value = d;
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void print() {
        Node n = this;
        while (n != null) {
            System.out.println(n.value);
            n = n.next;
        }
    }
}

class KthToLast {
    static int index = 0;

    public static void main(String[] args) {
        Node l = new Node(0);
        l.next = new Node(1);
        l.next.next = new Node(2);
        l.next.next.next = new Node(1);
        l.next.next.next.next = new Node(1);
        l.next.next.next.next.next = new Node(5);
        l.print();
        System.out.println(findKthRunner(l, Integer.parseInt(args[0])));

    }

    // This is too simple
    public static int findKth(Node head, int k) {
        Node current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        current = head;
        for (int i = 0; i < size - k; ++i) {
            current = current.next;
        }
        return current.value;
    }

    // Let's assume we can't compute the length
    // Use recursion
    public static int findKthRecursive(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int index = findKthRecursive(head.next, k) + 1;
        if (k == index) {
            System.out.println(head.value);
        }

        return index;
    }

    // Runner Technique
    public static int findKthRunner(Node head, int k) {
        Node fast = head;
        Node current = head;
        for (int i = 0; i < k - 1; ++i)
            fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            current = current.next;
        }
        return current.value;
    }
}