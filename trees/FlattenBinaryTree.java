import java.util.*;

/* 
 * Flatten a binary tree to a linked list (using the right pointer to represent to next item in the list).
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list
 */
public class FlattenBinaryTree {
    public void flatten(TreeNode root) {
        traverseTree(root);
    }
    
    private TreeNode traverseTree(TreeNode node) {
        if (node == null) return null;
        
        if (node.left == null && node.right == null) return node;
        
        TreeNode leftTail = traverseTree(node.left);
        TreeNode rightTail = traverseTree(node.right);
        
        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        return rightTail != null ? rightTail : leftTail;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

}