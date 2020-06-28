import java.util.*;

/*
 * Given the root of a binary tree, retrurn its height;
 * https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
 */
public class HeightOfABinaryTree {
    public static int height(Node root) {
        if (root == null || root.left == null && root.right == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    class Node {
        Node left, right;
        int data;
    }
}