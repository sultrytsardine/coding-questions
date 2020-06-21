import java.util.*;

/*
 * Given 2 sorted linked lists, merge them into a new linked list, such that the ascending order is preserved.
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                current.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            
            current = current.next;
        }
        
        if(l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }
        
        return temp.next;
    }

    class ListNode {
        ListNode next;
        int val;

        ListNode (int val) {
            this.val = val;
        }
    }
}