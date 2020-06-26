import java.util.*;

/*
 * Implement a function to perform a level order traversal on a binary tree and print out the value of each node.
 * https://www.hackerrank.com/challenges/tree-level-order-traversal/problem
 */
public class LevelOrderTraversal {
    public static void levelOrder(Node root) {
        if (root == null) return;
  
        Queue<Node> queue = new LinkedList<>();
  
        queue.offer(root);
  
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.data + " ");
  
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
      }

      class Node {
          Node left, right;
          int data;
      }
}