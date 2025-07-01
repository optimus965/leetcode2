import java.util.*;
// ArrayDeque based problem
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            while (!stack1.isEmpty() && stack1.peekLast() <= height[i]) {
                stack1.removeLast();
            }
            if (stack1.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack1.peekFirst();
            }
            stack1.addLast(height[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && stack2.peekLast() <= height[i]) {
                stack2.removeLast();
            }
            if (stack2.isEmpty()) {
                right[i] = -1;
            } else {
                right[i] = stack2.peekFirst();
            }
            stack2.addLast(height[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            if (min == -1) {
                continue;
            }
            count = count + (min - height[i]);
        }

        return count;
    }
}
