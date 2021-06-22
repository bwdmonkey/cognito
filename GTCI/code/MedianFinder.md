# Find Median from Data Stream (hard)

## problem statement

The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

Example 1:

```java
Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
```

## my solution (perfect)

```java
/**
 * median values
 * come up with method interface and see if they meet the requirement as per the need
 * a MedianFinder class with insert and findMedian methods
 * [1,2,3,4,5] => 3
 * [1,2,3,4] => 2.5
 * [1,2], [3,4]
 * option 1: self balancing binary tree O (log N)
 * option 2: keeping a sorted array O(N log N)
 * option 3: two priority queues (max heap, min heap) O(log N)
 *  - init two PQ, lowerHalf, upperHalf with right compare function
 *  - when inserting values, check if lowerHalf is longer than upperHalf, then pop from lower and insert to upper
 *  - insert value to lower
 */

class MedianFinder {
    PriorityQueue<Integer> lowerHalf;
    PriorityQueue<Integer> upperHalf;
    /** initialize your data structure here. */
    public MedianFinder() {
        lowerHalf = new PriorityQueue<>(1, (a, b) -> -Integer.compare(a,b)); // max heap
        upperHalf = new PriorityQueue<>(1, (a, b) -> Integer.compare(a,b)); // min heap
    }

    public void addNum(int num) {
        // lowerHalf becomes same size as upperHalf
        if (lowerHalf.size() > upperHalf.size())
            upperHalf.offer(lowerHalf.poll());

        if (!upperHalf.isEmpty() && num > upperHalf.peek()) {
            upperHalf.offer(num);
            lowerHalf.offer(upperHalf.poll());
            // exit as lowerHalf == upperHalf
        } else {
            lowerHalf.offer(num);
            // exit lowerHalf + 1 == upperHalf
        }

    }

    public double findMedian() {
        if (lowerHalf.size() > upperHalf.size())
            return lowerHalf.peek();
        return (lowerHalf.peek() + upperHalf.peek()) * 0.5;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
```
