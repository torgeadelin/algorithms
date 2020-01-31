// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent = null;

    public TreeNode(int x) {
        val = x;
    }
}

class Successor {
    public static TreeNode getSuccessor(TreeNode node, TreeNode root) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            TreeNode temp = node.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            return temp;
        } else {
            TreeNode succ = null;
            TreeNode parent = root;
            while (parent != node) {
                if (node.val < parent.val) {
                    succ = parent;
                    parent = parent.left;
                } else {
                    parent = parent.right;
                }
            }
            return succ;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.parent = root;
        root.right.parent = root;
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.parent = root.left;
        root.left.right.parent = root.left;
        System.out.println(getSuccessor(root.left, root).val);
    }
}
