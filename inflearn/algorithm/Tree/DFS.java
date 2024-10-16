package inflearn.algorithm.Tree;

public class DFS {
    private static class TreeNode {
        String value;
        TreeNode left, right;

        TreeNode(String x) {
            value = x;
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        TreeNode root;
        root = new TreeNode("A");
        root.left = new TreeNode("B");
        root.right = new TreeNode("C");
        root.left.left = new TreeNode("D");
        root.left.right = new TreeNode("E");
        root.right.right = new TreeNode("F");
        root.left.left.left = new TreeNode("G");
        root.left.left.right = new TreeNode("H");

        System.out.println("Preorder Traversal");
        dfs.dfsPreorder(root);
        System.out.println("Inorder Traversal");
        dfs.dfsInorder(root);
        System.out.println("Postorder Traversal");
        dfs.dfsPostorder(root);
    }

    /**
     * 전위순회 (Preorder Traversal)
     * @param currentNode
     */
    public void dfsPreorder(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.println(currentNode.value);
        dfsPreorder(currentNode.left);
        dfsPreorder(currentNode.right);
    }

    /**
     * 중위순회 (Inorder Traversal)
     * @param currentNode
     */
    public void dfsInorder(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        dfsInorder(currentNode.left);
        System.out.println(currentNode.value);
        dfsInorder(currentNode.right);
    }

    /**
     * 후위순회 (Postorder Traversal)
     * @param currentNode
     */
    public void dfsPostorder(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }

        dfsPostorder(currentNode.left);
        dfsPostorder(currentNode.right);
        System.out.println(currentNode.value);
    }

}
