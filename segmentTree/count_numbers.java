import java.util.ArrayList;
import java.util.List;
class Node {
    int[] range;
    int sum;
    Node left;
    Node right;
    public Node() {}
}
class solution {
    int[] array;
    public List<Integer> sol(int[] nums) {
        int offset = (int)1e4;
        int size = 2*(int)1e4 + 2;
        array = new int[size];
        List<Integer> list =new ArrayList<>();
        Node root = this.tree(array,0,array.length - 1);
        for (int num : nums) {
            int smaller = query(root, 0, num + offset);
            update(root, num + offset + 1);
            list.add(smaller);
        }
        return list;
    }
    public Node tree(int[] nums,int start, int end) {
        if(start == end) {
            Node node = new Node();
            node.sum = nums[start];
            node.range = new int[]{start,end};
            return node;
        }
        if(start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        Node node  = new Node();
        node.left = tree(nums,start,mid);
        node.right = tree(nums,mid + 1, end);
        node.sum = (node.left == null?0:node.left.sum) + (node.right == null?0:node.right.sum);
        return node;
    }
    public void update(Node root,int index) {
        if(root == null) {
            return;
        }
        int[] range = root.range;
        if(index >= range[0] && index <= range[1]) {
            root.sum = root.sum + 1;
            update(root.left,index);
            update(root.right,index);
        }
    }
    public int query(Node root,int start,int end) {
        if(root == null) {
            return 0;
        }
        int[] range =root.range;
        if(range[0] >= start && range[1] <= end) {
            return root.sum;
        }
        if(range[0] > end || range[1] < start) {
            return  0;
        }
        return query(root.left,start,end) + query(root.right,start,end);
    }
}
public class sol {
    public static void main(String[] args) {
        System.out.println("Hello, world");
    }
}
