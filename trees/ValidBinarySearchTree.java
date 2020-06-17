import java.util.*;

/*
 * Given the root node of a binary tree, determine whether or not it is a valid binary search tree.
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 2 soultions shown below:
 * 1. Recursive approach
 * 2. Depth first search using a stack
 */
public class ValidBinarySearchTree {
    /* 
     * Solution 1 - Recursive
     * Traverse the tree and maintain upper and lower values against which you can compare the node's value.
     */
    public boolean isValidBST(TreeNode root) {
        return traverseTree(root, null, null);
    }
    
    private boolean traverseTree(TreeNode node, Integer upper, Integer lower) {
        if (node == null) return true;
        
        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;
        
        if (!traverseTree(node.left, val, lower)) return false;
        if (!traverseTree(node.right, upper, val)) return false;
        
        
        return true;
    }

    /*
     * Soultion 2 - Stack
     * Walk the left side of the tree, adding all values to the stack. Once you reach the left most point, start popping values and start comparing their value to the minimum
     * current value on the left. If the parent is ever less than (or equal to) the minimum left node, then it's not a valid BST. At the end of each loop, move to the first right node and repeat.
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double minLeftVal = -Double.MAX_VALUE;
        
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            int val = root.val;
            
            if (val <= minLeftVal) return false;
            minLeftVal = val;
            root = root.right;
        }
        
        return true;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}