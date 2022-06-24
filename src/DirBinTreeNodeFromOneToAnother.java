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

    private int cnt =0 ;

    private TreeNode ansec;

    public int LCA(TreeNode root, int s, int d){
        if(root==null)return 0;
        if(ansec!=null)return 0;
        int mid=0;
        
        int left = LCA(root.left,s,d);
        if(root.val == s|| root.val == d)mid=1;
        int right = LCA(root.right,s,d);
        if(ansec!=null)return 0;
        if(mid+left+right>=2)ansec = root;
        return mid+left+right;
        
    }

    public TreeNode lowComAns(TreeNode root, int s, int d){
        LCA(root,s,d);
        return ansec;
    }
    boolean flag_done = false;
    public void getDir(StringBuilder s,TreeNode lca, int c){
        if(lca==null||flag_done)return;
        if(lca.val==c){flag_done=true;return;}

        s.append('L');
        getDir(s,lca.left,c);
        if(flag_done)return;
        s.deleteCharAt(s.length()-1);


        s.append('R');
        getDir(s,lca.right,c);
        if(flag_done)return;
        s.deleteCharAt(s.length()-1);
    }



    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lowComAns(root,startValue,destValue);
        
        
        flag_done = false;
        StringBuilder ansleft = new StringBuilder("");
        getDir(ansleft,lca,startValue);
        
        for(int i=0;i<ansleft.length();i++){
            ansleft.setCharAt(i,'U');
        }

        flag_done = false;
        StringBuilder ansright = new StringBuilder("");
        getDir(ansright,lca,destValue);
        

        ansleft = ansleft.append(ansright);
        return ansleft.toString();

        
        
    }
}

/*You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.

Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:

'L' means to go from a node to its left child node.
'R' means to go from a node to its right child node.
'U' means to go from a node to its parent node.
Return the step-by-step directions of the shortest path from node s to node t.

 The number of nodes in the tree is n.
2 <= n <= 105
1 <= Node.val <= n
All the values in the tree are unique.
1 <= startValue, destValue <= n
startValue != destValue
*/
