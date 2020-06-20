import java.util.*;

/*
 * Given the root of a binary search tree, return the sum of all of the nodes who's value falls within a window.
 * https://leetcode.com/problems/range-sum-of-bst
 */
public class RangeFromBST {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        traverse(root, L, R);
        return sum;
    }
    
    private void traverse(TreeNode root, int L, int R) {
        if (root == null) return;
        
        int val = root.val;
        if (val >= L && val <= R) {
            sum += val;
        }
        if (L < val) {
            traverse(root.left, L, R);    
        }
        if (val < R) {
            traverse(root.right, L, R);    
        }
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}