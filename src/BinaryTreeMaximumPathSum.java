public class BinaryTreeMaximumPathSum {
    private int ans=Integer.MIN_VALUE;
    public int maxSum(TreeNode root) {
        if(root==null) return 0;

        int left = maxSum(root.left);
        int right = maxSum(root.right);
        int sum_left = left + root.val;
        int sum_right = right + root.val;
        int full = left + right + root.val;

        int max = Math.max(sum_left,sum_right);
        max = Math.max(max,root.val);
        ans = Math.max(ans,Math.max(max,full));

        return max;
    }

    public int maxPathSum(TreeNode root) {
        int ret= maxSum(root);
        return ans;
    }
}
/*
* A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty p
*
* The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000
* */