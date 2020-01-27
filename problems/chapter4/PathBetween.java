import java.util.*;

class Graph {
    public ArrayList<Node> nodes;
    public Graph() {
        nodes = new ArrayList<>();
    }
    public void add(Node a) {
        this.nodes.add(a);
    }
}

class Node {
    public int value;
    public ArrayList<Node> adj;
    public boolean visited = false;

    public Node(int value){
        this.adj = new ArrayList<>();
        this.value = value;
    }

    public void addAdjacent(Node n) {
        this.adj.add(n);
    }
}
    

class PathBetween extends Object {
    public static boolean findPath(Node a, Node b) {
        LinkedList<Node> q = new LinkedList<>();
        a.visited = true;
        q.add(a);
        while(!q.isEmpty()) {
            Node n = q.removeFirst();
            if(n == b) return true;
            for(Node node: n.adj) {
                if(!node.visited) {
                    node.visited = true;
                    q.add(node);
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Node a1 = new Node(1);
        
        Node a2 = new Node(2);
        
        Node a3 = new Node(3);
        
        Node a4 = new Node(4);

        Node a5 = new Node(5);

        a1.addAdjacent(a2);
        a1.addAdjacent(a3);

        a2.addAdjacent(a4);

        a3.addAdjacent(a4);
        System.out.println(findPath(a1, a5));
    }
}