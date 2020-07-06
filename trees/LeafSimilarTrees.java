import java.util.*;

/*
 * Given the root nodes for 2 binary trees, find out whether they are leaf similar (i.e. the leaf nodes of both trees form the same sequence of numbers from left to right);
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> tree1Seq = new ArrayList<>();
        List<Integer> tree2Seq = new ArrayList<>();
        
        traverse(root1, tree1Seq);
        traverse(root2, tree2Seq);
        
        return tree1Seq.equals(tree2Seq);
    }
    
    public void traverse(TreeNode node, List<Integer> seq) {
        if (node == null) return;
        
        if (node.left == null && node.right == null) {
            seq.add(node.val);
            return;
        }
        
        traverse(node.left, seq);
        traverse(node.right, seq);
    }

    class TreeNode {
        TreeNode left, right;
        int val;
    }
}