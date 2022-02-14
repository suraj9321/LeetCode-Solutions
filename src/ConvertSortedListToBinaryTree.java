/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
import javax.swing.tree.TreeNode;
import java.util.*;

/*
public class ConvertSortedListToBinaryTree {
    int arr[];
    public TreeNode BST(int i, int j){
        if(i>j)return null;
        int root = (i + j)/2;

        TreeNode subroot = new TreeNode(arr[root]);
        subroot.left = BST(i,root-1);
        subroot.right = BST(root+1,j);
        return subroot;
    }

    public TreeNode sortedListToBST(ListNode a) {

        int n = 0;
        ListNode b = a;
        while(b!=null){
            n++;
            b = b.next;
        }
        arr = new int[n];
        b = a;
        n=0;
        while(b!=null){
            arr[n]=b.val;
            b = b.next;
            n++;
        }

        return BST(0,n-1);
    }
}
*/
