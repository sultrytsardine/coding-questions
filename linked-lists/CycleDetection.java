import java.util.*;

/*
 * Detect whether a linked list contains a cycle.
 * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
 */
public class CycleDetection {
    static boolean hasCycle(SinglyLinkedListNode head) {
        if (head == null) return false;
        SinglyLinkedListNode slow = head, fast = head.next;

        while(fast.next != null && fast.next.next != null) {
            if (slow.equals(fast)) return true;

            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }

    class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;
    }
}