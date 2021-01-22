# LinkedList Cycle (easy)

Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.

## my solution (optimal, some extraneous operations)

```java
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycle {

  public static boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    if (fast != null)
      fast = fast.next;
    while (slow != null && fast != null) {
      if (slow == fast)
        return true;

      slow = slow.next;
      fast = fast.next;
      if (fast != null)
        fast = fast.next;
    }


    return false;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
  }
}
```
