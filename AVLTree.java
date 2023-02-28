import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int val;
    Node left;
    Node right;
    int height;
    public Node(int val) {
        this.val = val;
        this.height = 1;
    }
}
class AVLTrees {
    public Node insert(Node node,int val) {
        if(node == null) {
            return new Node(val);
        }
        if(val > node.val) {
            node.right = insert(node.right,val);
        }
        else if(val < node.val) {
            node.left = insert(node.left, val);
        }
        else {
            return node;
        }
        node.height = 1 + Math.max(node.left == null?0:node.left.height,node.right ==null?0:node.right.height);
        int balance = (node.left == null?0:node.left.height) - (node.right == null?0:node.right.height);
        if(balance > 1 && val < node.left.val) {
            Node temp = node.left;
            Node tem1 = temp.right;
            temp.right = node;
            node.left = tem1;
            node.height = 1 + Math.max(node.left == null?0:node.left.height,node.right==null?0:node.right.height);
            temp.height = 1 + Math.max(temp.left.height, temp.right.height);
            return temp;
        }
        if(balance < -1 && val > node.right.val) {
            Node temp = node.right;
            Node tem1 = temp.left;
            temp.left = node;
            node.right = tem1;
            node.height = 1 + Math.max(node.left == null?0:node.left.height,node.right==null?0:node.right.height);
            temp.height = 1 + Math.max(temp.left.height, temp.right == null?0:temp.right.height);
            return temp;
        }
        if(balance  > 1 && val > node.left.val) {
            Node temp = node.left;
            Node tem1 = temp.right;
            node.left = tem1;
            temp.right = tem1.left;
            tem1.left = temp;
            temp.height = 1 + Math.max(temp.left == null?0:temp.left.height,temp.right ==null?0:temp.right.height);
            tem1.height = 1 + Math.max(tem1.left.height,tem1.right ==null?0:tem1.right.height);
            temp = node.left;
            tem1 = temp.right;
            temp.right = node;
            node.left = tem1;
            node.height = 1 + Math.max(node.left == null?0:node.left.height,node.right==null?0:node.right.height);
            temp.height = 1 + Math.max(temp.left.height, temp.right.height);
            return temp;
        }

        if(balance < -1 && val < node.right.val) {
            Node temp = node.right;
            Node tem1 = temp.left;
            node.right = tem1;
            temp.left= tem1.right;
            tem1.right = temp;
            temp.height = 1 + Math.max(temp.left == null?0:temp.left.height,temp.right ==null?0:temp.right.height);
            tem1.height = 1 + Math.max(tem1.left == null?0:tem1.left.height, tem1.right.height);
            temp = node.right;
            tem1 = temp.left;
            temp.left = node;
            node.right = tem1;
            node.height = 1 + Math.max(node.left == null?0:node.left.height,node.right==null?0:node.right.height);
            temp.height = 1 + Math.max(temp.left.height, temp.right.height);
            return temp;
        }

        return node;
    }
    public void Tree(Node node) {
        if(node == null) {
            return;
        }
        Queue<Node> que = new ArrayDeque<>();
        que.add(node);
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i =0;i < size;i++) {
                Node node1= que.poll();
                assert node1 != null;
                System.out.print(node1.val + "\t");
                if(node1.left != null) {
                    que.add(node1.left);
                }
                if(node1.right != null) {
                    que.add(node1.right);
                }
            }
        }
        System.out.println();
    }
    
}
public class sol {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node node = null;
        AVLTrees avl = new AVLTrees();
        int[] nums = {2,19,5,6,121,9,13,17,15,141,111,7,3,12,16,54,77,43,44,40,1000};
        for (int num : nums) {
            node = avl.insert(node, num);
        }
        avl.Tree(node);
    }
}
