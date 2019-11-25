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

class SumList {
    public static void main(String[] args) {
        Node a = new Node(7);
        a.appendToTail(1);
        a.appendToTail(6);
        a.print();

        Node b = new Node(5);
        b.appendToTail(9);
        b.appendToTail(2);
        b.print();
        System.out.println(sum1(a, b));
        System.out.println(sum2(a, b));
    }

    public static int compute(Node a) {
        if (a == null) {
            return 0;
        }
        return compute(a.next) * 10 + a.value;
    }

    // List is in reversed order
    public static int sum1(Node a, Node b) {
        return compute(a) + compute(b);
    }

    // List is in normal order
    public static int sum2(Node a, Node b) {
        int x = 0;
        int y = 0;

        while (a != null) {
            x = x * 10 + a.value;
            a = a.next;
        }

        while (b != null) {
            y = y * 10 + b.value;
            b = b.next;
        }

        return x + y;
    }
}