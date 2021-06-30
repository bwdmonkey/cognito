# Find the First K Missing Positive Numbers (hard)

## problem statement

Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.

Example 1:

```java
Input: [3, -1, 4, 5, 5], k=3
Output: [1, 2, 6]
Explanation: The smallest missing positive numbers are 1, 2 and 6.
```

Example 2:

```java
Input: [2, 3, 4], k=3
Output: [1, 5, 6]
Explanation: The smallest missing positive numbers are 1, 5 and 6.
```
Example 3:

```java
Input: [-2, -3, 4], k=2
Output: [1, 2]
Explanation: The smallest missing positive numbers are 1 and 2.
```

## my solution

```java
/**
 * This solution wouldn't work in Java as the input array cannot be appended to.
 */
import java.util.*;

class FirstKMissingPositive {

  public static List<Integer> findNumbers(int[] nums, int k) {
    List<Integer> missingNumbers = new ArrayList<>();
    int N = nums.length;
    boolean containsN = false;
    for (int i = 0; i < N; i++) {
      if (nums[i] == N)
        containsN = true;
      if (nums[i] <= 0 || nums[i] >= N)
        nums[i] = 0;
    }

    for (int i = 0; i < N; i++)
      nums[nums[i] % N] += N;
    for (int i = 1; i < N; i++) {
      if (nums[i] / N == 0) {
        missingNumbers.add(i);
        if (missingNumbers.size() == k)
          return missingNumbers;
      }
    }

    while (missingNumbers.size() < k) {
      missingNumbers.add((containsN) ? N + 1 : N);
      N++;
    }

    return missingNumbers;
  }
}
```

```python
def find_first_k_missing_positive(nums, k):
  missingNumbers = []
  for i in range(k):
    nums.append(0)
  n = len(nums)
  for i in range(len(nums)): #delete those useless elements
    if nums[i]<0 or nums[i]>=n:
      nums[i]=0
  for i in range(len(nums)): #use the index as the hash to record the frequency of each number
    nums[nums[i]%n]+=n
  for i in range(1,len(nums)):
    if nums[i]//n == 0:
      missingNumbers.append(i)
      if (len(missingNumbers) == k):
        return missingNumbers
  while (len(missingNumbers) < k):
    missingNumbers.append(n)
    n += 1;
  return missingNumbers
```

## solution

```java
import java.util.*;

class FirstKMissingPositive {

  public static List<Integer> findNumbers(int[] nums, int k) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
        swap(nums, i, nums[i] - 1);
      else
        i++;
    }

    List<Integer> missingNumbers = new ArrayList<>();
    Set<Integer> extraNumbers = new HashSet<>();
    for (i = 0; i < nums.length && missingNumbers.size() < k; i++)
      if (nums[i] != i + 1) {
        missingNumbers.add(i + 1);
        extraNumbers.add(nums[i]);
      }

    // add the remaining missing numbers
    for (i = 1; missingNumbers.size() < k; i++) {
      int candidateNumber = i + nums.length;
      // ignore if the array contains the candidate number
      if (!extraNumbers.contains(candidateNumber))
        missingNumbers.add(candidateNumber);
    }

    return missingNumbers;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
    System.out.println("Missing numbers: " + missingNumbers);

    missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
    System.out.println("Missing numbers: " + missingNumbers);

    missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
    System.out.println("Missing numbers: " + missingNumbers);
  }
}



```
