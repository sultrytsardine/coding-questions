import java.util.*;

/*
 * Create an iterator that exposes the next smallest node of a binary search tree.
 * It requests that the next() and hasNext() methods execute in O(1) time, which is true of this soltion. It also requires the space complexity to be O(h) where h is the
 * height of the binary tree. 
 * Solution 1 - uses a queue and adds all of the nodes to the queue at the start. This uses O(N) space and therefore doesn't fit the brief.
 * Soltion 2 - uses a stack and "controlled recursion", adding only the left nodes to the stack, making the space complexity O(h).
 * https://leetcode.com/problems/binary-search-tree-iterator
 */

 /*
  * Solution 1
  */
public class BinarySearchTreeIterator {
    private LinkedList<TreeNode> queue;
    
    public BinarySearchTreeIterator(TreeNode root) {
        queue = new LinkedList<>();
        fillQueue(root);
    }
    
    private void fillQueue(TreeNode node) {
        if (node == null) return;
        
        fillQueue(node.left);
        
        queue.add(node);
        
        fillQueue(node.right);
    }
    
    /** @return the next smallest number */
    public int next() {
            return queue.poll().val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}

/*
 * Solution 2
 */
class BSTIterator {
    private Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAll(root);
    }
    
    private void pushAll(TreeNode node) {
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }
}
