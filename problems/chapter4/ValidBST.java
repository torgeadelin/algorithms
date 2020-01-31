// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}

class ValidBST {

    // We start with a range of (min = NULL, max = NULL), which the root obviously
    // meets.(NULL
    // indicates that there is no min or max) We then branch left, checking that
    // these nodes are within
    // the range(min = NULL, max = 20). Then, we branch right, checking that the
    // nodes are within the
    // range (min = 20, max = NULL).

    // We proceed through the tree with this approach. When we branch left, the max
    // gets updated. When // we branch right, the min gets updated. If anything
    // fails these checks, we stop and return false.

    public static boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if (min != null && root.val <= min)
            return false;

        if (max != null && root.val >= max)
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

}
