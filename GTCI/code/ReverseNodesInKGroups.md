# Reverse Nodes in k-Group (hard)

## problem statement

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.

## my solution (perfect, 34 minutes)

```java
/**
 * Given a linked list, reverse the nodes of the linked list k nodes at a time if there is k nodes in each group
 *     1 -> 2 -> 3 -> 4 -> 5 -> null
 * null <- 1 <- 2   3 -> 4 -> 5 -> null
 *     2 -> 1 -> 3 -> 4 -> 5 -> null
 *     2 -> 1 -> 3 <- 4    5 -> null
 *     2 -> 1 -> 4 -> 3 -> 5 -> null
 *     returns
 * 1. we need to make sure theres at least k nodes in the rest of the linked list
 * 2. specific time and space complexity? O(N) and O(1)
 * 3. we need the previous group's head and tail to solve the problem
 * 4. reverse the next k nodes
 * 5. set the tail.next and prevTail.next
 * 6. remember the first group's head after reversal
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 *    null<-1<-2 3->4->5->null
 *    k = 2
 *    curr = Node(1)
 *    finalHead = Node(2)
 *    prevGroupTail = Node(1)
 *    ptr = Node(3)
 *    count = 2
 *    groupHead = Node(2)
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode finalHead = null;
        ListNode prevGroupTail = null; // tail of previous group after reversal

        while (curr != null) {
            int count = 0;
            ListNode ptr = curr;
            while (ptr != null && count < k) {
                ptr = ptr.next;
                count++;
            }

            // ptr points to the next group's head (not reversed)
            if (count == k) {
                ListNode groupHead = reverseKNodes(curr, k);
                // curr became the group tail
                if (prevGroupTail != null)
                    prevGroupTail.next = groupHead;
                if (finalHead == null)
                    finalHead = groupHead;
            } else {
                if (prevGroupTail != null)
                    prevGroupTail.next = curr;
            }

            prevGroupTail = curr;
            curr = ptr;
        }
        return (finalHead == null) ? head : finalHead;
    }
    // null<-1<-2 3->4->5->null
    // head = Node(1)
    // count = 2
    // prev = Node(1)
    // curr = Node(2)
    // next = Node(3)
    // return Node(2)
    // Assume at least k nodes exists
    private ListNode reverseKNodes(ListNode head, int k) {
        if (k <= 1)
            return head;
        ListNode curr = head;
        ListNode prev = null;
        int count = 0;
        while (curr != null && count < k) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }
}
```
