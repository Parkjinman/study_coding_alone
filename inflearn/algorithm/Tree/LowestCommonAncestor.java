package inflearn.algorithm.Tree;

public class LowestCommonAncestor {
    private static class TreeNode {
        String value;
        TreeNode left, right;

        TreeNode(String x) {
            value = x;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        TreeNode root;
        root = new TreeNode("A");
        root.left = new TreeNode("B");
        root.right = new TreeNode("C");
        root.left.left = new TreeNode("D");
        root.left.right = new TreeNode("E");
        root.right.right = new TreeNode("F");
        root.left.left.left = new TreeNode("G");
        root.left.left.right = new TreeNode("H");

        System.out.println(lca.lowestCommonAncestor(root, root.left.left.left, root.left.left.right).value);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (root == p || root == q) {
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
