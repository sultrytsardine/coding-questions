import java.util.*;

/*
 * Given 2 linked lists where each node is an integer (0 - 9) that represents a larger integer (list in reversed order), add the 2 numbers togther.
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode newHead = dummyHead;
        
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int result = l1Val + l2Val + carry;
            
            carry = result / 10;
            
            newHead.next = new ListNode(result % 10);
            newHead = newHead.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        if (carry > 0) newHead.next = new ListNode(carry);
        
        return dummyHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}   