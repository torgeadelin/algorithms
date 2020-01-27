import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class CheckBalanced {
    // This method runs in O(n logn) which is not that efficient.
    // We can do better, by checking if the tree is balanced while calculating the
    // height.
    // That would run in O(n) time and space.

    public static boolean isBalanced(TreeNode node) {
        if (node == null)
            return true;
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left - right) > 1)
            return false;
        else {
            return isBalanced(node.left) && isBalanced(node.right);
        }
    }

    public static int height(TreeNode node) {
        if (node == null)
            return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        System.out.println(isBalanced(root));
    }

}