import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class permutation2 {
    List<List<Integer>> ans = new ArrayList<>();
    int nums[];
    Set<List<Integer>> st;

    private void swap(int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void next_permute(int i){

        if(i==nums.length-1){
            List<Integer> intList = new ArrayList<Integer>(nums.length);
            for (int k : nums)
            {
                intList.add(k);
            }
            if(!st.contains(intList)){
                ans.add(intList);
                st.add(intList);
            }
        }

        for(int j=i;j<nums.length;j++){
            swap(j,i);
            next_permute(i+1);
            swap(j,i);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        st = new HashSet<>();
        this.nums = nums;
        next_permute(0);
        return ans;
    }
}
