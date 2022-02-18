/*import java.util.*;
public class FindLeavesOfBinaryTree {
    List<List<Integer>> ans;

    public int inorder(TreeNode node){
        if(node==null)return -1;

        int left = inorder(node.left) +1;
        int right = inorder(node.right) +1;
        int lvl = Math.max(left,right);
        if(ans.size()==lvl)ans.add(new ArrayList<>());
        ans.get(lvl).add(node.val);
        return lvl;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {

        ans = new ArrayList<>();
        inorder(root);
        return ans;


    }
}*/
