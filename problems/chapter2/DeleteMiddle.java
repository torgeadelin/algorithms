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

class DeleteMiddle {
    public static void main(String[] args) {
        Node l = new Node(0);
        l.next = new Node(1);
        l.next.next = new Node(2);
        l.next.next.next = new Node(1);
        l.next.next.next.next = new Node(1);
        l.next.next.next.next.next = new Node(5);
        l.print();
        System.out.println();
        delete(l.next.next);
        l.print();
    }

    public static boolean delete(Node n) {
        if (n == null || n.next == null) {
            return false; // Failure
        }

        n.value = n.next.value;
        n.next = n.next.next;

        return true;

    }
}