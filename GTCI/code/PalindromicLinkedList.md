# Palindrome LinkedList (medium)

## problem statement

Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.

Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. The algorithm should have O(N)O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.

Example 1:

```java
Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
Output: true
```

Example 2:

```java
Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
Output: false
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

class PalindromicLinkedList {

  public static boolean isPalindrome(ListNode head) {
    ListNode middle = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      middle = middle.next;
      fast = fast.next.next;
    }
    // reverse from middle
    ListNode head2 = reverse(middle);

    boolean isPalind = true;
    ListNode ptr1 = head;
    ListNode ptr2 = head2;
    while (ptr1 != null && ptr2 != null) {
      if (ptr1.value != ptr2.value) {
        isPalind = false;
      }
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }

    reverse(head2);
    return isPalind && ptr1 == null && ptr2 == null;
  }

  public static ListNode reverse(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    ListNode tmp = null;

    while (fast != null) {
      slow.next = tmp;
      tmp = slow;
      slow = fast;
      fast = fast.next;
    }

    slow.next = tmp;
    return slow;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
  }
}
```
