import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class ListOfDepths {
    public static void convertToList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if (root == null)
            return;

        LinkedList<TreeNode> list = null;
        if (lists.size() == level) {
            list = new LinkedList<TreeNode>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        convertToList(root.left, lists, level + 1);
        convertToList(root.right, lists, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);

        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        convertToList(root, lists, 0);
        for (LinkedList<TreeNode> l : lists) {
            System.out.println(Arrays.toString(l.toArray()));
        }

    }
}