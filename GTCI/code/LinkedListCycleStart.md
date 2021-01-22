# Start of LinkedList Cycle (medium)

## problem statement

Given the head of a Singly LinkedList that contains a cycle, write a function to find the starting node of the cycle.

## my solution (incorrect)

```java
class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class LinkedListCycleStart {

  public static ListNode findCycleStart(ListNode head) {
    // 1. find if cycle exist
    // 2. find the length of the cycle
    // 3.1. set ptr1 and ptr2 to head
    // 3.2. move ptr2 by cycle length
    // 3.3. until ptr1 == ptr2, move ptrs

    int cycleLength = 0;
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        cycleLength = findCycleLength(slow);
        break;
      }
    }
    return findCycleStartWithLength(head, cycleLength);
  }

  public static int findCycleLength(ListNode head) {
    ListNode slow = head.next;
    int length = 1; // include head count
    while (slow != head) {
      length++;
      slow = slow.next;
    }
    return length;
  }

  public static ListNode findCycleStartWithLength(ListNode head, int length) {
    ListNode ptr1 = head;
    ListNode ptr2 = head;

    for (int i = 0; i < length; i++)
      ptr1 = ptr1.next;

    while (ptr1 != ptr2) {
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    return ptr1;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    head.next.next.next.next.next.next = head.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head.next.next.next;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

    head.next.next.next.next.next.next = head;
    System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
  }
}
```
