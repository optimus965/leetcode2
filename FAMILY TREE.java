import java.io.*;
import java.util.*;
public class Main {
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        FastReader fr = new FastReader();
        StringBuilder sb = new StringBuilder();
        int n = fr.nextInt();
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<n;i++) tree.add(new ArrayList<>());
        int[] a = new int[n];
        for(int i=0;i<a.length;i++) a[i] = fr.nextInt();
        int root = -1;
        for(int child=0;child<n;child++){
            int parent = fr.nextInt()-1;
            if(parent == -2) root = child;
            else tree.get(parent).add(child);
        }
        dfs(root,tree,a);
        sb.append(max);
        output.write(sb.toString());
        output.flush();
    }
    private static int[] dfs(int node,List<List<Integer>> tree,int[] a){
        if(tree.get(node).isEmpty()) {
            return new int[]{a[node],a[node]};
        }
        int min_from_children = Integer.MAX_VALUE;
        int max_from_children = Integer.MIN_VALUE;
        for(int child: tree.get(node)){
            
            int[] cv = dfs(child,tree,a);
            min_from_children = Math.min(min_from_children,cv[0]);
            max_from_children = Math.max(max_from_children,cv[1]);
           
        }
        max = Math.max(max,a[node]-min_from_children);
        max = Math.max(max,max_from_children - a[node]);
        int[] ans = new int[]{Math.min(min_from_children,a[node]),Math.max(max_from_children,a[node])};
        return ans;
    }
}
class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try {
            if(st.hasMoreTokens()){
                str = st.nextToken("\n");
            }
            else{
                str = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
