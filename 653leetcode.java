class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root, k);
    }

    boolean dfs(TreeNode root, TreeNode curr, int k) {
        if (curr == null) return false;

        if (search(root, curr, k - curr.val)) return true;

        return dfs(root, curr.left, k) || 
               dfs(root, curr.right, k);
    }

    boolean search(TreeNode root, TreeNode curr, int val) {
        if (root == null) return false;

        if (root.val == val && root != curr) return true;

        if (val < root.val)
            return search(root.left, curr, val);
        else
            return search(root.right, curr, val);
    }
}
