class Solution {
    int size = 2 * (int)1e4 + 1;
    int offset = (int)1e4;
    int[] tree = new int[size];
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list =new ArrayList<>();
        for(int i = nums.length - 1;i  >= 0;i--) {
            int small = getSum(nums[i] + offset);
            list.add(small);
            update(nums[i] + offset,1);
        }
        Collections.reverse(list);
        return list;
    }
     int getSum(int index) {
        int sum = 0;
        while(index > 0) {
            sum += tree[index];
            index -= (index & (-index));
        }
        return sum;
    }
    public void update(int index, int val) {
        index++;
        while(index < size) {
            tree[index] += val;
            index += (index & (-index));
        }
    }
}
