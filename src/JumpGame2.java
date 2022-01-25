public class JumpGame2 {
    public int jump(int[] A) {
        int dp[] = new int[A.length];
        dp[0]=0;
        for(int i=1;i<A.length;i++)dp[i]=Integer.MAX_VALUE;
        for(int i=1;i<A.length;i++){
            for(int j=0;j<i;j++){
                if(j+A[j]>=i&&dp[j]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],1+dp[j]);
                }
            }
            if(dp[i]==Integer.MAX_VALUE)return -1;
        }

        return dp[A.length-1]==Integer.MAX_VALUE?-1:dp[A.length-1];
    }
}
/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000*/