//   https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/solutions/6580855/beats-super-easy-beginners-java-c-c-python-javascript-dart/
import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> all = new ArrayList<>();
        
        for (int[] row : grid) {
            for (int num : row) {
                all.add(num);
            }
        }
        
        int mod = all.get(0) % x;
        for (int num : all) {
            if (num % x != mod) return -1;
        }

        Collections.sort(all);
        int median = all.get(all.size() / 2);
        int operations = 0;

        for (int num : all) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}
