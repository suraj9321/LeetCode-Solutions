public class MinimumDiffernceSubsets {
    public int solve(int[] A) {
        int sum =0;
        for(int k:A)sum+=k;
        int dp[][] = new int[A.length+1][sum/2+1];
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=sum/2;j++){
                if(A[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = Math.max(A[i-1]+dp[i-1][j-A[i-1]],dp[i-1][j]);
                }
            }
        }
        return Math.abs(sum-2*dp[A.length][sum/2]);
    }
}
/*Problem Description

Given an integer array A containing N integers.

You need to divide the array A into two subsets S1 and S2 such that the absolute difference between their sums is minimum.

Find and return this minimum possible absolute difference.

NOTE:

Subsets can contain elements from A in any order (not necessary to be contiguous).
Each element of A should belong to any one subset S1 or S2, not both.
It may be possible that one subset remains empty.


Problem Constraints
1 <= N <= 100

1 <= A[i] <= 100



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the minimum possible difference among the sums of two subsets.



Example Input
Input 1:

 A = [1, 6, 11, 5]


Example Output
Output 1:

 1


Example Explanation
Explanation 1:

 Subset1 = {1, 5, 6}, sum of Subset1 = 12
 Subset2 = {11}, sum of Subset2 = 11*/