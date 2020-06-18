import java.util.*;

/*
 * Given the root of a binary tree, find the longest path between 2 leaf nodes. The path may or may not pass through the root.
 * https://leetcode.com/problems/diameter-of-binary-tree
 */
public class DiameterOfBinaryTree {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max;
    }
    
    public int traverse(TreeNode node) {
        if (node == null) return 0;
        
        int left = traverse(node.left);
        int right = traverse(node.right);
        
        max = Math.max(max, left + right);
        
        return 1 + Math.max(left, right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}