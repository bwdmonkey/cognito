# Design Search Autocomplete System (hard)

## problem statement

Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#').

You are given a string array sentences and an integer array times both of length n where sentences[i] is a previously typed sentence and times[i] is the corresponding number of times the sentence was typed. For each input character except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.

Here are the specific rules:

The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same hot degree, use ASCII-code order (smaller one appears first).
If less than 3 hot sentences exist, return as many as you can.
When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
Implement the AutocompleteSystem class:

AutocompleteSystem(String[] sentences, int[] times) Initializes the object with the sentences and times arrays.
List<String> input(char c) This indicates that the user typed the character c.
Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If there are fewer than 3 matches, return them all.

Example 1:

```txt
Input
["AutocompleteSystem", "input", "input", "input", "input"]
[[["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]], ["i"], [" "], ["a"], ["#"]]
Output
[null, ["i love you", "island", "i love leetcode"], ["i love you", "i love leetcode"], [], []]

Explanation
AutocompleteSystem obj = new AutocompleteSystem(["i love you", "island", "iroman", "i love leetcode"], [5, 3, 2, 2]);
obj.input("i"); // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
obj.input(" "); // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
obj.input("a"); // return []. There are no sentences that have prefix "i a".
obj.input("#"); // return []. The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
```

Constraints:

n == sentences.length
n == times.length
1 <= n <= 100
1 <= sentences[i].length <= 100
1 <= times[i] <= 50
c is a lowercase English letter, a hash '#', or space ' '.
Each tested sentence will be a sequence of characters c that end with the character '#'.
Each tested sentence will have a length in the range [1, 200].
The words in each input sentence are separated by single spaces.
At most 5000 calls will be made to input.

## my solution (accepted, 50 minutes could optimize string find by having a Map<String, Integer> to store final strings)

```java
// Implement TrieNode such it tracks children and the times
class TrieNode {
    Map<Character, TrieNode> children;
    String val;
    int times;

    public TrieNode(String val) {
        this.val = val;
        times = 0;
        children = new HashMap<>();
    }

    public TrieNode(String val, int times) {
        this.val = val;
        times = times;
        children = new HashMap<>();
    }

    public void insert(String str, int times) {
        TrieNode curr = this;
        TrieNode next;
        char ch;
        for (int i = 0; i < str.length() - 1; i++) {
            ch = str.charAt(i);
            if (curr.children.containsKey(ch)) {
                next = curr.children.get(ch);
            } else {
                next = new TrieNode(str.substring(0, i + 1));
                curr.children.put(ch, next);
            }
            curr = next;
        }
        ch = str.charAt(str.length() - 1);
        if (curr.children.containsKey(ch)) {
            next = curr.children.get(ch);
        } else {
            next = new TrieNode(str);
            curr.children.put(ch, next);
        }
        next.times += times;
    }

    public List<String> find(String str) {
        TrieNode curr = this;
        List<String> res = new ArrayList<>();
        PriorityQueue<TrieNode> pq = new PriorityQueue<>(1,(a,b) -> (a.times != b.times) ? -Integer.compare(a.times, b.times) : a.val.compareTo(b.val)); // max heap
        for (char ch : str.toCharArray()) {
            if (curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
            } else {
                return res;
            }
        }
        // we have successfully finished matching the search term and found a TrieNode
        Queue<TrieNode> q = new LinkedList<>();
        q.add(curr);
        while (!q.isEmpty()) {
            curr = q.poll();
            if (curr.times > 0)
                pq.add(curr);
            if (!curr.children.isEmpty())
                q.addAll(curr.children.values());
        }

        int i = 0;
        while (i++ < 3 && !pq.isEmpty()) {
            res.add(pq.poll().val);
        }

        return res;
    }
}

class AutocompleteSystem {
    TrieNode root;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode("");
        sb = new StringBuilder();
        int N = sentences.length;
        for (int i = 0; i < N; i++)
            root.insert(sentences[i], times[i]);
    }

    public List<String> input(char c) {
        if (c == '#') {
            String sentence = sb.toString();
            sb = new StringBuilder();
            root.insert(sentence, 1);
            return new ArrayList<>();
        }
        sb.append(c);
        return root.find(sb.toString());
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
```
