// Let's get one thing out of the way first - let's just bloody sort the damn array before worrying about anything else :)

// Now, the idea is to reach a state where all elements are equal - simple, fair enough.

// In the process, the element which will change the most is the first element - the leftmost one - while, conversely, the element which will change the least is the last one, the rightmost one i.e. The sodding array is sorted, after all.

// So for nothing but the heck of it, let's look at the whole thing from the perspective of the first element.

// Let's imagine the first element setting an initial task for itself - I have to catch up with my neighbor (i.e. second) element. So what does it do - increments itself and all other elements, except the second one of course, by the exact difference between itself and the second element.

// If the array was "1, 5, 6, 7" then the array change to "5 5 10 11".

// Next, the first element expands it's horizons a bit and looks at the element just beyond the second one - the third element. It must catch up with the third element. So: every element, except the third element is upgraded by the difference between the first element and the third one. As a result, the array now is - "10 10 10 16".

// Finally, only one element left that's towering above everyone else - the last element. In the final step, the array is modified to "16 16 16 16".
class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int min = nums[0];
        for(int i =1;i < nums.length;i++) {
            count= count + (nums[i] - min);
        }
        return count;
    }
}
