/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Node[] nums;
    public Solution() {
        nums = new Node[104];
    }
    public Node cloneGraph(Node root) {
        if(root == null) return null;
        if(nums[root.val] != null) {
            return nums[root.val];
        }
        Node node = new Node();
        node.val = root.val;
        nums[node.val] = node;
        for(Node node1:root.neighbors) {
            Node temp = cloneGraph(node1);
            node.neighbors.add(temp);
        }
        return node;
    }
}
