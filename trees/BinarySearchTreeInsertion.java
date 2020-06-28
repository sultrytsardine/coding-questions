import java.util.*;

/*
 * Insert the data provided into the binary search tree, maintaining the ordering properties of a BST.
 * https://www.hackerrank.com/challenges/binary-search-tree-insertion
 */
public class BinarySearchTreeInsertion {
    public static Node insert(Node root,int data) {
        if (root == null) return new Node(data);

        Node temp = root;
        insertNode(temp, data);

        return root;
    }

    private static void insertNode(Node node, int data) {
        if (data < node.data) {
            if (node.left == null) {
                node.left = new Node(data);   
            } else {
                insertNode(node.left, data);
            }
        } else {
            if (node.right == null) {
                node.right = new Node(data);
            } else {
                insertNode(node.right, data);
            }
        }
    }

    public class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
        }
    }
}