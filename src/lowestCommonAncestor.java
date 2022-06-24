/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    public int inorder(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)return 0;
        if(ans!=null)return 0;
        int mid=0;

        if(root==p||root==q)mid=1;
        int left = inorder(root.left,p,q);
        int right = inorder(root.right,p,q);
        if(ans!=null)return 0;
        if(mid+left+right>=2)ans = root;
        return mid+left+right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        inorder(root,p,q);
        return ans;
    }
}

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q

*/
p and q will exist in the tree.
