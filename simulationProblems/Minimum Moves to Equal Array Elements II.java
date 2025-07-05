// To minimize the number of moves to equalize all elements by incrementing or decrementing, the optimal strategy is to align all numbers to the median. Any other pivot would lead to a greater total distance.
// any number if we choose other than median index then it will cost us more
// so the optimal way is to make all the elements to median index element
// because it is nearer element to every element
class Solution {
    public int minMoves2(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        int value = nums[n/2];
        int count = 0;
        for(int i= 0;i < n;i++) {
            count = count + Math.abs(nums[i] - value);
        }
        return count;
    }
}
