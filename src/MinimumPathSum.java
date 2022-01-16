public class MinimumPathSum {
    public int minPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int dp[][] = new int[m][n];
        dp[0][0]=A[0][0];
        for(int i=1;i<m;i++){
            //if(A[i][0]==1)break;
            dp[i][0]=dp[i-1][0]+A[i][0];
        }
        for(int i=1;i<n;i++){
            //if(A[0][i]==1)break;
            dp[0][i]=dp[0][i-1]+A[0][i];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){

                dp[i][j]=A[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
//    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//
//        Note: You can only move either down or right at any point in time.