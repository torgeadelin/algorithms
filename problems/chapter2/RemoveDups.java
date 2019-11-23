
import linkedList.LinkedList;
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

class RemoveDups {
    public static void main(String[] args) {
        Node l = new Node(0);
        l.next = new Node(1);
        l.next.next = new Node(2);
        l.next.next.next = new Node(1);
        l.next.next.next.next = new Node(1);
        l.next.next.next.next.next = new Node(5);
        l.print();
        removeDupsFollow(l);
        l.print();

    }

    // Using additional buffer
    public static void removeDups(Node head) {
        Node prev = head;
        Node current = head.next;

        HashSet<Integer> set = new HashSet<>();
        set.add(prev.value);

        while (current.next != null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
            } else {
                set.add(current.value);
                prev = current;
            }
            current = current.next;
        }
    }

    // FOLLOW UP
    // Not using additional buffer

    public static void removeDupsFollow(Node head) {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (current.value == runner.next.value) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}