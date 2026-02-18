class Solution {

    private Map<Integer, TreeNode> rootMap = new HashMap<>();
    private Set<Integer> leafSet = new HashSet<>();

    public TreeNode canMerge(List<TreeNode> trees) {

        prepare(trees);

        TreeNode root = findRoot(trees);
        if (root == null) return null;

        rootMap.remove(root.val);

        mergeTrees(root);

      
        if (!rootMap.isEmpty())
            return null;

        
        if (!isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE))
            return null;

        return root;
    }

    private void prepare(List<TreeNode> trees) {
        for (TreeNode tree : trees) {
            rootMap.put(tree.val, tree);

            if (tree.left != null)
                leafSet.add(tree.left.val);

            if (tree.right != null)
                leafSet.add(tree.right.val);
        }
    }

    private TreeNode findRoot(List<TreeNode> trees) {
        for (TreeNode tree : trees) {
            if (!leafSet.contains(tree.val))
                return tree;
        }
        return null;
    }
    private void mergeTrees(TreeNode node) {
        if (node == null) return;

        if (node.left != null && rootMap.containsKey(node.left.val)) {
            node.left = rootMap.remove(node.left.val);
        }

        if (node.right != null && rootMap.containsKey(node.right.val)) {
            node.right = rootMap.remove(node.right.val);
        }

        mergeTrees(node.left);
        mergeTrees(node.right);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max)
            return false;

        return isValidBST(node.left, min, node.val)
            && isValidBST(node.right, node.val, max);
    }
}

