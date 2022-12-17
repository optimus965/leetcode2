class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(TreeNode left,TreeNode right,int val) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public int maxPathSum(TreeNode root) {
        this.sol(root);
        return this.max;
    }
    int max = Integer.MIN_VALUE;
    public int sol(TreeNode root) {
        if(root == null) {
            return -(int)1e7;
        }
        int sum1 = sol(root.right);
        int sum2 = sol(root.left);
        int max1 = Math.max(root.val,Math.max(root.val + sum1,root.val + sum2));
        max  = Math.max(max1,Math.max(max,root.val + sum1 + sum2));
        return max1;
    }
}
