import java.util.HashSet;

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

class LoopDetection {
    public static void main(String[] args) {
        Node a = new Node(1);
        a.appendToTail(2);
        a.appendToTail(3);
        a.appendToTail(4);
        a.appendToTail(5);
        a.next.next.next.next = a.next;
        System.out.println(loop2(a).value);

    }

    // not sure it works for all cases
    public static Node loop(Node a) {
        HashSet<Node> set = new HashSet<>();
        while (a != null) {
            if (set.contains(a)) {
                return a;
            } else {
                set.add(a);
                a = a.next;
            }
        }
        return null;
    }

    // solution provided by the book
    // Turtle and Rabbit algorithm
    public static Node loop2(Node a) {
        Node slow = a;
        Node fast = a;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        slow = a;
        while (slow != null && fast != null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next;

        }
        return slow;
    }
}