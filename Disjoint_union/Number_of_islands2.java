class Solution {
    public int[] find(int[][][] parent,int x,int y) {
        if(parent[x][y][0] == x && parent[x][y][1] == y) {
            return new int[]{x,y};
        }
        int[] nums = find(parent,parent[x][y][0],parent[x][y][1]);
        parent[x][y][0] = nums[0];
        parent[x][y][1] = nums[1];
        return nums;
    }
    int count =0;
    public void union(int[][][] parent,int currx,int curry,int x,int y,int[][] size) {
        int[] parentA = find(parent,currx,curry);
        int[] parentB = find(parent,x,y);
        if(parentA[0] != parentB[0] || parentA[1] != parentB[1]) {
            if(size[parentA[0]][parentA[1]] > size[parentB[0]][parentB[1]]) {
                size[parentA[0]][parentA[1]] += size[parentB[0]][parentB[1]];
                parent[parentB[0]][parentB[1]][0] = parentA[0];
                parent[parentB[0]][parentB[1]][1] = parentA[1];
            }
            else {
                 size[parentB[0]][parentB[1]] += size[parentA[0]][parentA[1]];
                 parent[parentA[0]][parentA[1]][0] = parentB[0];
                parent[parentA[0]][parentA[1]][1] = parentB[1];
            }
            count--;

        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][][] parent = new int[m][n][2];
        int[][] size = new int[m][n];
        int[][] nums = new int[m][n];
        for(int i =0;i < positions.length;i++) {
            int x= positions[i][0];
            int y = positions[i][1];
            parent[x][y][0] = x;
            parent[x][y][1] = y;
            size[x][y] = 1;
        }
        int[][] dimensions = {{0,-1},{-1,0},{1,0},{0,1}};
        boolean[][] visited = new boolean[m][n];
          int incrementer = 1;
        List<Integer> list = new ArrayList<>();
        for(int p =0;p < positions.length;p++) {
            int i  = positions[p][0];
            int j = positions[p][1];
             nums[i][j] = 1;  
             if(!visited[i][j]) {
                 visited[i][j] = true; 
                count++;
             }
                    for(int k =0;k < dimensions.length;k++) {
                        int x= i + dimensions[k][0];
                        int y = j + dimensions[k][1];
                        if(x >= m || y >= n || x < 0 || y < 0) {
                            continue;
                        }
                        if(nums[x][y] == 1) {
                            union(parent,i,j,x,y,size);
                        }  
                }
                list.add(count);
        }
        return list;
    }
}
