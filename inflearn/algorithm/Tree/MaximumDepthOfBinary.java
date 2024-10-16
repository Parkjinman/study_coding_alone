package inflearn.algorithm.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinary {
    private static class TreeNode {
        int value;
        TreeNode left, right;

        TreeNode(int x) {
            value = x;
        }
    }

    private static class TreeNodeDepthObject {
        TreeNode node;
        int depth;

        TreeNodeDepthObject(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static void main(String[] args) {
        MaximumDepthOfBinary maximumDepthOfBinary = new MaximumDepthOfBinary();
        TreeNode root;
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maximumDepthOfBinary.maxDepthDFS(root));
        System.out.println(maximumDepthOfBinary.maxDepthBFS(root));
    }

    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepthDFS(root.left);
        int rightDepth = maxDepthDFS(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepthBFS(TreeNode root) {
        int maxDepth = 0;

        if (root == null) {
            return 0;
        }

        Queue<TreeNodeDepthObject> queue = new LinkedList<>();
        queue.add(new TreeNodeDepthObject(root, 1));

        while (!queue.isEmpty()) {
            TreeNodeDepthObject current = queue.poll();
            TreeNode currentNode = current.node;
            int currentDepth = current.depth;

            maxDepth = Math.max(maxDepth, currentDepth);

            if (currentNode.left != null) {
                queue.add(new TreeNodeDepthObject(currentNode.left, currentDepth + 1));
            }
            if (currentNode.right != null) {
                queue.add(new TreeNodeDepthObject(currentNode.right, currentDepth + 1));
            }
        }

        return maxDepth;
    }
}
