import java.util.*;

/*
 * Given the root of a binary tree, return the right-sided view of the tree (i.e. the rightmost node at each level).
 * This uses a reverse level order traversal and adds the rightmost node at each level to the results.
 * https://leetcode.com/problems/binary-tree-right-side-view
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) return result;
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == 0) result.add(current.val);
                if (current.right != null) queue.offer(current.right);
                if (current.left != null) queue.offer(current.left);
            }
        }
        
        return result;
    }

    class TreeNode {
        TreeNode left, right;
        int val;
    }
}