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

class Palindrome {
    public static void main(String[] args) {
        Node a = new Node(1);
        a.appendToTail(2);
        a.appendToTail(1);

        System.out.println(palindrome(a));

    }

    public static Node reverse(Node a) {
        Node head = null;
        while (a != null) {
            Node n = new Node(a.value);
            n.next = head;
            head = n;
            a = a.next;
        }
        return head;
    }

    public static boolean palindrome(Node a) {
        Node b = reverse(a);
        while (a != null && b != null) {
            if (a.value != b.value)
                return false;
            a = a.next;
            b = b.next;
        }

        return true;
    }
}