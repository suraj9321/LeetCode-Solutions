import java.util.*;

public class SteppingNumbers {
    List<Integer> ans;
    int high;
    int low;

    public void dfs(String s){

        int last = s.charAt(s.length()-1)-'0';
        long z = Long.valueOf(s);
        if(z<=high){
            if(z>=low){
                ans.add((int)z);
            }
            if(z==high)return;
            if(last-1>=0)dfs(s+Integer.toString(last-1));
            if(last+1<=9)dfs(s+Integer.toString(last+1));
        }

    }

    public List<Integer> countSteppingNumbers(int low, int high) {
        ans = new ArrayList<>();
        if(low==0){ans.add(0);
            low=1;}

        this.low = low;
        this.high = high;
        if(high<=low)return ans;

        for(int i=1;i<=9;i++){
            dfs(Integer.toString(i));
        }

        Collections.sort(ans);
        return ans;
    }
}
/*A stepping number is an integer such that all of its adjacent digits have an absolute difference of exactly 1.

For example, 321 is a stepping number while 421 is not.
Given two integers low and high, return a sorted list of all the stepping numbers in the inclusive range [low, high].



Example 1:

Input: low = 0, high = 21
Output: [0,1,2,3,4,5,6,7,8,9,10,12,21]
Example 2:

Input: low = 10, high = 15
Output: [10,12]


Constraints:

0 <= low <= high <= 2 * 109*/