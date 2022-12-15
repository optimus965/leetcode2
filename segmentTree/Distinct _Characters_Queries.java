import java.util.*;
import java.util.Scanner;
public class sol {
    public static void main(String[] args) {
        solution sol =new solution();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] arc = s.toCharArray();
        int n = scanner.nextInt();
        Node root = sol.build(s.toCharArray(),0,s.length() - 1);
        for(int i =0;i < n;i++) {
            int a = scanner.nextInt();
            if(a == 2) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                sol.max = new BitSet();
                sol.query(root,start - 1, end -1);
                System.out.println(sol.max.cardinality());
            }
            else {
                int index = scanner.nextInt();
                char c = scanner.next().charAt(0);
                sol.update(root,c,arc[index - 1],index - 1);
                arc[index - 1] = c;
            }
        }
    }
}
class Node {
    int[] array;
    Node left,right;
    int[] range = new int[2];
    BitSet set = new BitSet(26);
    Node() {
        array = new int[26];
    }
}
class solution {
    public Node build(char[] ar,int start,int end) {
        if(start == end) {
            Node temp = new Node();
            int c = ar[start] - 'a';
            temp.set.set(c);
            temp.array[c]++;
            temp.range = new int[]{start,end};
            return temp;
        }
        if(start > end) {
            return null;
        }
        int mid = (start + end) >> 1;
        Node root = new Node();
        root.left = build(ar,start,mid);
        root.right = build(ar,mid + 1,end);
        int[] arr = root.array;
        if(root.left == null) {
            root.left = new Node();
        }
        if(root.right == null) {
            root.right = new Node();
        }
        int i = 0;
        while(i < 26 ) {
            arr[i] = root.left.array[i] + root.right.array[i];
            if(arr[i] >= 1) {
                root.set.set(i);
            }
            i++;
        }
        root.range = new int[]{start,end};
        return root;
    }
    public void update(Node root,char current,char prev,int index) {
        if(root == null) {
            return;
        }
        int[] range = root.range;
        if(index < range[0] || index > range[1]) {
            return;
        }
        int currentValue = current - 'a';
        int previousValue = prev - 'a';
        root.array[currentValue]++;
        root.array[previousValue]--;
        root.set.set(currentValue);
        if(root.array[previousValue] == 0) {
            root.set.clear(previousValue);
        }
        update(root.left,current,prev,index);
        update(root.right,current,prev,index);
    }
    BitSet max = new BitSet();
    public void query(Node root, int start, int end) {
        if(root == null) {
            return;
        }
        int[] range = root.range;
        if(range[0] > end || range[1] < start) {
            return;
        }
        if(range[0] >= start && range[1] <= end) {
            max.or(root.set);
            return;
        }
        query(root.left,start,end);
        query(root.right,start,end);
    }
}


//abacaba
