import java.util.*;

/*
 * Given a linked list, where each Node has an additional field (radom - a random pointer to another node or null), perform a deep copy and return the new list.
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class DeepCopyListWithRandomPointers {
    private Map<Node, Node> nodes = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        Node copy = head;
        Node newNode = new Node(copy.val);
        
        nodes.put(copy, newNode);
        
        while(copy != null) {
            newNode.next = getClonedNode(copy.next);
            newNode.random = getClonedNode(copy.random);
            
            newNode = newNode.next;
            copy = copy.next;
        }
        
        return nodes.get(head);
    }
    
    private Node getClonedNode(Node node) {
        if (node != null) {
            if (nodes.containsKey(node)) {
                return nodes.get(node);
            } else {
                nodes.put(node, new Node(node.val));
                return nodes.get(node);
            }    
        }
        
        return null;
    }

    class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
        }
    }
}