# Basic Calculator (hard)

## problem statement

Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:

```txt
Input: s = "1 + 1"
Output: 2
```

Example 2:

```txt
Input: s = " 2-1 + 2 "
Output: 3
```

Example 3:

```txt
Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
```

Example 4:

```txt
Input: s = "+48 + -48"
Output: 0
Explanation: Numbers can have multiple digits and start with +/-.
```

## my solution (perfect, took 40 minutes)

```java
// get rid of all spaces by spliting and rejoining O(N), O(N)
// "(2-+1)+1"
// ignoring brackets
// "2-+1+1"
// order of operations do matter (need to go left to right)
// "(2-+1)+1" => 2
// "2-1+(+1+1)" => 0
// how to handle different signes
// 2-+1 or 2+-1
// for handling brackets
// go to left to right; keeping values stored on a stack with the sign such that we continue operation
// [1,+,]
// how to parse the numbers?


class Solution {
    public int calculate(String s) {
        String[] noSpaces = s.split(" ");
        String str = String.join("", noSpaces);

        int i = 0;
        Stack<Integer> q = new Stack<>();
        int res = 0;
        int val = 0;
        int sign = 1;
        while (i < str.length()) {
            char ch = str.charAt(i);
            // System.out.format("%d,%d,%d,", res, sign, val);
            // System.out.println(q);
            if (ch == '(') {
                q.add(res);
                q.add(sign);
                res = 0;
                val = 0;
                sign = 1;
            } else if (ch == ')') {
                res += sign * val;
                // (sign * insideRes) + outsideRes
                res = q.pop() * res + q.pop();
                val = 0;
                sign = 1;
            } else if (ch == '+') {
                res += sign * val;
                val = 0;
                sign = 1;
            } else if (ch == '-') {
                res += sign * val;
                val = 0;
                sign = -1;
            } else {
                val = val*10 + Character.digit(ch, 10);
            }
            i++;
        }
        res += sign * val;
        return res;
    }
}
```
