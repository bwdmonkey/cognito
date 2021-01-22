# Rearrange a LinkedList (medium)

## problem statement

Given the head of a Singly LinkedList, write a method to modify the LinkedList such that the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order. So if the LinkedList has nodes `1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null`, your method should return `1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null`.

Your algorithm should not use any extra space and the input LinkedList should be modified in-place.

Example 1:

```java
Input: 2 -> 4 -> 6 -> 8 -> 10 -> 12 -> null
Output: 2 -> 12 -> 4 -> 10 -> 6 -> 8 -> null
```

## my solution (perfect)

```java
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class RearrangeList {

  public static void reorder(ListNode head) {
    // 1. find the middle of the list
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    // 2. reverse from the middle of the list
    ListNode secondHalf = reverse(slow);
    ListNode firstHalf = head;

    // 3. merge two heads to form a new head
    while (firstHalf != null && secondHalf != null) {
      ListNode tmp = firstHalf.next;
      ListNode tmp2 = secondHalf.next;
      firstHalf.next = secondHalf;
      secondHalf.next = tmp;
      firstHalf = tmp;
      secondHalf = tmp2;
    }
  }

  public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next = new ListNode(12);
    RearrangeList.reorder(head);
    while (head != null) {
      System.out.print(head.value + " ");
      head = head.next;
    }
  }
}
```
