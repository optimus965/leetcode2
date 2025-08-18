/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new ArrayList[n + 2][n + 2];
        for(int i = 1;i <= n + 1;i++) {
            dp[1][i] = new ArrayList<>();
            dp[0][i] = new ArrayList<>();
            dp[1][i].add(new TreeNode(i));
            dp[0][i].add(null); 
          
        }
        for(int len = 2;len <= n;len++) {
            for(int i = 1; i + len - 1 <= n; i++) {
                int j  = len + i  - 1;
                TreeNode node = new TreeNode();
                List<TreeNode> list = new ArrayList<>();
                for(int k = i;k <= j;k++) {
                    for(TreeNode node1:dp[j - k][k + 1]) {
                        for(TreeNode node2:dp[k - i][i]) {
                            node = new TreeNode(k);
                            node.right = node1;
                            node.left = node2;
                            list.add(node);
                        }
                    }   
                }
                dp[len][i] = list;
            }
        }
        return dp[n][1];
    }
}
