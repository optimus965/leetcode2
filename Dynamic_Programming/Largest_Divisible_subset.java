class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int n = nums.length;
        int index = 0;
        int[] parent = new int[nums.length];
        Arrays.fill(parent,-1);
        Arrays.sort(nums);
        int max = 0;
        for(int i = 1;i < n;i++) {
            for(int j = 0;j < i;j++) {
                if(nums[i]%nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = dp[j] + 1;
                    if(dp[i] > max) {
                        index = i;
                        max = dp[i];
                    }
                    parent[i] = j;
                }
            }
        }
        int f = index;
        List<Integer> list = new ArrayList<>();
        while(parent[index] != -1) {
            list.add(nums[parent[index]]);
            index = parent[index];
        }
        Collections.reverse(list);
        list.add(nums[f]);
        return list;
    }
}
