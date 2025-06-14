//  we can make use of union find alogirthm for this question
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length];
        for(int i =0;i < parent.length;i++) {
            parent[i] = i;
        }
        int[] rank = new int[edges.length];
        Arrays.fill(rank,1);
        int[] nums = new int[2];
        for(int i = 0;i < edges.length;i++) {
            int start = edges[i][0] - 1;
            int end = edges[i][1] - 1;
            boolean  value = this.union(parent,rank,start,end);
            if(value) {
                nums = new int[]{start + 1,end + 1};
            }
        }
        return nums;
    }
    public boolean union(int[] parent,int[] rank,int start,int end) {
        int x = find(parent,start);
        int y = find(parent,end);

        int size1 = rank[x];
        int size2 = rank[y];
        if(size1 >= size2) {
            parent[y] = x;
            rank[x] += rank[y];
        }
        else {
            parent[x] = y;
            rank[y] += rank[x];
        }
        if(x == y) {
            return true;
        }
        return false;
    }
    public int find(int[] parent,int index) {
        if(parent[index] != index) {
            parent[index] = find(parent,parent[index]);
            return parent[index];
        }
        return index;
    }
}
