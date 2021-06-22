# Integer to English Words (hard)

## problem statement

Convert a non-negative integer num to its English words representation.

Example 1:

```txt
Input: num = 123
Output: "One Hundred Twenty Three"
```

Example 2:

```txt
Input: num = 12345
Output: "Twelve Thousand Three Hundred Forty Five"
```

Example 3:

```txt
Input: num = 1234567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
```

Example 4:

```txt
Input: num = 1234567891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
```

Constraints:

`0 <= num <= 2^31 - 1`

## my solution (optimal but messy, 37 minutes)

```java
/**
 * 0 => Zero
 * 1 => One
 * 2 => Two
 * 10 => Ten
 * 1234567 => One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
 * 1234567891 => One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One
 * 100
 * 1,000
 * 1,000,000
 * 1,000,000,000
 */

class Solution {
    private static final int HUNDRED = 100;
    private static final int THOUSAND = 1000;
    private static final int MILLION = 1000000;
    private static final int BILLION = 1000000000;
    private static final String[] underTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        return numberToWordsHelper(num, false);
    }

    public String numberToWordsHelper(int num, boolean addPadding) {
        if (num / BILLION > 0)
            return numberToWordsHelper(num / BILLION, addPadding) + " Billion" + numberToWordsHelper(num % BILLION, true);
        if (num / MILLION > 0)
            return numberToWordsHelper(num / MILLION, addPadding) + " Million" + numberToWordsHelper(num % MILLION, true);
        if (num / THOUSAND > 0)
            return numberToWordsHelper(num / THOUSAND, addPadding) + " Thousand" + numberToWordsHelper(num % THOUSAND, true);
        if (num / HUNDRED > 0)
            return ((addPadding) ? " " : "") + underTwenty[num / HUNDRED] + " Hundred" + numberToWordsHelper(num % HUNDRED, true);
        if (num >= 20)
            return ((addPadding) ? " " : "") + tens[num / 10] + numberToWordsHelper(num % 10, true);
        return (addPadding && num != 0) ? " " + underTwenty[num] : underTwenty[num];
    }
}
```
