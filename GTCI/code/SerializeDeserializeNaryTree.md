# Serialize and Deserialize N-ary Tree (hard)

## problem statement

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.

## my solution (not working, 50 minutes)

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// null => ''
// '1,x,x'
// ex1 => '1,x,3,2,4,x,5,6,x'
class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuffer sb = new StringBuffer();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // Queue<Node> nextQ = new LinkedList<>();
            Node node = q.poll();
            if (node != null) {
                sb.append(Integer.toString(node.val)+",");
                q.add(null);
                q.addAll(node.children);
            } else {
                sb.append("x,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] strNodes = data.split(",");
        List<String> q = Arrays.asList(strNodes);
        Queue<Node> nextNodes = new LinkedList<>();
        // return deserializeHelper(q);
        Node root = new Node(0);
        Node curr = root;
        int i = 0;
        while (i < q.size() - 1) {
            Queue<String> children = new LinkedList<>();
            while (!q.get(i).equals("x"))
                children.offer(q.get(i++));
            List<Node> childNodes = new ArrayList<>();
            System.out.println(children);
            while(!children.isEmpty()) {
                String strVal = children.poll();
                Node child = new Node(Integer.parseInt(strVal, 10));
                childNodes.add(child);
                nextNodes.add(child);
            }
            if (curr != null)
                curr.children = childNodes;
            if (!nextNodes.isEmpty())
                curr = nextNodes.poll();
            i++;
        }
        return (root.children.size() > 0) ? root.children.get(0) : null;
    }

//     public Node deserialize(List<String> strNodes) {

//     }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```
