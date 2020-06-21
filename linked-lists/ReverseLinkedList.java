import java.util.*;

/*
 * Given a pointer to the start of a linked list, reverse the list and return a pointer to the new head;
 * https://leetcode.com/problems/reverse-linked-list
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        
        while(current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        
        return previous;
    }

    class ListNode {
        int val;
        ListNode next;
    }
}