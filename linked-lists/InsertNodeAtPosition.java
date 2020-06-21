import java.util.*;

/*
 * Given a pointer to the head of a linked list, some new data and an index, insert a new node with the data at the specified index.
 * https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
 */
public class InsertNodeAtPosition {
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if (head == null) return null;
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        SinglyLinkedListNode current = head;

        int i = 0;

        while(i < position - 1) {
            current = current.next;
            i++;
        }
        
        node.next = current.next;
        current.next = node;

        return head;
    }

    public class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}