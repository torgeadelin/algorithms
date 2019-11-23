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

    public static void main(String[] args) {
        Node l = new Node(0);
        l.next = new Node(1);
        l.next.next = new Node(2);
        l.next.next.next = new Node(1);
        l.next.next.next.next = new Node(1);
        l.next.next.next.next.next = new Node(5);
        l.print();
        System.out.println(findKth(l, Integer.parseInt(args[0])));

    }

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
}