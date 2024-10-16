package inflearn.algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static class TreeNode {
        String value;
        TreeNode left, right;

        TreeNode(String x) {
            value = x;
        }
    }

    private Queue<TreeNode> queue = new LinkedList<>();
    private ArrayList<TreeNode> visited = new ArrayList<>();

    public static void main(String[] args) {
        BFS bfs = new BFS();
        TreeNode root;
        root = new TreeNode("1");
        root.left = new TreeNode("2");
        root.right = new TreeNode("3");
        root.left.left = new TreeNode("4");
        root.left.right = new TreeNode("5");
        root.right.right = new TreeNode("6");
        bfs.bfs(root);
    }

    public void bfs(TreeNode root) {

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            visited.add(currentNode);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        for (TreeNode node : visited) {
            System.out.println(node.value);
        }
    }

}
// [1, 2, 3, 4, 5, 6]

//from collections import deque
//
//def bfs(root):
//        visited = []
//        if root is None:
//        return 0;
//    q = deque()
//    q.append(root)
//    while q:
//        cur_node = q.popleft()
//        visited.append(cur_node.value)
//
//        if cur_node.left:
//        q.append(cur_node.left)
//        if cur_node.right:
//        q.append(cur_node.right)
//    return visited