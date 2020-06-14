import java.util.*;

/*
 * Merge 2 sorted lists into a new sorted list.
 * https://leetcode.com/problems/merge-two-sorted-lists
 */
public class MergeLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode current = temp;
        
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        if (l1 != null) {
            current.next = l1;
            l1 = l1.next;
        } else if (l2 != null) {
            current.next = l2;
            l2 = l2.next;
        }
        
        return temp.next;
    }

    class ListNode {
        ListNode next;
        int val;

        ListNode(int val) { 
            this.val = val;
        }
    }
}