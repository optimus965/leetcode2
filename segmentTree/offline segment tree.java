import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader();
BufferedWriter output = new BufferedWriter(
	            new OutputStreamWriter(System.out));
        int n= scanner.nextInt();
        int[] nums = new int[n];
        for(int i =0;i < n;i++) {
            nums[i] = scanner.nextInt();
        }
        solution sol = new solution();
        int queries = scanner.nextInt();
        Node node = sol.sol(nums, 0, nums.length - 1);
        while(queries-- > 0) {
            int left = scanner.nextInt() - 1;
            int right = scanner.nextInt()  - 1;
            int k = scanner.nextInt();
            sol.count = 0;
            sol.query(node, left, right, k);
            output.write(sol.count + "\n");
        }
       output.flush();
    }
}
class Reader {
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
 
    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public Reader(String file_name) throws IOException
    {
        din = new DataInputStream(
                new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) {
                    break;
                }
                else {
                    continue;
                }
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
    }
 
    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
 
        if (neg)
            return -ret;
        return ret;
    }
 
    public long nextLong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }
 
    public double nextDouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
 
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
 
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }
 
        if (neg)
            return -ret;
        return ret;
    }
 
    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0,
                BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }
 
    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
 
    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}
class Node {
    int[] nums;
    int[] range = new int[2];
    Node left;
    Node right;
}
class solution {
    int number  = 0;
    public Node sol(int[] nums,int left, int right) {
        if(left == right) {
            Node node = new Node();
            node.range= new int[]{left, right};
            node.nums= new int[]{nums[left]};
            return node;
        }
        Node node = new Node();
        int mid = (left + right) >> 1;
        node.range = new int[] {left, right};
        node.nums= new int[right - left + 1];
        node.left = this.sol(nums, left, mid);
        node.right = this.sol(nums, mid + 1, right);
        int first = left;
        int secondf = mid + 1;
        int second = mid + 1;
        int count =0;
        while(first <= mid && second <= right) {
            if(node.left.nums[first - left] < node.right.nums[second -secondf]) {
                node.nums[count++] = node.left.nums[first - left];
                first++;
            }
            else {
                node.nums[count++] = node.right.nums[second - secondf];
                second++;
            }
        }
        while(first <= mid) {
            node.nums[count++] = node.left.nums[first - left];
            first++;
        }
        while(second <= right) {
            node.nums[count++] = node.right.nums[second - secondf];
            second++;
        }
        return node;
    }
    int count =0;
   public void query(Node node,int left, int right,int target) {
        if(node == null) {
            return;
        }
        int[] range = node.range;

        if(range[0] >= left && range[1] <= right) {
            int low = range[0];
            int end = range[1];
            while(low <= end) {
                int mid = (low + end) >> 1;
                if(target >= node.nums[mid - range[0]]) {
                    low = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            count = count + node.nums.length - (low - range[0]);
            return;
        }
        if(range[0] > right  || range[1] < left) {
            return;
        }
        query(node.left,left, right,target);
        query(node.right,left, right, target);
    }
}
