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
            System.out.print(n.value + ", ");
            n = n.next;
        }
        System.out.println();
    }
}

class Partition {
    public static void main(String[] args) {
        Node l = new Node(0);
        l.next = new Node(1);
        l.next.next = new Node(2);
        l.next.next.next = new Node(7);
        l.next.next.next.next = new Node(4);
        l.next.next.next.next.next = new Node(5);
        l.print();

        Node n = partition(l, Integer.parseInt(args[0]));
        n.print();

    }

    public static Node partition(Node head, int n) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node node = head;

        while (node != null) {
            Node next = node.next;
            node.next = null;
            if (node.value < n) {
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}