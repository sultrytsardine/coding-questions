import java.util.*;

/* 
 * Reorder the provided list so that it goes from 1->2->3->4->5->6 to 1->6->2->5->3->4
 * The basic algorithm goes: 
 * 1. Find the middle of the list (or the node after the middle)
 * 2. Reverse the second half of the list
 * 3. Merge the 2 parts of the list
 * Time complexity = O(N), space complexity = O(1)
 * https://leetcode.com/problems/reorder-list
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        ListNode fast = head, slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode current = slow, prev = null, temp;
        
        while(current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        
        ListNode first = head, second = prev;
        while(second.next != null) {
            temp = first.next;
            first.next = second;
            first = temp;
            
            temp = second.next;
            second.next = first;
            second = temp;
        }
    }

    class ListNode {
        int val;
        ListNode next;
    }
}