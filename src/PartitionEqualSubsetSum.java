public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] A) {
        int sum=0;
        for(int k:A)sum+=k;
        if(sum%2==1)return false;
        int B=sum/2;
        boolean dp[][] = new boolean[A.length+1][B+1];

        for(int i=0;i<=A.length;i++)dp[i][0]=true;

        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=B;j++){

                if(A[i-1]>j){dp[i][j]=dp[i-1][j];}
                else{
                    dp[i][j] = dp[i-1][j-A[i-1]]||dp[i-1][j];
                }
            }
        }

        return dp[A.length][B];
    }
}

/*Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.



Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.


Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100*/
