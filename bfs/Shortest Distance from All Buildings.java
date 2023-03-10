class Solution {
    public int shortestDistance(int[][] grid) {
        return this.sol(grid);
    }
    public int sol(int[][] nums) {
        int total_houses =0;
        int count =0;
        List<int[]> list =new ArrayList<>();
        for (int i =0;i < nums.length;i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 1) {
                    total_houses++;
                }
                list.add(new int[]{i,j});
            }
        }
        Queue<int[]> que;
        boolean[][] visited;
        int[][] dimensions = {{-1,0},{1,0},{0,1},{0,-1}};
        int[][] distance;
        int min = Integer.MAX_VALUE;
        int sum =Integer.MAX_VALUE;
        for(int z =0;z < list.size();z++) {
            int i = list.get(z)[0];
            int j = list.get(z)[1];
                if(nums[i][j] == 0) {
                    sum = 0;
                    visited = new boolean[nums.length][nums[0].length];
                    distance = new int[nums.length][nums[0].length];
                    que =new ArrayDeque<>();
                    que.add(new int[]{i,j});
                    visited[i][j] = true;
                    while(!que.isEmpty()) {
                        int[] c = que.poll();
                        for(int p =0;p < dimensions.length;p++) {
                            int x = c[0] + dimensions[p][0];
                            int y = c[1] + dimensions[p][1];
                            if(x < 0 || y < 0 || x >= nums.length || y >= nums[0].length) {
                                continue;
                            }
                            if(visited[x][y]) {
                                continue;
                            }
                            if(nums[x][y] == 2) {
                                continue;
                            }
                            visited[x][y] = true;
                            if(nums[x][y] == 0) {
                                que.add(new int[]{x,y});
                            }
                            distance[x][y] = distance[c[0]][c[1]] + 1;
                            if(nums[x][y] == 1) {
                                sum = sum + distance[x][y];
                                count++;
                            }
                            if(total_houses == count) {
                                break;
                            }
                        }
                    }
                }
                if(sum > 0 && count ==total_houses) {
                min = Math.min(min,sum);
                }
                 count =0;
        }
        return min == Integer.MAX_VALUE?-1:min;
    }
}
