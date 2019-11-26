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

class Intersection {
    public static void main(String[] args) {
        Node a = new Node(0);
        a.appendToTail(1);
        a.appendToTail(2);
        System.out.println("Init" + a.value);

        Node b = new Node(10);
        b.appendToTail(9);
        b.next.next = a.next;

        System.out.println(intersect(a, b).value);
    }

    public static int getSize(Node a) {
        if (a == null)
            return 0;
        return getSize(a.next) + 1;
    }

    public static Node intersect(Node a, Node b) {
        int len1 = getSize(a);
        int len2 = getSize(b);
        System.out.println(len1);
        System.out.println(len2);

        Node x = a;
        Node y = b;

        while (x.next != null) {
            x = x.next;
        }
        while (y.next != null) {
            y = y.next;
        }
        if (x == y) {
            if (len1 > len2) {
                for (int i = 0; i < len1 - len2; ++i) {
                    a = a.next;
                }

            }
            if (len1 < len2) {
                for (int i = 0; i < len2 - len1; ++i) {
                    b = b.next;
                }
            }
            while (a != b) {
                a = a.next;
                b = b.next;
            }
            return a;

        } else
            return null;

    }
}