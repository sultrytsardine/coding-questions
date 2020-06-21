import java.util.*;

/*
 * Given the root node of a non-empty binary search tree, find the node with the value that is closest to the target.
 * https://leetcode.com/problems/closest-binary-search-tree-value
 */
public class ClosestBSTValue {
    private double closestVal;
    private TreeNode closestNode;
    
    public int closestValue(TreeNode root, double target) {
        closestVal = Double.MAX_VALUE;
        closestNode = root;
        
        traverse(root, target); 
        
        return closestNode.val;
    }
    
    private void traverse(TreeNode node, double target) {
        if (node == null) return;
        
        checkDiff(node, target);
        
        if (target < node.val) {
            traverse(node.left, target);    
        } else {
            traverse(node.right, target);    
        }
    }
    
    private void checkDiff(TreeNode node, double target) {
        double currentDiff = Math.abs(node.val - target);
        
        if (currentDiff < closestVal) {
            closestVal = currentDiff;
            closestNode = node;
        }
        
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}