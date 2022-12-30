class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        solution n  = new solution();
        return n.sol(nums);
    }
}
class solution {
    public int find(int[] parent,int value) {
        if(parent[value] == value) {
            return value;
        }
        return parent[value] = find(parent,parent[value]);
    }
    int max = 1;
    public int union(int[] parent,int a, int b) {
        int parent_a = find(parent,a);
        int parent_b= find(parent,b);
        if(parent_a == parent_b) {
            return 0;
        }
        int localMax = 1;
        if(parent_a != parent_b) {
            if(size[parent_a] > size[parent_b]) {
                size[parent_a] = size[parent_a] + size[parent_b];
                parent[parent_b] = parent_a;
                localMax  = size[parent_a];
            }
            else {
               size[parent_b] = size[parent_b] + size[parent_a];
                parent[parent_a]= parent_b;
                localMax = size[parent_b];
            }
        }
        max  = Math.max(max,localMax);
        return 0;
    }
    int[] size;
    public int sol(int[] nums) {
        HashMap<Integer,Integer> map =new HashMap<>();
        int[] parent = new int[nums.length];
        size = new int[nums.length];
        for(int i =0;i < parent.length;i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(int i =0;i < nums.length;i++) {
           if(map.containsKey(nums[i])) {
               continue;
           } 
           if(map.containsKey(nums[i] + 1) || map.containsKey(nums[i] - 1)) {
               if(map.containsKey(nums[i] + 1)) {
                   union(parent,i,map.get(nums[i] + 1));
               }
               if(map.containsKey(nums[i] - 1)) {
                   union(parent,i,map.get(nums[i] - 1));
               }
           }
           map.put(nums[i],i);
        }
        return max;
    }
}
