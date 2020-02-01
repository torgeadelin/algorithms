
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.*;

// Definition for a binary tree node.
class Node {
    int val;
    ArrayList<Node> adj = new ArrayList<>();

    public Node(int x) {
        val = x;
    }
}

public class BuildOrder {

    public static List<Integer> getOrder(ArrayList<Node> nodes, Node a) {
        ArrayList<Node> list = new ArrayList<>();
        ArrayList<Node> temp = new ArrayList<>();
        int[] indexes = new int[10]; // #no of in-edges

        for (Node n : nodes) {
            indexes[n.val] = 0;
        }

        for (Node u : nodes) {
            for (Node v : u.adj) {
                indexes[v.val] += 1;
            }
        }

        // init temp
        for (Node n : nodes) {
            if (indexes[n.val] == 0)
                temp.add(n);
        }

        while (!temp.isEmpty()) {
            Node v = temp.remove(0);
            list.add(v);
            for (Node u : v.adj) {
                indexes[u.val] -= 1;
                if (indexes[u.val] == 0)
                    temp.add(u);
            }
        }

        return list.stream().map(m -> m.val).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Node a = new Node(0);
        Node b = new Node(1);
        Node c = new Node(2);
        Node d = new Node(3);
        Node e = new Node(4);
        Node f = new Node(5);

        a.adj.add(d);
        f.adj.add(b);
        f.adj.add(a);
        b.adj.add(d);
        d.adj.add(c);

        ArrayList<Node> nodes = new ArrayList<>(Arrays.asList(a, b, c, d, e, f));

        System.out.println(Arrays.toString(getOrder(nodes, a).toArray()));
    }
}