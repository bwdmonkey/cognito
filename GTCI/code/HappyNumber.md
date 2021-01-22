# Happy Number (medium)

## problem statement

Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

Example 1:

```java
Input: 23
Output: true (23 is a happy number)
Explanations: Here are the steps to find out that 23 is a happy number:
```

1. 2^2 + 3^2 = 4 + 9 = 13
2. 1^2 + 3^2 = 1 + 9 = 10
3. 1^2 + 0^2 = 1 + 0 = 1

## my solution (perfect)

```java
class HappyNumber {

  public static boolean find(int num) {
    int slow = num;
    int fast = calculate(num);
    while (fast != 1 && slow != fast) {
      slow = calculate(slow);
      fast = calculate(calculate(fast));
    }
    return fast == 1;
  }

  public static int calculate(int num) {
    int sum = 0;
    while (num > 0) {
      int digit = num % 10;
      sum += digit * digit;
      num = num / 10;
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(HappyNumber.find(23));
    System.out.println(HappyNumber.find(12));
  }
}
```
